package com.movie.reviews.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ratings")
public class Ratings {

	public Ratings() {
	}

	public Ratings(Integer movieId, Double avgRating) {
		this.movieId = movieId;
		this.avgRating = avgRating;
	}

	@Id
	@Column(name = "movieId")
	private Integer movieId;

	@Column(name = "rating")
	private Double avgRating;

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public Double getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(Double avgRating) {
		this.avgRating = avgRating;
	}

}
