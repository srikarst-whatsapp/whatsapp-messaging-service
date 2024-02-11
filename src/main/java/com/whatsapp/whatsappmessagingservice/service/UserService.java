package com.whatsapp.whatsappmessagingservice.service;

import com.whatsapp.whatsappmessagingservice.entity.User;

public interface UserService {
    User getUser(Long id);

    User getUser(String username);

    User saveUser(User user);
}