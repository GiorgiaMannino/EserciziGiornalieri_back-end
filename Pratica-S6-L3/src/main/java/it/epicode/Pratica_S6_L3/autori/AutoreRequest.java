package it.epicode.Pratica_S6_L3.autori;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutoreRequest {

    @NotBlank(message = "Il nome è obbligatorio")
    private String nome;
    @NotBlank(message = "Il cognome è obbligatorio")
    private String cognome;
    @NotBlank(message = "L'email è obbligatoria")
    private String email;
    @NotBlank(message = "La data di nascita è obbligatoria")
    private String dataDiNascita;
    @NotBlank(message = "L'avatar è obbligatorio")
    private String avatar;
}
