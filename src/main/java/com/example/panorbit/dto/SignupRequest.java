package com.example.panorbit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequest {

    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private String phoneNumber;

}

