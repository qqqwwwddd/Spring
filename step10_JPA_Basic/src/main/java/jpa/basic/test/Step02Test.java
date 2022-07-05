package jpa.basic.test;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jpa.basic.enumType.MemberType;
import step02.entity.Member2;

public class Step02Test {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step10_JPA_Basic");

		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();

		tx.begin();

		try {
			logic(em);
			tx.commit();

		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
			tx.rollback();
		} finally {
			em.close();
		}

		emf.close();

	}

	private static void logic(EntityManager em) {
		Member2 member = new Member2();
//		member.setId(1L);
		member.setName("pasta");
		member.setAge(10);
		member.setMemberType(MemberType.NORMAL);
		member.setRegistrationTime(LocalDateTime.now());

		em.persist(member);
		System.out.println(member);

	}
}
