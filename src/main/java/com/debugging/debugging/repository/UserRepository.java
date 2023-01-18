package com.debugging.debugging.repository;

import com.debugging.debugging.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final EntityManager em;

    public List<User> findAll() {
        List<User> userList = null;

        userList = em.createQuery("select u from User u", User.class).getResultList();

        return userList;
    }

}
