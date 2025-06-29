package com.bookstore.controller.frontend.shoppingcart;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.bookstore.entity.Book;

public class ShoppingCart {
	private Map<Book, Integer> cart = new HashMap<>();
	
	public void addItem(Book book) {
		
		if(cart.containsKey(book)) {
			Integer quantity = cart.get(book) + 1;
			cart.put(book, quantity);
		}
		else {
			cart.put(book, 1);
		}
		
	}
	
	public Map<Book, Integer> getItems(){
		return this.cart;
	}
	
	public void removeItem(Book book) {
		cart.remove(book);
	}
	
	public int getTotalQuantity() {
		int total = 0;
		
		Iterator<Book> itr = cart.keySet().iterator();
		while(itr.hasNext()) {
			Book next = itr.next();
			Integer quantity = cart.get(next);
			total += quantity;
		}
		return total;
	}
	
	public float getTotalAmount() {
		float total = 0.0f;
		
		Iterator<Book> itr = cart.keySet().iterator();
		while(itr.hasNext()) {
			Book next = itr.next();
			Integer quantity = cart.get(next);
			total += quantity*next.getPrice();
		}
		return total;
	}
	
	public void clear() {
		cart.clear();
	}
	
	public int getTotalItems() {
		return cart.size();
	}
	
	public void updateCart(int[] bookIds, int[] quantities) {
		
		for(int i = 0 ; i < bookIds.length ; i++  ) {
			Book key = new Book(bookIds[i]);
			int value = quantities[i];
			cart.put(key, value);
		}
		
	}
	
	
} 




