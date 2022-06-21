package com.example.demo.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.MovieDTO;
import com.example.demo.exception.ClientNoContentRuntimeException;
import com.example.demo.repository.MovieRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieService {
	
	/*
	 * RequiredArgsConstructor�� ���� @Autowired �ʿ���� DI ���� ����
	@Autowired
	private MovieRepository movieRepository;
	 */
	
	private final MovieRepository movieRepository;
	
	public List<MovieDTO> search(final String query) {
		MovieGroup moviegroup = new MovieGroup(movieRepository.findByQuery(query));
		return moviegroup.getWithoutZeroRating();
	}
	
	public List<MovieDTO> query(final String query) {
		return Arrays.asList(
				MovieDTO.builder().title("��ȭ1").link("http://test").build(),
				MovieDTO.builder().title("��ȭ2").link("http://test").build()
		);
	}
	
	public MovieDTO recommendeTodayMovie(String query) throws ClientNoContentRuntimeException{
		MovieGroup movieGroup = new MovieGroup(movieRepository.findByQuery(query));
//		return movieGroup.getHighestRatingMovie().orElse(MovieDTO.builder().title("�⺻��ȭ").userRating(9.9f).build());
		return movieGroup.getHighestRatingMovie().orElseThrow(ClientNoContentRuntimeException::new);
	}
}
