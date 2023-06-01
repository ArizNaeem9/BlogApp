package com.blog_app.practice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.blog_app.practice.payloads.CategoryDto;
import com.blog_app.practice.services.categoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Category")
public class CategoryController {
    
    private categoryService categoryService; ;

    @PostMapping("/")
    public ResponseEntity<CategoryDto> createUser(@Valid @RequestBody CategoryDto categoryDto) {
        
    CategoryDto createdUser = this.categoryService.createCategory(categoryDto);
        
     return new ResponseEntity<CategoryDto>(createdUser,  HttpStatus.CREATED);
    }
}
