package com.example.springbase.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.After;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.springbase.dto.Posts;

@RunWith(SpringRunner.class)
@SpringBootTest	// H2 DB �ڵ����� ����
class PostsRepositoryTest {

	@Autowired
	PostsRepository postsRepository;
	
	@After
	public void cleanup() {
		postsRepository.deleteAll();
	}
	
	@Test
	@DisplayName("�Խñ�����_�ҷ�����")
	public void postsSaveLoadTest() {
		
		String title = "�׽�Ʈ �Խñ�";
		String content = "�׽�Ʈ ����";
		
		// builder Ŭ������ ���� ������ ���� �� save (insert/update)
		postsRepository.save(Posts.builder()
									.title(title)
									.content(content)
									.author("test@test.com")
									.build());
		
		List<Posts> postsList = postsRepository.findAll();
		Posts posts = postsList.get(0);
		
		assertThat(posts.getTitle()).isEqualTo(title);
		assertThat(posts.getContent()).isEqualTo(content);		
	}
}