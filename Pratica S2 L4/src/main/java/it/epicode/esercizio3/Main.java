package it.epicode.esercizio3;

import it.epicode.classi.EcommerceData;
import it.epicode.classi.Product;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Product> prodotti = EcommerceData.getProdotti();

        // Ordino i prodotti per prezzo decrescente e prendo i primi 3
        List<Product> top3Prodotti = prodotti.stream()
                .sorted((p1, p2) -> Double.compare(p2.getPrice(), p1.getPrice())) // Ordina in modo decrescente
                .limit(3)
                .collect(Collectors.toList());

        // Stampo i 3 prodotti più costosi
        System.out.println("I 3 prodotti più costosi:");
        top3Prodotti.forEach(p ->
                System.out.println(p.getName() + " - Prezzo: " + p.getPrice())
        );
    }
}
