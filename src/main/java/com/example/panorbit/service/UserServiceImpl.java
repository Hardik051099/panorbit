package com.example.panorbit.service;

import com.example.panorbit.dto.SignupRequest;
import com.example.panorbit.model.User;
import com.example.panorbit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(SignupRequest signupRequest) {
        if (userRepository.findByEmail(signupRequest.getEmail()) == null) {
            User user = new User();
            user.setFirstName(signupRequest.getFirstName());
            user.setLastName(signupRequest.getLastName());
            user.setGender(signupRequest.getGender());
            user.setEmail(signupRequest.getEmail());
            user.setPhoneNumber(signupRequest.getPhoneNumber());
            return userRepository.save(user);
        } else {
            return null;
        }
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
