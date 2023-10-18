package Emanuele.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EventoDAO {
    private final EntityManager entityManager;

    public EventoDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void save (Evento evento) {
        EntityTransaction transaction = entityManager.getTransaction();

       /* INIZIO LA TRANSAZIONE*/
        transaction.begin();

        /*AGGIUNGO AL PERSISTENCE CONTEXT ---- no salvataggio*/
        entityManager.persist(evento);

        /* SALVO NUOVA RIGA DEL DB */
        transaction.commit();
        System.out.println("L'evento è stato correttamente salvato");

    }

    public Evento findById (long id) {
        return entityManager.find(Evento.class, id);
    }

    public void delete (long id) {
        Evento eventToBeDeleted = entityManager.find(Evento.class, id);

        if (eventToBeDeleted != null) {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.remove(eventToBeDeleted);
            transaction.commit();
            System.out.println("L'evento è stato cancellato con successo!");
        } else {
            System.out.println("Evento non presente nel database");
        }
    }
}
