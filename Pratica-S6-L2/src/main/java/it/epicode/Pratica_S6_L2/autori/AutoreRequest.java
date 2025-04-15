package it.epicode.Pratica_S6_L2.autori;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutoreRequest {

    private String nome;
    private String cognome;
    private String email;
    private String dataDiNascita;
    private String avatar;
}
