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
	
	@DisplayName("0점 제외하기 테스트 코드")
	@Test
	void shouldSortedInOrderOfGrade() {
		// 테스트코드 작성
		String query = "반지의제왕";	// 조회할 영화
		String expectedTopRankingMovieTitle = "제목2";

		MovieService movieService = new MovieService(movieRepository);
		
		List<MovieDTO> actualMovie = movieService.search(query);
		
		System.out.println("actualMovie:::" + actualMovie.toString());
		
		assertEquals(expectedTopRankingMovieTitle, actualMovie.stream().findFirst().get().getTitle());
	}

	
	@DisplayName("오늘의 추천 영화로 평점이 제일 높은 영화를 제공하는 검증")
	@Test
	void shoulRecommendedHighestRating() {
		
		// given
		var query = "테스트_쿼리";
		var expectedTopRankingMovieTitle = "평점1";

		// when
		MovieService movieService = new MovieService(movieRepository);
		
		MovieDTO actualMovie = movieService.recommendeTodayMovie();
		
		System.out.println("actualMovie:::" + actualMovie.toString());
		
		// then
		
		assertEquals(expectedTopRankingMovieTitle, actualMovie.getTitle());
	}
}
