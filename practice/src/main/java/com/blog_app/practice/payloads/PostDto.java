package com.blog_app.practice.payloads;

import java.util.Date;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {
    
    @NotEmpty
    String title;
    @NotEmpty
    String content;

    String imageName;

    Date addedDate;

    CategoryDto category;

    UserDto user;
    

}
