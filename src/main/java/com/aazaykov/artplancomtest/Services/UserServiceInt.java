package com.aazaykov.artplancomtest.Services;

import com.aazaykov.artplancomtest.Entities.User;

import javax.servlet.http.HttpServletRequest;

public interface UserServiceInt{
    void createNewUser(User user, HttpServletRequest request);
    String validateLogin(String login);

    boolean isLoginVacant(String login);

}
