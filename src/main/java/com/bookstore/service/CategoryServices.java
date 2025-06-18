package com.bookstore.service;

import java.io.IOException;
import java.util.List;

import com.bookstore.dao.CategoryDAO;
import com.bookstore.entity.Category;

import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CategoryServices {
	
	private CategoryDAO categoryDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private EntityManager entityManager;
	
	public CategoryServices(EntityManager entityManager, HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.entityManager = entityManager;
		categoryDAO = new CategoryDAO(entityManager);
	}
	
	public void listCategory() throws ServletException, IOException {
		listCategory(null);
	}
	
	public void listCategory(String message) throws ServletException, IOException {
		List<Category> listCategory = categoryDAO.listAll();
		if(message!=null) {
			request.setAttribute("newCategoryMessage", message);
		}
		
		

		
		request.setAttribute("pageTitle", "Manage Category");
		request.setAttribute("listCategory", listCategory);
		request.getRequestDispatcher("category_list.jsp").forward(request, response);
	}
	
	public void createCategory() throws ServletException, IOException {
		String categoryName = request.getParameter("category_name");
		Category existCategory = categoryDAO.findByName(categoryName);
		
		if(existCategory != null) {
			request.setAttribute("newUserMessage", "Category already exist!");
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}
		else {
			Category newCategory = new Category(categoryName);
			categoryDAO.create(newCategory);
			listCategory("Category successfully created!");

		}
	}
	
	public void editCategory() throws ServletException, IOException {
		int categoryId = Integer.parseInt(request.getParameter("id"));
		Category category = categoryDAO.get(categoryId);
		request.setAttribute("categoryObj", category);
		request.getRequestDispatcher("category_form.jsp").forward(request, response);
	}
	
	public void updateCategory() throws ServletException, IOException {
		int categoryId = Integer.parseInt(request.getParameter("category_id"));
		String categoryName = request.getParameter("category_name");
		
		Category existingCategoryById = categoryDAO.get(categoryId);
		Category existingCategoryByName = categoryDAO.findByName(categoryName);
		
		if((existingCategoryByName!=null) && (existingCategoryById.getCategory_id() != existingCategoryByName.getCategory_id())) {
			request.setAttribute("newUserMessage", "Could not update category. Category name already exists!");
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}
		else {
			existingCategoryById.setName(categoryName);
			categoryDAO.update(existingCategoryById);
			listCategory("Category name updated successfully!");
		}
		
		
	}
}
