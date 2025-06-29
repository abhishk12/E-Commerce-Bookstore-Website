package com.bookstore.controller.frontend.shoppingcart;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.bookstore.dao.BookDAO;
import com.bookstore.entity.Book;

class ShoppingCartTest {
	private static ShoppingCart cart;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		cart = new ShoppingCart();
		Book book = new Book(1);
		book.setPrice(10);
		cart.addItem(book);
		cart.addItem(book);
	}
	
	@Test
	void testAddItem() {
		Map<Book, Integer> items = cart.getItems();
		int quantity = items.get(new Book(1));
		assertEquals(2, quantity);

	}
	
	@Test
	public void testRemoveItem(){
		cart.removeItem(new Book(1));
		assertTrue(cart.getItems().isEmpty());
	}
	
	@Test
	public void testRemoveItem2(){
		Book book2 = new Book(2);
		cart.addItem(book2);
		cart.removeItem(new Book(2));
		assertNull(cart.getItems().get(book2));
	}
	
	@Test
	public void testTotalQuantity(){
		Book book3 = new Book(3);
		cart.addItem(book3);
		cart.addItem(book3);
		cart.addItem(book3);
		assertEquals(5, cart.getTotalQuantity());
		
	}
	
	@Test
	public void testTotalAmountZero(){
		ShoppingCart cart2 = new ShoppingCart();
		assertEquals(0.0f, cart.getTotalAmount());
		
	}
	
	@Test
	public void testTotalAmountNonZero(){
		float totalAmount = cart.getTotalAmount();
		System.out.println(totalAmount);
		assertEquals(20.0f, cart.getTotalAmount());
	}
	
	@Test
	public void testClear(){
		int totalQuantityBefore = cart.getTotalQuantity();
		
		cart.clear();
		int totalQuantity = cart.getTotalQuantity();
		
		System.out.println("total before: " + totalQuantityBefore + "\ntotal after:" + totalQuantity);
		assertEquals(0, totalQuantity);
	}
	
	@Test
	public void testUpdateCart(){
		ShoppingCart cart = new ShoppingCart();
		Book book1 = new Book(1);
		Book book2 = new Book(2);
		cart.addItem(book2);
		cart.addItem(book1);
		
		int[] bookids = {1,2};
		int[] quantities = {3,4};
		
		cart.updateCart(bookids, quantities);
		assertEquals(7, cart.getTotalQuantity());
	}
	
	
}
