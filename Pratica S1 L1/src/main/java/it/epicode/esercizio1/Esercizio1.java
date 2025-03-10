package it.epicode.esercizio1;
import java.util.Scanner;

public class Esercizio1 {
    // Metodo moltiplica
    public static int moltiplica(int a, int b) {
        return a * b;
    }

    // Metodo concatena
    public static String concatena(String testo, int numero) {
        return testo + numero;
    }

    // Metodo per inserire una stringa in un array
    public static String[] inseriscilnArray(String[] array, String nuovaStringa) {
        String[] nuovoArray = new String[6];
        nuovoArray[0] = array[0];
        nuovoArray[1] = array[1];
        nuovoArray[2] = nuovaStringa;
        nuovoArray[3] = array[2];
        nuovoArray[4] = array[3];
        nuovoArray[5] = array[4];
        return nuovoArray;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Test moltiplica
        int risultatoMoltiplicazione = moltiplica(2, 3);
        System.out.println("Moltiplicazione: " + risultatoMoltiplicazione);

        // Test concatena
        String risultatoConcatenazione = concatena("Ciao", 5);
        System.out.println("Stringa concatenata: " + risultatoConcatenazione);

        // Test inserisciInArray
        String[] arrayOriginale = {"uno", "due", "tre", "quattro", "cinque"};
        String[] nuovoArray = inseriscilnArray(arrayOriginale, "NUOVO");

        System.out.print("Nuovo array: ");
        for (String elemento : nuovoArray) {
            System.out.print(elemento + " ");
        }
        System.out.println();

        scanner.close();
    }
}
