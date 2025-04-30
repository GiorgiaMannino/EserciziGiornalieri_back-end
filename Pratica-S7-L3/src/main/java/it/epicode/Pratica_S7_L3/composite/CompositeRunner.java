package it.epicode.Pratica_S7_L3.composite;

import it.epicode.Pratica_S7_L3.composite.Libri.Libro;
import it.epicode.Pratica_S7_L3.composite.Libri.Pagina;
import it.epicode.Pratica_S7_L3.composite.Libri.Sezione;
import it.epicode.Pratica_S7_L3.composite.autori.Autore;

import java.util.ArrayList;

public class CompositeRunner {
    public static void main(String[] args) {

        Autore autore1 = new Autore("Erich", "Gamma");
        Autore autore2 = new Autore("Richard", "Helm");

        Libro libro = new Libro("Design Patterns", 39.99);
        libro.aggiungiAutore(autore1);
        libro.aggiungiAutore(autore2);

        // Creo pagine semplici
        Pagina prefazione = new Pagina("Prefazione");
        Pagina introduzione = new Pagina("Introduzione");

        // 4. Crea una sezione con pagine
        Sezione capitolo1 = new Sezione("Capitolo 1", new ArrayList<>());
        capitolo1.aggiungiElemento(new Pagina("Contenuto 1.1"));
        capitolo1.aggiungiElemento(new Pagina("Contenuto 1.2"));

        // 5. Crea sottosezione
        Sezione sottosezione = new Sezione("Capitolo 1.1", new ArrayList<>());
        sottosezione.aggiungiElemento(new Pagina("Dettaglio 1.1.1"));
        sottosezione.aggiungiElemento(new Pagina("Dettaglio 1.1.2"));

        // 6. Aggiunge la sottosezione alla sezione principale
        capitolo1.aggiungiElemento(sottosezione);

        // 7. Aggiunge contenuti al libro
        libro.aggiungiContenuto(prefazione);
        libro.aggiungiContenuto(introduzione);
        libro.aggiungiContenuto(capitolo1);

        // 8. Stampa il libro e il totale pagine
        libro.stampa();
        System.out.println("Numero totale di pagine: " + libro.getNumeroTotalePagine());
        System.out.println("--------------------------------------------");
    }
}
