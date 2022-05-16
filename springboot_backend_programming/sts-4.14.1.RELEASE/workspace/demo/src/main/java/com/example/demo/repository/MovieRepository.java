package com.example.demo.repository;

import java.util.List;

import com.example.demo.dto.MovieDTO;

public interface MovieRepository {
	List<MovieDTO> findByQuery(String query);

}
