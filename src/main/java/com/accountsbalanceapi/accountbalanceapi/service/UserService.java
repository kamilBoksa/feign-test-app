package com.accountsbalanceapi.accountbalanceapi.service;

import com.accountsbalanceapi.accountbalanceapi.client.UserFeignClient;
import com.accountsbalanceapi.accountbalanceapi.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserFeignClient userFeignClient;

    public UserService(UserFeignClient userFeignClient) {
        this.userFeignClient = userFeignClient;
    }

    public List<User> getUsers() {
        return this.userFeignClient.getUsers();
    }
}
