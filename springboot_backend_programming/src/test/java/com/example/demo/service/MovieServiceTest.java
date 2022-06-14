package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.example.demo.dto.MovieDTO;
import com.example.demo.repository.MockMovieRepositoryImpl;

class MovieServiceTest {

	@Mock
	MockMovieRepositoryImpl movieRepository = new MockMovieRepositoryImpl();
	
	@DisplayName("0�� �����ϱ� �׽�Ʈ �ڵ�")
	@Test
	void shouldSortedInOrderOfGrade() {
		// �׽�Ʈ�ڵ� �ۼ�
		String query = "����������";	// ��ȸ�� ��ȭ
		String expectedTopRankingMovieTitle = "����2";

		MovieService movieService = new MovieService(movieRepository);
		
		List<MovieDTO> actualMovie = movieService.search(query);
		
		System.out.println("actualMovie:::" + actualMovie.toString());
		
		assertEquals(expectedTopRankingMovieTitle, actualMovie.stream().findFirst().get().getTitle());
	}

	
	@DisplayName("������ ��õ ��ȭ�� ������ ���� ���� ��ȭ�� �����ϴ� ����")
	@Test
	void shoulRecommendedHighestRating() {
		
		// given
		var query = "�׽�Ʈ_����";
		var expectedTopRankingMovieTitle = "����1";

		// when
		MovieService movieService = new MovieService(movieRepository);
		
		MovieDTO actualMovie = movieService.recommendeTodayMovie();
		
		System.out.println("actualMovie:::" + actualMovie.toString());
		
		// then
		
		assertEquals(expectedTopRankingMovieTitle, actualMovie.getTitle());
	}
}
