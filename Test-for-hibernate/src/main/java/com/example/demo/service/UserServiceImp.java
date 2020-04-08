package com.example.demo.service;


import com.example.demo.models.Role;
import com.example.demo.models.Individuu;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;

@Service
@Transactional
public class UserServiceImp implements UserService {

    @Autowired
    PasswordEncoder encoder;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public void saveUser(Individuu user) {
        user.setMotDePasseAccount(encoder.encode(user.getMotDePasseAccount()));
        user.setStatus("VERIFIED");
        Role userRole = roleRepository.findByRole("simpleUser");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

    @Override
    public boolean isUserAlreadyPresent(Individuu user) {
        boolean isUserAlreadyExists = false;
        Individuu existingUser = userRepository.findByEmail(user.getEmail());
        // verifier si l'user existe dans la base de données
        if (existingUser != null) {
            isUserAlreadyExists = true;
        }
        return isUserAlreadyExists;
    }

}
