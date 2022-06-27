package com.spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import step01.model.domain.Car;
import step01.model.domain.People;

public class Step01Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("step01.xml");

		// step01
		// Car

		Car c1 = context.getBean("c1", Car.class); // Car.class라고 하면 형변환 필요 없음
		System.out.println(c1);

		// People
		People p1 = context.getBean("p1", People.class);
		System.out.println(p1);

		// Setter Injection //
		// People p1 = new People();
		// p1.setName("spring");
		// p1.setAge(29);
		// p1.setMyCar(c1);

		// 객체 생성이 가장 먼저 이루어 지고 그 후에 의존성 주입이 일어나게 된다 !!!

		// step02
		// People

		People p2 = context.getBean("p2", People.class);
		System.out.println(p2);

		// p1과 p2는 다른 사람 일 것이다 = 다른 객체일 것이다
		System.out.println(p1 == p2); // false

		// p1-myCar 와 p2-myCar는 ??
		System.out.println(p1.getMyCar() == p2.getMyCar()); // true : 기본 값은 singleton(효율) 으로 관리하기 때문

		// 그렇다면 p1-myCar 와 p2-myCar가 서로 다른 객체가 되려면???
		// step01.xml 의 6번 라인에 scope="prototype")

		// request -> 요청마다 새로운 객체로 생성
		// session -> 세션마다 새로운 객체로 생성

	}

}
