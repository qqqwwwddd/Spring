package com.example.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.example.dto.EmpDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
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

	// toDTO
	public EmpDTO toDTO(Emp empEntity) {
		EmpDTO empDTO = EmpDTO.builder().empno(empEntity.getEmpno()).ename(empEntity.getEname()).job(empEntity.getJob())
				.mgr(empEntity.getMgr()).hiredate(empEntity.getHiredate()).sal(empEntity.getSal())
				.comm(empEntity.getComm()).dept(empEntity.getDept()).build();
		return empDTO;
	}

}
