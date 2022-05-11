package com.example.demo.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.MovieDTO;

@Service
public class MovieService {
	
	public List<MovieDTO> query(final String query) {
		return Arrays.asList(
				MovieDTO.builder().title("��ȭ1").link("http://test").build(),
				MovieDTO.builder().title("��ȭ2").link("http://test").build()
		);
	}
}
