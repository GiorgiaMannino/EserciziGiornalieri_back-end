package it.epicode.Pratica_S5_L4.tavoli;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "tavoli")
public class Tavolo {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (length = 50, nullable = false)
    private int numeroTavolo;

    @Column (length = 50)
    private int numeroCopertiMax;

    private StatoTavolo stato= StatoTavolo.LIBERO;

    public Tavolo(int numeroTavolo, int copertiMax) {
        this.numeroTavolo = numeroTavolo;
        this.numeroCopertiMax = copertiMax;
        this.stato = StatoTavolo.LIBERO;
    }
}
