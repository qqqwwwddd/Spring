package run;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPAFinalTest {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step11_JPA_Practice");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		JPA02CRUD crud = new JPA02CRUD();

		// create 따로
		crud.create(em, tx);

		tx.begin();

		// select
		System.out.println(crud.select(em, 1L));

		// update

		tx.commit();

	}

}
