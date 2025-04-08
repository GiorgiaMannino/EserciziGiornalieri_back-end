package it.epicode.Pratica_S5_L2.menu;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Titolo implements RigaMenu {
    private String riga;

    @Override
    public String descrizioneRiga() {
        return riga;
    }

    @Override
    public double prezzoTotale() {
        return 0;
    }

}
