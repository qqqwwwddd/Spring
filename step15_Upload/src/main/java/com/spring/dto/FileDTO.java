package com.spring.dto;

import com.spring.entity.FileEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileDTO {

	private Long id;

	private String originalFilename;

	private String filename;

	private String filePath;

	// DTO는 Entity로 바뀜
	public FileEntity toEntity(FileDTO fileDTO) {
		FileEntity fileEntity = FileEntity.builder().originalFilename(fileDTO.getOriginalFilename())
				.filename(fileDTO.getFilename()).filePath(fileDTO.filePath).build();
		return fileEntity;
	}

}
