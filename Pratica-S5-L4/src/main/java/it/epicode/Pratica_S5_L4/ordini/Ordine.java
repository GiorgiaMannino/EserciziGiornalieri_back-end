package it.epicode.Pratica_S5_L4.ordini;

import it.epicode.Pratica_S5_L4.menu.ElementoMenu;
import it.epicode.Pratica_S5_L4.tavoli.Tavolo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ordini")
public class Ordine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int coperti;
    @ManyToOne
    private Tavolo tavolo;

    @OneToMany
    private List<ElementoMenu> elementi = new ArrayList<>();

    public double calcolaTotale() {
        double totale = 0;
        for (ElementoMenu em : elementi) {
            totale += em.getPrezzo();
        }
        return totale;
    }

    // Stampa l’ordine: tavolo, coperti, lista degli elementi e totale
    public void stampaOrdine() {
        System.out.println("Tavolo: " + tavolo.getNumeroTavolo());
        System.out.println("Coperti: " + coperti);
        System.out.println("Elementi Ordinati:");
        for (ElementoMenu em : elementi) {
            System.out.println(em.descrizione());
        }
        System.out.println("Totale Ordine: " + calcolaTotale());
    }
}