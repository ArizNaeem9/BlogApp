package com.blog_app.practice.services;

import java.util.List;

import com.blog_app.practice.payloads.CategoryDto;

public interface categoryService {

    CategoryDto createCategory(CategoryDto categoryDto);

    CategoryDto updateCategory(CategoryDto categoryDto, Integer id);

    CategoryDto getCategoryById(Integer id);

    void deleteCategory(Integer id);

    List<CategoryDto> getAllCategory();
    
}
