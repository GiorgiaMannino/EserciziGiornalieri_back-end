package it.epicode.esercizio4;

import it.epicode.classi.Customer;
import it.epicode.classi.EcommerceData;
import it.epicode.classi.Order;
import it.epicode.classi.Product;

import java.util.List;
import java.util.DoubleSummaryStatistics;

public class Main {
    public static void main(String[] args) {

        List<Order> ordini = EcommerceData.getOrdini();

        // Calcolo dell'importo totale per ogni ordine
        DoubleSummaryStatistics statistiche = ordini.stream()
                .mapToDouble(order -> order.getProducts().stream()
                        .mapToDouble(Product::getPrice) // Ottengo il prezzo di ciascun prodotto
                        .sum()) // Sommo i prezzi dei prodotti per ogni ordine
                .summaryStatistics();

        System.out.println("Importo totale degli ordini: " + statistiche.getSum());
        System.out.println("Media degli importi degli ordini: " + statistiche.getAverage());

    }
}
