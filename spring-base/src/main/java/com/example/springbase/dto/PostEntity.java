package com.example.springbase.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Post µµ∏ﬁ¿Œ
 * 2022.11.30 
 * @author JunHi
 */

@Getter
@NoArgsConstructor
@Entity
public class PostEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 500, nullable = false)
	private String title;
	
	@Column(columnDefinition = "TEXT", nullable = false)
	private String content;
	
	private String author;
	
	@Builder
	public PostEntity(String title, String content, String author) {
		this.title = title;
		this.content = content;
		this.author = author;
	}
}
