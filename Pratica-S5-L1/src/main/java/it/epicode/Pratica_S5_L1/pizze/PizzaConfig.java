package it.epicode.Pratica_S5_L1.pizze;

import it.epicode.Pratica_S5_L1.toppings.Topping;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class PizzaConfig {

    private final Topping funghi;
    private final Topping peperoni;
    private final Topping olive;
    private final Topping mozzarella;
    private final Topping prosciutto;
    private final Topping salame;
    private final Topping pomodoro;


    @Bean
    public Pizza margherita() {
        return new Pizza("Margherita", "Pomodoro, mozzarella, basilico", 5.00, 800, List.of(pomodoro, mozzarella));
    }

    @Bean
    public Pizza pizzaPeperoni() {
        return new Pizza("Pizza Peperoni", "Pomodoro, mozzarella, peperoni", 6.50, 900, List.of(pomodoro, mozzarella, peperoni));
    }

    @Bean
    public Pizza pizzaSalame() {
        return new Pizza("Pizza Salame", "Pomodoro, mozzarella, salame", 6.50, 900, List.of(pomodoro, mozzarella, salame));
    }

    @Bean
    public Pizza pizzaProsciuttoEFunghi() {
        return new Pizza("Pizza Prosciutto e Funghi", "Pomodoro, mozzarella, prosciutto, funghi", 7.00, 950, List.of(pomodoro, mozzarella, prosciutto, funghi));
    }





}
