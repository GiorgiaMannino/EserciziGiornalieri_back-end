package it.epicode.Esercizio3.classi;

import it.epicode.Esercizio3.exceptions.BancaException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Scanner;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        // Istanzio il ContoCorrente e ContoOnLine
        ContoCorrente conto = new ContoCorrente("Giorgia", 3000);
        ContoOnLine conto1 = new ContoOnLine("Giorgia", 2000, 1000);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Saldo disponibile Conto Corrente: " + conto.restituisciSaldo());
        System.out.println("Saldo disponibile Conto OnLine: " + conto1.restituisciSaldo());

        while (true) {
            System.out.println("Scegli da quale conto prelevare:");
            System.out.println("1 - Conto Corrente");
            System.out.println("2 - Conto Online");
            System.out.println("Digita 'esci' per uscire");

            String scelta = scanner.nextLine();

            if (scelta.equalsIgnoreCase("esci")) {
                System.out.println("Uscita dal programma.");
                break;
            }

            if (!scelta.equals("1") && !scelta.equals("2")) {
                System.out.println("Scelta non valida, riprova.");
                continue;
            }

            System.out.println("Inserisci importo da prelevare: ");
            String input = scanner.nextLine();

            try {
                double importo = Double.parseDouble(input);

                if (scelta.equals("1")) {
                    conto.preleva(importo);
                    System.out.println("Saldo Conto Corrente dopo il prelievo: " + conto.restituisciSaldo());
                } else {
                    conto1.preleva(importo);
                    System.out.println("Saldo Conto Online dopo il prelievo: " + conto1.restituisciSaldo());
                }

            } catch (NumberFormatException e) {
                System.out.println("Per favore, inserisci un valore numerico valido.");
                logger.error("Errore di input: valore non numerico inserito", e);
            } catch (BancaException e) {
                System.out.println("Errore: " + e.getMessage());
                logger.error("Errore di prelievo", e);
            }
        }

        scanner.close();
    }
}
