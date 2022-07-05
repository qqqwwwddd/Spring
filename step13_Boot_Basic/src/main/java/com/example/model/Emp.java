package com.example.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity

public class Emp {

	@Id
	private Long empno;

	@Column(length = 10)
	private String ename;

	@Column(length = 9)
	private String job;

	private Long mgr;

	private LocalDate hiredate;

	private Double sal;

	private Double comm;

//	private Long deptno;

	@ManyToOne
	@JoinColumn(name = "deptno")
	private Dept dept;

}
