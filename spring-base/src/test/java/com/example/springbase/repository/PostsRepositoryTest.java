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
@SpringBootTest	// H2 DB 자동으로 실행
class PostsRepositoryTest {

	@Autowired
	PostsRepository postsRepository;
	
	@After
	public void cleanup() {
		postsRepository.deleteAll();
	}
	
	@Test
	@DisplayName("게시글저장_불러오기")
	public void postsSaveLoadTest() {
		
		String title = "테스트 게시글";
		String content = "테스트 본문";
		
		// builder 클래스를 통해 생성자 생성 후 save (insert/update)
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