package it.epicode.Pratica_S5_L1.bevande;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BevandaConfig {

    @Bean
    public Bevanda cocaCola() {
        return new Bevanda("Coca Cola", "Bibita gassata", 2.50, 140);
    }

    @Bean
    public Bevanda fanta() {
        return new Bevanda("Fanta", "Bibita gassata", 2.50, 160);
    }

    @Bean
    public Bevanda sprite() {
        return new Bevanda("Sprite", "Bibita gassata", 2.50, 140);
    }

}
