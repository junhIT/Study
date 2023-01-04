package com.example.springbase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbase.entity.PostEntity;

public interface PostRepository extends JpaRepository<PostEntity, Long>{	// Entity 클래스, PK타입

}
