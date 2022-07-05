package com.example.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
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
}