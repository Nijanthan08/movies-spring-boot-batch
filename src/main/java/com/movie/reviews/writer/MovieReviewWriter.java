package com.movie.reviews.writer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import com.movie.reviews.domain.Ratings;
import com.movie.reviews.repo.RatingsRepository;

public class MovieReviewWriter implements ItemWriter<List<Ratings>> {

	private static final Logger LOG = LoggerFactory.getLogger(MovieReviewWriter.class);

	@Autowired
	private RatingsRepository repo;

	@Override
	public void write(List<? extends List<Ratings>> items) throws Exception {

		LOG.info("Movie Review Writer....");

		List<Ratings> ratings = items.get(0);
		LOG.debug("No. of Movies with User Ratings... " + ratings.size());

		repo.saveAll(ratings);

	}

}
