package it.epicode.Pratica_S7_L2.viaggi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViaggioResponse {
    private Long id;
    private String destinazione;
    private LocalDate data;
    private StatoViaggio stato;
}
