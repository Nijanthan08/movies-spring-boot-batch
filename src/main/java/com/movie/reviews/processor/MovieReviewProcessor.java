package com.movie.reviews.processor;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.movie.reviews.domain.UserReviews;

public class MovieReviewProcessor implements ItemProcessor<List<UserReviews>, Map<Integer, Double>> {

	private static final Logger LOG = LoggerFactory.getLogger(MovieReviewProcessor.class);

	@Override
	public Map<Integer, Double> process(List<UserReviews> list) throws Exception {
		LOG.info("Movie Review Processor....");
		LOG.debug("List size: " + list.size());
		return null;
	}

}
