package com.example.springbase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbase.dto.PostEntity;

public interface PostRepository extends JpaRepository<PostEntity, Long>{	// Entity Ŭ����, PKŸ��

}
