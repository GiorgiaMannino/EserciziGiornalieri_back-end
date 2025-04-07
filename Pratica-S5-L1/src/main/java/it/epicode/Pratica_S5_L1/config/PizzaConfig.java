package it.epicode.Pratica_S5_L1.config;

import it.epicode.Pratica_S5_L1.classi.Pizza;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PizzaConfig {

    @Bean
    public Pizza pizzaMargherita() {
        Pizza pizza = new Pizza();
        pizza.setName("Margherita");
        pizza.setDescription("Pizza di pomodoro e mozzarella");
        pizza.setPrice(9.99);


        return new Pizza();
    }

    @Bean
    public Pizza pizzaDiavola() {
        Pizza pizza = new Pizza();
        pizza.setName("Diavola");
        pizza.setDescription("Pizza di pomodoro, mozzarella e peperoncino");
        pizza.setPrice(12.99);

        return new Pizza();
    }

    @Bean
    public Pizza pizzaNapoletana() {
        Pizza pizza = new Pizza();
        pizza.setName("Napoletana");
        pizza.setDescription("Pizza di pomodoro, mozzarella e funghi");
        pizza.setPrice(11.99);

        return new Pizza();


}
