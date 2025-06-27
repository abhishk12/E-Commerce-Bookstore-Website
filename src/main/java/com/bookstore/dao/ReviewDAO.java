package com.bookstore.dao;

import java.util.Date;
import java.util.List;

import com.bookstore.entity.Review;

public class ReviewDAO extends JpaDAO<Review> implements GenericDAO<Review> {
	
	
	@Override
	public Review create(Review review) {
		review.setReview_time(new Date());
		return super.create(review);
	}

	@Override
	public Review get(Object reviewId) {
		return super.find(Review.class, reviewId);
	}

	@Override
	public void delete(Object reviewId) {
		super.delete(Review.class, reviewId);
		
	}

	@Override
	public List<Review> listAll() {
		return super.findWithNamedQuery("review.listAll");
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("review.countAll");
	}

}
