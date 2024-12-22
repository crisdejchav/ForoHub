package dev.crisdejchav.ForoHub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import dev.crisdejchav.ForoHub.dto.User.UserDTO;
import dev.crisdejchav.ForoHub.model.User;
import dev.crisdejchav.ForoHub.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User registerUser(UserDTO user) {
        //Creates user instance with dto data
        User newUser = new User();
        newUser.setName(user.name());
        newUser.setEmail(user.email());
        newUser.setPassword(bCryptPasswordEncoder.encode(user.password()));
        return userRepository.save(newUser);
        
    }
    
}
