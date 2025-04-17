package it.epicode.Pratica_S6_L3.blog;

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

    private Long autoreId;
}
