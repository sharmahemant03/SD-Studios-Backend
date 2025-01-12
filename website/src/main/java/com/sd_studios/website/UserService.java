package com.sd_studios.website;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String registerUser(User user) {
        Optional<User> existingUser = Optional.ofNullable(userRepository.findByEmail(user.getEmail()));
        if (existingUser.isPresent()) {
            return "Email already exists";
        }
        userRepository.save(user);
        return "User registered successfully";
    }


    public String loginUser(String email, String password) {
        Optional<User> existingUser = Optional.ofNullable(userRepository.findByEmail(email));
        if (existingUser.isPresent() && existingUser.get().getPassword().equals(password)) {
            return "Login successful";
        }
        return "Invalid email or password";
    }
}
