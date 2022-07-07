package com.spring.dto;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.spring.entity.Diary;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DiaryDTO {

	@Id
	private Long no;

	private String title;

	private String content;

	private LocalDateTime writtenTime;

	public Diary toEntity(DiaryDTO diaryDTO) {
		Diary diaryEntity = Diary.builder().no(diaryDTO.getNo()).title(diaryDTO.getTitle())
				.content(diaryDTO.getContent()).build();
		return diaryEntity;
	}
}
