package it.epicode.esercizio1;

import it.epicode.classi.Customer;
import it.epicode.classi.EcommerceData;
import it.epicode.classi.Order;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Prendo gli ordini da EcommerceData
        List<Order> ordini = EcommerceData.getOrdini();

        // Raggruppo gli ordini per cliente
        Map<Customer, List<Order>> mappaOrdini = ordini.stream()
                .collect(Collectors.groupingBy(Order::getCustomer));

        // Stampo la mappa degli ordini
        mappaOrdini.forEach((cliente, ordiniCliente) -> {
            System.out.println("Cliente: " + cliente.getName() + " -> Ordini effettuati: " + ordiniCliente);
        });
    }
}
