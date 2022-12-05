package com.example.springbase.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.springbase.dto.PostEntity;
import com.example.springbase.repository.PostRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("/index")
	public String book() {
		return "/book/index";
	}
	
	// Post 등록
	@ResponseBody
	@PostMapping("/post")
	public PostEntity createPost(@RequestBody PostEntity post) {
		
		log.debug("post 등록 메소드 호출 :::: postEntity : {}", post);
		
		return postRepository.save(post);
	}
	
	// post 조회
	@ResponseBody
	@GetMapping("/post")
	public List<PostEntity> listAllPost() {
		
		log.debug("post 조회 메소드 호출");

		List<PostEntity> list = new ArrayList<>();
		Iterable<PostEntity> iterable = postRepository.findAll();
		
		for(PostEntity post : iterable) {
			list.add(post);
		}
		
		return list;
	}
	
	// post 수정
	@ResponseBody
	@PutMapping("/post/{id}")
	public PostEntity updatePost(@PathVariable("id") UUID id,
									@RequestBody PostEntity postEntity) {
		
		return postRepository.save(postEntity);
	}
	
	// post 삭제
	@ResponseBody
	@DeleteMapping("/post/{id}")
	public void deletePost(@PathVariable("id") Long id) {
		postRepository.deleteById(id);
	}
	
}
