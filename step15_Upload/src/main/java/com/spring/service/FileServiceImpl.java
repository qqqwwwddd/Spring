package com.spring.service;

import org.springframework.stereotype.Service;

import com.spring.dto.FileDTO;
import com.spring.entity.FileEntity;
import com.spring.repository.FileRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

	// 생성자 주입
	private final FileRepository fileRepository;

	@Override
	// file을 먼저 넣어주고 Entity -> 이때 file id 찾아서 매핑시켜서 줘야하니깐 void로 안하고 Long type
	public Long saveFile(FileDTO fileDTO) {
		FileEntity fileEntity = fileDTO.toEntity(fileDTO);
		return fileRepository.save(fileEntity).getId();
	}

}
