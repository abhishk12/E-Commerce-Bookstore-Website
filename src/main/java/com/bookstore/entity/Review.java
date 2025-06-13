package com.bookstore.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity(name="review")
@Table(name="review")
public class Review implements Serializable {
	
	private int review_id;
	private Book book;
	private Customer customer;
	private int rating;
	private String headline;
	private String comment;
	private Date review_time;
	
	
	
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Review(Book book, Customer customer, int rating, String headline, String comment, Date review_time) {
		super();
		this.book = book;
		this.customer = customer;
		this.rating = rating;
		this.headline = headline;
		this.comment = comment;
		this.review_time = review_time;
	}


	@Id
	@Column(name = "review_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getReview_id() {
		return review_id;
	}



	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "book_id", nullable = false)
	public Book getBook() {
		return book;
	}



	public void setBook(Book book) {
		this.book = book;
	}


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id", nullable = false)
	public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	@Column(name = "rating")
	public int getRating() {
		return rating;
	}



	public void setRating(int rating) {
		this.rating = rating;
	}


	@Column(name = "headline")
	public String getHeadline() {
		return headline;
	}



	public void setHeadline(String headline) {
		this.headline = headline;
	}


	@Column(name = "comment")
	public String getComment() {
		return comment;
	}



	public void setComment(String comment) {
		this.comment = comment;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "review_time")
	public Date getReview_time() {
		return review_time;
	}



	public void setReview_time(Date review_time) {
		this.review_time = review_time;
	}


	
	
	
}
