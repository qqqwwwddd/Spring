package step04.entity;

import javax.persistence.Column;
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
	@ManyToOne // 여러명의 멤버가 한팀에 속함
	@JoinColumn(name = "team_id")
	private Team team; // team toString 재정의 되어 있음

}
