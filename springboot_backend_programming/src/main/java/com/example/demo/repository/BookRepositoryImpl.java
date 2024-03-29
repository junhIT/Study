package com.example.demo.repository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.cache.LookAsideCaching;
import com.example.demo.config.PerformanceTimeRecord;
import com.example.demo.dto.BookDTO;
import com.example.demo.dto.NaverProperties;
import com.example.demo.dto.ResponseBook;

@Component
public class BookRepositoryImpl implements BookRepository {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private NaverProperties naverProperties;
	
	@Override
	public List<BookDTO> findByQuery(String query) {
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("X-Naver-Client-Id", naverProperties.getClientId());
		httpHeaders.add("X-Naver-Client-Secret", naverProperties.getClientSecret());
		
		String url = naverProperties.getBookUrl() + "?query=" + query;
		
		return restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(httpHeaders), ResponseBook.class)
				.getBody()
				.getItems()
				.stream()
				.map(m -> BookDTO.builder()
						.author(m.getAuthor())
						.description(m.getDescription())
						.discount(m.getDiscount())
						.image(m.getImage())
						.isbn(m.getIsbn())
						.link(m.getLink())
						.price(m.getPrice())
						.pubdate(m.getPubdate())
						.publisher(m.getPublisher())
						.title(m.getTitle())
						.build())
				.collect(Collectors.toList());
	}
	
	@Override
	@PerformanceTimeRecord
	@LookAsideCaching(value = "cache::recommend-movie")
	public List<BookDTO> findAllByAuthors(final String author) {
		try {
			// 비즈니스 로직 수행 시간
			Thread.sleep(3000);
			
			return Arrays.asList(BookDTO.builder().title("책1").build());
		} catch (InterruptedException e){
			throw new RuntimeException("TEST");
		}
	}
}
