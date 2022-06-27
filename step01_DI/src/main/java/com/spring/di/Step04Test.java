package com.spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.di.config.Step04Config;

import step03.model.domain.Car;
import step03.model.domain.People;

public class Step04Test {

	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("step03.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(Step04Config.class);
		// step01
		// People
		People p1 = context.getBean("people", People.class); // 클래스 네임 소문자 id로 인식 가능
		System.out.println(p1);

		// Car
		Car c1 = context.getBean("car", Car.class);
		System.out.println(c1);
	}

}
