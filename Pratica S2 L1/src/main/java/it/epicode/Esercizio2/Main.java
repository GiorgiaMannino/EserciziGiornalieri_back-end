package it.epicode.Esercizio2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Auto auto1 = new Auto(0, 0);

        while (true) {
            // Input km percorsi
            System.out.println("Inserisci il numero di km percorsi:");
            try {
                String inputKm = scanner.nextLine().trim();
                if (!inputKm.matches("-?\\d+")) {
                    logger.error("Input non valido. Devi inserire un numero intero.");
                    continue;
                }
                auto1.setKm(Integer.parseInt(inputKm));  // Imposta il valore dei km
            } catch (NumberFormatException e) {
                logger.error("Input non valido. Devi inserire un numero intero.");
                continue;
            }

            if (auto1.getKm() == 0) {
                logger.error("Impossibile calcolare il numero di km/litro se i km sono 0");
                continue;
            }

            // Input litri di carburante consumati
            System.out.println("Inserisci il numero di litri consumati:");
            try {
                String inputCarburante = scanner.nextLine().trim();
                if (!inputCarburante.matches("-?\\d+")) {
                    logger.error("Input non valido. Devi inserire un numero intero.");
                    continue;
                }
                auto1.setCarburanteConsumato(Integer.parseInt(inputCarburante));  // Imposta il valore del carburante
            } catch (NumberFormatException e) {
                logger.error("Input non valido. Devi inserire un numero intero.");
                continue;
            }

            if (auto1.getCarburanteConsumato() == 0) {
                logger.error("Impossibile calcolare il numero di km/litro se i litri sono 0");
                continue;
            }

            // Calcolo km/litro
            try {
                double kmPerLitro = (double) auto1.getKm() / auto1.getCarburanteConsumato();
                System.out.println("Il numero di km/litro percorsi è: " + kmPerLitro);
            } catch (ArithmeticException e) {
                logger.error("Errore nella divisione per zero: carburante non può essere zero.");
            }
            break;
        }

        scanner.close();
    }
}


