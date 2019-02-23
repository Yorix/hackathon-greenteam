package org.hillel.hackatongreenteam.service;


import org.hillel.hackatongreenteam.model.User;

import java.util.List;

public interface UserService {

    User save(User user);

    User read(int id);

    List<User> readAll();

    void delete(int id);

    User getCurrentUser();

    User findUserByUsername(String username);

    boolean checkPassword(User user, String password);

}
