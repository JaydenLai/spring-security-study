package com.hsbc.springsecuritystudy.controller;

import com.hsbc.springsecuritystudy.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping
    public List<User> usersQuery(@PageableDefault() Pageable pageable){
        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

    @GetMapping("/{id:\\d+}")
    public User userQuery(){
        return new User();
    }

    @PostMapping
    public User userCreate(@Valid @RequestBody User user, BindingResult bindingResult){
//        if(bindingResult.hasErrors()){
//            bindingResult.getAllErrors().forEach(err -> {
//                FieldError fieldError = (FieldError) err;
//                System.out.println(fieldError.getField().concat(err.getDefaultMessage()));
//            });
//        }
        return new User();
    }

    @PutMapping("/{id:\\d+}")
    public User userUpdate(@RequestBody User user) {
        return user;
    }
}
