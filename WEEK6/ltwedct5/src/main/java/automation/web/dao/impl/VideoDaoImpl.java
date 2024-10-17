package automation.web.dao.impl;

import java.util.List;

import org.eclipse.tags.shaded.org.apache.regexp.recompile;

import com.mysql.cj.QueryResult;

import Automation.Web.configs.JPAConfig;
import Automation.Web.dao.InterFaceVideoDao;
import Automation.Web.entity.Video;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class VideoDaoImpl implements InterFaceVideoDao {


	@Override
	public void insert(Video video) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.persist(video);
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
	public void update(Video video) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.merge(video);
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
	public void delete(int videoid) throws Exception {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			 Video video = enma.find(Video.class,videoid);
			 if(video != null) {
			 enma.remove(video);
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
	public Video findById(int videoid) {
		EntityManager enma = JPAConfig.getEntityManager();
		Video video = enma.find(Video.class, videoid);
		return video;
	}


	@Override
	public List<Video> findAll() {
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<Video> query = enma.createNamedQuery("Video.findAll", Video.class);
		return query.getResultList();
	}


	@Override
	public Video findByvideoname(String name) throws Exception {


		 EntityManager enma = JPAConfig.getEntityManager();
		 String jpql = "SELECT c FROM video c WHERE c.videoname =:vidname";
		 try {
		 TypedQuery<Video> query= enma.createQuery(jpql, Video.class);
		 query.setParameter("vidname", name);
		 Video video= query.getSingleResult();
		 if(video==null) {
		 throw new Exception("video Name đã tồn tại");
		 }
		 return video;
		 } finally {
		 enma.close();
		 } 
	}
	

	@Override
	public List<Video> findAll(int page, int pagesize) {
		 EntityManager enma = JPAConfig.getEntityManager();
		 TypedQuery<Video> query= enma.createNamedQuery("video.findAll", Video.class);
		 query.setFirstResult(page*pagesize);
		 query.setMaxResults(pagesize);
		 return query.getResultList();
		 }
	

	@Override
	public int count() {
		 EntityManager enma = JPAConfig.getEntityManager();
		 String jpql = "SELECT count(c) FROM video c";
		 Query query = enma.createQuery(jpql);
		 return ((Long)query.getSingleResult()).intValue();
		 }
	
	
}
