package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.dto.DeptDTO;
import com.example.dto.PageRequestDTO;
import com.example.dto.PageResultDTO;
import com.example.model.Dept;
import com.example.repository.DeptRepository;

@Service
public class DeptServiceImpl implements DeptService {

	@Autowired // 의존성 주입
	private DeptRepository deptRepository;

	// 모든 dept
	@Override
	public List<DeptDTO> getDeptAll() {

		List<DeptDTO> deptDTO = new ArrayList<DeptDTO>();
		for (Dept deptEntity : deptRepository.findAll()) {
			deptDTO.add(deptEntity.toDTO(deptEntity));

		}

		return deptDTO; // DeptRepository 통해 -> Dao -> Service 전달
	}

	// 부서번호로 검색
	@Override
	public DeptDTO getDeptByDeptno(Long deptno) {
		Dept deptEntity = deptRepository.findDeptByDeptno(deptno);
		if (deptEntity != null) {
			return deptEntity.toDTO(deptEntity);
		} else {
			return null;
		}
	}

	// dept 추가
	@Override
	public void insertDept(DeptDTO deptDTO) {

		if (getDeptByDeptno(deptDTO.getDeptno()) == null) {

			deptRepository.save(deptDTO.toEntity(deptDTO));

		}
	}

	// 부서번호로 dept 수정
	@Override
//	public void updateDeptByDeptno(Dept dept) {
//		System.out.println(dept);
//		Dept deptFind = deptRepository.findDeptByDeptno(dept.getDeptno());

	public void updateDeptByDeptno(Long deptno, DeptDTO newDeptDTO) {
		System.out.println(deptno);
		Dept deptFind = deptRepository.findDeptByDeptno(deptno);

		if (deptFind != null) {
			newDeptDTO.setDeptno(deptno);

			deptRepository.save(newDeptDTO.toEntity(newDeptDTO));

//			deptFind.setDname(newDeptDTO.getDname());
//			deptFind.setLoc(newDeptDTO.getLoc());

		}

	}

	// 부서번호로 dept 삭제
	@Override
	public void deleteDeptByDeptno(Long deptno) {
		deptRepository.deleteById(deptno);
	}

	// paging

	public PageResultDTO<DeptDTO, Dept> getList(PageRequestDTO pageRequestDTO) {
		Pageable pageable = pageRequestDTO.getPageable(Sort.by("deptno").ascending());

		Page<Dept> result = deptRepository.findAll(pageable);

		// entity -> dto
		Function<Dept, DeptDTO> function = (deptEntity -> deptEntity.toDTO(deptEntity));

		return new PageResultDTO<DeptDTO, Dept>(result, function);
	}

}
