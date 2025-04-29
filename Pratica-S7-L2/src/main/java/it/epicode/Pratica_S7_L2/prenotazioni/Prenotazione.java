package it.epicode.Pratica_S7_L2.prenotazioni;


import it.epicode.Pratica_S7_L2.auth.AppUser;
import it.epicode.Pratica_S7_L2.dipendenti.Dipendente;
import it.epicode.Pratica_S7_L2.viaggi.Viaggio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "prenotazioni")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    private Viaggio viaggio;

    @ManyToOne
    private Dipendente dipendente;

    private LocalDate dataRichiesta;

    @Column(length = 200)
    private String preferenze;

}
