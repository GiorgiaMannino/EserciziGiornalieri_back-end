package it.epicode.evento;

import it.epicode.evento.estensioni.Concerto;
import it.epicode.evento.estensioni.GaraDiAtletica;
import it.epicode.evento.estensioni.Genere;
import it.epicode.evento.estensioni.PartitaDiCalcio;
import it.epicode.persona.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class EventoDAO {

    private EntityManager em;

    public EventoDAO(EntityManager em) {

        this.em = em;
    }

    public Evento findById(Long id) {

        return em.find(Evento.class, id);
    }

    public void insert(Evento a) {

        em.persist(a);
    }

    public void update(Evento a) {

        em.merge(a);
    }

    public void delete(Long id) {
        Evento a = findById(id);
        em.remove(a);
    }

    // Metodo per ottenere concerti in streaming (true o false)
    public List<Concerto> getConcertiInStreaming(boolean inStreaming) {
        TypedQuery<Concerto> query = em.createNamedQuery("concerto.find.inStreaming", Concerto.class);
        query.setParameter("inStreaming", inStreaming);
        return query.getResultList();
    }

    // Metodo per ottenere concerti per genere
    public List<Concerto> getConcertiPerGenere(Genere genere) {
        TypedQuery<Concerto> query = em.createNamedQuery("concerto.find.genere", Concerto.class);
        query.setParameter("genere", genere);
        return query.getResultList();
    }

    // Metodo per ottenere le partite vinte in casa
    public List<PartitaDiCalcio> getPartiteVinteInCasa() {
        TypedQuery<PartitaDiCalcio> query = em.createNamedQuery("partita.find.vinteInCasa", PartitaDiCalcio.class);
        return query.getResultList();
    }

    // Metodo per ottenere le partite vinte in trasferta
    public List<PartitaDiCalcio> getPartiteVinteInTrasferta() {
        TypedQuery<PartitaDiCalcio> query = em.createNamedQuery("partita.find.vinteInTrasferta", PartitaDiCalcio.class);
        return query.getResultList();
    }

    // metodo per ottenere le partite pareggiate
    public List<PartitaDiCalcio> getPartitePareggiate() {
        TypedQuery<PartitaDiCalcio> query = em.createNamedQuery("partita.find.pareggiate", PartitaDiCalcio.class);
        return query.getResultList();
    }


    // metodo per ottenere le gare di atletica per vincitore
    public List<GaraDiAtletica> getGareDiAtleticaPerVincitore(String vincitore) {
        TypedQuery<GaraDiAtletica> query = em.createNamedQuery("gara.find.vincitore", GaraDiAtletica.class);
        query.setParameter("vincitore", vincitore);
        return query.getResultList();
    }



}

