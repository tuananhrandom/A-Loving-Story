package anh.nguyen.alovestory.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import anh.nguyen.alovestory.entities.User;
import anh.nguyen.alovestory.services.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/all")
    public List<User> getAllUser() {
        return userService.findAllUser();
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<?> deleteDoor(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>("Delete Complete", HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<?> newUser(@RequestBody User user) {
        userService.createNewUser(user);
        return new ResponseEntity<>("Created", HttpStatus.OK);
    }

}