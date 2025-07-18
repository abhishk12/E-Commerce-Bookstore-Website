package com.bookstore.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bookstore.entity.Book;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class BookDAO extends JpaDAO<Book> implements GenericDAO<Book> {

	public BookDAO() {

	}

	@Override
	public Book create(Book book) {
		book.setLast_update_time(new Date());
		return super.create(book);
	}

	@Override
	public Book update(Book book) {
		book.setLast_update_time(new Date());
		return super.update(book);
	}

	@Override
	public Book get(Object bookId) {
		return super.find(Book.class, bookId);
	}

	@Override
	public void delete(Object bookId) {
		super.delete(Book.class, bookId);
		
	}

	@Override
	public List<Book> listAll() {
		return super.findWithNamedQuery("book.findAll");
	}
	
	public Book findByTitle(String title) {
		List<Book> listBook = super.findWithNamedQuery("book.findByTitle", "title", title);
		
		if(listBook.size()>0) {
			return listBook.get(0);
		}
		return null;
	}

	@Override
	public long count() {
		
		return super.countWithNamedQuery("book.countAll");
	}
	
	public List<Book> listByCategory(int categoryId){
		return super.findWithNamedQuery("book.findByCategory", "categoryId", categoryId);
	}
	
	public List<Book> listNewBooks(){
		
		return super.findWithNamedQuery("book.listNewBooks", 0, 4);
	}
	
	public List<Book> search(String queryString){
		return super.findWithNamedQuery("book.findWithQueryString", "queryString", queryString);
	}
	
	public long countByCategory(int categoryId) {
		return super.countWithNamedQuery("book.countByCategory", "categoryID", categoryId);
	}
	
	public List<Book> listBestSellingBooks(){
		List<Book> listBooks = super.findWithNamedQuery("bookOrder.bestSelling", 0, 4);
		return listBooks;
	}
	
	
	public List<Book> listMostFavouredBooks(){
		List<Book> listBooks = new ArrayList<Book>();
		List<Object[]> result = super.findWithNamedQueryObjects("review.mostFavoured", 0, 4);
		
		if(!result.isEmpty()) {
			for(Object[] elements: result) {
				Book book = (Book) elements[0];
				listBooks.add(book);
			}
		}
		
		return listBooks;
	}
}


