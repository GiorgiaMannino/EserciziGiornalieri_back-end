package it.epicode.evento.estensioni;

import it.epicode.evento.Evento;
import it.epicode.persona.Persona;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
// query get gare di atletica per vincitore
@NamedQuery(name = "gara.find.vincitore", query = "SELECT g FROM GaraDiAtletica g WHERE g.vincitore = :vincitore")
public class GaraDiAtletica extends Evento {

    @ManyToMany
    @JoinTable(
            name = "partecipazioni",
            joinColumns = @JoinColumn(name = "gara_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "persona_id", referencedColumnName = "id")
    )
    private Set<Persona> atleti;

    @OneToOne
    private Persona vincitore;

    @Override
    public String toString() {
        return "GaraDiAtletica{" +
                "titolo='" + getTitolo() + '\'' +
                ", descrizione='" + getDescrizione() + '\'' +
                ", atleti=" + atleti +
                ", vincitore=" + vincitore +
                '}';
    }
}
