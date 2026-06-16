package dao;

import entities.Evento;
import exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EventoDAO {
    //  poiche l'interazione con il DB richiedono tanto codice, creiamo questa classe
    //  per semplificare il main

    // attributi
    private final EntityManager entityManager;
// il DAO ha bisogno di EntityManager quindi lo devi passare nel costruttore

    // costruttore
    public EventoDAO(EntityManager em) {
        this.entityManager = em;
    }


    // metodo per salvare
    public void save(Evento newEvento) {
        //  Entity manager quando facciamo modifiche (non letture) esige una transazione
        // 1. creiamo transazione
        EntityTransaction transaction = this.entityManager.getTransaction();

        //2. facciamo partire la transazione
        transaction.begin();

        // 3. poiche newEvento non è MANAGE, dobbiamo fare un PERSIST
        // (l'oggetto non è ancora parte del DB)

        this.entityManager.persist(newEvento);

        // 4. commit (sincronizza il PERSISTER con il DB)
        // poiche qui abbiamo un nuovo oggetto
        // questo crea una nuova riga
        transaction.commit();
        // 5. Log di successo (suggerita ma non obbligatoria)
        System.out.println("L' evento" + newEvento + "è stato aggiungo al DB");
    }

    public Evento getById(long id) {
        Evento fromDB = this.entityManager.find(Evento.class, id);
        if (fromDB == null) throw new NotFoundException(" evento non trovato");
        System.out.println("EVENTO RICHIESTO" + fromDB);
        return fromDB;

    }


    public void delete(long id) {
        // 1. cerchiamo tramite ID, usiamo il metotdo FIND BY ID
        Evento fromDB = this.getById(id);


        //  Entity manager quando facciamo modifiche (non letture) esige una transazione
        // 2. creiamo transazione
        EntityTransaction transaction = this.entityManager.getTransaction();
        //3. facciamo partire la transazione
        transaction.begin();

        // 4. Segniamo nell'elenco che l'oggetto trovato va eliminato del DB, usiamo REMOVE
        this.entityManager.remove(fromDB);

        // 4. commit (sincronizza con il DB)
        transaction.commit();
        // 5. Log di successo (suggerita ma non obbligatoria)
        System.out.println("L' evento" + fromDB + "è stato rimosso dal DB");
    }

}
