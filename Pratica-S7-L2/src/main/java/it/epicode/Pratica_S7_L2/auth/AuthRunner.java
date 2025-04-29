package it.epicode.Pratica_S7_L2.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;

@Component
public class AuthRunner implements ApplicationRunner {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Creazione dell'utente admin se non esiste
        Optional<AppUser> adminUser = appUserService.findByUsername("admin");
        if (adminUser.isEmpty()) {

            RegisterRequest registerRequest = new RegisterRequest();
            registerRequest.setUsername("admin");
            registerRequest.setPassword("adminpwd");
            registerRequest.setNome("Admin");
            registerRequest.setCognome("Admin");
            registerRequest.setEmail("admin@example.com");
            appUserService.registerUser(registerRequest, Set.of(Role.ROLE_ADMIN));
        }

        // Creazione dell'utente user se non esiste
        Optional<AppUser> normalUser = appUserService.findByUsername("user");
        if (normalUser.isEmpty()) {
            RegisterRequest registerRequest = new RegisterRequest();
            registerRequest.setUsername("user");
            registerRequest.setPassword("userpwd");
            registerRequest.setNome("User");
            registerRequest.setCognome("User");
            registerRequest.setEmail("user@example.com");

            appUserService.registerUser(registerRequest, Set.of(Role.ROLE_USER));
        }

    }
}
