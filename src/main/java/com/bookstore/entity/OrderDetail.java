package com.bookstore.entity;

import java.io.Serializable;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity(name="order_detail")
@Table(name="order_detail")
@NamedQueries({
	@NamedQuery(name="bookOrder.bestSelling", query = "SELECT bo.book FROM order_detail bo GROUP BY bo.book.book_id ORDER BY SUM(bo.quantity) DESC"),
})
public class OrderDetail implements Serializable {
	
	private OrderDetailId id = new OrderDetailId();
	private Book book;
	private BookOrder bookOrder;
	private int quantity;
	private float sub_total;
	
	
	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}


	public OrderDetail(OrderDetailId id, Book book, BookOrder bookOrder, int quantity, float sub_total) {
		super();
		this.id = id;
		this.book = book;
		this.bookOrder = bookOrder;
		this.quantity = quantity;
		this.sub_total = sub_total;
	}

	
	@EmbeddedId
	@AttributeOverrides({@AttributeOverride(name = "order_id", column = @Column(name="order_id", nullable = false)), 
		@AttributeOverride(name = "book_id", column = @Column(name = "book_id", nullable = false))})
	public OrderDetailId getId() {
		return id;
	}


	public void setId(OrderDetailId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "book_id", nullable = false, insertable = false, updatable = false)
	public Book getBook() {
		return book;
	}


	public void setBook(Book book) {
		this.book = book;
		this.id.setBook(book);
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "order_id", insertable = false, nullable = false, updatable = false)
	public BookOrder getBookOrder() {
		return bookOrder;
	}


	public void setBookOrder(BookOrder bookOrder) {
		this.bookOrder = bookOrder;
		this.id.setBookOrder(bookOrder);
	}

	@Column(name = "quantity")
	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Column(name = "sub_total")
	public float getSub_total() {
		return sub_total;
	}


	public void setSub_total(float sub_total) {
		this.sub_total = sub_total;
	}
	
	
	
}
