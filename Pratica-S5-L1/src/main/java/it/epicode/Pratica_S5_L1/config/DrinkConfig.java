package it.epicode.Pratica_S5_L1.config;

import it.epicode.Pratica_S5_L1.classi.Drink;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DrinkConfig {

    @Bean
    public Drink cocaCola() {
        Drink drink = new Drink();
        drink.setName("Coca Cola");
        drink.setDescription("Beverage");
        drink.setPrice(1.99);

        return new Drink();
    }

    @Bean
    public Drink fanta() {
        Drink drink = new Drink();
        drink.setName("Fanta");
        drink.setDescription("Beverage");
        drink.setPrice(1.99);

        return new Drink();
    }

    @Bean
    public Drink sprite() {
        Drink drink = new Drink();
        drink.setName("Sprite");
        drink.setDescription("Beverage");
        drink.setPrice(1.99);

        return new Drink();
    }
}
