package com.bookstore.dao;

import java.util.List;

import com.bookstore.entity.Category;

import jakarta.persistence.EntityManager;

public class CategoryDAO extends JpaDAO<Category> implements GenericDAO<Category> {

	public CategoryDAO(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Category create(Category category) {
		
		return super.create(category);
	}
	
	@Override
	public Category update(Category category) {
		return super.update(category);
	}
	
	@Override
	public Category get(Object id) {
		return super.find(Category.class, id);
	}

	@Override
	public void delete(Object id) {
		super.delete(Category.class, id);
		
	}

	@Override
	public List<Category> listAll() {
		return super.findWithNamedQuery("category.findAll");
	}

	@Override
	public long count() {
		
		return super.countWithNamedQuery("category.countAll");
	}
	
	public Category findByName(String categoryName) {
		List<Category> categories = super.findWithNamedQuery("category.findByName", "name", categoryName);
		
		if((categories!=null) && (categories.size()>0)) {
			return categories.get(0);
		}
		return null;
	}


}
