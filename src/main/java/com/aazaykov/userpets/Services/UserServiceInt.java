package com.aazaykov.userpets.Services;

import com.aazaykov.userpets.Entities.User;

import javax.servlet.http.HttpServletRequest;

public interface UserServiceInt{
    void createNewUser(User user, HttpServletRequest request);
    String validateLogin(String login);

    boolean isLoginVacant(String login);

}
