package com.app.controller;

import com.app.entity.User;
import com.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/add-user")
    public void addUser() {
        userService.addUser(new User("vantoan01", "123456"));
        userService.addUser(new User("vantoan02", "123456"));

    }

    @GetMapping("/view-users")
    public Iterable<User> allUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/{userId}/get-password")
    public String getPassword(@PathVariable Long userId) {
        return userService.getPasswordUser(userId);
    }

    @GetMapping("/{userId}/update-password")
    public void updatePassword(@PathVariable Long userId) {
        userService.editPasswordUser(userId, "p123456p");
        System.out.println("Edit password done");
    }

    @GetMapping("/{userId}/")
    public User findUser(@PathVariable Long userId) {
        return userService.findUserById(userId);
    }

    @GetMapping("/{userId}/delete-user")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }
}
