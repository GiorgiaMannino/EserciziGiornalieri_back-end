package it.epicode.Pratica_S5_L4.bevande;

import it.epicode.Pratica_S5_L4.menu.ElementoMenu;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bevanda extends ElementoMenu {

    public Bevanda( String nome, String descrizione, double prezzo, int calorie) {
        setNome(nome);
        setDescrizione(descrizione);
        setPrezzo(prezzo);
        setCalorie(calorie);

    }



}
