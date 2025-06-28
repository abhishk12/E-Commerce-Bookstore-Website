package com.bookstore.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class BookRatingTest {

	@Test
	void testAverageRatingOneRating() {
		Book book = new Book();
		Set<Review> review_ids = new HashSet<>();
		book.setReview_ids(review_ids);
		Review review1 = new Review();
		review1.setRating(5);
		review_ids.add(review1);
		
		float averageRating = book.getAverageRating();
		System.out.println(averageRating);
		assertEquals(5.0f, averageRating);
	}
	
	@Test
	void testAverageRatingNoRating() {
		Book book = new Book();
		Set<Review> review_ids = new HashSet<>();
		book.setReview_ids(review_ids);
//		Review review1 = new Review();
//		review1.setRating(5);
//		review_ids.add(review1);
		
		float averageRating = book.getAverageRating();
		System.out.println(averageRating);
		assertEquals(0.0f, averageRating);
	}
	
	@Test
	void testAverageRatingMultipleRating() {
		Book book = new Book();
		Set<Review> review_ids = new HashSet<>();
		book.setReview_ids(review_ids);
		Review review1 = new Review();
		review1.setRating(5);
		review_ids.add(review1);
		
		Review review2 = new Review();
		review2.setRating(4);
		review_ids.add(review2);
		
		Review review3 = new Review();
		review3.setRating(3);
		review_ids.add(review3);
		
		Review review4 = new Review();
		review4.setRating(3);
		review_ids.add(review4);
		
		float averageRating = book.getAverageRating();
		System.out.println(averageRating);
		assertEquals(3.75f, averageRating);
	}
	
	@Test
	void testRatingString() {
		Book book = new Book();
		float averageRating = 3.4f;
		System.out.println(averageRating);
		
		String ratingString = book.getRatingString(averageRating);
		System.out.println(ratingString);
		assertEquals("on,on,on,off,off", ratingString);
	}

}
