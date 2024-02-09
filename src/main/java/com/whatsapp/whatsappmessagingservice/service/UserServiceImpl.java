package com.whatsapp.whatsappmessagingservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.whatsapp.whatsappmessagingservice.entity.User;
import com.whatsapp.whatsappmessagingservice.exception.UserNotFoundException;
import com.whatsapp.whatsappmessagingservice.repository.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @SuppressWarnings("null")
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @SuppressWarnings("null")
    @Override
    public User getUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        User unwrappedUser = UserServiceImpl.unwrapUser(user, id);
        return unwrappedUser;
    }

    @Override
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

    static User unwrapUser(Optional<User> entity, Long id) {
        if (entity.isPresent())
            return entity.get();
        else
            throw new UserNotFoundException(id);
    }
}
