package it.epicode.Pratica_S5_L4.toppings;


import it.epicode.Pratica_S5_L4.menu.ElementoMenu;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Topping extends ElementoMenu {

    public Topping(String nome, String descrizione, double prezzo, int calorie) {
        setNome(nome);
        setDescrizione(descrizione);
        setPrezzo(prezzo);
        setCalorie(calorie);
    }

    public String descrizione() {
        return getNome() + " - " + getDescrizione() + " - " + getPrezzo() + "€" + " - " + getCalorie() + " kcal";
    }


}
