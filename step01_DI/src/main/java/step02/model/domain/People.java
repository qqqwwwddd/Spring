package step02.model.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import lombok.Data;

@Data
public class People {

	private String name;
	private int age;

	@Autowired(required = false) // 필드 주입으로 의존성 주입
	@Qualifier("c3") // 정해놓은 한정된 bean에 대해서만 참조 (참조대상 두가지 이상일 때)
	private Car myCar;

	public People() {
		System.out.println("People 기본 생성자");
	}

	@Autowired
	public People(String name, int age, Car myCar) {
		this.name = name;
		this.age = age;
		this.myCar = myCar;

		System.out.println("People 생성자");
	}

	@Autowired
	public void setMyCar(Car myCar) {
		this.myCar = myCar;

	}
}
