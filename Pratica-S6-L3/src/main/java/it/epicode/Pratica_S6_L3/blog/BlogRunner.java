package it.epicode.Pratica_S6_L3.blog;

import com.github.javafaker.Faker;
import it.epicode.Pratica_S6_L3.autori.Autore;
import it.epicode.Pratica_S6_L3.autori.AutoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Order(2)
public class BlogRunner implements CommandLineRunner {

    @Autowired
    private Faker faker;

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private AutoreRepository autoreRepository;

    @Override
    public void run(String... args) throws Exception {

        // Prendiamo gli autori già presenti
        List<Autore> autori = autoreRepository.findAll();

        // Creiamo 10 blog associati ad autori esistenti
        for (int i = 0; i < 10; i++) {
            Blog blog = new Blog();
            blog.setCategoria(faker.book().genre());
            blog.setTitolo(faker.book().title());
            blog.setCover(faker.internet().avatar());
            blog.setContenuto(faker.lorem().sentence());
            blog.setTempoDiLettura(faker.number().numberBetween(1, 10));

            // Assegna un autore ciclicamente
            blog.setAutore(autori.get(i % autori.size()));

            blogRepository.save(blog);
        }
    }
}
