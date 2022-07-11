package com.example.dto;

import javax.persistence.Column;
import javax.persistence.Id;

import com.example.model.Dept;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeptDTO {

	@Id
	@Column(nullable = false)
	private Long deptno;

	@Column(length = 14)
	private String dname;

	@Column(length = 13)
	private String loc;

//	public DeptDTO(Long deptno) {
//		if (deptno != null) {
//			this.deptno = deptno;
//		}
//	}
	// toEntity
	public Dept toEntity(DeptDTO deptDTO) {
		Dept deptEntity = Dept.builder().deptno(deptDTO.getDeptno()).dname(deptDTO.getDname()).loc(deptDTO.getLoc())
				.build();
		return deptEntity;
	}

}
