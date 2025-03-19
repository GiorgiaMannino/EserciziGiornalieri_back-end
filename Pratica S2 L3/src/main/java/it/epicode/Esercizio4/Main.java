package it.epicode.Esercizio4;

import it.epicode.Classi.Customer;
import it.epicode.Classi.Order;
import it.epicode.Classi.Product;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        // Creo i clienti
        Customer customer1 = new Customer(1, "Mario", 2);
        Customer customer2 = new Customer(2, "Luigi", 1);
        Customer customer3 = new Customer(3, "Peach", 2);
        Customer customer4 = new Customer(4, "Toad", 1);
        Customer customer5 = new Customer(5, "Yoshi", 2);

        // Creo i prodotti
        Product product1 = new Product(1, "MacBook Pro", "Electronics", 2299);
        Product product2 = new Product(2, "PlayStation 5", "Electronics", 499);
        Product product3 = new Product(3, "iPhone 13", "Electronics", 999);
        Product product4 = new Product(4, "Nintendo Switch", "Electronics", 299);
        Product product5 = new Product(5, "Leather Jacket", "Clothing", 120);
        Product product6 = new Product(6, "Harry Potter Book Set", "Books", 60);
        Product product7 = new Product(7, "Lego Star Wars Set", "Toys", 150);
        Product product8 = new Product(8, "Canon EOS 80D", "Electronics", 799);

        // Creo la lista di ordini
        List<Order> orders = List.of(
                new Order(1, "Shipped", LocalDate.of(2021, 2, 15), LocalDate.of(2021, 2, 20),
                        List.of(product1, product6), customer1),  // Tier 2
                new Order(2, "Delivered", LocalDate.of(2021, 3, 10), LocalDate.of(2021, 3, 15),
                        List.of(product2, product5), customer2),  // Tier 1
                new Order(3, "Pending", LocalDate.of(2021, 2, 25), LocalDate.of(2021, 3, 5),
                        List.of(product3, product4), customer3),  // Tier 2
                new Order(4, "Shipped", LocalDate.of(2021, 1, 30), LocalDate.of(2021, 2, 5),
                        List.of(product7, product8), customer4),  // Tier 1
                new Order(5, "Delivered", LocalDate.of(2021, 3, 5), LocalDate.of(2021, 3, 8),
                        List.of(product1, product3), customer5)   // Tier 2
        );

        // Filtro gli ordini da clienti di livello (tier) 2 tra l'01-Feb-2021 e l'01-Apr-2021
        List<Product> productsOrderedByTier2 = orders.stream()
                .filter(order -> order.getCustomer() != null && order.getCustomer().getTier() == 2)  // Controllo che il cliente non sia null e sia di livello 2
                .filter(order -> order.getOrderDate().isAfter(LocalDate.of(2021, 1, 31)))  // Dopo il 31 gennaio 2021
                .filter(order -> order.getOrderDate().isBefore(LocalDate.of(2021, 4, 1)))  // Prima del 1 aprile 2021
                .flatMap(order -> order.getProducts().stream())  // Espande la lista di prodotti in un flusso di singoli prodotti
                .collect(Collectors.toList());  // Colleziona i prodotti in una lista


        if (productsOrderedByTier2.isEmpty()) {
            System.out.println("Nessun prodotto ordinato da clienti di tier 2 tra l'01-Feb-2021 e l'01-Apr-2021.");
        } else {
            System.out.println("Lista di prodotti ordinati da clienti di livello (tier) 2 tra l'01-Feb-2021 e l'01-Apr-2021:");
            productsOrderedByTier2.forEach(product ->
                    System.out.println("Product ID: " + product.getId() +
                            " - Product Name: " + product.getName() +
                            " - Category: " + product.getCategory() +
                            " - Price: " + product.getPrice())
            );
        }
    }
}

