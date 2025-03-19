package it.epicode.Classi;

import lombok.Data;

@Data
public class Customer {
    private long id;
    private String name;
    private int tier;

    //costruttore
    public Customer(long id, String name, int tier) {
        this.id = id;
        this.name = name;
        this.tier = tier;
    }
    public Customer() {
    }

}
