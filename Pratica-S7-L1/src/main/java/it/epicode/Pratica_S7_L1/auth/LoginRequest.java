package it.epicode.Pratica_S7_L1.auth;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
