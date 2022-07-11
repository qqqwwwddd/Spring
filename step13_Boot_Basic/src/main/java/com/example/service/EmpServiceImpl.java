package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.dto.EmpDTO;
import com.example.dto.PageRequestDTO;
import com.example.dto.PageResultDTO;
import com.example.model.Emp;
import com.example.repository.EmpRepository;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpRepository empRepository;

	// 모든 emp
	@Override
	public List<EmpDTO> getEmpAll() {

		List<EmpDTO> empDTO = new ArrayList<EmpDTO>();
		for (Emp empEntity : empRepository.findAll()) {
			empDTO.add(empEntity.toDTO(empEntity));
		}
		return empDTO;
	}

	// 사원번호로 emp 검색
	@Override
	public EmpDTO getEmpByEmpno(Long empno) {
		Emp empEntity = empRepository.getEmpByEmpno(empno);
		if (empEntity != null) {
			return empEntity.toDTO(empEntity);
		} else {
			return null;
		}
	}

	// emp 추가
	@Override
	public void insertEmp(EmpDTO empDTO) {
		if (getEmpByEmpno(empDTO.getEmpno()) == null) {
			empRepository.save(empDTO.toEntity(empDTO));
		}
	}

	// 사원번호로 emp 수정
//	@Override
//	public void updateEmpByEmpno(Emp emp) {
//		Emp empFind = empRepository.getEmpByEmpno(emp.getEmpno());
//
//		if (empFind != null) {
//			empRepository.save(emp);
//		}
//
//	}

	@Override
	public void updateEmpByEmpno(EmpDTO newEmpDTO) {
		EmpDTO preEmp = getEmpByEmpno(newEmpDTO.getEmpno());

		if (preEmp != null) {

			preEmp.setEname(newEmpDTO.getEname() == null ? preEmp.getEname() : newEmpDTO.getEname());
			preEmp.setJob(newEmpDTO.getJob() == null ? preEmp.getJob() : newEmpDTO.getJob());
			preEmp.setMgr(newEmpDTO.getMgr() == null ? preEmp.getMgr() : newEmpDTO.getMgr());
			preEmp.setHiredate(newEmpDTO.getHiredate() == null ? preEmp.getHiredate() : newEmpDTO.getHiredate());
			preEmp.setSal(newEmpDTO.getSal() == null ? preEmp.getSal() : newEmpDTO.getSal());
			preEmp.setComm(newEmpDTO.getComm() == null ? preEmp.getComm() : newEmpDTO.getComm());
			preEmp.setDept(newEmpDTO.getDept() == null ? preEmp.getDept() : newEmpDTO.getDept());
			empRepository.save(preEmp.toEntity(preEmp));
		}

	}

	// 사원번호로 emp 삭제
	@Override
	public void deleteEmpByEmpno(Long empno) {
		empRepository.deleteById(empno);
	}

	// paging

	public PageResultDTO<EmpDTO, Emp> getList(PageRequestDTO pageRequestDTO) {
		Pageable pageable = pageRequestDTO.getPageable(Sort.by("empno").ascending());

		Page<Emp> result = empRepository.findAll(pageable);

		// entity -> dto
		Function<Emp, EmpDTO> function = (empEntity -> empEntity.toDTO(empEntity));

		return new PageResultDTO<EmpDTO, Emp>(result, function);
	}
}
