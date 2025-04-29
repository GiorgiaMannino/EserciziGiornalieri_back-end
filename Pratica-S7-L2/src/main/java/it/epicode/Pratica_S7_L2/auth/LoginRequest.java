package it.epicode.Pratica_S7_L2.auth;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
