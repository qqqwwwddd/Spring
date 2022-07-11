package com.example.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.model.Dept;
import com.example.model.Emp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmpDTO {

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

	// toEntity
	public Emp toEntity(EmpDTO empDTO) {
		Emp empEntity = Emp.builder().empno(empDTO.getEmpno()).ename(empDTO.getEname()).job(empDTO.getEname())
				.mgr(empDTO.getMgr()).hiredate(empDTO.getHiredate()).sal(empDTO.getSal()).comm(empDTO.getComm())
				.dept(empDTO.getDept()).build();
		return empEntity;
	}

}
