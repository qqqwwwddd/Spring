package com.spring.service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.spring.dto.DiaryDTO;
import com.spring.dto.PageRequestDTO;
import com.spring.dto.PageResultDTO;
import com.spring.entity.Diary;
import com.spring.repository.DiaryRepository;

@Service
public class DiaryServiceImpl implements DiaryService {

	@Autowired
	DiaryRepository diaryRepository;

	@Transactional
	@Override
	public void insertDiary(DiaryDTO diaryDTO) {
		Diary diaryEntity = diaryDTO.toEntity(diaryDTO);

//		diaryRepository.save(diaryDTO); // DTO -> entity 로 만들어야 save 사용 가능 
		diaryRepository.save(diaryEntity);
	}

	@Transactional
	@Override
	public void insertDiaryBatch(List<DiaryDTO> diaryDTOList) {

//		List<Diary> diaryEntityList = new ArrayList<Diary>();

		// ver1 //
//		for (DiaryDTO diaryDTO : diaryDTOList) {
//
//			diaryEntityList.add(diaryDTO.toEntity(diaryDTO));
//
//		}
		// ver2 //
//		diaryDTOList.forEach(diaryDTO -> diaryEntityList.add(diaryDTO.toEntity(DiaryDTO)));

		// ver3 //
		List<Diary> diaryEntityList = diaryDTOList.stream().map(diaryDTO -> diaryDTO.toEntity(diaryDTO))
				.collect(Collectors.toList());

//		diaryRepository.saveAll(diaryDTOList) // -> Entity 바꿔줘야함 
		diaryRepository.saveAll(diaryEntityList);
	}

	public PageResultDTO<DiaryDTO, Diary> getList(PageRequestDTO pageRequestDTO) {
		Pageable pageable = pageRequestDTO.getPageable(Sort.by("no").descending());

		Page<Diary> result = diaryRepository.findAll(pageable);

		// Entity -> DTO
		Function<Diary, DiaryDTO> function = (diaryEntity -> diaryEntity.toDTO(diaryEntity));

		return new PageResultDTO<DiaryDTO, Diary>(result, function);
	}

}
