package step03.model.domain;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component // bean으로 등록 안된 상태 id값 지정해주면 사용 가능
// id값이 기본적으로 갖는 것은 classname 대문자는 인식 못함 

public class Car {
	// Bean 조건 : 기본생성자, private 필드, getter/setter
	private int carNo;
	private String carName;

	public Car() {
		System.out.println("Car 기본 생성자");
	}

	public Car(int carNo, String carName) {
		this.carNo = carNo;
		this.carName = carName;
		System.out.println("Car 생성자");
	}
}
