package com.movie.reviews.repo;

import org.springframework.data.repository.CrudRepository;

import com.movie.reviews.domain.Ratings;

public interface ReviewRepository extends CrudRepository<Ratings, Integer> {

}
