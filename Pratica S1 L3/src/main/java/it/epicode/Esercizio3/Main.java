package it.epicode.Esercizio3;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        // Creo il carrello
        Carrello carrello = createCarrello();

        System.out.println("Cliente: " + carrello.getClienteAssociato().getNome() + " " + carrello.getClienteAssociato().getCognome());
        System.out.println("Articoli nel carrello:");
        for (Articolo art : carrello.getArticoli()) {
            System.out.println("- " + art.getDescrizione() + " | Prezzo: " + art.getPrezzo() + "€ | Pezzi disponibili: " + art.getPezziInMagazzino());
        }
    }

    // Creo carrello
    private static Carrello createCarrello() {
        // Creiamo gli articoli
        Articolo articolo0 = new Articolo(23719836L, "Borsa in pelle", 15.0, 3);
        Articolo articolo1 = new Articolo(34434454L, "Scarpe nere", 65.0, 10);
        Articolo articolo2 = new Articolo(86744224L, "Zaino", 44.0, 1);
        Articolo articolo3 = new Articolo(65789066L, "Borsa blu", 20.0, 6);
        Articolo articolo4 = new Articolo(14689054L, "Sandali", 10.0, 3);

        // Creo il cliente
        Cliente cliente = new Cliente(123456L, "Mario", "Rossi", "mario.rossi@example.com", LocalDate.of(2024, 3, 10));

        // Creo il carrello con gli articoli
        return new Carrello(cliente, new Articolo[]{articolo0, articolo1, articolo2, articolo3, articolo4}, 0.0);
    }
}
