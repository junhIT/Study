package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.dto.MovieDTO;
import com.example.demo.repository.MovieRepository;

@ExtendWith(MockitoExtension.class)
class MovieServiceTest {

	@Mock
	private MovieRepository movieRepository;
	  
	@DisplayName("0점 제외하기 테스트 코드")
	@Test
	void shouldSortedInOrderOfGrade() {
		// 테스트코드 작성
		String query = "반지의제왕";	// 조회할 영화
		String expectedTopRankingMovieTitle = "평점2위";

		MovieService movieService = new MovieService(movieRepository);
		
		given(movieRepository.findByQuery(anyString())).willReturn(getStubMovies());
		
		List<MovieDTO> actualMovie = movieService.search(query);
		
		System.out.println("actualMovie:::" + actualMovie.toString());
		
		assertEquals(expectedTopRankingMovieTitle, actualMovie.stream().findFirst().get().getTitle());
	}

	@DisplayName("오늘의 추천 영화로 평점이 제일 높은 영화를 제공하는 검증")
	@Test
	void shoulRecommendedHighestRating() {
		
		// given
		var query = "테스트_쿼리";
		var expectedTopRankingMovieTitle = "평점1위";
		
		given(movieRepository.findByQuery(anyString())).willReturn(getStubMovies());
		
		// when
		MovieService movieService = new MovieService(movieRepository);
		
		MovieDTO actualMovie = movieService.recommendeTodayMovie();
		
		System.out.println("actualMovie:::" + actualMovie.toString());
		
		// then
		
		assertEquals(expectedTopRankingMovieTitle, actualMovie.getTitle());
	}

	
	@DisplayName("추천한 영화가 없을 때 디폴트 영화를 제공하는지 검증")
	@Test
	void shouDefaultMovieWhenNoneRecommended() {
		
		var expectedDefaultMovie = "기본영화";
		
		given(movieRepository.findByQuery(anyString())).willReturn(Collections.emptyList());
		
		MovieService movieService = new MovieService(movieRepository);
		
		// when
		
		MovieDTO actualMovie = movieService.recommendeTodayMovie();
		
		System.out.println("디폴트 영화 제공 검증 output" + actualMovie.toString());
		
		// then
		
		assertEquals(expectedDefaultMovie, actualMovie.getTitle());
	}
	private List<MovieDTO> getStubMovies() {
		  return Arrays.asList(
	                MovieDTO.builder().title("평점0").link("http://test").userRating(0.0f).build(),
	                MovieDTO.builder().title("평점2위").link("http://test").userRating(9.3f).build(),
	                MovieDTO.builder().title("평점3위").link("http://test").userRating(8.7f).build(),
	                MovieDTO.builder().title("평점1위").link("http://test").userRating(9.7f).build()
	                );
	}
}
