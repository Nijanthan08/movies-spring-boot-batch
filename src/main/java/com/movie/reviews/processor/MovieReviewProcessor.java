package com.movie.reviews.processor;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.movie.reviews.domain.Ratings;
import com.movie.reviews.domain.UserReviews;

public class MovieReviewProcessor implements ItemProcessor<List<UserReviews>, List<Ratings>> {

	private static final Logger LOG = LoggerFactory.getLogger(MovieReviewProcessor.class);

	@Override
	public List<Ratings> process(List<UserReviews> list) throws Exception {
		LOG.info("Movie Review Processor....");

		LOG.debug("Total User Ratings... " + list.size());

		// Group all the Ratings based on the Movie
		Map<Integer, List<UserReviews>> map = list.stream()
				.collect(Collectors.groupingBy(UserReviews::getMovieId, Collectors.toList()));

		List<Ratings> ratings = new ArrayList<>();
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.CEILING);

		// Calculate average Rating for each movie and get the list of Ratings
		map.forEach((movieId, review) -> {
			OptionalDouble optional = review.parallelStream().mapToDouble(UserReviews::getRating).average();
			Double averageRating = Double.valueOf(df.format(optional.getAsDouble()));
			ratings.add(new Ratings(movieId, averageRating));
		});

		return ratings;
	}

}
