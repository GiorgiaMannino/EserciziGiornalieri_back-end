package it.epicode.Esercizio3.classi;

import it.epicode.Esercizio3.exceptions.BancaException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Istanzio il ContoCorrente e ContoOnLine
        ContoCorrente conto = new ContoCorrente("Giorgia", 2000);
        ContoOnLine conto1 = new ContoOnLine("Giorgia", 2000, 1000);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Saldo disponibile Conto Corrente: " + conto.restituisciSaldo());
        System.out.println("Saldo disponibile Conto OnLine: " + conto1.restituisciSaldo());

        // Ciclo per chiedere prelievi
        while (true) {
            System.out.println("Inserisci importo da prelevare (o digita 'esci' per uscire): ");
            String input = scanner.nextLine();  // Legge l'input come stringa

            if (input.equalsIgnoreCase("esci")) {
                System.out.println("Uscita dal programma.");
                break;
            }

            try {
                double importo = Double.parseDouble(input);

                conto1.preleva(importo);  // Prova a prelevare dal ContoOnLine
                System.out.println("Saldo dopo il prelievo: " + conto1.restituisciSaldo());
            } catch (NumberFormatException e) {
                System.out.println("Per favore, inserisci un valore numerico valido o digita 'esci' per uscire.");
            } catch (BancaException e) {
                System.out.println("Errore: " + e.getMessage());  // Gestisce l'eccezione "conto in rosso"
            }
        }

        scanner.close();
    }
}
