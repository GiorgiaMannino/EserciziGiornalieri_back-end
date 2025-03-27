package it.epicode.persona;

import jakarta.persistence.EntityManager;

public class PersonaDAO {


    private EntityManager em;

    public PersonaDAO(EntityManager em) {

        this.em = em;
    }

    public Persona findById(Long id) {

        return em.find(Persona.class, id);
    }

    public void insert(Persona a) {

        em.persist(a);
    }

    public void update(Persona a) {

        em.merge(a);
    }

    public void delete(Long id) {
        Persona a = findById(id);
        em.remove(a);
    }



}
