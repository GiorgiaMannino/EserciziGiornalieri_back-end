package it.epicode.Pratica_S7_L1.auth;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
}
