package ru.mattakvshi.SpringBoot.PostgreSQL.RedisCach.dto.auth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RefreshJwtRequest {

    public String refreshToken;

}