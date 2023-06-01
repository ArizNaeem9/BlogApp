package com.blog_app.practice.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog_app.practice.entities.Category;

public interface CategoryRepo extends JpaRepository<Category,Integer> {
    
}
