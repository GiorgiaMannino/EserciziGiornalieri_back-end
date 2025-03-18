package it.epicode.Esercizio3;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        // creazione della rubrica
        Map<String, Contatti> rubrica = new HashMap<>();

        rubrica.put("Giorgia", new Contatti("Giorgia", "123456789"));
        rubrica.put("Vincenzo", new Contatti("Vincenzo", "987654321"));
        rubrica.put("Maria", new Contatti("Maria", "555123456"));
        rubrica.put("Giuseppe", new Contatti("Giuseppe", "836408765"));
        rubrica.put("Giovanni", new Contatti("Giovanni", "017410789"));

        System.out.println("Rubrica iniziale:");
        stampaRubrica(rubrica);

        // cancellazione del contatto "Maria"
        rubrica.remove("Maria");
        System.out.println("\nRubrica dopo la cancellazione di Maria:");
        stampaRubrica(rubrica);

        // ricerca di una persona per numero di telefono
        String nomeRicerca = ricercaPerNumero(rubrica, "123456789");
        System.out.println("\nLa persona con il numero 123456789 è: " + nomeRicerca);

        // ricerca del numero di telefono di una persona
        String numeroRicerca = ricercaPerNome(rubrica, "Vincenzo");
        System.out.println("\nIl numero di Vincenzo è: " + numeroRicerca);
    }

    // metodo per cercare una persona in base al numero
    public static String ricercaPerNumero(Map<String, Contatti> rubrica, String numero) {
        for (Contatti contatto : rubrica.values()) {
            if (contatto.getNumero().equals(numero)) {
                return contatto.getNome();
            }
        }
        return "Numero non trovato";
    }

    // metodo per cercare il numero in base al nome
    public static String ricercaPerNome(Map<String, Contatti> rubrica, String nome) {
        Contatti contatto = rubrica.get(nome);
        if (contatto != null) {
            return contatto.getNumero();
        }
        return "Nome non trovato";
    }

    // metodo per stampare tutti i contatti
    public static void stampaRubrica(Map<String, Contatti> rubrica) {
        for (Contatti contatto : rubrica.values()) {
            System.out.println(contatto);
        }
    }
}
