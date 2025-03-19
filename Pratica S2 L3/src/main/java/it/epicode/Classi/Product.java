package it.epicode.Classi;


import lombok.Data;

@Data
public class Product {
    private long id;
    private String name;
    private String category;
    private double price;

    // costruttore
    public Product(long id, String name, String category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }
    public Product() {
    }

}

