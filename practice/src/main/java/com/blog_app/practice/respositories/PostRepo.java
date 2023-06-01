package com.blog_app.practice.respositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog_app.practice.entities.Category;
import com.blog_app.practice.entities.Post;
import com.blog_app.practice.entities.Users;

public interface PostRepo extends JpaRepository<Post,Integer> {
    
    List<Post> findByUser(Users user);
    List<Post> findByCategory(Category category);

}
