package com.whatsapp.whatsappmessagingservice.service;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.whatsapp.whatsappmessagingservice.entity.User;
import com.whatsapp.whatsappmessagingservice.exception.EntityNotFoundException;
import com.whatsapp.whatsappmessagingservice.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

}
