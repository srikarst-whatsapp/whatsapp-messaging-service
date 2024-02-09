package com.whatsapp.whatsappmessagingservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.whatsapp.whatsappmessagingservice.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
}