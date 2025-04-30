package it.epicode.Pratica_S7_L3.adapter;

import java.util.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

public class InfoAdapter implements DataSource {

    private Info info;

    public InfoAdapter(Info info) {
        this.info = info;
    }

    @Override
    public String getNomeCompleto() {
        return info.getNome() + " " + info.getCognome(); // Combino nome e cognome
    }

    @Override
    public int getEta() {
        if (info.getDataDiNascita() == null) {
            return 0; // Se non c'è data di nascita, restituisce 0
        }
        LocalDate dataNascita = info.getDataDiNascita().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        return Period.between(dataNascita, LocalDate.now()).getYears(); // Calcola l'età
    }
}
