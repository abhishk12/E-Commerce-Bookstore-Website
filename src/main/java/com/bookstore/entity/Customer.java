package com.bookstore.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity(name="customer")
@Table(name="customer")
@NamedQueries({
	@NamedQuery(name = "customer.findAll", query = "SELECT c FROM customer c ORDER BY c.register_date DESC"),
	@NamedQuery(name = "customer.countAll", query = "SELECT COUNT(*) FROM customer c"),
	@NamedQuery(name = "customer.findByEmail", query = "SELECT c FROM customer c WHERE c.email= :email")
})
public class Customer implements Serializable {
	
	private int customer_id;
	private String email;
	private String full_name;
	private String address;
	private String city;
	private String country;
	private String phone;
	private String zip_code;
	private String password;
	private Date register_date;
	private Set<Review> reviews = new HashSet<Review>(0);
	private Set<BookOrder> book_orders = new HashSet<BookOrder>(0);
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Customer(String email, String full_name, String address, String city, String country, String phone,
			String zip_code, String password, Date register_date, Set<Review> reviews, Set<BookOrder> book_orders) {
		super();
		this.email = email;
		this.full_name = full_name;
		this.address = address;
		this.city = city;
		this.country = country;
		this.phone = phone;
		this.zip_code = zip_code;
		this.password = password;
		this.register_date = register_date;
		this.reviews = reviews;
		this.book_orders = book_orders;
	}


	public Customer(String email, String full_name, String address, String city, String country, String phone,
			String zip_code, String password, Date register_date) {
		super();
		this.email = email;
		this.full_name = full_name;
		this.address = address;
		this.city = city;
		this.country = country;
		this.phone = phone;
		this.zip_code = zip_code;
		this.password = password;
		this.register_date = register_date;
	}

	@Id
	@Column(name = "customer_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getCustomer_id() {
		return customer_id;
	}


	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "full_name")
	public String getFull_name() {
		return full_name;
	}


	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	@Column(name = "address")
	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "city")
	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "country")
	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "phone")
	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "zip_code")
	public String getZip_code() {
		return zip_code;
	}


	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "register_date")
	public Date getRegister_date() {
		return register_date;
	}


	public void setRegister_date(Date register_date) {
		this.register_date = register_date;
	}

	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
	public Set<Review> getReviews() {
		return reviews;
	}


	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}

	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
	public Set<BookOrder> getBook_orders() {
		return book_orders;
	}


	public void setBook_orders(Set<BookOrder> book_orders) {
		this.book_orders = book_orders;
	}
	
	
	
}
