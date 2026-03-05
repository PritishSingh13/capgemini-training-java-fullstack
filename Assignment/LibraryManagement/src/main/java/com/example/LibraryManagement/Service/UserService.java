package com.example.LibraryManagement.Service;
import com.example.LibraryManagement.Model.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    private List<User> users = new ArrayList<>();
    public  boolean registerUser(User user){
        for(User s:users){
            if(s.getEmail().equalsIgnoreCase(user.getEmail())){
                return false;
            }
        }
        users.add(user);
        return true;
    }
    public User loginUser(String email,String password){
        for(User user:users){
            if(user.getEmail().equalsIgnoreCase(email) && user.getPassword().equalsIgnoreCase(password)){
                return user;
            }
        }
        return null;
    }
}
