package it.epicode.evento.estensioni;

import it.epicode.evento.Evento;
import jakarta.persistence.Entity;
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
// query get partite vinte in casa
@NamedQuery(name = "partita.find.vinteInCasa", query = "SELECT pc FROM PartitaDiCalcio pc WHERE pc.squadraVincente = pc.squadraDiCasa")
// query get partite vinte in trasferta
@NamedQuery(name = "partita.find.vinteInTrasferta", query = "SELECT pc FROM PartitaDiCalcio pc WHERE pc.squadraVincente = pc.squadraOspite")
// query get partite pareggiate
@NamedQuery(name = "partita.find.pareggiate", query = "SELECT pc FROM PartitaDiCalcio pc WHERE pc.numeroGolSquadraDiCasa = pc.numeroGolSquadraOspite")
public class PartitaDiCalcio extends Evento {
    private String squadraDiCasa;
    private String squadraOspite;
    private String squadraVincente;
    private int numeroGolSquadraDiCasa;
    private int numeroGolSquadraOspite;

    @Override
    public String toString() {
        return "PartitaDiCalcio{" +
                "squadraDiCasa='" + squadraDiCasa + '\'' +
                ", squadraOspite='" + squadraOspite + '\'' +
                ", squadraVincente='" + squadraVincente + '\'' +
                ", numeroGolSquadraDiCasa=" + numeroGolSquadraDiCasa +
                ", numeroGolSquadraOspite=" + numeroGolSquadraOspite +
                '}';
    }
}
