package com.sd_studios.website;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse> signUp(@RequestBody User user) {
        String response = userService.registerUser(user);

        if (response.equals("User registered successfully")) {
            ApiResponse apiResponse = new ApiResponse(true, response);
            return ResponseEntity.ok(apiResponse);
        }

        ApiResponse apiResponse = new ApiResponse(false, response);
        return ResponseEntity.badRequest().body(apiResponse);
    }


    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestBody User loginRequest) {
        String response = userService.loginUser(loginRequest.getEmail(), loginRequest.getPassword());

        if (response.equals("Login successful")) {
            ApiResponse apiResponse = new ApiResponse(true, response);
            return ResponseEntity.ok(apiResponse);
        }

        ApiResponse apiResponse = new ApiResponse(false, response);
        return ResponseEntity.badRequest().body(apiResponse);
    }




}

