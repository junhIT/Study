package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	@Cacheable(key = "#query", cacheNames="List<MovieDTO>")
	public List<MovieDTO> getMoviesByQuery(@RequestParam(name = "q") String query) {

		log.info("#################################### getMoviesByQuery Method 호출, " + query);
		
		List<MovieDTO> movieList = movieService.search(query);
		
		return movieList;
	}
	
	@GetMapping("/books")
	public List<BookDTO> getBookesByQuery(@RequestParam(name = "q") String query) {
		
		List<BookDTO> books = bookRepository.findByQuery(query);
		
		return books;
	}
	
	@GetMapping("/recommende-movie")
	public MovieDTO getRecommendeMovie(@RequestParam(name = "q") String query) throws ClientNoContentRuntimeException {
		return movieService.recommendeTodayMovie(query);
	}
	
	/*
	 * movieDTO 입력받아 저장하기 위한 Method
	 */
	@PostMapping("/insertMovie")
	public boolean insertMovie(MovieDTO movieDTO) {
		boolean success = false;
		
		log.info("############################# insertMovie Method 호출" + movieDTO.toString());
		
		
		
		return success;
	}
}
