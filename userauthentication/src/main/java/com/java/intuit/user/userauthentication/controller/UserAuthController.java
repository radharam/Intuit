package com.java.intuit.user.userauthentication.controller;

import com.java.intuit.user.userauthentication.dto.UserDTO;
import com.java.intuit.user.userauthentication.exception.InvalidPasswordException;
import com.java.intuit.user.userauthentication.exception.UserNotFound;
import com.java.intuit.user.userauthentication.models.IntuitUser;
import com.java.intuit.user.userauthentication.service.IUserAuthService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/user")
@AllArgsConstructor
public class UserAuthController {

   // private final IUserAuthService userAuthService;
    private final IUserAuthService userAuthService;


    @PostMapping(path = "register-user")
    public String registerUser(@RequestBody UserDTO request) throws InvalidPasswordException {
        System.out.println(request);
        return userAuthService.registerUser(request) ? "User Added Successfully" : "User with this email exists";
    }
    /*
    @PostMapping(path = "register-user")
    public IntuitUsers registerUser(@RequestBody IntuitUsers user) {
        System.out.printf("%s", user.getEmail());
        return user;
    } */


    @GetMapping(path = "fetchUser")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description  = "Not found - The product was not found")
    })
    public IntuitUser fetchUser(@RequestParam("email") String email) throws UserNotFound {
        System.out.printf("email: %s\t", email);
        return userAuthService.fetchUser(email);
    }

    @PutMapping(path = "update-user")
    public IntuitUser updateUser(@RequestBody UserDTO request) {
        System.out.println(request);
        return userAuthService.saveOrUpdate(request);
    }

    @DeleteMapping(path = "deleteUser")
    public IntuitUser deleteUser(@RequestParam("email") String email) throws UserNotFound {
        return userAuthService.deleteUser(email);
    }

}