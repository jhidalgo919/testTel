package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Post;
import com.example.demo.repository.PostRepository;

@Service
public class PostService {
	 private PostRepository postRepository;

	 public PostService(PostRepository postRepository) {
		 this.postRepository = postRepository;
	 }

     public Iterable<Post> list() {
         return postRepository.findAll();
     }
     
     public Post getPostById(Long id) {
    	 return postRepository.findById(id).orElse(null);
     }
     
     public Post save(Post post) {
    	 return postRepository.save(post);
     }

	 public Iterable<Post> save(List<Post> posts) {
	     return postRepository.saveAll(posts);
	 }
	 
	 /*public Post updatePost (Post post) {
		 Post oldPost = null;
		 Optional<Post> optionalPost = postRepository.findById(post.getId());
		 if (optionalPost.isPresent()) {
			 oldPost = optionalPost.get();
			 oldPost.setUserId(post.getUserId());
			 oldPost.setTitle(post.getTitle());
			 oldPost.setBody(post.getBody());
			 postRepository.save(oldPost);
		 }else {
			 return new Post();			 
		 }
		 return oldPost;
		 
	 }*/
	 
	 public String deletePostById(Long id) {
		 postRepository.deleteById(id);
		 return "Post deleted";
	 }

}
