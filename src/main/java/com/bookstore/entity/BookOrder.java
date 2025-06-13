package com.bookstore.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity(name="book_order")
@Table(name="book_order")
public class BookOrder implements Serializable {
	
	private int order_id;
	private Customer customer;
	private Date order_date;
	private String shipping_address;
	private String recipient_name;
	private String recipient_phone;
	private String payment_method;
	private float total;
	private String status;
	private Set<OrderDetail> order_details = new HashSet<OrderDetail>(0);
	
	
	public BookOrder() {
		super();
		// TODO Auto-generated constructor stub
	}


	public BookOrder(Customer customer, Date order_date, String shipping_address, String recipient_name,
			String recipient_phone, String payment_method, float total, String status, Set<OrderDetail> order_details) {
		super();
		this.customer = customer;
		this.order_date = order_date;
		this.shipping_address = shipping_address;
		this.recipient_name = recipient_name;
		this.recipient_phone = recipient_phone;
		this.payment_method = payment_method;
		this.total = total;
		this.status = status;
		this.order_details = order_details;
	}


	public BookOrder(Customer customer, Date order_date, String shipping_address, String recipient_name,
			String recipient_phone, String payment_method, float total, String status) {
		super();
		this.customer = customer;
		this.order_date = order_date;
		this.shipping_address = shipping_address;
		this.recipient_name = recipient_name;
		this.recipient_phone = recipient_phone;
		this.payment_method = payment_method;
		this.total = total;
		this.status = status;
	}

	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getOrder_id() {
		return order_id;
	}


	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id", nullable = false)
	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "order_date")
	public Date getOrder_date() {
		return order_date;
	}


	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	
	@Column(name = "shipping_address")
	public String getShipping_address() {
		return shipping_address;
	}

	
	public void setShipping_address(String shipping_address) {
		this.shipping_address = shipping_address;
	}

	@Column(name = "recipient_name")
	public String getRecipient_name() {
		return recipient_name;
	}


	public void setRecipient_name(String recipient_name) {
		this.recipient_name = recipient_name;
	}

	@Column(name = "recipient_phone")
	public String getRecipient_phone() {
		return recipient_phone;
	}


	public void setRecipient_phone(String recipient_phone) {
		this.recipient_phone = recipient_phone;
	}

	@Column(name = "payment_method")
	public String getPayment_method() {
		return payment_method;
	}


	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}

	@Column(name = "total")
	public float getTotal() {
		return total;
	}


	public void setTotal(float total) {
		this.total = total;
	}

	@Column(name = "status")
	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	@OneToMany(mappedBy = "bookOrder", fetch = FetchType.EAGER)
	public Set<OrderDetail> getOrder_details() {
		return order_details;
	}


	public void setOrder_details(Set<OrderDetail> order_details) {
		this.order_details = order_details;
	}
	
	
	
}
