package com.example.udemy_project1.services;

import com.example.udemy_project1.entities.Users;
import com.example.udemy_project1.exceptions.UserExistsException;
import com.example.udemy_project1.exceptions.UserNotFoundException;
import com.example.udemy_project1.exceptions.UsernameNotFoundException;
import com.example.udemy_project1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<Users> getAllUsers(){
        return userRepository.findAll();
    }
    public Users createUser(Users user) throws UserExistsException {
        Users existingUser= userRepository.findByUsername(user.getUsername());
        if (existingUser!=null) {
            throw new UserExistsException("User already exists");
        }
        return userRepository.save(user);
    }
    public Optional<Users> getUserById(Long id) throws UserNotFoundException {
        Optional<Users> user= userRepository.findById(id);
        if (!user.isPresent()) {
            throw new UserNotFoundException("User not found in user Repository");
        }
        return user;
    }
    public Users updateUserById(Long id,Users user) throws UserNotFoundException{
        //user check
        Optional<Users> optionalUser= userRepository.findById(id);
        if (!optionalUser.isPresent()) {
            throw new UserNotFoundException("User not found in user Repository,not updated");
        }
        //update user if present
        user.setId(id);
        return userRepository.save(user);
    }
    public void deleteUserById(Long id) throws UserNotFoundException{
        Optional<Users> optionalUser= userRepository.findById(id);
        if(!optionalUser.isPresent()){
            throw new UserNotFoundException("User not found in user Repository,no data deleted");
        }
        userRepository.deleteById(id);
    }
    public Users findUserByUsername(String username) {
        return userRepository.findByUsername(username);

    }
}
