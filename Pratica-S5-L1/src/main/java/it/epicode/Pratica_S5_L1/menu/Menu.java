package it.epicode.Pratica_S5_L1.menu;


import it.epicode.Pratica_S5_L1.bevande.Bevanda;
import it.epicode.Pratica_S5_L1.pizze.Pizza;
import it.epicode.Pratica_S5_L1.toppings.Topping;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu {

    private String nome;
    private String descrizione;

    private List <Pizza> pizze = new ArrayList<>();
   private List <Bevanda> bevande = new ArrayList<>();
    private List <Topping> toppings = new ArrayList<>();

    public void stampaMenu() {
        System.out.println("-- Menu " + nome + " --");
        System.out.println("--- pizze ---");
        for (Pizza pizza : pizze) {
            System.out.println(pizza.descrizioneRiga());
        }

        System.out.println("--- bevande ---");
        for (Bevanda bevanda : bevande) {
            System.out.println(bevanda.descrizioneRiga());
        }

        System.out.println("--- toppings ---");
        for (Topping topping : toppings) {
            System.out.println(topping.descrizioneRiga());
        }

    }

}
