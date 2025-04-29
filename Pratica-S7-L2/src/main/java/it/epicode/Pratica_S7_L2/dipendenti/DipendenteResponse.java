package it.epicode.Pratica_S7_L2.dipendenti;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DipendenteResponse {
    private Long id;
    private String nome;
    private String cognome;
    private String email;
    private String immagineProfilo;

    // Costruttore che converte Dipendente in DipendenteResponse
    public DipendenteResponse(Dipendente dipendente) {
        this.id = dipendente.getId();
        this.nome = dipendente.getNome();
        this.cognome = dipendente.getCognome();
        this.email = dipendente.getEmail();
        this.immagineProfilo = dipendente.getImmagineProfilo();
    }
}
