package step02.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import jpa.basic.enumType.MemberType;
import lombok.Data;

@Data
@Entity
public class Member2 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment 할때 Long
	private Long id;
	private String name;
	private Integer age;

	//
	@Column(name = "reg_Time")
	private LocalDateTime registrationTime;

//	@Temporal(TemporalType.TIMESTAMP)
//	private Date registrationTime;

//	private String memberType; // VVIP , VIP , NORMAL, ... 

	@Column(name = "member_Type")
	@Enumerated(EnumType.STRING)
	private MemberType memberType;

}
