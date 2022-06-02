package com.example.demo.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.MovieDTO;
import com.example.demo.repository.MovieRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieService {
	
	/*
	 * RequiredArgsConstructor�� ���� @Autowired �ʿ���� DI ���� ����
	@Autowired
	private MovieRepository movieRepository;
	 */
	
	private final MovieRepository movieRepository;
	
	public List<MovieDTO> search(final String query) {
		return movieRepository.findByQuery(query);
	}
	
	public List<MovieDTO> query(final String query) {
		return Arrays.asList(
				MovieDTO.builder().title("��ȭ1").link("http://test").build(),
				MovieDTO.builder().title("��ȭ2").link("http://test").build()
		);
	}
}
