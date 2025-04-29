package it.epicode.Pratica_S7_L2.dipendenti;

import it.epicode.Pratica_S7_L2.auth.AppUser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "dipendenti")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dipendente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 50, unique = true)
    private String username;

    @Column(length = 50)
    private String nome;

    @Column(length = 50)
    private String cognome;

    @Column(length = 50)
    private String email;

    private String immagineProfilo;

    @OneToOne(cascade={CascadeType.REMOVE, CascadeType.PERSIST})
    private AppUser appUser;
}
