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

import online.shop.Category;
import online.shop.Item;

@TestMethodOrder(OrderAnnotation.class)
class Data_insert_test {
	
	static EntityManagerFactory emf;
	EntityManager em;
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
		em=emf.createEntityManager();
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
	}
	
	@Test
	@Order(1)
	void insert_categories() {
		em.getTransaction().begin();
		Category c = new Category();
		c.setName("Drinks");
		em.persist(c);
		
		Category c1 = new Category();
		c1.setName("Dessert");
		em.persist(c1);
		
		Category c2 = new Category();
		c2.setName("Milkshakes");
		em.persist(c2);
		
		Category c3 = new Category();
		c3.setName("Cake");
		em.persist(c3);
		
		Category c4 = new Category();
		c4.setName("Waffles");
		em.persist(c4);
		
		Category c5 = new Category();
		c5.setName("Coffee");
		em.persist(c5);
		
		em.getTransaction().commit();
	}
	
	@Test
	@Order(2)
	void insert_item() {
		em.getTransaction().begin();
		Category c = em.find(Category.class, 6);
		
		Item i = new Item();
		i.setName("Stumptown Coffee: Espresso");
		i.setPrice(3);
		i.addCategory(c);
		em.getTransaction().commit();
	}

}
