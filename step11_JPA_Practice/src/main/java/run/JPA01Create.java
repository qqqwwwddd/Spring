package run;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entity.User;

public class JPA01Create {
	public void create(EntityManager em, EntityTransaction tx) {
		// create
		tx.begin();

		// insert
		User user = new User();
		user.setName("정인");
		user.setAge(20);
		em.persist(user);

		User user1 = new User();
		user.setName("영광");
		user.setAge(26);
		em.persist(user1);

		tx.commit();

	}
}
