package it.epicode.Classi;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Order {
    private long id;
    private String status;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private List<Product> products;
    private Customer customer;


    // costruttore
    public Order(long id, String status, LocalDate orderDate, LocalDate deliveryDate, List<Product> products, Customer customer) {
        this.id = id;
        this.status = status;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.products = products;
        this.customer = customer;
    }
    public Order() {
    }

    public <E> Order(int i, LocalDate of, LocalDate of1, List<E> es, Customer customer1) {
    }
}
