package com.example.demo.noDI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.NaverProperties;
import com.example.demo.repository.MovieRepository;
import com.example.demo.repository.MovieRepositoryImpl;
import com.example.demo.service.MovieService;

@Configuration
public class BeansConfig {
	
	// ������̼� �Ⱦ��� Bean �����غ���
	
	@Bean
	public BeanService beanService() {
		return new BeanService(beanRepository());
	}
	
	@Bean 
	public BeanRepositoryImpl beanRepository() {
		return new BeanRepositoryImpl();
	}
}
