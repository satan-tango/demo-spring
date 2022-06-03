package com.example.demo.controller;


import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user")
    public String user() {
        return "addUser";
    }

    @PostMapping("/user")
    public String addUser(@ModelAttribute("name") String name,
                          @ModelAttribute("email") String email,
                          @ModelAttribute("tel") String tel,
                          Model model) {
        UserEntity userEntity = UserEntity.builder()
                .userName(name)
                .userEmail(email)
                .userTel(tel)
                .build();
        userRepository.save(userEntity);
        model.addAttribute("user", userEntity);
        System.out.println(name + tel);
        return "users";
    }

}
