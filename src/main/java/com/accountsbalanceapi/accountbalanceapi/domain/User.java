package com.accountsbalanceapi.accountbalanceapi.domain;


import lombok.Builder;
import lombok.Data;

import java.math.BigInteger;

@Builder
@Data
public class User {
    private String username;
    private String email;
    private BigInteger accountBalance;
}
