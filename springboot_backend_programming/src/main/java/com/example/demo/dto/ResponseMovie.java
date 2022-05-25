package com.example.demo.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMovie {
	
	private List<Item> items;
	
	@Getter
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Item {
		private String title;
		private String link;
		private String actor;
		private String director;
		private float userRating;
		private String image;
		private String subtitle;
		private String pubDate; 
	}
}
