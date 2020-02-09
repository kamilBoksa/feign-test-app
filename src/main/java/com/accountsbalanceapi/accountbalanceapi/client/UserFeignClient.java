package com.accountsbalanceapi.accountbalanceapi.client;

import com.accountsbalanceapi.accountbalanceapi.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@FeignClient(name="userFeignClient")
public interface UserFeignClient {

    @RequestMapping(method = GET, value = "/users")
    List<User> getUsers();
}
