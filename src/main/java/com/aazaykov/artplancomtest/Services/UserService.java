package com.aazaykov.artplancomtest.Services;

import com.aazaykov.artplancomtest.Entities.User;
import com.aazaykov.artplancomtest.Exceptions.LoginIsNotVacantException;
import com.aazaykov.artplancomtest.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserService implements UserServiceInt{

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createNewUser(User user, HttpServletRequest request) {
        if (!isLoginVacant(user.getUsername())){
            throw new LoginIsNotVacantException("Пользователь с логином " + user.getUsername() + " уже зарегистрирован!");
        }
        userRepository.save(user);
        request.getSession().setAttribute("Login", true);
        request.getSession().setAttribute("User", user);
    }

    @Override
    public String validateLogin(String login) {
        if (isLoginVacant(login)){
            return "Указанный логин свободен!";
        }else throw new LoginIsNotVacantException("");
    }

    @Override
    public boolean isLoginVacant(String userName) {
        return userRepository.findByUsername(userName) == null;
    }
}