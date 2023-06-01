package com.blog_app.practice.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog_app.practice.entities.Users;
import com.blog_app.practice.payloads.UserDto;
import com.blog_app.practice.respositories.UserRepo;
import com.blog_app.practice.services.UserService;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserRepo repo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        Users user = this.userDtoToUser(userDto);
        Users saveUser = this.repo.save(user);
        return this.userToUserDto(saveUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer id) {
        Users user = this.repo.findById(id).get();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());

        Users updatedUser = this.repo.save(user);
        UserDto updatedUserDto = this.userToUserDto(updatedUser);
        return updatedUserDto;

    }

    @Override
    public UserDto getUserById(Integer id) {
        Users user = this.repo.findById(id).get();
        UserDto userDto = this.userToUserDto(user);
        return userDto;
    }

    @Override
    public void deleteUser(Integer id) {
        this.repo.deleteById(id);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<Users> users = this.repo.findAll();

        List<UserDto> userDtoList = users.stream().map(user -> this.userToUserDto(user)).collect(Collectors.toList());
        return userDtoList;

    }

    private Users userDtoToUser(UserDto userDto) {
        Users user = this.modelMapper.map(userDto, Users.class);
        return user;
    }

    private UserDto userToUserDto(Users user) {
        UserDto userDto = this.modelMapper.map(user, UserDto.class);
        return userDto;
    }
}
