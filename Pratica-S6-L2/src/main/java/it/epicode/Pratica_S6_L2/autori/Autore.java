package it.epicode.Pratica_S6_L2.autori;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "autori")

public class Autore {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nome;
    @Column(nullable = false, length = 50)
    private String cognome;

    @Column(length = 100)
    private String email;

    private LocalDate dataDiNascita;

    private String avatar;
}
