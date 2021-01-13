package online.shop.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;



import online.shop.Category;

public class CategoryRepository {
	EntityManager em;
	
	public CategoryRepository(EntityManager em) {
		this.em = em;
	}
	
	public Category findById(int id) {
		Category c = em.find(Category.class, id);	
		return c;
	}
	
	public List<Category> descOrder() {
		@SuppressWarnings("unchecked")
		List<Category> c = em.createQuery("SELECT c FROM Category c ORDER BY name DESC").getResultList();
		return c;
	}
	
	public List<Category> greatestCategory() {
		@SuppressWarnings("unchecked")
		List<Category> c = em.createQuery("SELECT c FROM Category c ORDER BY id DESC")
				.setMaxResults(1)
				.getResultList();
		return c;
	}
	
	public List<Category> endWithS() {
		@SuppressWarnings("unchecked")
		List<Category> c = em.createQuery("SELECT c FROM Category c WHERE c.name LIKE '%s'")
				.getResultList();
		return c;
	}
	
	public void updateCategory(int id, String name) {
		em.getTransaction().begin();
		Category c = em.find(Category.class, id);
		c.setName(name);
		em.persist(c);
		em.getTransaction().commit();
	}
	
	public void removeCategory(int id) {
		em.getTransaction().begin();
		Category c = em.find(Category.class, id);
		em.remove(c);
		em.getTransaction().commit();
	}
	
	public void removeCategories() {
		em.getTransaction().begin();
		Query query = em.createQuery("DELETE FROM Category c WHERE c.id BETWEEN 2 AND 4");
		query.executeUpdate();
		em.getTransaction().commit();
	}
}
