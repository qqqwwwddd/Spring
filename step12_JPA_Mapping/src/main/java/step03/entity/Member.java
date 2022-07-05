package step03.entity;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
//@Entity
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 20)
	private String name;

	private Integer age;

	// 양방향 참조

	// fetch
	// 개별 select 실행
	// 실제 데이터를 필요로 하는 시점에만 select 실행
	// 주의사항 : toString() 사용하는 경우, team 값 반환하는 로직이 포함되어 있다면
	// team과 관련된 select 구문이 자동으로 실행됨

	@ManyToOne(fetch = FetchType.LAZY)

	@JoinColumn(name = "team_id")
	private Team team; // team toString 재정의 되어 있음

}
