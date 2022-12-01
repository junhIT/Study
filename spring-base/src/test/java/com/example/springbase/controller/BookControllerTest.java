package com.example.springbase.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import com.example.springbase.dto.PostEntity;
import com.example.springbase.repository.PostRepository;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BookControllerTest {

	@Autowired
	PostRepository postRepository;
	
	@Test
	@Order(1)
	@DisplayName("Post 생성 Test")
	void testCreatePost() {
		String title = "제목";
		String content = "내용";
		
		PostEntity post =PostEntity.builder()
							.title(title)
							.content(content)
							.build();
		
		PostEntity postEntity = postRepository.save(post);
		
		assertThat(postEntity.getTitle()).isEqualTo(title);
		assertThat(postEntity.getContent()).isEqualTo(content);
	}

	@Test
	@Order(2)
	@DisplayName("Post 조회 Test")
	void testListAllPost() {
		List<PostEntity> postList = postRepository.findAll();
		assertThat(postList.size()).isGreaterThan(0);
	}

	@Test
	@Order(3)
	@DisplayName("Post 업데이트 Test")
	void testUpdatePost() {
		
		PostEntity post = postRepository.findAll().get(0);
		
		String title = "변경된제목";
		
		// setter가 설정되지 않은 field에 value 설정
		ReflectionTestUtils.setField(post, "title", title);	
		
		PostEntity newPost = postRepository.save(post);
		
		assertThat(newPost.getTitle()).isEqualTo(title);
	}

	@Test
	@DisplayName("Post 삭제 Test")
	@Order(99)
	void testDeletePost() {
		postRepository.deleteAll();
		
		assertThat(postRepository.count()).isEqualTo(0);
	}

}
