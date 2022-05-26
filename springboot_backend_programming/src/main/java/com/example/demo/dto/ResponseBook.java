package com.example.demo.dto;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseBook {
	
	private List<Item> items;
	
	@Getter
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Item {
		private String title;
		private String link;
		private String image;
		private String author;
		private int price;
		private int discount;
		private String publisher;
		private String isbn;
		private String description;
		private String pubdate;
	}
}
