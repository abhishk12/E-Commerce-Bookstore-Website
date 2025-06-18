package com.bookstore.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.bookstore.entity.Category;


class CategoryDAOTest extends BaseDAOTest {
	
	
	private static CategoryDAO categoryDAO;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		BaseDAOTest.setUpBeforeClass();
		categoryDAO = new CategoryDAO(entityManager);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		BaseDAOTest.tearDownAfterClass();
	}

	@Test
	void testCreateCategory() {
		Category newCategory = new Category("Crime");
		Category addedCategory = categoryDAO.create(newCategory);
		assertTrue((addedCategory!=null) && (addedCategory.getCategory_id()>0));
	}

	@Test
	void testUpdateCategory() {
		Category newCategory = new Category("Sci-Fi");
		newCategory.setCategory_id(11);
		Category changedCategory = categoryDAO.update(newCategory);
		assertEquals(newCategory.getName(), changedCategory.getName());
	}

	@Test
	void testGet() {
		Category category = categoryDAO.get(11);
		assertNotNull(category);
	}

	@Test
	void testDeleteCategory() {
		categoryDAO.delete(13);
		Category category = categoryDAO.get(13);
		assertNull(category);
	}

	@Test
	void testListAll() {
		List<Category> categories = categoryDAO.listAll();
		assertTrue(categories.size()>0);
	}

	@Test
	void testCount() {
		long cnt = categoryDAO.count();
		assertEquals(cnt, 2);
	}
	
	@Test
	void testFindByName() {
		Category category = categoryDAO.findByName("Horror");
		assertNotNull(category);
	}
	
	@Test
	void testFindByNameNotFound() {
		Category category = categoryDAO.findByName("Horr");
		assertNull(category);
	}

}
