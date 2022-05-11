package controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import dto.MovieDTO;

@Service
public class MovieService {
	
	public List<MovieDTO> query(final String query) {
		return Arrays.asList(
				MovieDTO.builder().title("영화1").link("http://test").build(),
				MovieDTO.builder().title("영화2").link("http://test").build()
		);
	}
}
