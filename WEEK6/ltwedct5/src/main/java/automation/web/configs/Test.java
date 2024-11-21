package automation.web.configs;


import automation.web.etity.Video;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class Test {
	public static void main(String[] args) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		Video vid = new Video();
		vid.setTitle("PLC Siemens");
		vid.setViews(300);
		vid.setDescription("cskjcnaks");
		
		try {
			trans.begin();
			enma.persist(vid);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
	}
}
