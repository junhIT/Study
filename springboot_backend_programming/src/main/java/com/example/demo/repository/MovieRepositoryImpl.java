package com.example.demo.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.MovieDTO;
import com.example.demo.dto.NaverProperties;
import com.example.demo.dto.ResponseMovie;

@Component
@Primary
public class MovieRepositoryImpl implements MovieRepository {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private NaverProperties naverProperties;

	@Override
	public List<MovieDTO> findByQuery(String query) {
 
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("X-Naver-Client-Id", naverProperties.getClientId());
		httpHeaders.add("X-Naver-Client-Secret", naverProperties.getClientSecret());
		
		String url = naverProperties.getMovieUrl() + "?query=" + query;
		
		return restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(httpHeaders), ResponseMovie.class)
				.getBody()
				.getItems()
				.stream()
				.map(m -> MovieDTO.builder()
						.title(m.getTitle())
						.link(m.getLink())
						.userRating(m.getUserRating())
						.image(m.getImage())   
						.subtitle(m.getSubtitle())
						.pubDate(m.getPubDate())
						.director(m.getDirector())
						.actor(m.getActor())
						.build())
				.collect(Collectors.toList());
	}

}
