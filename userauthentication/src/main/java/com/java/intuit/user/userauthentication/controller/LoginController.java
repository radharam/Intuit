package com.java.intuit.user.userauthentication.controller;

import com.java.intuit.user.userauthentication.dao.IUserAuthDAO;
import com.java.intuit.user.userauthentication.exception.UserNotFound;
import com.java.intuit.user.userauthentication.models.IntuitUser;
import com.java.intuit.user.userauthentication.models.LoginUser;
import com.java.intuit.user.userauthentication.service.ILoginAuthService;
import com.java.intuit.user.userauthentication.service.IUserAuthService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping(path = "api/v1/user")
@AllArgsConstructor
public class LoginController {
    private final ILoginAuthService loginAuthService;

    @PostMapping(path = "login")
    public IntuitUser loginUser(@RequestBody LoginUser user) throws UserNotFound {
        IntuitUser loginUser = loginAuthService.loginUser(user);
        if(Objects.isNull(loginUser) ) throw new UserNotFound("Invalid emailid or password");

        return loginUser;
    }
}
