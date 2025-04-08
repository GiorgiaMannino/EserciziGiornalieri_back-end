package it.epicode.Pratica_S5_L2.ordini;

import it.epicode.Pratica_S5_L2.menu.RigaMenu;
import it.epicode.Pratica_S5_L2.tavoli.Tavolo;
import lombok.Data;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class Ordine {

    private int numeroOrdine;
    private StatoOrdine statoOrdine;
    private int coperti;
    private LocalTime oraOrdine;
    private List<RigaMenu> elementi = new ArrayList<>();

    private Tavolo tavolo;

    public double calcolaPrezzo(double prezzoUnitarioCoperto) {
        double prezzoTotale = 0;
        for (RigaMenu rigaMenu : elementi) {
            prezzoTotale += rigaMenu.prezzoTotale();
        }

        prezzoTotale += prezzoUnitarioCoperto * coperti;
        return prezzoTotale;
    }

    public void stampaOrdine (double prezzoUnitarioCoperto) {
        System.out.println("Numero ordine: " + numeroOrdine);
        System.out.println("Stato ordine: " + statoOrdine);
        System.out.println("Coperti: " + coperti);
        System.out.println("Ora ordine: " + oraOrdine);
        System.out.println("Tavolo: " + tavolo.getNumeroTavolo());
        System.out.println("---Elementi ordinati---");
        for (RigaMenu rigaMenu : elementi) {
            System.out.println(rigaMenu.descrizioneRiga());
        }
        System.out.println("-------");
        System.out.println("Prezzo totale: " + calcolaPrezzo(prezzoUnitarioCoperto));
    }

}
