package com.example.springbase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbase.dto.Posts;

public interface PostsRepository extends JpaRepository<Posts, Long>{	// Entity Ŭ����, PKŸ��

}
