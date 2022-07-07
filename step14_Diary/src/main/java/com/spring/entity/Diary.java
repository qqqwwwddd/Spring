package com.spring.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.spring.dto.DiaryDTO;

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
@EntityListeners(AuditingEntityListener.class) // entity 실행될때 어떤게 실행될지 정함
public class Diary implements Persistable<Long> { // 영속성 관리

	@Id
	private Long no;

	private String title;

	private String content;

	@CreatedDate // 오늘 날짜 들어감
	private LocalDateTime writtenTime;

	// 영속성
	@Override
	public Long getId() {
		return no;
	}

	// isNew가 writtenTime으로 구분해서 새 객체가 아니면 false 새 객체면 true
	// 없을 때는 select 필요 없음
	@Override
	public boolean isNew() {
		return writtenTime == null;
	}

	// entity -> DTO 로 바꿔주는 메소드
	public DiaryDTO toDTO(Diary diaryEntity) {
		DiaryDTO diaryDTO = DiaryDTO.builder().no(diaryEntity.getNo()).title(diaryEntity.getTitle())
				.content(diaryEntity.getContent()).writtenTime(diaryEntity.getWrittenTime()).build();

		return diaryDTO;
	}
}
