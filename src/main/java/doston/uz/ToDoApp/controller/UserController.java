package doston.uz.ToDoApp.controller;

import doston.uz.ToDoApp.User;
import doston.uz.ToDoApp.service.UserService;
import jdk.jfr.Registered;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users") // api versioning should be api/v1/*
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    // get One user
    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") Integer userId) {  // give meaningful name for method
        return userService.getUser(userId);

    }

    // add user
    @PostMapping("/")
    public String addUser(@RequestBody User user) {
        return userService.addNewUser(user);
    }

    // changing user Info by id
    @PutMapping("/{userId}")
    public String updateUser(
            @PathVariable("userId") Integer userId,
            @RequestBody User user) {
        return userService.updateUser(userId, user);
    }

    // delete Student with id
    @DeleteMapping("/{userId}")
    public String deleteStudent(@PathVariable("userId") Integer userId){
        userService.deleteUser(userId);
        return "User deleted successfully";
    }
}
