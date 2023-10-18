package Emanuele.entities;

import Emanuele.entities.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PersonaDAO {
    private final EntityManager entityManager;

    public PersonaDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void save (Persona person) {
        EntityTransaction transaction = entityManager.getTransaction();

       /* INIZIO LA TRANSAZIONE*/
        transaction.begin();

        /*AGGIUNGO AL PERSISTENCE CONTEXT ---- no salvataggio*/
        entityManager.persist(person);

        /* SALVO NUOVA RIGA DEL DB */
        transaction.commit();
        System.out.println("La persona è stata correttamente salvata");

    }

    public Persona findById (long id) {
        return entityManager.find(Persona.class, id);
    }

    public void delete (long id) {
        Persona personToBeDeleted = entityManager.find(Persona.class, id);

        if (personToBeDeleted != null) {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.remove(personToBeDeleted);
            transaction.commit();
            System.out.println("Questa persona è stato cancellato con successo!");
        } else {
            System.out.println("Persona non presente nel database");
        }
    }
}
