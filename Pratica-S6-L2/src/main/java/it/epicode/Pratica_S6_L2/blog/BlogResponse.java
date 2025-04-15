package it.epicode.Pratica_S6_L2.blog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogResponse {
    private Long id;
    private String categoria;
    private String titolo;

    private String autoreNomeCognome;
}
