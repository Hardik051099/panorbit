package com.example.panorbit.controller;

import com.example.panorbit.dto.LoginRequest;
import com.example.panorbit.dto.SignupRequest;
import com.example.panorbit.model.User;
import com.example.panorbit.service.OTPService;
import com.example.panorbit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/pan")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private OTPService otpService;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        User user = userService.findUserByEmail(loginRequest.getEmail());
        if (user != null) {
            String otp = otpService.generateAndStoreOTP(user.getEmail());
            otpService.sendOTP(user.getPhoneNumber(), otp); // Send OTP via SMS using Twilio
            return new ResponseEntity<>("OTP generated and sent via SMS", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest signupRequest) {
        User user = userService.createUser(signupRequest);
        if (user != null) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("User already exists", HttpStatus.CONFLICT);
        }

    }
    @PostMapping("/perform_login")
    public ResponseEntity<?> performLogin(Authentication authentication) {
        return new ResponseEntity<>("User authenticated", HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request) {
        SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
        logoutHandler.logout(request, null, null);
        return new ResponseEntity<>("User logged out", HttpStatus.OK);
    }
}
