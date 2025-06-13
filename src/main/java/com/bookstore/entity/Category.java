package com.bookstore.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity(name="category")
@Table(name="category")
public class Category implements Serializable {

	private int category_id;
	private String name;
	private Set<Book> books = new HashSet<Book>(0);
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(String name, Set<Book> books) {
		super();
		this.name = name;
		this.books = books;
	}

	public Category(String name) {
		super();
		this.name = name;
	}
	
	@Id
	@Column(name = "category_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	
	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	
	
	
}
