package it.epicode.main;

import it.epicode.evento.EventoDAO;
import it.epicode.evento.estensioni.Concerto;
import it.epicode.evento.estensioni.GaraDiAtletica;
import it.epicode.evento.estensioni.Genere;
import it.epicode.evento.estensioni.PartitaDiCalcio;
import it.epicode.location.Location;
import it.epicode.location.LocationDAO;
import it.epicode.partecipazione.Partecipazione;
import it.epicode.partecipazione.PartecipazioneDAO;
import it.epicode.partecipazione.StatoEvento;
import it.epicode.persona.Persona;
import it.epicode.persona.PersonaDAO;
import it.epicode.persona.Sesso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Creazione di EntityManagerFactory e EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
        EntityManager em = emf.createEntityManager();

        // Creazione dei DAO
        EventoDAO eventoDAO = new EventoDAO(em);
        LocationDAO locationDAO = new LocationDAO(em);
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(em);
        PersonaDAO personaDAO = new PersonaDAO(em);

        // Inizio della transazione
        em.getTransaction().begin();

        // Creazione delle persone per le partecipazioni (diverse dagli atleti)
        Persona p = new Persona(null, "Mario", "Rossi", "mario.rossi@epicode.it",
                LocalDate.of(1990, 1, 1), Sesso.M, new ArrayList<>(), new HashSet<>());
        Persona p2 = new Persona(null, "Luigi", "Verdi", "luigi.verdi@epicode.it",
                LocalDate.of(1995, 4, 15), Sesso.M, new ArrayList<>(), new HashSet<>());
        personaDAO.insert(p);
        personaDAO.insert(p2);

        // Creazione delle location
        Location l = new Location(null, "Palazzo pitti", "Roma", null);
        Location l2 = new Location(null, "Teatro Massimo", "Palermo", null);
        locationDAO.insert(l);
        locationDAO.insert(l2);

        // Creazione degli eventi

        // Concerti
        Concerto concerto1 = Concerto.builder()
                .titolo("Concerto di Vasco")
                .descrizione("Concerto rock di Vasco Rossi")
                .genere(Genere.ROCK)
                .inStreaming(false)
                .dataEvento(LocalDate.of(2025, 6, 15))
                .build();

        Concerto concerto2 = Concerto.builder()
                .titolo("Concerto di Beethoven")
                .descrizione("Concerto di musica classica con orchestra")
                .genere(Genere.CLASSICO)
                .inStreaming(true)
                .dataEvento(LocalDate.of(2025, 9, 10))
                .build();

        // Partite di calcio
        PartitaDiCalcio partita1 = PartitaDiCalcio.builder()
                .titolo("Finale Champions League")
                .descrizione("Partita tra due top club europei")
                .squadraDiCasa("Real Madrid")
                .squadraOspite("Manchester City")
                .squadraVincente("Real Madrid")
                .numeroGolSquadraDiCasa(3)
                .numeroGolSquadraOspite(1)
                .dataEvento(LocalDate.of(2025, 5, 28))
                .build();

        PartitaDiCalcio partita2 = PartitaDiCalcio.builder()
                .titolo("Derby di Milano")
                .descrizione("Partita tra Milan e Inter")
                .squadraDiCasa("Milan")
                .squadraOspite("Inter")
                .squadraVincente("Inter")
                .numeroGolSquadraDiCasa(2)
                .numeroGolSquadraOspite(3)
                .dataEvento(LocalDate.of(2025, 10, 15))
                .build();

        Persona atleta1 = new Persona(null, "Usain", "Bolt", "usain.bolt@example.com",
                LocalDate.of(1986, 8, 21), Sesso.M, new ArrayList<>(), new HashSet<>());
        Persona atleta2 = new Persona(null, "Serena", "Williams", "serena.williams@example.com",
                LocalDate.of(1981, 9, 26), Sesso.F, new ArrayList<>(), new HashSet<>());
        Persona atleta3 = new Persona(null, "Michael", "Phelps", "michael.phelps@example.com",
                LocalDate.of(1985, 6, 30), Sesso.M, new ArrayList<>(), new HashSet<>());
        Persona atleta4 = new Persona(null, "Simone", "Biles", "simone.biles@example.com",
                LocalDate.of(1987, 10, 25), Sesso.M, new ArrayList<>(), new HashSet<>());

        // Se non hai già salvato gli atleti, salvali prima (per evitare errori di transient)
        personaDAO.insert(atleta1);
        personaDAO.insert(atleta2);
        personaDAO.insert(atleta3);
        personaDAO.insert(atleta4);

        // Gare di atletica
        GaraDiAtletica gara1 = GaraDiAtletica.builder()
                .titolo("100m Olimpiadi")
                .descrizione("Finale dei 100m alle Olimpiadi")
                .atleti(Set.of(atleta1, atleta2))
                .vincitore(atleta1)
                .dataEvento(LocalDate.of(2025, 8, 3))
                .build();

        GaraDiAtletica gara2 = GaraDiAtletica.builder()
                .titolo("200m Campionati Mondiali")
                .descrizione("Finale dei 200m ai Campionati Mondiali")
                .atleti(Set.of(atleta3, atleta4))
                .vincitore(atleta3)
                .dataEvento(LocalDate.of(2025, 9, 22))
                .build();

        // Inserimento degli eventi nel database
        eventoDAO.insert(concerto1);
        eventoDAO.insert(concerto2);
        eventoDAO.insert(partita1);
        eventoDAO.insert(partita2);
        eventoDAO.insert(gara1);
        eventoDAO.insert(gara2);

        // Creazione delle partecipazioni utilizzando eventi esistenti
        // Ad esempio, qui usiamo i concerti, le gare e le partite per le partecipazioni
        Partecipazione partecipazione = new Partecipazione(null, p, concerto1, StatoEvento.CONFERMATA);
        Partecipazione partecipazione4 = new Partecipazione(null, p, concerto2, StatoEvento.CONFERMATA);
        Partecipazione partecipazione2 = new Partecipazione(null, p2, gara1, StatoEvento.DA_CONFERMARE);
        Partecipazione partecipazione5 = new Partecipazione(null, p2, gara2, StatoEvento.DA_CONFERMARE);
        Partecipazione partecipazione3 = new Partecipazione(null, p2, partita1, StatoEvento.DA_CONFERMARE);
        Partecipazione partecipazione6 = new Partecipazione(null, p2, partita2, StatoEvento.DA_CONFERMARE);

        partecipazioneDAO.insert(partecipazione);
        partecipazioneDAO.insert(partecipazione2);
        partecipazioneDAO.insert(partecipazione3);
        partecipazioneDAO.insert(partecipazione4);
        partecipazioneDAO.insert(partecipazione5);
        partecipazioneDAO.insert(partecipazione6);

        // Commit della transazione
        em.getTransaction().commit();


        // Esecuzione della Named Query per ottenere concerti in streaming
        TypedQuery<Concerto> queryInStreaming = em.createNamedQuery("concerto.find.inStreaming", Concerto.class);
        queryInStreaming.setParameter("inStreaming", true);
        List<Concerto> concertiInStreaming = queryInStreaming.getResultList();
        System.out.println("Concerti in streaming:");
        for (Concerto c : concertiInStreaming) {
            System.out.println(c);
        }

        // Esecuzione della Named Query per ottenere concerti per genere
        TypedQuery<Concerto> queryPerGenere = em.createNamedQuery("concerto.find.genere", Concerto.class);
        queryPerGenere.setParameter("genere", Genere.ROCK);
        List<Concerto> concertiPerGenere = queryPerGenere.getResultList();
        System.out.println("\nConcerti di genere ROCK:");
        for (Concerto c : concertiPerGenere) {
            System.out.println(c);
        }

        // Metodo per ottenere le partite vinte in casa
        TypedQuery<PartitaDiCalcio> queryPartiteVinteInCasa = em.createNamedQuery("partita.find.vinteInCasa", PartitaDiCalcio.class);
        List<PartitaDiCalcio> partiteVinteInCasa = queryPartiteVinteInCasa.getResultList();
        System.out.println("\nPartite vinte in casa:");
        for (PartitaDiCalcio pc : partiteVinteInCasa) {
            System.out.println(pc);
        }
        // Metodo per ottenere le partite vinte in trasferta
        TypedQuery<PartitaDiCalcio> queryPartiteVinteInTrasferta = em.createNamedQuery("partita.find.vinteInTrasferta", PartitaDiCalcio.class);
        List<PartitaDiCalcio> partiteVinteInTrasferta = queryPartiteVinteInTrasferta.getResultList();
        System.out.println("\nPartite vinte in trasferta:");
        for (PartitaDiCalcio pc : partiteVinteInTrasferta) {
            System.out.println(pc);
        }

        // Metodo per ottenere le partite pareggiate
        TypedQuery<PartitaDiCalcio> queryPartitePareggiate = em.createNamedQuery("partita.find.pareggiate", PartitaDiCalcio.class);
        List<PartitaDiCalcio> partitePareggiate = queryPartitePareggiate.getResultList();
        System.out.println("\nPartite pareggiate:");
        for (PartitaDiCalcio pc : partitePareggiate) {
            System.out.println(pc);
        }

        // metodo per ottenere le gare di atletica per vincitore
        TypedQuery<GaraDiAtletica> queryGareDiAtleticaPerVincitore = em.createNamedQuery("gara.find.vincitore", GaraDiAtletica.class);
        List<GaraDiAtletica> gareDiAtleticaPerVincitore = queryGareDiAtleticaPerVincitore.getResultList();
        System.out.println("\nGare di atletica per vincitore:");
        for (GaraDiAtletica gd : gareDiAtleticaPerVincitore) {
            System.out.println(gd);
        }


        // Chiusura degli EntityManager
        em.close();
        emf.close();
    }
}
