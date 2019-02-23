package org.hillel.hackatongreenteam.service;


import org.hillel.hackatongreenteam.model.User;

import java.util.List;

public interface UserService {

    User create(User user);

    User read(int id);

    List<User> readAll();

    User update(User user);

    void delete(int id);
}
