package automation.web.dao.impl;

import java.util.List;

import org.eclipse.tags.shaded.org.apache.regexp.recompile;

import com.mysql.cj.QueryResult;

import Automation.Web.configs.JPAConfig;
import Automation.Web.dao.InterFaceCategoryDao;
import Automation.Web.entity.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class CategoryDaoImpl implements InterFaceCategoryDao {

	@Override
	public void insert(Category category) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.persist(category);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
	}

	@Override
	public void update(Category category) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.merge(category);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
	}

	@Override
	public void delete(int categoryid) throws Exception {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			 Category category = enma.find(Category.class,categoryid);
			 if(category != null) {
			 enma.remove(category);
			 }else {
			 throw new Exception("Không tìm thấy");
			 }
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
	}

	@Override
	public Category findById(int categoryid) {
		EntityManager enma = JPAConfig.getEntityManager();
		Category category = enma.find(Category.class, categoryid);
		return category;
	}

	@Override
	public List<Category> findAll() {
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<Category> query = enma.createNamedQuery("Category.findAll", Category.class);
		return query.getResultList();
	}

	@Override
	public Category findByCategoryname(String name) throws Exception {


		 EntityManager enma = JPAConfig.getEntityManager();
		 String jpql = "SELECT c FROM Category c WHERE c.categoryname =:catename";
		 try {
		 TypedQuery<Category> query= enma.createQuery(jpql, Category.class);
		 query.setParameter("catename", name);
		 Category category= query.getSingleResult();
		 if(category==null) {
		 throw new Exception("Category Name đã tồn tại");
		 }
		 return category;
		 } finally {
		 enma.close();
		 } 
	}
	
	@Override
	public List<Category> findAll(int page, int pagesize) {
		 EntityManager enma = JPAConfig.getEntityManager();
		 TypedQuery<Category> query= enma.createNamedQuery("Category.findAll", Category.class);
		 query.setFirstResult(page*pagesize);
		 query.setMaxResults(pagesize);
		 return query.getResultList();
		 }
	
	@Override
	public int count() {
		 EntityManager enma = JPAConfig.getEntityManager();
		 String jpql = "SELECT count(c) FROM Category c";
		 Query query = enma.createQuery(jpql);
		 return ((Long)query.getSingleResult()).intValue();
		 }
	
	
}
