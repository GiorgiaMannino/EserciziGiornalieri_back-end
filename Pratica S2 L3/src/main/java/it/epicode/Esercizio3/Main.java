package it.epicode.Esercizio3;

import it.epicode.Classi.Product;

import java.util.List;

public class Main {

    // lista di prodotti della categoria boys e applicare il 10% di sconto
    public static List<Product> products = List.of(
            new Product(1, "Football", "Boys", 40),
            new Product(2, "T-shirt", "Boys", 20),
            new Product(3, "Pants", "Boys", 50),
            new Product(4, "Shirt", "Boys", 25)
    );

    public static void main(String[] args) {

        System.out.println("Prodotti senza sconto:");
        // Prodotti senza sconto
        products.stream()
                .filter(product -> product.getCategory().equals("Boys"))
                .forEach(product -> System.out.println("Name: " + product.getName() + " | Price: €" + product.getPrice()));

        System.out.println("------------------------------");

        System.out.println("Prodotti della categoria 'Boys' con il 10% di sconto applicato:");
        // Applico il 10% di sconto ai prodotti e stampo il prezzo scontato
        products.stream()
                .filter(product -> product.getCategory().equals("Boys"))
                .map(product -> {
                    double discountedPrice = product.getPrice() * 0.9; // Calcola il prezzo scontato
                    return new Product(product.getId(), product.getName(), product.getCategory(), discountedPrice);
                })
                .forEach(product -> System.out.println("Name: " + product.getName() + " | Discounted Price: €" + product.getPrice()));
    }
}
