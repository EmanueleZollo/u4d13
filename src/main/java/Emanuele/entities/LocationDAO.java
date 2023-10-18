package Emanuele.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LocationDAO {
    private final EntityManager entityManager;

    public LocationDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void save (Location location) {
        EntityTransaction transaction = entityManager.getTransaction();

       /* INIZIO LA TRANSAZIONE*/
        transaction.begin();

        /*AGGIUNGO AL PERSISTENCE CONTEXT ---- no salvataggio*/
        entityManager.persist(location);

        /* SALVO NUOVA RIGA DEL DB */
        transaction.commit();
        System.out.println("Il luogo è stato correttamente salvato");

    }

    public Location findById (long id) {
        return entityManager.find(Location.class, id);
    }

    public void delete (long id) {
        Persona locationToBeDeleted = entityManager.find(Persona.class, id);

        if (locationToBeDeleted != null) {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.remove(locationToBeDeleted);
            transaction.commit();
            System.out.println("Il luogog è stato cancellato con successo!");
        } else {
            System.out.println("Luogo non presente nel database");
        }
    }
}
