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
	  
	@DisplayName("0�� �����ϱ� �׽�Ʈ �ڵ�")
	@Test
	void shouldSortedInOrderOfGrade() {
		// �׽�Ʈ�ڵ� �ۼ�
		String query = "����������";	// ��ȸ�� ��ȭ
		String expectedTopRankingMovieTitle = "����2��";

		MovieService movieService = new MovieService(movieRepository);
		
		given(movieRepository.findByQuery(anyString())).willReturn(getStubMovies());
		
		List<MovieDTO> actualMovie = movieService.search(query);
		
		System.out.println("actualMovie:::" + actualMovie.toString());
		
		assertEquals(expectedTopRankingMovieTitle, actualMovie.stream().findFirst().get().getTitle());
	}

	@DisplayName("������ ��õ ��ȭ�� ������ ���� ���� ��ȭ�� �����ϴ� ����")
	@Test
	void shoulRecommendedHighestRating() {
		
		// given
		var query = "�׽�Ʈ_����";
		var expectedTopRankingMovieTitle = "����1��";
		
		given(movieRepository.findByQuery(anyString())).willReturn(getStubMovies());
		
		// when
		MovieService movieService = new MovieService(movieRepository);
		
		MovieDTO actualMovie = movieService.recommendeTodayMovie();
		
		System.out.println("actualMovie:::" + actualMovie.toString());
		
		// then
		
		assertEquals(expectedTopRankingMovieTitle, actualMovie.getTitle());
	}

	
	@DisplayName("��õ�� ��ȭ�� ���� �� ����Ʈ ��ȭ�� �����ϴ��� ����")
	@Test
	void shouDefaultMovieWhenNoneRecommended() {
		
		var expectedDefaultMovie = "�⺻��ȭ";
		
		given(movieRepository.findByQuery(anyString())).willReturn(Collections.emptyList());
		
		MovieService movieService = new MovieService(movieRepository);
		
		// when
		
		MovieDTO actualMovie = movieService.recommendeTodayMovie();
		
		System.out.println("����Ʈ ��ȭ ���� ���� output" + actualMovie.toString());
		
		// then
		
		assertEquals(expectedDefaultMovie, actualMovie.getTitle());
	}
	private List<MovieDTO> getStubMovies() {
		  return Arrays.asList(
	                MovieDTO.builder().title("����0").link("http://test").userRating(0.0f).build(),
	                MovieDTO.builder().title("����2��").link("http://test").userRating(9.3f).build(),
	                MovieDTO.builder().title("����3��").link("http://test").userRating(8.7f).build(),
	                MovieDTO.builder().title("����1��").link("http://test").userRating(9.7f).build()
	                );
	}
}
