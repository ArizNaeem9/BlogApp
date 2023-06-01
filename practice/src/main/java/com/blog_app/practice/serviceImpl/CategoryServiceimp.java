package com.blog_app.practice.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog_app.practice.entities.Category;
import com.blog_app.practice.payloads.CategoryDto;
import com.blog_app.practice.respositories.CategoryRepo;
import com.blog_app.practice.services.categoryService;


@Service
public class CategoryServiceimp implements categoryService {

  @Autowired
  private CategoryRepo repo;

  @Autowired
  private ModelMapper modelMapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto){
      Category category = this.categoryDtoToCategory(categoryDto);
      Category saveCategory =  this.repo.save(category);

      return this.categoryToCategoryDto(saveCategory);

    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer id){
        Category category = this.categoryDtoToCategory(categoryDto);

        category.setCategoryDescription(categoryDto.getCategoryDescription());
        category.setCategoryId(categoryDto.getCategoryId());
        category.setCategoryTitle(categoryDto.getCategoryTitle());

        return this.categoryToCategoryDto(category);
    }

    @Override
    public CategoryDto getCategoryById(Integer id){
        Category category = this.repo.findById(id).get();
        return this.categoryToCategoryDto(category);

    }

    @Override
    public void deleteCategory(Integer id){
        this.repo.deleteById(id);
    }

    @Override
    public List<CategoryDto> getAllCategory(){
      List<Category> Categories = this.repo.findAll();
      List<CategoryDto> categoriesDto = Categories.stream().map(category -> this.categoryToCategoryDto(category)).collect(Collectors.toList());
      return categoriesDto;
    }

    private Category categoryDtoToCategory(CategoryDto categoryDto) {
      Category category = this.modelMapper.map(categoryDto, Category.class);
      return category;
  }

  private CategoryDto categoryToCategoryDto(Category category) {
      CategoryDto categoryDto = this.modelMapper.map(category, CategoryDto.class);
      return categoryDto;
  }
}
