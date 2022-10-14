package com.java.intuit.user.userauthentication.models;


import com.java.intuit.user.userauthentication.models.enums.UserType;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.UniqueConstraint;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
public class IntuitUser extends BaseModel {

    private String firstName;
    private String lastName;
    private String email;
    private char[] password;
    private UserType userType;
    private String salt;
    private String hash;
}
