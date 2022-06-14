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
				MovieDTO.builder().actor("액터1").director("디렉터1").title("제목1").userRating(0.0f).build()	// 평점이 0점인 영화
				,MovieDTO.builder().actor("액터2").director("디렉터2").title("제목2").userRating(0.1f).build()
				,MovieDTO.builder().actor("액터3").director("디렉터3").title("제목3").userRating(99.0f).build()
				);
	}
	
	public List<MovieDTO> getStubRecommendedMovies() {
		return Arrays.asList(
				MovieDTO.builder().actor("액터1").director("디렉터1").title("제목1").userRating(0.0f).build()	// 평점이 0점인 영화
				,MovieDTO.builder().actor("액터2").director("디렉터2").title("제목2").userRating(0.1f).build()
				,MovieDTO.builder().actor("액터3").director("디렉터3").title("평점1위").userRating(99.0f).build()
				);
	}

}
