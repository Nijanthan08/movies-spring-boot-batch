package com.movie.reviews.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reviews")
public class UserReviews {
	
	public UserReviews() {
	}

	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "movieId")
	private Integer movieId;
	
	@Column(name = "createdUserName")
	private String createdUserName;
	
	@Column(name = "rating")
	private Double rating;

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

	public String getCreatedUserName() {
		return createdUserName;
	}

	public void setCreatedUserName(String createdUserName) {
		this.createdUserName = createdUserName;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

}
