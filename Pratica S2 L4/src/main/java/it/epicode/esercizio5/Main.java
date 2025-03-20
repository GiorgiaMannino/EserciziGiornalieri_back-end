package it.epicode.esercizio5;

import it.epicode.classi.EcommerceData;
import it.epicode.classi.Product;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // Elenco di prodotti
        List<Product> prodotti = EcommerceData.getProdotti();

        // Raggruppo i prodotti per categoria e calcolo la somma degli importi per ogni categoria
        Map<String, Double> sommaPerCategoria = prodotti.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.summingDouble(Product::getPrice)));

        sommaPerCategoria.forEach((categoria, somma) -> {
            System.out.println("Categoria: " + categoria);
            System.out.println("Somma totale degli importi: " + somma);
            System.out.println();
        });
    }
}
