package it.epicode.cicli;
import java.util.Scanner;


public class Esercizio_2 {

    public static void main(String[] args) {
        // SWITCH

        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci un numero intero tra 0 e 3: ");
        int numero = scanner.nextInt();


        switch (numero) {
            case 0:
                System.out.println("Il numero inserito è Zero");
                break;
            case 1:
                System.out.println(" Il numero inserito è  Uno");
                break;
            case 2:
                System.out.println(" Il numero inserito è Due");
                break;
            case 3:
                System.out.println("Il numero inserito è Tre");
                break;
            default:
                System.out.println("Errore: numero fuori intervallo!");
        }

        scanner.close();
    }
}