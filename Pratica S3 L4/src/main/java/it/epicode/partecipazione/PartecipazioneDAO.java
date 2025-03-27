package it.epicode.partecipazione;

import jakarta.persistence.EntityManager;

public class PartecipazioneDAO {

    private EntityManager em;

    public PartecipazioneDAO(EntityManager em) {

        this.em = em;
    }

    public Partecipazione findById(Long id) {

        return em.find(Partecipazione.class, id);
    }

    public void insert(Partecipazione a) {

        em.persist(a);
    }

    public void update(Partecipazione a) {

        em.merge(a);
    }

    public void delete(Long id) {
        Partecipazione a = findById(id);
        em.remove(a);
    }



}
