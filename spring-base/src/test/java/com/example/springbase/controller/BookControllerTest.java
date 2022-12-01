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
	@DisplayName("Post ���� Test")
	void testCreatePost() {
		String title = "����";
		String content = "����";
		
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
	@DisplayName("Post ��ȸ Test")
	void testListAllPost() {
		List<PostEntity> postList = postRepository.findAll();
		assertThat(postList.size()).isGreaterThan(0);
	}

	@Test
	@Order(3)
	@DisplayName("Post ������Ʈ Test")
	void testUpdatePost() {
		
		PostEntity post = postRepository.findAll().get(0);
		
		String title = "���������";
		
		// setter�� �������� ���� field�� value ����
		ReflectionTestUtils.setField(post, "title", title);	
		
		PostEntity newPost = postRepository.save(post);
		
		assertThat(newPost.getTitle()).isEqualTo(title);
	}

	@Test
	@DisplayName("Post ���� Test")
	@Order(99)
	void testDeletePost() {
		postRepository.deleteAll();
		
		assertThat(postRepository.count()).isEqualTo(0);
	}

}
