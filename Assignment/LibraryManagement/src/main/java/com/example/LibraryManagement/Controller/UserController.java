package com.example.LibraryManagement.Controller;


import com.example.LibraryManagement.Model.User;
import com.example.LibraryManagement.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public  String showRegistrationForm(Model model){
        model.addAttribute("user",new User());
        return "register";
    }

    @PostMapping("/register")
    public  String registerUser(@Valid @ModelAttribute("user") User user,
                                BindingResult result,Model model){
        if(result.hasErrors()){
            return "register";
        }
        if(!userService.registerUser(user)){
            model.addAttribute("error","Email Already exists");
            return "register";
        }
        return "redirect:/login";
    }

    @GetMapping("/login")
    public  String showLoginForm(){
        return "login";
    }
    @PostMapping("/login")
    public  String loginUser(@RequestParam("email") String email,
                             @RequestParam("password") String password, Model model){
        if(userService.loginUser(email,password) != null){
            return "redirect:/books/dashboard";
        }
        model.addAttribute("error","Invalid email or pass");
        return "login";
    }


}
