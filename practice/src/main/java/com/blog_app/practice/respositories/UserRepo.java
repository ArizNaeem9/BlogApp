package com.blog_app.practice.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog_app.practice.entities.Users;

public interface UserRepo extends JpaRepository<Users, Integer>{
    
}
