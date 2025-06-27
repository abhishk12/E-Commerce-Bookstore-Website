package com.bookstore.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.bookstore.entity.Book;
import com.bookstore.entity.Customer;
import com.bookstore.entity.Review;

class ReviewDAOTest {
	
	private static ReviewDAO reviewDAO;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		reviewDAO = new ReviewDAO();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		reviewDAO.close();
	}

	@Test
	void testCreateReview() {
		Review review = new Review();
		Book book = new Book();
		Customer customer = new Customer();
		book.setBook_id(33);
		customer.setCustomer_id(12);
		
		review.setBook(book);
		review.setCustomer(customer);
		review.setHeadline("Great book");
		review.setRating(5);
		review.setComment("Easily understandable and no deviation from actual meaning exact words described");
		
		Review newReview = reviewDAO.create(review);
		
		assertTrue(newReview.getReview_id()>0);
		
		
	}

	@Test
	void testGet() {
		Review review = reviewDAO.get(15);
		assertNotNull(review);
		
	}
	
	@Test
	void testUpdateReview() {
		Review review = reviewDAO.get(15);
		review.setRating(4);
		Review updatedReview = reviewDAO.update(review);
		assertEquals(review.getRating(), updatedReview.getRating());
		
	}

	@Test
	void testDeleteObject() {
		reviewDAO.delete(16);
		Review review = reviewDAO.get(16);
		assertNull(review);
	}

	@Test
	void testListAll() {
		List<Review> listReview = reviewDAO.listAll();
		
		for(Review review: listReview) {
			System.out.println(review.getHeadline());
		}
		
		assertEquals(listReview.size(), 2);
	}

	@Test
	void testCount() {
		long cnt = reviewDAO.count();
		assertEquals(cnt, 2);
	}

}
