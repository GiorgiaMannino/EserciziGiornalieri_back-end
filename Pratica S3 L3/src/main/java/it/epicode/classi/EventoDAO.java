package it.epicode.classi;

import jakarta.persistence.EntityManager;

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

}
