package it.epicode.test_dao;

import it.epicode.classi.Evento;
import it.epicode.classi.EventoDAO;
import it.epicode.classi.TipoEvento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
        EntityManager em = emf.createEntityManager();
        EventoDAO eventoDAO = new EventoDAO(em);

        // Creo eventi usando LocalDate
        Evento evento1 = new Evento(100, "Cena aziendale", LocalDate.of(2023, 10, 10), TipoEvento.PRIVATO, "Descrizione evento 1");
        Evento evento2 = new Evento(250, "Festival", LocalDate.of(2025, 1, 16), TipoEvento.PUBBLICO, "Descrizione evento 2");
        Evento evento3 = new Evento(60, "Workshop", LocalDate.of(2025, 3, 4), TipoEvento.PRIVATO, "Descrizione evento 3");
        Evento evento4 = new Evento(80, "Concerto", LocalDate.of(2024, 12, 20), TipoEvento.PUBBLICO, "Descrizione evento 4");

        // Inserisco gli eventi nel database
        eventoDAO.insert(evento1);
        eventoDAO.insert(evento2);
        eventoDAO.insert(evento3);
        eventoDAO.insert(evento4);

        // Cerco un evento per ID
        Evento eventoFind = eventoDAO.find(3L);
        System.out.println("Evento trovato: " + eventoFind);

        // Modifico evento con ID 2
        Evento eventoUpdate = eventoDAO.find(2L);
        eventoUpdate.setTitolo("Nuovo titolo");
        eventoDAO.update(eventoUpdate);
        System.out.println("Evento modificato: " + eventoUpdate);

        // Elimino un evento tramite ID 1
        eventoDAO.delete(1L);
        System.out.println("Evento eliminato");

        // Chiudo EntityManager e EntityManagerFactory
        em.close();
        emf.close();
    }
}
