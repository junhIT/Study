package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.dto.MovieDTO;

public class MovieGroup {
	
	private final List<MovieDTO> list;
	
	public MovieGroup(final List<MovieDTO> list) {
		this.list = list;
	}
	
	public List<MovieDTO> getListOrderRating() {
		return list.stream()
				.filter(b -> !((Float)b.getUserRating()).equals(0.0f))
				.sorted((a, b) -> b.getUserRating() > a.getUserRating() ? 1 : -1)
				.collect(Collectors.toList());
	}
	
	public List<MovieDTO> getWithoutZeroRating() {
		
		
		return list.stream()
				.filter(b -> Float.compare(b.getUserRating(), 0.0f) > 0)
				.collect(Collectors.toList());
//		return list.stream()
//				.filter(b -> !((Float)b.getUserRating()).equals(0.0f))
//				.collect(Collectors.toList());
	}
	
}
