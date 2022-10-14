package com.java.intuit.user.userauthentication.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoginUser {
    private String email;
    private char[] password;
    private String token;
}
