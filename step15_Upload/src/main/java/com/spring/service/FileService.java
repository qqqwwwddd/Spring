package com.spring.service;

import com.spring.dto.FileDTO;

public interface FileService {

	// 처음 saveFile 하기위해서 받아와야 하므로 DTO
	public Long saveFile(FileDTO fileDTO);
}
