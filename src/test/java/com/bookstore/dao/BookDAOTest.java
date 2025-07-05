package com.bookstore.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.bookstore.entity.Book;
import com.bookstore.entity.Category;

import jakarta.persistence.EntityNotFoundException;

class BookDAOTest {
	private static BookDAO bookDAO;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		bookDAO = new BookDAO();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		bookDAO.close();
	}

	@Test
	void testCreateBook() throws ParseException, IOException {
		Book newBook = new Book();
		Category category = new Category("Business & Economics");
		category.setCategory_id(18);
		newBook.setCategory(category);
		
		newBook.setTitle("Rich Dad Poor Dad");
		newBook.setAuthor("Robert T. Kiyosaki");
		newBook.setDescription("Rich Dad Poor Dad is Robert's story of growing up with two dads — his real father and the father of his best friend, his rich dad — and the ways in which both men shaped his thoughts about money and investing.");
		newBook.setPrice(375.00f);
		newBook.setIsbn("978-1612681139");
		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date publishDate = dateFormat.parse("08/06/2022");
		newBook.setPublish_date(publishDate);
		
		
		String imagePath = "C:\\Users\\Abhishek Kakakde\\Downloads\\testBookImage2.jpg";
		byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
		newBook.setImage(imageBytes);
		
		Book createdBook = bookDAO.create(newBook);
		assertTrue(createdBook.getBook_id()>0);
		
		
	}
	
	@Test
	void testUpdateBook() throws ParseException, IOException {
		Book newBook = new Book();
		Category category = new Category("Business & Economics");
		category.setCategory_id(18);
		newBook.setCategory(category);
		newBook.setBook_id(34);
		newBook.setTitle("Rich Dad Poor Dad");
		newBook.setAuthor("Robert T. Kiyosaki");
		newBook.setDescription("Rich Dad Poor Dad is Robert's story of growing up with two dads — his real father and the father of his best friend, his rich dad — and the ways in which both men shaped his thoughts about money and investing.");
		newBook.setPrice(375.00f);
		newBook.setIsbn("978-1612681139");
		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date publishDate = dateFormat.parse("08/06/2022");
		newBook.setPublish_date(publishDate);
		
		
		String imagePath = "C:\\Users\\Abhishek Kakakde\\Downloads\\testBookImage2.jpg";
		byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
		newBook.setImage(imageBytes);
		
		Book updatedBook = bookDAO.update(newBook);
		assertEquals(updatedBook.getPublish_date(), newBook.getPublish_date());
	} 
	
	@Test()
	void testDeleteBookFail(){
		int bookId = 1;
		bookDAO.delete(bookId);
	}
	
	@Test()
	void testDeleteBookSuccess(){
		int bookId = 32;
		bookDAO.delete(bookId);
		assertTrue(true);
	}
	
	@Test()
	void testGetBookFail() {
		int bookId = 32;
		assertNull(bookDAO.get(bookId));
	}
	
	@Test()
	void testGetBookSuccess() {
		int bookId = 33;
		assertNotNull(bookDAO.get(bookId));
	}
	
	
	@Test()
	void testListAllBook() {
		List<Book> listBook = bookDAO.listAll();
		for(Book bk: listBook) {
			System.out.println(bk.getTitle());
		}
		assertTrue(listBook.size()>0);
	}
	
	@Test()
	void testFindByTitleNotExist() {
		String title = "sdfhsdf";
		assertNull(bookDAO.findByTitle(title));
	}
	
	@Test()
	void testFindByTitleExists() {
		String title = "Bhagvad Gita";
		Book bk = bookDAO.findByTitle(title);
		System.out.println(bk.getDescription());
		assertNotNull(bk);
	}
	
	@Test()
	void testCountSuccess() {
		long cnt = bookDAO.count();

		assertEquals(cnt, 1);
	}
	
	@Test()
	void testCountFailure() {
		long cnt = bookDAO.count();

		assertNotEquals(cnt, 2);
	}
	
	@Test()
	void testListByCategory() {
		List<Book> listBooksByCategory = bookDAO.listByCategory(19);
		
		for(Book bk: listBooksByCategory) {
			System.out.println(bk.getTitle());
		}
		
		assertTrue(listBooksByCategory.size() > 0);
	}
	
	@Test()
	void testListNewBooks() {
		List<Book> listBooksByCategory = bookDAO.listNewBooks();
		
		for(Book bk: listBooksByCategory) {
			System.out.println(bk.getTitle() + " Date: " + bk.getPublish_date());
		}
		
		assertTrue(listBooksByCategory.size() > 0);
	}
	
	@Test()
	void testFindWithQueryString() {
		List<Book> listBooks = bookDAO.search("of");
		
		for(Book bk: listBooks) {
			System.out.println(bk.getTitle());
		}
		
		assertEquals(listBooks.size(), 2);
		
		
	}
	
	@Test()
	void testFindWithQueryStringInAuthor() {
		List<Book> listBooks = bookDAO.search("king");
		
		for(Book bk: listBooks) {
			System.out.println(bk.getTitle());
		}	
		assertEquals(listBooks.size(), 1);	
	}
	
	@Test()
	void testCountByCategory() {
		long cnt = bookDAO.countByCategory(19);
		
		assertTrue(cnt>0);	
	}
	
	@Test()
	void testListBestSellingBooks() {
		List<Book> listBooks = bookDAO.listBestSellingBooks();
		assertEquals(4, listBooks.size());
	}
	
	@Test()
	void testListMostFavouredBooks() {
		List<Book> listBooks = bookDAO.listMostFavouredBooks();
		assertEquals(4, listBooks.size());
	}
	
}


