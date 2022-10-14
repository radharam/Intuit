package com.java.intuit.user.userauthentication.dao;

import com.java.intuit.user.userauthentication.dto.UserDTO;
import com.java.intuit.user.userauthentication.models.IntuitUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
//public interface IUserAuthDAO extends JpaRepository<IntuitUser, String> {
public interface IUserAuthDAO extends CrudRepository<IntuitUser, Integer> {

    Optional<IntuitUser> findIntuitUserByEmail(String email);
    @Transactional
    Optional<IntuitUser> deleteIntuitUserByEmail(String email);

    //@Query(select u from IntuitUser where u.firstname = ?1)
    Optional<IntuitUser> findIntuitUserByFirstName(String firstName);

    Optional<IntuitUser> findIntuitUserByEmailAndPassword(String email, char[] password);

}
