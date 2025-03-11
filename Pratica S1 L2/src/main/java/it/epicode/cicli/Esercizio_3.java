package it.epicode.cicli;

import java.util.Scanner;

public class Esercizio_3 {
    public static void main(String[] args) {

        // WHILE
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci una stringa, termina il ciclo con la stringa :q ");
        String stringa = scanner.nextLine();

    while (!stringa.equals(":q")) {
        char[] caratteri = stringa.toCharArray();
        for (int i = 0; i < caratteri.length; i++) {
            System.out.print(caratteri[i]);
            if (i < caratteri.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(); // A capo dopo la stampa
        // Chiedo all'utente un'altra stringa
        System.out.print("Inserisci un'altra stringa (o ':q' per uscire): ");
        stringa = scanner.nextLine();
    }

        System.out.println("Programma terminato.");
        scanner.close();
    }
}