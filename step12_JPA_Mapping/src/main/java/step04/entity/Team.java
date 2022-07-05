package step04.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
//@Entity
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 20)
	private String name;

	@OneToMany(mappedBy = "team") // FK 가진 쪽 = 주인 / mappedBy -> 주인이 아닌쪽에서 !
	List<Member> members = new ArrayList<Member>();
	// * 에러 원인 ) Members 의 Member 있어서 또 toString 호출

	// 내부적으로 toString이 계속 반복 호출 List에
	public String toString() {
		return "Team";
	}
}
