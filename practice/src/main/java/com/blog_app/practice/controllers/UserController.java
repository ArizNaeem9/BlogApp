package com.blog_app.practice.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog_app.practice.payloads.ApiResponse;
import com.blog_app.practice.payloads.UserDto;
import com.blog_app.practice.services.UserService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/user")
public class UserController {
    
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
        
    UserDto createdUser = this.userService.createUser(userDto);
        
     return new ResponseEntity<UserDto>(createdUser,  HttpStatus.CREATED);
    }

    
    @PostMapping("/update/{id}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto,@PathVariable Integer id) {
        
    UserDto updatedUser = this.userService.updateUser(userDto, id);
        
     return  ResponseEntity.ok(updatedUser);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer id) {
        
    this.userService.deleteUser(id);
    return new ResponseEntity<ApiResponse>(new ApiResponse("User is deleted" , true),HttpStatus.OK);
        
    }


    
}
