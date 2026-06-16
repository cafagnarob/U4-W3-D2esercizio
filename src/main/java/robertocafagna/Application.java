package robertocafagna;

import Enum.TipoEvento;
import dao.EventoDAO;
import entities.Evento;
import exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    // creiamo una "fabbrica" di EntityManager
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("u4w3d2pu");

    public static void main(String[] args) {
        // creiamo un EntityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        // creiamo un nuovo EventoDAO per poter utilizzare i metodi al suo interno
        // all'interno del EventoDAO passiamo l'entity manager.
        EventoDAO eventoDAO = new EventoDAO(entityManager);
        // creiamo nuovi eventi
        Evento e1 = new Evento(
                "Concerto Rock Milano",
                LocalDate.of(2026, 2, 10),
                "Grande concerto rock con band internazionali",
                TipoEvento.PUBBLICO,
                5000
        );

        Evento e2 = new Evento(
                "Riunione Aziendale",
                LocalDate.of(2026, 1, 25),
                "Meeting strategico interno aziendale",
                TipoEvento.PRIVATO,
                30
        );

        Evento e3 = new Evento(
                "Fiera della Moda",
                LocalDate.of(2026, 3, 5),
                "Esposizione brand emergenti e fashion show",
                TipoEvento.PUBBLICO,
                2000
        );

        Evento e4 = new Evento(
                "Compleanno Privato",
                LocalDate.of(2026, 2, 14),
                "Festa di compleanno riservata",
                TipoEvento.PRIVATO,
                50
        );

        Evento e5 = new Evento(
                "Hackathon Tech",
                LocalDate.of(2026, 4, 12),
                "Competizione di sviluppo software 24h",
                TipoEvento.PUBBLICO,
                300
        );

        Evento e6 = new Evento(
                "Cena di Gala",
                LocalDate.of(2026, 5, 1),
                "Evento elegante con ospiti selezionati",
                TipoEvento.PRIVATO,
                120
        );

        Evento e7 = new Evento(
                "Festival Street Food",
                LocalDate.of(2026, 6, 20),
                "Cibo da tutto il mondo in piazza",
                TipoEvento.PUBBLICO,
                10000
        );

        Evento e8 = new Evento(
                "Workshop Fotografia",
                LocalDate.of(2026, 3, 18),
                "Corso pratico di fotografia urbana",
                TipoEvento.PUBBLICO,
                80
        );

        Evento e9 = new Evento(
                "Consiglio Direttivo",
                LocalDate.of(2026, 2, 2),
                "Riunione interna del board aziendale",
                TipoEvento.PRIVATO,
                15
        );

        Evento e10 = new Evento(
                "Maratona Cittadina",
                LocalDate.of(2026, 9, 10),
                "Gara podistica aperta a tutti",
                TipoEvento.PUBBLICO,
                15000
        );

        // aggiungiamo l'evento al db con il metodo save

        /*eventoDAO.save(e1);
        eventoDAO.save(e2);
        eventoDAO.save(e3);
        eventoDAO.save(e4);
        eventoDAO.save(e5);
        eventoDAO.save(e6);
        eventoDAO.save(e7);
        eventoDAO.save(e8);
        eventoDAO.save(e9);
        eventoDAO.save(e10);*/


        // uso il try per intercettare l'errore e non crashare il programma.

        try {

            eventoDAO.getById(11);
        } catch (NotFoundException e) {
            System.out.println("oggetto non trovato");
        }

        try {

            eventoDAO.delete(5);
        } catch (NotFoundException e) {
            System.out.println("oggetto non trovato");
        }


        try {

            eventoDAO.getById(5);
        } catch (NotFoundException e) {
            System.out.println("oggetto non trovato");
        }

        try {

            eventoDAO.getById(3);
        } catch (NotFoundException e) {
            System.out.println("oggetto non trovato");
        }


    }
}
