package it.epicode.Esercizio1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Set<String> parole = new HashSet<>();
        Set<String> paroleDuplicate = new HashSet<>();
        System.out.println("Inserisci il numero di parole da scrivere");

        try {
            int n = scanner.nextInt();

            for (int i = 0; i < n; i++) {
                System.out.println("Inserisci la parola");
                String parola = scanner.next();
                if (!parole.add(parola)) {  // se la parola non è aggiunta, è duplicata
                    paroleDuplicate.add(parola);
                }
            }

            System.out.println("Parole duplicate: " + paroleDuplicate);

            System.out.println("Numero parole distinte: " + parole.size());

            System.out.println("Le parole distinte sono: " + parole);

        } catch (Exception e) {
            System.out.println("Inserisci un numero valido");
        }

        scanner.close();
    }
}
