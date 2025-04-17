package it.epicode.Pratica_S6_L4.autori;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;

@Component
@Order (1)
public class AutoreRunner implements CommandLineRunner {

    @Autowired
    private Faker faker;

    @Autowired
    private AutoreRepository autoreRepository;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 10; i++) {
            Autore autore = new Autore();
            autore.setNome(faker.name().firstName());
            autore.setCognome(faker.name().lastName());
            autore.setEmail(faker.internet().emailAddress());
            LocalDate dataDiNascita = faker.date().birthday().toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
            autore.setAvatar(faker.internet().avatar());

            autoreRepository.save(autore);
        }


    }

}
