package it.epicode.Esercizio3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    private long codiceCliente;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataIscrizione;
}
