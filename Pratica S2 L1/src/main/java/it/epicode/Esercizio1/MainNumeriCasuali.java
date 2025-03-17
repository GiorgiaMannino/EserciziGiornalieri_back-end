package it.epicode.Esercizio1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Scanner;

public class MainNumeriCasuali {
    private static final Logger logger = LoggerFactory.getLogger(MainNumeriCasuali.class);

    public static void main(String[] args) {
        int[] numeriCasuali = new int[5];
        Scanner scanner = new Scanner(System.in);

        // Generazione numeri casuali
        for (int i = 0; i < numeriCasuali.length; i++) {
            numeriCasuali[i] = (int) (Math.random() * 10) + 1;
        }

        // Stampa array iniziale
        System.out.println("Numeri casuali generati:");
        stampaArray(numeriCasuali);

        // Ciclo per chiedere numeri finché l'utente non inserisce 0
        while (true) {
            System.out.println("Inserisci un numero da 1 a 10 (0 per uscire):");
            int numeroInserito;
            try {
                numeroInserito = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                logger.error("Input non valido. Devi inserire un numero intero.");
                continue;
            }

            if (numeroInserito == 0) {
                break;
            }

            if (numeroInserito < 1 || numeroInserito > 10) {
                logger.error("Numero fuori intervallo. Inserisci un numero tra 1 e 10.");
                continue;
            }

            System.out.println("In quale posizione vuoi inserirlo? (da 1 a 5):");
            int posizione;
            try {
                posizione = Integer.parseInt(scanner.nextLine()) - 1;
            } catch (NumberFormatException e) {
                logger.error("Input non valido. Devi inserire un numero intero.");
                continue;
            }

            if (posizione < 0 || posizione >= numeriCasuali.length) {
                logger.error("Posizione non valida. Devi inserire un numero tra 1 e 5.");
                continue;
            }

            numeriCasuali[posizione] = numeroInserito;
            System.out.println("Nuovo stato dell'array:");
            stampaArray(numeriCasuali);
        }

        System.out.println("Programma terminato. Stato finale dell'array:");
        stampaArray(numeriCasuali);
    }

    private static void stampaArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}