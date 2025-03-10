package it.epicode.esercizio3;
// Esercizio 3
import java.util.Scanner;

public class Main {
    // Metodo per calcolare il perimetro del rettangolo
    public static double calcolaPerimetroRettangolo(double b, double h) {
        return 2 * (b + h);
    }

    // Metodo per verificare se un numero è pari o dispari
    public static int pariDispari(int numero) {
        return numero % 2 == 0 ? 0 : 1;
    }

    // Metodo per calcolare l'area di un triangolo con la formula di Erone
    public static double areaTriangolo(double lato1, double lato2, double lato3) {
        double semiPerimetro = (lato1 + lato2 + lato3) / 2;
        return Math.sqrt(semiPerimetro * (semiPerimetro - lato1) * (semiPerimetro - lato2) * (semiPerimetro - lato3));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Test calcolo perimetro rettangolo
        System.out.print("Inserisci la base del rettangolo: ");
        double base = scanner.nextDouble();
        System.out.print("Inserisci l'altezza del rettangolo: ");
        double altezza = scanner.nextDouble();
        System.out.println("Il perimetro del rettangolo è: " + calcolaPerimetroRettangolo(base, altezza));

        // Test pari o dispari
        System.out.print("Inserisci un numero intero: ");
        int numero = scanner.nextInt();
        System.out.println("Risultato pariDispari: " + pariDispari(numero));

        // Test area triangolo
        System.out.print("Inserisci la lunghezza del primo lato del triangolo: ");
        double latoTriangolo1 = scanner.nextDouble();
        System.out.print("Inserisci la lunghezza del secondo lato del triangolo: ");
        double latoTriangolo2 = scanner.nextDouble();
        System.out.print("Inserisci la lunghezza del terzo lato del triangolo: ");
        double latoTriangolo3 = scanner.nextDouble();
        System.out.println("Area del triangolo: " + areaTriangolo(latoTriangolo1, latoTriangolo2, latoTriangolo3));

        scanner.close();
    }
}
