package mapping.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import step03.entity.Member;
import step03.entity.Team;

public class Step03Test {
	static void logic(EntityManager em) {

		// team VS member ??
		Team teamA = new Team();
		teamA.setName("TeamA");
		em.persist(teamA);

		Team teamB = new Team();
		teamB.setName("TeamB");
		em.persist(teamB);

		Member member1 = new Member();
		member1.setName("의진");
		member1.setAge(25);
		member1.setTeam(teamA);
		em.persist(member1);

		teamA.getMembers().add(member1);

		Member member2 = new Member();
		member2.setName("의진2");
		member2.setAge(28);
		member2.setTeam(teamB);
		em.persist(member2);

		teamB.getMembers().add(member2);
//
		Member member01 = em.find(Member.class, member1.getId());
		System.out.println(member01);

		Team team01 = em.find(Team.class, teamA.getId());
		System.out.println(team01);
		System.out.println(team01.getMembers()); // 양방향참조라 members도 가능

//		List<Member> members = new ArrayList<Member>();
//		Member member3 = new Member();
//		member3.setName("의진3");
//		member3.setAge(23);
//		member3.setTeam(teamB); // 영속성에 들어간 상황
//		members.add(member3);

		// list가 추가되게 값 지정
//		team01.setMembers(members); // 변경사항 생겨서 추가 되야함 -> 값이 안들어감
//		// 이유 : 양방향 참조 하면서 주도권 가진 객체가 member 여서 새로 들어갈려면 Member 로만 들어갈수 있음
//		// 아무리 team 에다가 member 넣어줘도 주도권을 갖지 않아 넣을 수 없음
//		em.persist(team01); // 영속성 컨텍스트에 값 추가
//		System.out.println(team01.getMembers()); // *에러 원인) team에 있는 members 호출
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
