package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BookDTO;
import com.example.demo.dto.MovieDTO;
import com.example.demo.exception.ClientNoContentRuntimeException;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.MovieService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/search")
public class SearchController {
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private BookRepository bookRepository;

	@GetMapping("/movies")
	public List<MovieDTO> getMoviesByQuery(@RequestParam(name = "q") String query) {

		List<MovieDTO> movieList = movieService.search(query);
		
		return movieList;
	}
	
	@GetMapping("/books")
	public List<BookDTO> getBookesByQuery(@RequestParam(name = "q") String query) {
		
		List<BookDTO> books = bookRepository.findByQuery(query);
		
		return books;
	}
	
	@GetMapping("/booksByAuthor")
	public List<BookDTO> getBooksByAuthor(@RequestParam(name = "author") String author) {
		return bookRepository.findAllByAuthors(author);
	}
	
	@GetMapping("/recommende-movie")
	public MovieDTO getRecommendeMovie(@RequestParam(name = "q") String query) throws ClientNoContentRuntimeException {
		return movieService.recommendeTodayMovie(query);
	}
	
	@GetMapping("/searchCache")
	@Cacheable(key = "#query", cacheNames="List<MovieDTO>")
	public List<MovieDTO> searchCache(@RequestParam(name = "q") String query) {

		log.info("#################################### searchCache Method 호출, " + query);
		
		List<MovieDTO> movieList = movieService.search(query);
		
		return movieList;
	}
	
	/*
	 * 강제로 Cache update
	 */
	@GetMapping("/updateCache")
	@CachePut(key = "#query", cacheNames="List<MovieDTO>")
	public List<MovieDTO> insertMovie(@RequestParam(name = "q") String query) {

		List<MovieDTO> movieList = movieService.search(query);
		
		log.info("#################################### updateCache Method 호출, " + query);
		
		return movieList;
	}
	
	/*
	 * Cache 삭제
	 */
	@CacheEvict(cacheNames="List<MovieDTO>", key = "#query")
	@GetMapping("/removeCache")
	public void deleteCache(@RequestParam(name = "q") String query) {
		log.info("#################################### removeCache Method 호출, " + query);
		
	}
}
