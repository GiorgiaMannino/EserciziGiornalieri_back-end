package it.epicode.Pratica_S7_L2.auth;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
}
