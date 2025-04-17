package it.epicode.Pratica_S6_L4.blog;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogRequest {
    @NotBlank (message = "Il campo categoria non può essere vuoto")
    private String categoria;
    @NotBlank (message = "Il campo titolo non può essere vuoto")
    private String titolo;
    @NotBlank (message = "Il campo cover non può essere vuoto")
    private String cover;
    @NotBlank (message = "Il campo contenuto non può essere vuoto")
    private String contenuto;
    @Max(value = 1000, message = "Il campo tempoDiLettura non puo essere maggiore di 1000")
    private int tempoDiLettura;

    private Long autoreId;
}
