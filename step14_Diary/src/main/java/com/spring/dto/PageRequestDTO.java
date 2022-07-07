package com.spring.dto;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class PageRequestDTO {
	// 화면에서 전달되는 page, size 파라미터 정보를 얻는 객체
	// Pageable 타입의 객체를 받을 수 있게 변경 해주는 DTO
	// --> JPA 에서 사용하는 Pageable 타입의 객체를 생성하기 위해

	private int page;
	private int size;

	public PageRequestDTO() {
		this.page = 1;
		this.size = 10;

	}

	public Pageable getPageable(Sort sort) {
		return PageRequest.of(page - 1, size, sort);
	}
}
