package com.whatsapp.whatsappmessagingservice.service;

import java.util.List;

import com.whatsapp.whatsappmessagingservice.entity.User;

public interface UserService {
    User saveUser(User user);

    User getUser(Long id);

    List<User> getUsers();
}
