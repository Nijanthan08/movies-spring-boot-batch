package com.movie.reviews.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ratings")
public class Ratings {
	
	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "movieId")
	private Integer movieId;
	
	@Column(name = "rating")
	private Double avgRating;
	
	@Column(name = "totalRatings")
	private Integer totalRatings;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public Integer getTotalRatings() {
		return totalRatings;
	}

	public void setTotalRatings(Integer totalRatings) {
		this.totalRatings = totalRatings;
	}
	
}
