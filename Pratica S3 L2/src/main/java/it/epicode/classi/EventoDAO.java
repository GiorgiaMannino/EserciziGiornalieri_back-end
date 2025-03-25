package it.epicode.classi;

import jakarta.persistence.EntityManager;

public class EventoDAO {

    private EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    // insert per inserire
    public  void insert (Evento evento){
        em.getTransaction().begin();
        em.persist(evento);
        em.getTransaction().commit();
    }

    public void insertNoTx(Evento evento) {
        em.getTransaction().begin();
        em.persist(evento);
        em.getTransaction().commit();
    }


    // update per aggiornare
    public void update(Evento evento) {
        em.getTransaction().begin();
        em.merge(evento);
        em.getTransaction().commit();
    }

    public void updateNoTx(Evento evento) {
        em.merge(evento);
    }

    // delete per cancellare
    public void delete(Long id) {
        em.getTransaction().begin();
        Evento evento = em.find(Evento.class, id);
        if (evento != null) {
            em.remove(evento);
        }
        em.getTransaction().commit();
    }

    public void deleteNoTx(Evento evento) {
        em.remove(evento);
    }

    // find per cercare
    public Evento find(long id) {
        return em.find(Evento.class, id);
    }
}
