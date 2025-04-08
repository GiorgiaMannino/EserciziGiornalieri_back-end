package it.epicode.Pratica_S5_L2.menu;

import it.epicode.Pratica_S5_L2.bevande.Bevanda;
import it.epicode.Pratica_S5_L2.pizze.Pizza;
import it.epicode.Pratica_S5_L2.toppings.Topping;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class MenuConfig {

    private final Topping funghi;
    private final Topping peperoni;
    private final Topping olive;
    private final Topping mozzarella;
    private final Topping prosciutto;
    private final Topping salame;
    private final Topping pomodoro;

    private final Pizza margherita;
    private final Pizza pizzaPeperoni;
    private final Pizza pizzaSalame;
    private final Pizza pizzaProsciuttoEFunghi;

    private final Bevanda cocaCola;
    private final Bevanda fanta;
    private final Bevanda sprite;

    @Bean
    public Menu menuPranzo() {
        return new Menu(
                "Menu Pranzo",
                "Menu del pranzo",
                List.of(margherita, pizzaPeperoni, pizzaSalame, pizzaProsciuttoEFunghi),
                List.of(cocaCola, fanta, sprite),
                List.of(funghi, peperoni, olive, mozzarella, prosciutto, salame, pomodoro)
        );
    }
}
