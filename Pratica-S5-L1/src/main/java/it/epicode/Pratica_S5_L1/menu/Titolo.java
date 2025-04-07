package it.epicode.Pratica_S5_L1.menu;

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

}
