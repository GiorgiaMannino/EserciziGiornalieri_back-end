package it.epicode.Pratica_S5_L2.menu;

import it.epicode.Pratica_S5_L2.bevande.Bevanda;
import it.epicode.Pratica_S5_L2.pizze.Pizza;
import it.epicode.Pratica_S5_L2.toppings.Topping;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MenuRunner implements CommandLineRunner {

    private final Menu menuPranzo;

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

    public static void printMenu(List<RigaMenu> righe) {
        for (RigaMenu riga : righe) {
            System.out.println(riga.descrizioneRiga());
        }

    }
    @Override
    public void run(String... args) throws Exception {
        menuPranzo.stampaMenu();

        System.out.println("-----------------");
        System.out.println("stampa statica");
        System.out.println("-----------------");
        printMenu( List.of(
                new Titolo("--- Menu ---"),
                new Titolo("--- Pizze ---"),
                margherita,
                pizzaPeperoni,
                pizzaSalame,
                pizzaProsciuttoEFunghi,
                new Titolo("--- Bevande ---"),
                cocaCola,
                fanta,
                sprite,
                new Titolo("--- Toppings ---"),
                funghi,
                peperoni,
                olive,
                mozzarella,
                prosciutto,
                salame,
                pomodoro
        ));
    }
}
