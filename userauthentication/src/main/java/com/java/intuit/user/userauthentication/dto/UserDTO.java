package com.java.intuit.user.userauthentication.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private long userid;
    @ApiModelProperty()
    private String firstName;
    @ApiModelProperty(position = 2)
    private String lastName;

    @ApiModelProperty(position = 3)
    private String email;

    @ApiModelProperty(position = 4, dataType = "array")
    private char[] password;

    @ApiModelProperty(position = 5, dataType = "array")
    private char[] confirmPassword;
}
