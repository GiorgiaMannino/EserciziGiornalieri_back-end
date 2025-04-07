package it.epicode.Pratica_S5_L1.classi;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table ( name = "pizze" )
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pizza {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column ( nullable = false, length = 50 )
    private String name;

    @Column ( length = 100 )
    private String description;

    private double price;

    @ManyToOne
    @JoinColumn ( name = "topping_id" )
    private Topping topping;


}
