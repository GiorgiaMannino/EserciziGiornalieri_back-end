package it.epicode.Pratica_S5_L1.toppings;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ToppingConfig {

    @Bean
    public Topping funghi() {
        return new Topping("Funghi", "Funghi freschi", 1.50, 50);
    }

    @Bean
    public Topping peperoni() {
        return new Topping("Peperoni", "Peperoni piccanti", 1.50, 100);
    }

    @Bean
    public Topping olive() {
        return new Topping("Olive", "Olive nere", 1.50, 30);
    }

    @Bean
    public Topping mozzarella() {
        return new Topping("Mozzarella", "Mozzarella fresca", 1.50, 80);
    }

    @Bean
    public Topping prosciutto() {
        return new Topping("Prosciutto", "Prosciutto crudo", 1.50, 120);
    }

    @Bean
    public Topping salame() {
        return new Topping("Salame", "Salame piccante", 1.50, 100);
    }

    @Bean
    public Topping pomodoro() {
        return new Topping("Pomodoro", "Pomodoro fresco", 1.50, 20);
    }

}
