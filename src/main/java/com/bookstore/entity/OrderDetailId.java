package com.bookstore.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class OrderDetailId implements Serializable {
	private Book book;
	private BookOrder bookOrder;
	
	
	public OrderDetailId() {
		super();
		// TODO Auto-generated constructor stub
	}


	public OrderDetailId(Book book, BookOrder bookOrder) {
		super();
		this.book = book;
		this.bookOrder = bookOrder;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "book_id", nullable = false, insertable = false, updatable = false)
	public Book getBook() {
		return book;
	}


	public void setBook(Book book) {
		this.book = book;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "order_id", insertable = false, updatable = false, nullable = false)
	public BookOrder getBookOrder() {
		return bookOrder;
	}


	public void setBookOrder(BookOrder bookOrder) {
		this.bookOrder = bookOrder;
	}


	@Override
	public int hashCode() {
		return Objects.hash(book, bookOrder);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDetailId other = (OrderDetailId) obj;
		return Objects.equals(book, other.book) && Objects.equals(bookOrder, other.bookOrder);
	}
	
	
	
}
