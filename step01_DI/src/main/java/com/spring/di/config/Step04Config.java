package com.spring.di.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // 설정 파일 이라는 것을 컨테이너가 알게함
@ComponentScan(basePackages = { "step03.model.domain" })
public class Step04Config {

	// componentScan 으로
//	@Bean
//	public Car car() {
//		Car car = new Car();
//		return car;
//	}
//
//	@Bean
//	public People people(Car car) {
//		People people = new People();
//		people.setMyCar(car);
//		return people;
//	}
}
