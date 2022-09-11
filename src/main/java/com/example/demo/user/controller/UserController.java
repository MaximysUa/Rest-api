package com.example.demo.user.controller;

import com.example.demo.user.entity.UserEntity;
import com.example.demo.user.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        List<UserEntity> users = this.userService.getAll();
        if (users.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getById(@PathVariable("id") Long id) {
        if (id == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        UserEntity userEntity = this.userService.get(id);
        if (userEntity == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<UserEntity>(userEntity, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserEntity> saveUser(@RequestBody UserEntity userEntity) {
        if (userEntity == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        this.userService.save(userEntity);
        return new ResponseEntity<>(userEntity, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<UserEntity> updateUser(@RequestBody UserEntity userEntity) {
        if (userEntity == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        this.userService.save(userEntity);

        return new ResponseEntity<>(userEntity, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserEntity> deleteUser(@PathVariable("id") Long id) {
        if (id == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        UserEntity userEntity = this.userService.get(id);
        if (userEntity == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        this.userService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping
    public ResponseEntity<UserEntity> deleteAllUsers() {
        userService.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/saveAll")
    public ResponseEntity<List<UserEntity>> saveAllUsers (@RequestBody List<UserEntity> list) {
        if (list.isEmpty()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        userService.saveAll(list);
        return new ResponseEntity<>(list, HttpStatus.CREATED);
    }

}
