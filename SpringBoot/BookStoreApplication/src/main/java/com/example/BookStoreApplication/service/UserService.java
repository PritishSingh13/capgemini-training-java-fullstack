package com.example.BookStoreApplication.service;

import com.example.BookStoreApplication.dto.UserDto;
import com.example.BookStoreApplication.entity.User;
import com.example.BookStoreApplication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserDto createUser(UserDto userDto){

        User user = modelMapper.map(userDto, User.class);

        User savedUser = userRepository.save(user);

        return modelMapper.map(savedUser, UserDto.class);
    }

    public UserDto getUserById(Long id){

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return modelMapper.map(user, UserDto.class);
    }

    public List<UserDto> getAllUsers(){

        List<User> users = userRepository.findAll();

        return users.stream()
                .map(u -> modelMapper.map(u, UserDto.class))
                .toList();
    }

    public void deleteUser(Long id){

        userRepository.deleteById(id);

    }

}