package com.java.intuit.user.userauthentication.service;

import com.java.intuit.user.userauthentication.dto.UserDTO;
import com.java.intuit.user.userauthentication.exception.InvalidPasswordException;
import com.java.intuit.user.userauthentication.exception.UserNotFound;
import com.java.intuit.user.userauthentication.models.IntuitUser;
import com.java.intuit.user.userauthentication.models.LoginUser;
import org.springframework.stereotype.Service;

@Service
public interface ILoginAuthService {

    public IntuitUser loginUser(LoginUser user);
}
