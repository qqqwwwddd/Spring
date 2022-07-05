package run;

import javax.persistence.EntityManager;

import entity.User;

public class JPA01Select {
	public User select(EntityManager em, Long id) {
		return em.find(User.class, id);

	}

}
