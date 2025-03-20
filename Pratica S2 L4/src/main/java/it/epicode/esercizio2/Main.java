package it.epicode.esercizio2;

import it.epicode.classi.Customer;
import it.epicode.classi.EcommerceData;
import it.epicode.classi.Order;
import it.epicode.classi.Product; // Import per accedere ai prodotti

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Prendo gli ordini da EcommerceData
        List<Order> ordini = EcommerceData.getOrdini();

        // Creiamo la mappa Cliente -> Totale acquisti
        Map<Customer, Double> venditePerCliente = ordini.stream()
                .collect(Collectors.groupingBy(
                        Order::getCustomer, // Raggruppa per cliente
                        Collectors.summingDouble(order -> order.getProducts().stream()
                                .mapToDouble(Product::getPrice) // Somma i prezzi dei prodotti
                                .sum()
                        )
                ));

        // Stampiamo il totale delle vendite per ogni cliente
        venditePerCliente.forEach((cliente, totale) -> {
            System.out.println("Cliente: " + cliente.getName() + " (ID: " + cliente.getId() + ")");
            System.out.println("Totale vendite: €" + totale);
            System.out.println(); // Riga vuota per leggibilità
        });
    }
}
