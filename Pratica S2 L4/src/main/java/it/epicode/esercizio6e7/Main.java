package it.epicode.esercizio6e7;

import it.epicode.classi.EcommerceData;
import it.epicode.classi.Product;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // Recupero l'elenco di prodotti dal mio sistema
        List<Product> prodotti = EcommerceData.getProdotti();

        // Salvo i prodotti su un file di testo
        salvaProdottiSuDisco(prodotti);
    }

    public static void salvaProdottiSuDisco(List<Product> prodotti) {
        // Definisco il nome del file dove voglio salvare i prodotti
        File file = new File("prodotti.txt");

        // Creo una stringa che rappresenta i prodotti, separando nome, categoria e prezzo con '@' e ogni prodotto con '#'
        String stringaProdotti = prodotti.stream()
                .map(prodotto -> prodotto.getName() + "@" + prodotto.getCategory() + "@" + prodotto.getPrice())
                .collect(Collectors.joining("#"));

        // Scrivo la stringa nel file
        try {
            FileUtils.writeStringToFile(file, stringaProdotti, "UTF-8");

            System.out.println("I prodotti sono stati salvati correttamente su disco.");
        } catch (IOException e) {

            System.out.println("Si è verificato un errore durante il salvataggio dei prodotti su disco.");
            e.printStackTrace();
        }
    }

    // Metodo che legge i prodotti dal file e li inserisce in un ArrayList
    public static List<Product> leggiProdottiDaDisco(String filePath) {
        List<Product> prodotti = new ArrayList<>();

        try {
            // Leggo il contenuto del file in una stringa
            String content = FileUtils.readFileToString(new File(filePath), "UTF-8");

            // Divido il contenuto in singoli record (prodotti) utilizzando '#' come separatore
            String[] records = content.split("#");

            // Per ogni record, separo i dati e creo un oggetto Product
            for (String record : records) {
                String[] parts = record.split("@");
                if (parts.length == 3) {
                    // Creo un nuovo oggetto Product con i dati separati
                    String name = parts[0];
                    String category = parts[1];
                    double price = Double.parseDouble(parts[2]);
                    prodotti.add(new Product(name, category, price));
                }
            }
        } catch (IOException e) {

            System.out.println("Errore durante la lettura del file: " + e.getMessage());
        } catch (NumberFormatException e) {

            System.out.println("Errore nel formato del prezzo: " + e.getMessage());
        }


        return prodotti;
    }
}
