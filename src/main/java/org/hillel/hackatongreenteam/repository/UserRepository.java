package org.hillel.hackatongreenteam.repository;

import org.hillel.hackatongreenteam.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by User on 23.02.2019.
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);

}
