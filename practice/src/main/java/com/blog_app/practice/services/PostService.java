package com.blog_app.practice.services;

import java.util.List;

import com.blog_app.practice.payloads.PostDto;

public interface PostService {
    
PostDto createPost(PostDto post, Integer categoryId, Integer userId);

PostDto updatePost(PostDto post, Integer categoryId, Integer userId);

void deletePost(PostDto post, Integer categoryId, Integer userId);

PostDto getPostById(Integer postId);

PostDto findPostByUser(Integer userId);

List<PostDto> getAllPost(Integer pageSize, Integer pageNumber);
    
}
