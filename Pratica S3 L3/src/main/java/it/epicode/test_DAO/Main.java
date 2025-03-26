package it.epicode.test_DAO;


import it.epicode.classi.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
        EntityManager em = emf.createEntityManager();

        EventoDAO eventoDAO = new EventoDAO(em);
        LocationDAO locationDAO = new LocationDAO(em);
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(em);
        PersonaDAO personaDAO = new PersonaDAO(em);


        em.getTransaction().begin();
        Location l = new Location(null, "Palazzo pitti", "Roma", null);
        locationDAO.insert(l);

        Evento e = new Evento(null, "Evento 1", LocalDate.of(2021, 1, 1), "Concerto vasco rossi", TipoEvento.PUBBLICO,1000,null, l);
        eventoDAO.insert(e);

        Persona p = new Persona( null, "Mario", "Rossi", "mario.rossi@epicode.it",  LocalDate.of(1990, 1, 1), Sesso.M, null);
        personaDAO.insert(p);

        Partecipazione partecipazione = new Partecipazione(null,  p, e, StatoEvento.CONFERMATA);
        partecipazioneDAO.insert(partecipazione);


        em.getTransaction().commit();


        em.close();
        emf.close();

    }
}