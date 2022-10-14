package com.java.intuit.user.userauthentication.service;

import com.java.intuit.user.userauthentication.dto.UserDTO;
import com.java.intuit.user.userauthentication.exception.InvalidPasswordException;
import com.java.intuit.user.userauthentication.exception.UserNotFound;
import com.java.intuit.user.userauthentication.models.IntuitUser;
import org.springframework.stereotype.Service;

@Service
public interface IUserAuthService {

    public boolean registerUser(UserDTO data) throws InvalidPasswordException;

    public IntuitUser fetchUser(String email) throws UserNotFound;

    IntuitUser deleteUser(String email) throws UserNotFound;

    IntuitUser saveOrUpdate(UserDTO request);
}
