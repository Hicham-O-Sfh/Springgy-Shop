package com.example.demo.service;

import com.example.demo.models.Individuu;

public interface UserService {

    public void saveUser(Individuu user);

    public boolean isUserAlreadyPresent(Individuu user);
}
