package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.demo.dto.MovieDTO;
import com.example.demo.repository.MockMovieRepositoryImpl;
import com.example.demo.repository.MovieRepository;

class MovieServiceTest {

	@DisplayName("0점 제외하기 테스트 코드")
	@Test
	void shouldSortedInOrderOfGrade() {
		// 테스트코드 작성
		String query = "반지의제왕";	// 조회할 영화
		String expectedTopRankingMovieTitle = "제목3";
		
		MovieRepository movieRepository = new MockMovieRepositoryImpl();
		MovieService movieService = new MovieService(movieRepository);
		
		List<MovieDTO> actualMovie = movieService.search(query);
		
		System.out.println("actualMovie:::" + actualMovie.toString());
		
		assertEquals(expectedTopRankingMovieTitle, actualMovie.stream().findFirst().get().getTitle());
	}

}
