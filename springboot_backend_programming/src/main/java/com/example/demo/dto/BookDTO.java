package com.example.demo.dto;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
public class BookDTO implements Serializable{

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
