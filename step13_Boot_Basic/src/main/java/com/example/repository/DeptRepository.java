package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Dept;

@Repository
public interface DeptRepository extends JpaRepository<Dept, Long> { // Long( Dept에서 사용하는 id type)
	public List<Dept> findAll();

	// 검색
	public Dept findDeptByDeptno(Long deptno);

}
