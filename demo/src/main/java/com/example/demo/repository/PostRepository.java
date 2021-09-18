package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.Post;

public interface PostRepository extends CrudRepository<Post, Long> {

}
