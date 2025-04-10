package it.epicode.Pratica_S5_L4.menu;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
public abstract class ElementoMenu {

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nome;

    private String descrizione;

    private double prezzo;

    private int calorie;

    public String descrizione (){
        return getNome() + " - " + getDescrizione() + " - " + getPrezzo() + "€" + " - " + getCalorie() + " kcal";
    }
}
