package org.hillel.hackatongreenteam.controller;

import org.hillel.hackatongreenteam.controller.RestResponse;
import org.hillel.hackatongreenteam.controller.dto.UserLoginInfo;
import org.hillel.hackatongreenteam.model.User;
import org.hillel.hackatongreenteam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class SecurityController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    @PostMapping(value = "/login")
    public RestResponse login(@RequestBody UserLoginInfo loginInfo){

        if ((loginInfo.getEmail() == null) || (loginInfo.getEmail().isEmpty())){
            return new RestResponse(400, "Email is empty");
        }

        if ((loginInfo.getPassword() == null) || (loginInfo.getPassword().isEmpty())){
            return new RestResponse(400, "Password is empty");
        }

        User user = userService.findUserByUsername(loginInfo.getEmail());
        if(user == null){
            return new RestResponse(404, String.format("User %s not found", loginInfo.getEmail()));
        }

        if (!userService.checkPassword(user, loginInfo.getPassword())) {
            return new RestResponse(400, "Password is incorrect");
        }

        return new RestResponse(200, "User logged in successfully");
    }

    @PostMapping(value = "/register")
    public RestResponse register(@RequestBody User user){

        if (user == null){
            return new RestResponse(400, "Incorrect user data structure");
        }

        if ((user.getEmail() == null) || (user.getEmail().isEmpty())){
            return new RestResponse(400, "Email is empty");
        }

        if ((user.getName() == null) || (user.getName().isEmpty())){
            return new RestResponse(400, "Name is empty");
        }

        if ((user.getPassword() == null) || (user.getPassword().isEmpty())){
            return new RestResponse(400, "Password is empty");
        }

        if(userService.findUserByUsername(user.getEmail()) != null){
            return new RestResponse(400, String.format("User %s already exists", user.getEmail()));
        }

        return new RestResponse(201, "User registered successfully", userService.save(user));
    }

}
