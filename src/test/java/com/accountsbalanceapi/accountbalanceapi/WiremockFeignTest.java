package com.accountsbalanceapi.accountbalanceapi;

import com.accountsbalanceapi.accountbalanceapi.domain.User;
import com.accountsbalanceapi.accountbalanceapi.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = RANDOM_PORT, classes = FeignContextConfiguration.class)
@AutoConfigureWireMock(port = 0)
public class WiremockFeignTest {

    private static ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private UserService userService;

    @Test
    public void getUsersTest() throws Exception {
        String expected = mapper.writeValueAsString(getUsers());

        stubFor(get(urlEqualTo("/users")).willReturn(aResponse()
                .withHeader("Content-Type", "application/json")
                .withBody(expected)));

        String actual = mapper.writeValueAsString(userService.getUsers());
        assertEquals(expected, actual);
    }

    private List<User> getUsers() {
        List<User> users = new ArrayList<>();
        User user1 = User.builder()
                .email("test1@mail.com")
                .username("Mike")
                .accountBalance(BigInteger.valueOf(39))
                .build();

        User user2 = User.builder()
                .email("roger@mail.com")
                .username("Roger")
                .accountBalance(BigInteger.valueOf(23))
                .build();

        users.add(user1);
        users.add(user2);
        return users;
    }
}

