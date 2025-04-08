package it.epicode.Pratica_S5_L2.bevande;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BevandaConfig {

    @Bean
    public it.epicode.Pratica_S5_L2.bevande.Bevanda cocaCola() {
        return new it.epicode.Pratica_S5_L2.bevande.Bevanda("Coca Cola", "Bibita gassata", 2.50, 140);
    }

    @Bean
    public it.epicode.Pratica_S5_L2.bevande.Bevanda fanta() {
        return new it.epicode.Pratica_S5_L2.bevande.Bevanda("Fanta", "Bibita gassata", 2.50, 160);
    }

    @Bean
    public it.epicode.Pratica_S5_L2.bevande.Bevanda sprite() {
        return new it.epicode.Pratica_S5_L2.bevande.Bevanda("Sprite", "Bibita gassata", 2.50, 140);
    }

}
