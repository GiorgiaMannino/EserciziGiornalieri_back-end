package it.epicode.Pratica_S5_L1.config;

import it.epicode.Pratica_S5_L1.classi.Topping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ToppingConfig {

    @Bean
    public Topping Hawaiian() {
        Topping topping = new Topping();
        topping.setName("Hawaiian");
        topping.setDescription("Prosciutto e ananas");
        return new Topping();
    }


    @Bean
    public Topping Peperoncino() {
        Topping topping = new Topping();
        topping.setName("Peperoncino");
        topping.setDescription("Peperoncino");
        return new Topping();
    }


    @Bean
        public Topping DoppioProsciutto() {
        Topping topping = new Topping();
        topping.setName("Doppio Prosciutto");
        topping.setDescription("Doppio Prosciutto");
        return new Topping();
    }


}
