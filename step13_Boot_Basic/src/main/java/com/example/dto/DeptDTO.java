//package com.example.dto;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.Column;
//import javax.persistence.FetchType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//
//import com.example.model.Dept;
//import com.example.model.Emp;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//public class DeptDTO {
//
//	@Id
//	@Column(nullable = false)
//	private Long deptno;
//
//	@Column(length = 14)
//	private String dname;
//
//	@Column(length = 13)
//	private String loc;
//
//	public DeptDTO(Long deptno) {
//		if (deptno != null) {
//			this.deptno = deptno;
//		}
//	}
//
//	public DeptDTO dtoToEntity(DeptDTO deptDTO) {
//		DeptDTO deptEntityDeptDTO = Dept.builder().dname(deptDTO.getDname()).loc(deptDTO.getLoc()).build();
//		return deptEntity;
//	}
//
//}
