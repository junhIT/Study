package com.example.demo.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.demo.dto.MovieDTO;

@Component
@Qualifier("MockMovieRepositoryImpl")
public class MockMovieRepositoryImpl implements MovieRepository {

	@Override
	public List<MovieDTO> findByQuery(String query) {
		return Arrays.asList(
				MovieDTO.builder().actor("����1").director("����1").title("����1").userRating(0.0f).build()	// ������ 0���� ��ȭ
				,MovieDTO.builder().actor("����2").director("����2").title("����2").userRating(0.1f).build()
				,MovieDTO.builder().actor("����3").director("����3").title("����3").userRating(99.0f).build()
				);
	}
	
	public List<MovieDTO> getStubRecommendedMovies() {
		return Arrays.asList(
				MovieDTO.builder().actor("����1").director("����1").title("����1").userRating(0.0f).build()	// ������ 0���� ��ȭ
				,MovieDTO.builder().actor("����2").director("����2").title("����2").userRating(0.1f).build()
				,MovieDTO.builder().actor("����3").director("����3").title("����1��").userRating(99.0f).build()
				);
	}

}
