package com.blog_app.practice.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class UserDto  {

    public Integer id;

    @NotEmpty
    @Size(min=5, message="Must be of 5 letters")
    public String name;

    @Email
    public String email;
    
    @NotEmpty
    @Size(min=10, message="Must be of 10 letters")
    public String password;

    @NotEmpty
    @Size(min=10, message="Must be of 10 letters")
    public String about;

    
}
