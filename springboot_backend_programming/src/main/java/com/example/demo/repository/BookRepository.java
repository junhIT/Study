package com.example.demo.repository;

import java.util.List;

import com.example.demo.dto.BookDTO;

public interface BookRepository {
	List<BookDTO> findByQuery(String query);

	List<BookDTO> findAllByAuthors(String author);

}
