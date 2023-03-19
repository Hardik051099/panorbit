package com.example.panorbit.service;

import com.example.panorbit.dto.SignupRequest;
import com.example.panorbit.model.User;

public interface UserService {

    User createUser(SignupRequest signupRequest);

    User findUserByEmail(String email);
}
