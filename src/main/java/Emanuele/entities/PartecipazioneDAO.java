package Emanuele.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PartecipazioneDAO {
    private final EntityManager entityManager;

    public PartecipazioneDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void save (Partecipazione attendingEvent) {
        EntityTransaction transaction = entityManager.getTransaction();

       /* INIZIO LA TRANSAZIONE*/
        transaction.begin();

        /*AGGIUNGO AL PERSISTENCE CONTEXT ---- no salvataggio*/
        entityManager.persist(attendingEvent);

        /* SALVO NUOVA RIGA DEL DB */
        transaction.commit();
        System.out.println("La partecipazione all'evento è stata correttamente inserita");

    }

    public Partecipazione findById (long id) {
        return entityManager.find(Partecipazione.class, id);
    }

    public void delete (long id) {
        Partecipazione attendanceToBeDeleted = entityManager.find(Partecipazione.class, id);

        if (attendanceToBeDeleted != null) {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.remove(attendanceToBeDeleted);
            transaction.commit();
            System.out.println("La partecipazione all'evento è stata annullata!");
        } else {
            System.out.println("Richiesta di partecipazione non presente nel database");
        }
    }
}
