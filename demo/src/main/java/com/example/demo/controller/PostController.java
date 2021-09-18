package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Post;
import com.example.demo.service.PostService;

@RestController
@RequestMapping("/productos")
public class PostController {
	
	private PostService postService;

	public PostController(PostService postService) {
		this.postService = postService;
	}
	
	@GetMapping("/list")
	public Iterable<Post> list() {
		return postService.list();
	}
	
	@GetMapping("/post/{id}")
	public Post getOnePost(@PathVariable Long id) {
		return postService.getPostById(id);
		
	}
	
	@PostMapping("/add")
	public Post addPost(@RequestBody Post post) {
		return postService.save(post);
	}
	
	@PostMapping("/addPosts")
	public Iterable<Post> addPosts(@RequestBody List<Post> posts) {
		return postService.save(posts);
	}
	
	/*@PutMapping("/update")
	public Post updatePost(@RequestBody Post post) {
		return postService.updatePost(post);
	}*/
	
	@DeleteMapping("/delete/{id}")
	public String deletePost(@PathVariable Long id) {
		return postService.deletePostById(id);
	}
	
}
