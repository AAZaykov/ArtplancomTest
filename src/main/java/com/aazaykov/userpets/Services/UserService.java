package com.aazaykov.userpets.Services;

import com.aazaykov.userpets.Entities.User;
import com.aazaykov.userpets.Exceptions.LoginIsNotVacantException;
import com.aazaykov.userpets.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class UserService implements UserServiceInt{

    @Autowired
    PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @Override
    public void createNewUser(User user, HttpServletRequest request) {
        if (!isLoginVacant(user.getUsername())){
            throw new LoginIsNotVacantException("Пользователь с логином " + user.getUsername() + " уже зарегистрирован!");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
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