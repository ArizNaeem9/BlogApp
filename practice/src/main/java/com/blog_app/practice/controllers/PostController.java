package com.blog_app.practice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blog_app.practice.payloads.PostDto;
import com.blog_app.practice.services.PostService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/")
public class PostController {

    @Autowired
    private PostService postService;
    @PostMapping("user/{userId},category/{categoryId}")
   public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto,@PathVariable Integer userId, @PathVariable Integer categoryId) {

    PostDto post = this.postService.createPost(postDto, categoryId, userId);
    return new ResponseEntity<PostDto>(post, HttpStatus.OK);
   } 

   @PostMapping("/")
   public ResponseEntity<List<PostDto>> getAllPost(@RequestParam(value = "pageNumber", defaultValue = "1", required = false) Integer pageNumber,
   @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize) {

    List<PostDto> post = this.postService.getAllPost(pageSize, pageNumber);
    return new ResponseEntity<List<PostDto>>(post, HttpStatus.OK);
   } 
    
    
}
