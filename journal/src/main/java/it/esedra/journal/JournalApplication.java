package it.esedra.journal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
//@EnableWebMvc
public class JournalApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(JournalApplication.class, args);
	}
	/*
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/all").allowedOrigins("http://localhost:8080")
			     .allowedMethods("*")
		         .allowedHeaders("*")
		         .allowCredentials(false)
		         .maxAge(48000);
			}
		};
	}
	*/
}
