package online.shop.test;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.*;

import online.shop.Category;
import online.shop.service.CategoryRepository;

@TestMethodOrder(OrderAnnotation.class)
class Category_management_test {
	static EntityManagerFactory emf;
	EntityManager em;
	CategoryRepository cr;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("project-assignment");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		 cr = new CategoryRepository(em);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
	}

	@Test
	@Order(1)
	void category_findById() {
		Category c = cr.findById(2);
		System.out.println("Category Name: " + c.getName());
	}
	
	@Test
	@Order(2)
	void category_descOrder() {
		List<Category> dList = cr.descOrder();
		for(Category c : dList) {
			System.out.println(c.getName());
		}
	}
	
	@Test
	@Order(3)
	void category_greatestCategory() {
		List<Category> gCategory = cr.greatestCategory();
		for(Category c : gCategory) {
			System.out.println(c.getName());
		}
	}
	
	@Test
	@Order(4)
	void category_endWithS() {
		List<Category> sList = cr.endWithS();
		for(Category c : sList) {
			System.out.println(c.getName());
		}
	}
	
	@Test
	@Order(5)
	void category_updateCategory() {
		cr.updateCategory(2, "Sweets");
	}
	
	@Test
	@Order(6)
	void category_removeCategory() {
		cr.removeCategory(5);
	}
	
	@Test
	@Order(7)
	void category_removeCategories() {
		cr.removeCategories();
	}

}
