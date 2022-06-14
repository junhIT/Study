package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BookDTO;
import com.example.demo.dto.MovieDTO;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.MovieService;

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
	
	@GetMapping("/recommende-movie")
	public MovieDTO getRecommendeMovie(@RequestParam(name = "q") String query) {
		return movieService.recommendeTodayMovie();
	}
}
