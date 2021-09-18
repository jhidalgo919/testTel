package com.example.demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.domain.Post;
import com.example.demo.service.PostService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner(PostService postService) {
		return args -> {
			// read json and write to db
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Post>> typeReference = new TypeReference<List<Post>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/productos.json");
			try {
				List<Post> posts = mapper.readValue(inputStream,typeReference);
				postService.save(posts);
				System.out.println("Posts are Saved!");
			} catch (IOException e){
				System.out.println("Unable to save posts: " + e.getMessage());
			}
		};
	}

}
