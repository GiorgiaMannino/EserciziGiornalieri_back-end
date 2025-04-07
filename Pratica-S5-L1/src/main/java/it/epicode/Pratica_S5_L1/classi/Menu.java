package it.epicode.Pratica_S5_L1.classi;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table ( name = "menu" )
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu {


    private Pizza pizza;

    private Drink drink;

    private Topping topping;

}
