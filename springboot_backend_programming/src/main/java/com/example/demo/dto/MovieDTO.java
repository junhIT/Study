package com.example.demo.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Builder
@Getter
public class MovieDTO implements Serializable{

	private String title;
	private String link;
	private float userRating;
	private String image;
	private String subtitle;
	private String pubDate; 
	private String director;
	private String actor;
}
