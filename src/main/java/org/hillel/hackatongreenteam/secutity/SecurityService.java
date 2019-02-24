package org.hillel.hackatongreenteam.secutity;

public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);

}
