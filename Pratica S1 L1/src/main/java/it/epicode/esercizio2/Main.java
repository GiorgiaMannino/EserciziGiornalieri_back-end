package it.epicode.esercizio2;

// Esercizio 2
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Chiedi tre stringhe all'utente
        System.out.print("Inserisci la prima stringa: ");
        String strUno = scanner.nextLine();
        System.out.print("Inserisci la seconda stringa: ");
        String strDue = scanner.nextLine();
        System.out.print("Inserisci la terza stringa: ");
        String strTre = scanner.nextLine();

        // Concatenazione in ordine
        String concatenazione = strUno + strDue + strTre;
        System.out.println("Concatenazione normale: " + concatenazione);

        // Concatenazione in ordine inverso
        String concatenazioneInversa = strTre + strDue + strUno;
        System.out.println("Concatenazione inversa: " + concatenazioneInversa);

        scanner.close();
    }
}
