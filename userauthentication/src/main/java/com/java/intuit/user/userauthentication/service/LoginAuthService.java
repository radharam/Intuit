package com.java.intuit.user.userauthentication.service;

import com.java.intuit.user.userauthentication.dao.IUserAuthDAO;
import com.java.intuit.user.userauthentication.models.IntuitUser;
import com.java.intuit.user.userauthentication.models.LoginUser;
import com.java.intuit.user.userauthentication.models.Session;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Locale;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LoginAuthService implements ILoginAuthService{

    private final IUserAuthDAO userAuthRepository;

    public IntuitUser loginUser(LoginUser user) {
        Optional<IntuitUser> loggedinuser = userAuthRepository.findIntuitUserByEmailAndPassword(user.getEmail(), user.getPassword());
        Calendar cal = Calendar.getInstance();
        user.setToken(user.getEmail().toUpperCase()
                + "|" + "userid" + "|"
                + cal.getTimeInMillis());
        Session.getInstance().map.put(user.getEmail(), user.getToken());
        return loggedinuser.isEmpty() ? null : loggedinuser.get();
    }


}

