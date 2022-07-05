package mapping.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import step06.entity.Member;

public class Step06Test {
	static void logic(EntityManager em) {

//		Product productA = new Product();
////		productA.setId(1L);
//		productA.setName("상품A");
//		em.persist(productA);
//
//		Member member1 = new Member();
////		member1.setId(1L);
//		member1.setName("멤버1");
//		member1.setAge(27);
//		em.persist(member1);
////
////		// MemberProduct //
//		Order order = new Order();
//		order.setMember(member1);
//		order.setProduct(productA);
//		em.persist(order);

//		 // Order 조회 //
//		 // 복수 안됨 -> order는 사람한명과 물건하나로 매핑
//		Order order = em.find(Order.class, 1L);
//		Member member = order.getMember();
//		Product product = order.getProduct();
//
//		System.out.println(member);
//		System.out.println(product);

		// 삭제 //
		Member member = em.find(Member.class, 1L);
		System.out.println(member);
		em.remove(member);

	}

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step12_JPA_Mapping");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			logic(em);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
			emf.close();
		}

	}

}
