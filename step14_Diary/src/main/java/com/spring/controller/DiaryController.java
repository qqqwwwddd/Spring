package com.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.DiaryDTO;
import com.spring.dto.PageRequestDTO;
import com.spring.dto.PageResultDTO;
import com.spring.entity.Diary;
import com.spring.repository.DiaryRepository;
import com.spring.service.DiaryServiceImpl;

@RestController
//@RequiredArgsConstructor  
// DiaryController 객체가 생성이 될때 내부에 있는걸로 생성 반드시 필요로 하는 것 . 
// final이 붙거나 @NotNull 붙은 필드(멤버변수)의 생성자를 자동 생성하는 어노테이션 
public class DiaryController {

	@Autowired // 생성자 주입
	DiaryServiceImpl diaryServiceImpl;

	@Autowired // page test
	DiaryRepository diaryRepository;

//	private final DiaryServiceImpl diaryServiceImpl;

	@PostMapping("/diary")
	public void insertDiary(@RequestBody DiaryDTO diaryDTO) {
		diaryServiceImpl.insertDiary(diaryDTO);

	}

	// 대용량 데이터 넣기
	@PostMapping("/diary-batch")
	public void insertDiaryBatch() {
		List<DiaryDTO> diaryDTOList = new ArrayList<DiaryDTO>();
		// 지정된 시점까지 list 반환 // i = int 인자값
		IntStream.rangeClosed(1, 200).forEach(i -> {

			DiaryDTO diaryDTO = DiaryDTO.builder().no(Long.valueOf(i)).title("Title :" + i).content("Content : " + i)
					.build();
//			diaryServiceImpl.insertDiary(diaryDTO);
			diaryDTOList.add(diaryDTO);
		});
		diaryServiceImpl.insertDiaryBatch(diaryDTOList);
	}

	// 페이지 처리
	// Pageable 인터페이스 사용 -> 구현체 PageRequest
	// Pageable pageable = new PageRequest(); x
	// 내부 static of 메소드를 사용가능
	// of(int page, int size) : 페이지번호(0부터 시작), 한페이지 요소 개수
	// of(int page, int size, Sort sort) : 페이지번호, 개수, 정렬

	@GetMapping("/pageable")
	public void pageDefault() {
		Pageable pageable1 = PageRequest.of(10, 10);
		Page<Diary> result1 = diaryRepository.findAll(pageable1);
		System.out.println(result1);

		System.out.println("===pageable result===");

		// 총 페이지 수
//		System.out.println(result.getTotalPages());

		// 전체 개수
//		System.out.println(result.getTotalElements());

		// 현재 페이지 번호 : 0부터 시작
//		System.out.println(result.getNumber());

		// 페이지당 데이터 개수
//		System.out.println(result.getSize());

		// 다음페이지 혹은 이전 페이지 존재 여부
//		System.out.println(result.hasNext());
//		System.out.println(result.hasPrevious());

		// 모든 데이터
//		System.out.println(result.getContent());

		// 정렬
		Sort sort1 = Sort.by("no").descending();
		Pageable pageable2 = PageRequest.of(10, 10, sort1);
		Page<Diary> result2 = diaryRepository.findAll(pageable2);
		System.out.println("===pageable result===");
//		for (Diary diary : result1.getContent()) {
//			System.out.println(diary);

		result2.forEach(diary -> {
			System.out.println(diary);

		});

		System.out.println("=====쿼리메소드 + Pageable====");
		// 쿼리 메소드 + Pageable
		Pageable pageable3 = PageRequest.of(0, 10, Sort.by("no").descending());
		Page<Diary> result3 = diaryRepository.findByNoBetween(10L, 50L, pageable3);

		result3.get().forEach(diary -> System.out.println(diary));

		// 고려사항
		// Entity -> DTO
		// DTO -> Pageable
		// 페이지 번호 -> 어떻게 출력할지 고민

		System.out.println("======PageRequestDTO===========");

		PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).size(10).build();

		PageResultDTO<DiaryDTO, Diary> pageResultDTO = diaryServiceImpl.getList(pageRequestDTO);

		System.out.println(pageResultDTO.isPrev()); // ? false
		System.out.println(pageResultDTO.isNext()); // ? next
		System.out.println(pageResultDTO.getTotalPage()); // ? 20

		System.out.println("=======PageRequestDTO 객체값 출력 1번페이지만========");
		// ??
		pageResultDTO.getDtoList().forEach(diaryDTO -> System.out.println(diaryDTO));
	}

	@GetMapping("diary")
	public void getDiary(PageRequestDTO pageRequestDTO) {
		System.out.println(pageRequestDTO);

	}

}
