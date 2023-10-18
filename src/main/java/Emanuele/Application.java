package Emanuele;


import Emanuele.entities.Evento;
import Emanuele.entities.EventoDAO;
import Emanuele.entities.TipoEvento;

import javax.persistence.EntityManager;
import java.time.LocalDate;

import static Emanuele.utils.JpaUtil.getEntityManagerFactory;

public class Application {

    public static void main(String[] args) {
    EntityManager entityManager = getEntityManagerFactory().createEntityManager();
try{

        EventoDAO ed = new EventoDAO(entityManager);
         Evento gala = new Evento("Gran Gala", LocalDate.of(2023, 3 ,21),
                 "grande ballo per festeggiare l'anniversario della filarmonica",
                TipoEvento.PRIVATO, 200 );

         ed.save(gala);


} catch (Exception ex) {
    System.err.println(ex.getMessage());
} finally {
    entityManager.close();
    getEntityManagerFactory().close();
}
    }
}
