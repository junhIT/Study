package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.demo.dto.MovieDTO;
import com.example.demo.repository.MockMovieRepositoryImpl;
import com.example.demo.repository.MovieRepository;

class MovieServiceTest {

	@DisplayName("0�� �����ϱ� �׽�Ʈ �ڵ�")
	@Test
	void shouldSortedInOrderOfGrade() {
		// �׽�Ʈ�ڵ� �ۼ�
		String query = "����������";	// ��ȸ�� ��ȭ
		String expectedTopRankingMovieTitle = "����3";
		
		MovieRepository movieRepository = new MockMovieRepositoryImpl();
		MovieService movieService = new MovieService(movieRepository);
		
		List<MovieDTO> actualMovie = movieService.search(query);
		
		System.out.println("actualMovie:::" + actualMovie.toString());
		
		assertEquals(expectedTopRankingMovieTitle, actualMovie.stream().findFirst().get().getTitle());
	}

}
