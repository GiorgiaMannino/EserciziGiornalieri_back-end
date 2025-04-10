package it.epicode.Pratica_S5_L4.menu;


import it.epicode.Pratica_S5_L4.bevande.Bevanda;
import it.epicode.Pratica_S5_L4.pizze.Pizza;
import it.epicode.Pratica_S5_L4.toppings.Topping;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descrizione;

    @OneToMany
    private Set<ElementoMenu> elementi = new HashSet<>();
}