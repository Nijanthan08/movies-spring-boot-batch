package com.movie.reviews.repo;

import org.springframework.data.repository.CrudRepository;

import com.movie.reviews.domain.UserReviews;

public interface UserReviewRepository extends CrudRepository<UserReviews, Integer> {

}
