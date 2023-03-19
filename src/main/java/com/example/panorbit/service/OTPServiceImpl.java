package com.example.panorbit.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

@Service
public class OTPServiceImpl implements OTPService {

    @Value("${twilio.account.sid}")
    private String accountSid;

    @Value("${twilio.auth.token}")
    private String authToken;

    @Value("${twilio.phone.number}")
    private String twilioPhoneNumber;

    @Autowired
    public OTPServiceImpl(@Value("${twilio.account.sid}") String accountSid,
                          @Value("${twilio.auth.token}") String authToken) {
        this.accountSid = accountSid;
        this.authToken = authToken;
        Twilio.init(accountSid, authToken);
    }
    private Map<String, String> otpStorage = new HashMap<>();

    @Override
    public String generateAndStoreOTP(String email) {
        String otp = generateOTP();
        otpStorage.put(email, otp);
        return otp;
    }

    @Override
    public void sendOTP(String phoneNumber, String otp) {
        Message message = Message.creator(
                        new PhoneNumber(phoneNumber),
                        new PhoneNumber(twilioPhoneNumber),
                        "Your OTP is: " + otp)
                .create();
    }

    @Override
    public boolean verifyOtp(String email, String otp) {
        return (otpStorage.containsKey(email))?(otpStorage.get(email).equals(otp))?true:false:false;
    }

    private String generateOTP() {
        SecureRandom random = new SecureRandom();
        int otp = 100000 + random.nextInt(900000);
        return String.valueOf(otp);
    }
}
