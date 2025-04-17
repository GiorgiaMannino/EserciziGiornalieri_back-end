package it.epicode.Pratica_S6_L4.autori;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutoreResponse {
    private Long id;
    private String nomeCognome;
}
