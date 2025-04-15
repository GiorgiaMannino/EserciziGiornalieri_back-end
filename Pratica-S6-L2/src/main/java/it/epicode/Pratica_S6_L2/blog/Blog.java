package it.epicode.Pratica_S6_L2.blog;

import it.epicode.Pratica_S6_L2.autori.Autore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "blog")
public class Blog {

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column (length = 50)
    private String categoria;

    @Column (nullable = false, length = 100)
    private String titolo;

    private String cover;

    @Column (length = 200)
    private String contenuto;

    private int tempoDiLettura;

    @ManyToOne
    private Autore autore;


}
