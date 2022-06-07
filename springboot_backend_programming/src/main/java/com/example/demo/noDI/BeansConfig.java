package com.example.demo.noDI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.service.MovieService;

@Configuration
public class BeansConfig {
	
	// 어노테이션 안쓰고 Bean 설정해보기
	
	@Bean
	public BeanService beanService() {
		return new BeanService(beanRepository());
	}
	
	@Bean 
	public BeanRepository beanRepository() {
//		return new BeanRepositoryImpl();
		return new JunRepositoryImpl();
	}
}
