package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BookDTO;
import com.example.demo.dto.MovieDTO;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.MovieRepository;
import com.example.demo.service.MovieGroup;
import com.example.demo.service.MovieService;

@RestController
@RequestMapping("/api/v1/search")
public class SearchController {
	
	@Autowired
	private MovieService movieService;
	
	@Autowired 
	private MovieRepository movieRepository;
	
	@Autowired
	private BookRepository bookRepository;

	@GetMapping("/movies")
	public List<MovieDTO> getMoviesByQuery(@RequestParam(name = "q") String query) {
		
		MovieGroup movieGroup = new MovieGroup(movieService.search(query));
		
		return movieGroup.getListOrderRating();
	}
	
	@GetMapping("/books")
	public List<BookDTO> getBookesByQuery(@RequestParam(name = "q") String query) {
		
		List<BookDTO> books = bookRepository.findByQuery(query);
		
		return books;
	}
}
