package it.epicode.cicli;

import java.util.Scanner;

public class Esercizio_4 {

    public static void main(String[] args) {
        //chiedo all'utente un numero intero e stampo il conto alla rovescia a partire da quel numero filo a zero

        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci un numero intero:");
        int numero = scanner.nextInt();

        for (int i = numero; i >= 0; i--) {
            System.out.println(i);
        }

        scanner.close();
    }
}
