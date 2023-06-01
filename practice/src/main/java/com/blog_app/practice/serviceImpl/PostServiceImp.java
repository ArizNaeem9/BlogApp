package com.blog_app.practice.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.blog_app.practice.entities.Category;
import com.blog_app.practice.entities.Post;
import com.blog_app.practice.entities.Users;
import com.blog_app.practice.payloads.PostDto;
import com.blog_app.practice.respositories.CategoryRepo;
import com.blog_app.practice.respositories.PostRepo;
import com.blog_app.practice.respositories.UserRepo;
import com.blog_app.practice.services.PostService;

@Service
public class PostServiceImp implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PostDto createPost(PostDto post, Integer categoryId, Integer userId) {
        Post newPost = this.PostDtoToPost(post);

        Category category = this.categoryRepo.findById(categoryId).get();
        Users user = this.userRepo.findById(userId).get();

        newPost.setAddedDate(new Date());
        newPost.setUser(user);
        newPost.setImageName("default.jpg");
        newPost.setCategory(category);

        Post savePost = this.postRepo.save(newPost);

        return this.PostToPostDto(savePost);

    }

    @Override
    public PostDto updatePost(PostDto post, Integer categoryId, Integer userId) {
        Category category = this.categoryRepo.findById(categoryId).get();
        Users user = this.userRepo.findById(userId).get();
        Post updatedPost = this.PostDtoToPost(post);
        updatedPost.setContent(post.getContent());
        updatedPost.setTitle(post.getTitle());
        updatedPost.setAddedDate(new Date());
        updatedPost.setUser(user);
        updatedPost.setCategory(category);

        return this.PostToPostDto(updatedPost);

    }

    @Override
    public void deletePost(PostDto post, Integer categoryId, Integer userId) {

    }

    @Override
    public PostDto getPostById(Integer postId) {
        Post post = this.postRepo.findById(postId).get();

        return this.PostToPostDto(post);
    }

    @Override
    public PostDto findPostByUser(Integer userId) {
        Users user = this.userRepo.findById(userId).get();
        Post post = this.postRepo.findByUser(user).get(0);

        return this.PostToPostDto(post);
    }

    @Override
    public List<PostDto> getAllPost(Integer pageSize, Integer pageNumber) {
        PageRequest p = PageRequest.of(pageNumber, pageSize);

        Page<Post> paginatedPosts = this.postRepo.findAll(p);

        List<Post> allPosts = paginatedPosts.getContent();

        List<PostDto> allPostsDto = allPosts.stream().map(post -> this.PostToPostDto(post))
                .collect(Collectors.toList());

        return allPostsDto;
    }

    private Post PostDtoToPost(PostDto postDto) {
        Post post = this.modelMapper.map(postDto, Post.class);
        return post;
    }

    private PostDto PostToPostDto(Post Post) {
        PostDto postDto = this.modelMapper.map(Post, PostDto.class);
        return postDto;
    }

}
