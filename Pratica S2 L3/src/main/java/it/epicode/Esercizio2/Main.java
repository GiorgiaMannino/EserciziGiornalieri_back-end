package it.epicode.Esercizio2;

import it.epicode.Classi.Product;

import java.util.List;

public class Main {

    // lista di prodotti della categoria baby
    public static List<Product> products = List.of(
            new Product(1, "Bib", "Baby", 160),
            new Product(2, "Diaper", "Baby", 85),
            new Product(3, "Pacifier", "Baby", 15),
            new Product(4, "Teddy Bear", "Baby", 80)
    );

    public static void main(String[] args) {
        System.out.println("Lista di prodotti della categoria 'Baby'");

        // Filtro i prodotti della categoria Baby
        products.stream()
                .filter(product -> product.getCategory().equals("Baby"))
                .forEach(product -> System.out.println(product.getName() + " - €" + product.getPrice()));
    }
}
