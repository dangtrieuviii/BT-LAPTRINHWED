package automation.web.configs;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;

@PersistenceContext
public class JPAConfig {
public static EntityManager getEntityManager() {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa_automation");
	return factory.createEntityManager();
}
}
