package it.epicode.Pratica_S5_L1.classi;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table ( name = "toppings" )
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Topping {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column ( nullable = false, length = 50 )
    private String name;

    @Column ( length = 100 )
    private String description;

    @OneToMany ( mappedBy = "topping" )
    private Pizza pizza;

}
