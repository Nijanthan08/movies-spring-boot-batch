package com.movie.reviews.reader;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;

import com.movie.reviews.domain.UserReviews;
import com.movie.reviews.repo.UserReviewRepository;

public class MovieReviewReader implements ItemReader<List<UserReviews>> {

	private static final Logger LOG = LoggerFactory.getLogger(MovieReviewReader.class);

	@Autowired
	private UserReviewRepository repo;

	boolean processBatch = false;

	@Override
	public List<UserReviews> read() {
		processBatch = !processBatch;
		if (!processBatch)
			return null;
		
		LOG.info("Movie Review Reader....");
		
		//Get the full user reviews from the database
		List<UserReviews> list = (List<UserReviews>) repo.findAll();
		return list;
	}

}
