package it.epicode.Esercizio1;

import it.epicode.Classi.Product;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

    // lista di prodotti della categoria books
    public static List<Product> products = List.of(
            new Product(1, "The Lord of the Rings", "Books", 140),
            new Product(2, "The Chronicles of Narnia", "Books", 120),
            new Product(3, "Harry Potter and the Philosopher’s Stone", "Books", 105),
            new Product(4, "Harry Potter and the Chamber of Secrets", "Books", 80)
    );

    public static void main(String[] args) {
        System.out.println("Lista di prodotti della categoria 'Books' con prezzo > 100:");

        // Filtro per categoria e prezzo, e raccogliere in una lista
        List<Product> filteredProducts = products.stream()
                .filter(product -> product.getCategory().equals("Books"))
                .filter(product -> product.getPrice() > 100)
                .collect(Collectors.toList());

        filteredProducts.forEach(product -> System.out.println(product.getName() + " - €" + product.getPrice()));
    }
}
