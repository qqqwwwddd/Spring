package run;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entity.User;

public class JPA02CRUD {
	// create 외에 에러가 나도 테이블이 성공적으로 만들어질 수 있게 tx 따로 실행
	public void create(EntityManager em, EntityTransaction tx) {
		JPA01Create create = new JPA01Create();
		create.create(em, tx);

	}

	public User select(EntityManager em, Long id) {
		JPA01Select select = new JPA01Select();
		return select.select(em, id);
	}

}
