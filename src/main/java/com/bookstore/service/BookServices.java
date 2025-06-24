package com.bookstore.service;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.bookstore.dao.BookDAO;
import com.bookstore.dao.CategoryDAO;
import com.bookstore.entity.Book;
import com.bookstore.entity.Category;

import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

public class BookServices {
	private BookDAO bookDAO;
	private CategoryDAO categoryDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public BookServices(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;

		bookDAO = new BookDAO();
		categoryDAO = new CategoryDAO();
	}
	
	public void listBooks() throws ServletException, IOException {
		listBooks(null);
	}
	
	public void listBooks(String message) throws ServletException, IOException {
		List<Book> listBooks = bookDAO.listAll();
		request.setAttribute("listBooks", listBooks);
		request.setAttribute("pageTitle", "Manage Books");
		
		if(message!=null) {
			request.setAttribute("newBookMessage", message);
		}
		
		request.getRequestDispatcher("book_list.jsp").forward(request, response);
	}
	
	public void showBookCreationForm() throws ServletException, IOException {
//		List<Category> listCategories = categoryDAO.listAll();
//		request.setAttribute("listCategory", listCategories);
		request.getRequestDispatcher("book_form.jsp").forward(request, response);
	}
	
	public void createBook() throws ServletException, IOException {
		Book newBook = new Book();
		readBookFields(newBook);
		Book sameTitlebook = bookDAO.findByTitle(newBook.getTitle());
		
		if(sameTitlebook!= null) {
			listBooks("Cannot create new book. Title already exists!");
		}
		Book createdBook = bookDAO.create(newBook);
		
		if(createdBook.getBook_id()>0) {
			request.setAttribute("newBookMessage", "Book created successfully!");
			listBooks("Book created successfully!");
		}

	}
	
	public void editBook() throws ServletException, IOException {
		int bookId = Integer.parseInt(request.getParameter("id"));
		Book bk = bookDAO.get(bookId);
//		List<Category> listCategories = categoryDAO.listAll();
//		
//		request.setAttribute("listCategory", listCategories);
		request.setAttribute("bookObj", bk);
		request.getRequestDispatcher("book_form.jsp").forward(request, response);
	}
	
	public void readBookFields(Book book) throws ServletException, IOException {
		String title = request.getParameter("book_title");
		String book_author = request.getParameter("book_author");
		String book_isbn = request.getParameter("book_isbn");
		float book_price = Float.parseFloat(request.getParameter("book_price")) ;
		String book_description = request.getParameter("book_description");
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date book_publish_date = null;
		try {
			book_publish_date = dateFormat.parse(request.getParameter("book_publish_date"));
		} catch (ParseException e) {
			e.printStackTrace();
			throw new ServletException("Error parsing publish date..");
		}
		
		Part part = request.getPart("book_cover");
		if(part != null && part.getSize() > 0) {
			long size = part.getSize();
			byte[] imageBytes = new byte[(int)size];
			InputStream inputStream = part.getInputStream();
			inputStream.read(imageBytes);
			inputStream.close();
			book.setImage(imageBytes);
		}
		
		
		book.setTitle(title);
		book.setAuthor(book_author);
		book.setDescription(book_description);
		book.setIsbn(book_isbn);
		book.setPublish_date(book_publish_date);
		int category_id = Integer.parseInt(request.getParameter("book_category"));
		Category category = categoryDAO.get(category_id);
		book.setCategory(category);
		book.setPrice(book_price);
	}
	
	public void updateBook() throws ServletException, IOException {
		String title = request.getParameter("book_title");
		int bookId = Integer.parseInt(request.getParameter("book_id"));
		
		Book existingBook = bookDAO.get(bookId);
		Book bookByTitle = bookDAO.findByTitle(title);
		
		if( (bookByTitle!=null) && (!existingBook.equals(bookByTitle))) {
			listBooks("Could not update book. Title already exists!");
			return;
		}
		
		readBookFields(existingBook);
		bookDAO.update(existingBook);
		listBooks("The book has been updated successfully!");
		
	}

	public void deleteBook() throws ServletException, IOException {
		int bookId = Integer.parseInt(request.getParameter("id"));
		bookDAO.delete(bookId);
		listBooks("Book deleted successfully!");
		
	}

	public void listBooksByCategory() throws ServletException, IOException {
		int categoryId = Integer.parseInt(request.getParameter("id"));
		String categoryName = request.getParameter("name");
		List<Book> listBooksByCategory = bookDAO.listByCategory(categoryId);
		
//		List<Category> listCategories = categoryDAO.listAll();
//		request.setAttribute("listCategory", listCategories);
		
		request.setAttribute("listBooksByCategory", listBooksByCategory);
		request.setAttribute("pageTitle", "Books in " + categoryName + " - An Online Bookstore");
		request.setAttribute("categoryName", categoryName);
		request.getRequestDispatcher("frontend/books_list_by_category.jsp").forward(request, response);
		
	}

	public void viewBookDetail() throws ServletException, IOException {
		int bookId = Integer.parseInt(request.getParameter("id"));
		Book bookDetail = bookDAO.get(bookId);
//		List<Category> listCategories = categoryDAO.listAll();
//		request.setAttribute("listCategory", listCategories);
		request.setAttribute("pageTitle", bookDetail.getTitle());
		request.setAttribute("bookDetail", bookDetail);
		request.getRequestDispatcher("frontend/book_detail.jsp").forward(request, response);

	}

	public void search() throws ServletException, IOException {
		String queryString = request.getParameter("keyword");
		List<Book> resultList = null;
		
		if((queryString == null) || (queryString.equals(""))) {
			resultList = bookDAO.listAll();
		}
		else {
			resultList = bookDAO.search(queryString);
		}
//		List<Category> listCategories = categoryDAO.listAll();
		request.setAttribute("resultList", resultList);
//		request.setAttribute("listCategory", listCategories);
		request.setAttribute("queryString", queryString);
		request.setAttribute("pageTitle", "Results for " + queryString);
		
		request.getRequestDispatcher("frontend/search_result.jsp").forward(request, response);
		
	}
}
