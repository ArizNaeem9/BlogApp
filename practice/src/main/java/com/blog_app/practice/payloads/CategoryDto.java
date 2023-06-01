package com.blog_app.practice.payloads;

import jakarta.validation.constraints.Size;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class CategoryDto {

    @NotEmpty
    public Integer categoryId;
 
    @NotEmpty
    @Size (min = 10, message= "Must be at least 10 characters")
    public String categoryTitle;

    @NotEmpty
    @Size(min = 10, message= "Must be at least 10 characters")
    public String categoryDescription;
}
