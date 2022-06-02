package noDI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.NaverProperties;
import com.example.demo.repository.MovieRepository;
import com.example.demo.repository.MovieRepositoryImpl;
import com.example.demo.service.MovieService;

@Configuration
public class BeansConfig {
	
	// 어노테이션 안쓰고 Bean 설정해보기
	
	@Bean
	public MovieService movieService() {
		return new MovieService(movieRepository());
	}
	
	@Bean 
	public MovieRepository movieRepository() {
//		return new MovieRepositoryImpl(restTemplate(), naverProperties());
		return null;
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public NaverProperties naverProperties() {
		return new NaverProperties();
	}
	

}
