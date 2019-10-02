package com.movie.reviews.writer;

import java.util.List;
import java.util.Map;

import org.springframework.batch.item.ItemWriter;

public class MovieReviewWriter implements ItemWriter<Map<Integer, Double>> {

	@Override
	public void write(List<? extends Map<Integer, Double>> items) throws Exception {
		// TODO Auto-generated method stub

	}

}
