package com.example.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.example.dto.DeptDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

// -> entity에선 setter 사용 x

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
@ToString(exclude = { "emps" })
public class Dept {

	@Id
	private Long deptno;

	@Column(length = 14)
	private String dname;

	@Column(length = 13)
	private String loc;

	@OneToMany(mappedBy = "dept", fetch = FetchType.LAZY)
	@JsonIgnore
	List<Emp> emps = new ArrayList<Emp>();

	// toDTO
	public DeptDTO toDTO(Dept deptEntity) {
		DeptDTO deptDTO = DeptDTO.builder().deptno(deptEntity.getDeptno()).dname(deptEntity.getDname())
				.loc(deptEntity.getLoc()).build();

		return deptDTO;
	}
}
