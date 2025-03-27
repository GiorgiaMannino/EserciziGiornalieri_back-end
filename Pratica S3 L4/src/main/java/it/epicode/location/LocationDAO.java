package it.epicode.location;

import jakarta.persistence.EntityManager;

public class LocationDAO {

    private EntityManager em;

    public LocationDAO(EntityManager em) {

        this.em = em;
    }

    public Location findById(Long id) {

        return em.find(Location.class, id);
    }

    public void insert(Location a) {

        em.persist(a);
    }

    public void update(Location a) {

        em.merge(a);
    }

    public void delete(Long id) {
        Location a = findById(id);
        em.remove(a);
    }


}
