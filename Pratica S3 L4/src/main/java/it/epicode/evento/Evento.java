package it.epicode.evento;

import it.epicode.location.Location;
import it.epicode.partecipazione.Partecipazione;
import jakarta.persistence.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="eventi")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@SuperBuilder
public abstract class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 250, nullable = false)
    private String titolo;

    private LocalDate dataEvento;

    private String descrizione;

    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEvento;
    private int numeroMassimoPartecipanti;

    @OneToMany(mappedBy = "evento")
    private List<Partecipazione> partecipazioni = new ArrayList<>();

    /**
     * un Evento una location
     *
     *
     * una location è in molti eventi
     */

    @ManyToOne
    private Location location;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getTitolo() {

        return titolo;
    }

    public void setTitolo(String titolo) {

        this.titolo = titolo;
    }

    public LocalDate getDataEvento() {

        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public int getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Evento() {
    }

    public Evento(Long id, String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, List<Partecipazione> partecipazioni, Location location) {
        this.id = id;
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
        this.partecipazioni = partecipazioni;
        this.location = location;
    }




}

// relazioni evento con partecipazione e location
// evento molte partecipazioni
// evento una location

// relazione tra partecipazione ed evento
// molte partecipazioni 1 evento

// relazione tra location ed evento
// location molti eventi
