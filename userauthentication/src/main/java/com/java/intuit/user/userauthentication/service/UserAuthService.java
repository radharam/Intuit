package com.java.intuit.user.userauthentication.service;

import com.java.intuit.user.userauthentication.dao.IUserAuthDAO;
import com.java.intuit.user.userauthentication.dto.UserDTO;
import com.java.intuit.user.userauthentication.exception.InvalidPasswordException;
import com.java.intuit.user.userauthentication.exception.UserNotFound;
import com.java.intuit.user.userauthentication.models.IntuitUser;
import com.java.intuit.user.userauthentication.models.enums.UserType;
import com.java.intuit.user.userauthentication.util.PasswordUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Objects;

@Service
@AllArgsConstructor
public class UserAuthService implements IUserAuthService{

    private final IUserAuthDAO userAuthRepository;

    private final PasswordUtil passwordUtil;
    public boolean registerUser(UserDTO data) throws InvalidPasswordException {
        // return false if user found else false
        if(checkUserExists(data.getEmail())) return false;

        String salt = passwordUtil.getSalt();
        String hash = passwordUtil.getHash(data.getPassword(), salt);

        boolean passwordsMatch = Arrays.equals(data.getPassword(), data.getConfirmPassword());
        if(!passwordsMatch) throw new InvalidPasswordException("Passwords do not match");

        IntuitUser user = IntuitUser.builder()
                .firstName(data.getFirstName())
                .lastName(data.getLastName())
                .password(data.getPassword())
                .userType(UserType.CLIENT)
                .salt(salt)
                .hash(hash)
                .email(data.getEmail())
                .build();

        userAuthRepository.save(user);
        return true;
    }

    @Override
    public IntuitUser fetchUser(String email) throws UserNotFound {

        IntuitUser user = userAuthRepository.findIntuitUserByEmail(email).get();
            if(Objects.isNull(user)) throw new UserNotFound("User Not found");

        return user;
    }

    public boolean checkUserExists(String email) {
        // return false if no user found else true
        return !userAuthRepository.findIntuitUserByEmail(email).isEmpty();
    }

    @Override
    public IntuitUser deleteUser(String email) throws UserNotFound {

        IntuitUser user = userAuthRepository.findIntuitUserByEmail(email).get();
        if(Objects.isNull(user)) throw new UserNotFound("User Not found");
        userAuthRepository.deleteIntuitUserByEmail(email);
        return user;
    }

    @Override
    public IntuitUser saveOrUpdate(UserDTO data) {
        IntuitUser user = IntuitUser.builder()
                .firstName(data.getFirstName())
                .lastName(data.getLastName())
                .password(data.getPassword())
                .userType(UserType.CLIENT)
                .email(data.getEmail())
                .build();
        return userAuthRepository.save(user);
    }


}

