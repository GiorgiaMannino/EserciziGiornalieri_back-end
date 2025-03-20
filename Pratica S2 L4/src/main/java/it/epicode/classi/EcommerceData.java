package it.epicode.classi;

import java.util.List;

public class EcommerceData {
    public static List<Product> getProdotti() {
        return List.of(
                new Product(1L, "Il signore degli anelli", 120.0, "Books"),
                new Product(2L, "Moby dick", 130.0, "Books"),
                new Product(3L, "La casa nella prateria", 90.0, "Books"),
                new Product(4L, "Culla da passeggio", 230.0, "Baby"),
                new Product(5L, "Passegino", 340.0, "Baby"),
                new Product(6L, "Bicicletta cross", 190.0, "Boys"),
                new Product(6L, "Gokart da paseggio", 1190.0, "Boys")
        );
    }

    public static List<Customer> getClienti() {
        return List.of(
                new Customer(1L,"Gino", 1),
                new Customer(2L,"Roberto", 2),
                new Customer(3L,"Andrea", 2),
                new Customer(4L,"Sandro", 2),
                new Customer(5L,"Marcello", 2),
                new Customer(6L,"Mattia", 2),
                new Customer(7L,"Stefano", 3)
        );
    }

    public static List<Order> getOrdini() {
        return List.of(
                new Order(1L, "In preparazione", "2021-01-02" , "2021-01-05", getClienti().get(0), List.of(getProdotti().get(1), getProdotti().get(2))),
                new Order(2L, "Spedito", "2021-02-02", "2021-02-04", getClienti().get(1), List.of(getProdotti().get(3), getProdotti().get(4))),
                new Order(3L, "In preparazione", "2021-03-12", "2021-03-15", getClienti().get(2), List.of( getProdotti().get(5), getProdotti().get(6))),
                new Order(4L, "Spedito", "2021-03-04", "2021-03-07", getClienti().get(3), List.of( getProdotti().get(0), getProdotti().get(3))),
                new Order(5L, "In preparazione", "2021-07-12", "2021-07-15", getClienti().get(4), List.of( getProdotti().get(2), getProdotti().get(4))),
                new Order(6L, "Ricevuto", "2021-07-04", "2021-07-07", getClienti().get(5), List.of( getProdotti().get(2), getProdotti().get(3))),
                new Order(7L, "In preparazione", "2021-02-12", "2021-02-15", getClienti().get(6), List.of( getProdotti().get(6), getProdotti().get(5)))
        );
    }
}
