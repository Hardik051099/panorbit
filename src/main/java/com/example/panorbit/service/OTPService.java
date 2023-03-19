package com.example.panorbit.service;

public interface OTPService {
    String generateAndStoreOTP(String email);

    void sendOTP(String phoneNumber, String otp);

    boolean verifyOtp(String email,String otp);
}

