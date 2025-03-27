package it.epicode.evento.estensioni;

import it.epicode.evento.Evento;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.NamedQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
// query get concerti in streamig true o false
@NamedQuery(name = "concerto.find.inStreaming", query = "SELECT c FROM Concerto c WHERE c.inStreaming = :inStreaming" )
// query get concerti per genere
@NamedQuery(name = "concerto.find.genere", query = "SELECT c FROM Concerto c WHERE c.genere = :genere")
public class Concerto extends Evento {

    @Enumerated(EnumType.STRING)
    private Genere genere;

    private boolean inStreaming;

    @Override
    public String toString() {
        return "Concerto{" +
                "titolo='" + getTitolo() + '\'' +
                ", descrizione='" + getDescrizione() + '\'' +
                ", genere=" + genere +
                ", inStreaming=" + inStreaming +
                '}';
    }
}
