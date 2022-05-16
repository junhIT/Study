package com.example.demo.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.MovieDTO;
import com.example.demo.repository.MovieRepository;

@Service
public class MovieService {
	
	private final MovieRepository movieRepository;
	
	public MovieService(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}
	
	public List<MovieDTO> search(final String query) {
		return movieRepository.findByQuery(query);
	}
	
	
	
	
	
	
	
	public List<MovieDTO> query(final String query) {
		return Arrays.asList(
				MovieDTO.builder().title("영화1").link("http://test").build(),
				MovieDTO.builder().title("영화2").link("http://test").build()
		);
	}
}
