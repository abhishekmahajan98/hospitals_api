package com.example.udemy_project1.controllers;

import com.example.udemy_project1.entities.Users;
import com.example.udemy_project1.exceptions.UserExistsException;
import com.example.udemy_project1.exceptions.UserNotFoundException;
import com.example.udemy_project1.exceptions.UsernameNotFoundException;
import com.example.udemy_project1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Optional;

@RestController
@Validated
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<Users> getAllUsers(){
        return  userService.getAllUsers();
    }

    @PostMapping("/users")
    public ResponseEntity<Void> createUser(@Valid @RequestBody Users user, UriComponentsBuilder builder){
        try {
             userService.createUser(user);
            HttpHeaders headers= new HttpHeaders();
            headers.setLocation(builder.path("/users/{id}").buildAndExpand(user.getId()).toUri());
            return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
        } catch (UserExistsException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,ex.getMessage());
        }
    }

    @GetMapping("/users/{id}")
    public Optional<Users> getUserById(@PathVariable("id") @Min(1) Long id){
        try {
            return userService.getUserById(id);
        }catch (UserNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }

    @PostMapping("/users/{id}")
    public Users updateUserById(@PathVariable("id") Long id,@RequestBody Users user){
        try {
            return userService.updateUserById(id,user);
        } catch (UserNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }

    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable("id") Long id){
        try {
            userService.deleteUserById(id);
        } catch (UserNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }
    @GetMapping("/users/username/{username}")
    public Users getUserByUsername(@PathVariable("username") String username) throws UsernameNotFoundException {
        Users user= userService.findUserByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("Username "+ username+" not found in user repository");
        }
        return user;

    }
}
