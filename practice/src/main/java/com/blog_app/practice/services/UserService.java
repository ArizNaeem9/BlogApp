package com.blog_app.practice.services;



import java.util.List;

import com.blog_app.practice.payloads.UserDto;

public interface  UserService {
  
    UserDto createUser(UserDto user);

    UserDto updateUser(UserDto user, Integer id);

    UserDto getUserById(Integer id);

    void deleteUser(Integer id);
     
    List<UserDto> getAllUsers();   
}
