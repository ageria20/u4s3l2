package ageria;

import dao.EventoDAO;
import entities.EventType;
import entities.Evento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.engine.spi.EntityUniqueKey;

import java.time.LocalDate;

public class Application {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4s3l2");
    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();

        Evento evento1 = new Evento(
                "Conference on AI",
                LocalDate.of(2024, 9, 10),
                "An event discussing the latest advancements in Artificial Intelligence.",
                EventType.PUBLIC,
                200
        );

        Evento evento2 = new Evento(
                "Music Festival",
                LocalDate.of(2024, 8, 25),
                "A vibrant music festival featuring live bands and DJs.",
                EventType.PUBLIC,
                500
        );

        Evento evento3 = new Evento(
                "Art Exhibition",
                LocalDate.of(2024, 11, 5),
                "A showcase of contemporary art from emerging artists.",
                EventType.PRIVATE,
                150
        );

        Evento evento4 = new Evento(
                "Startup Pitch Event",
                LocalDate.of(2024, 12, 15),
                "A platform for startups to pitch their ideas to investors.",
                EventType.PRIVATE,
                100
        );

        EventoDAO ed = new EventoDAO(em);

        /* ed.save(evento1);
        ed.save(evento2);
        ed.save(evento3);
        ed.save(evento4);

         */

        try {
            Evento eventId = ed.getById(102);
            System.out.println(eventId);
        }
        catch (RuntimeException ex){
            System.out.println(ex.getMessage());
        }

        try {
            ed.delete(104);
            System.out.println();
        }
        catch (RuntimeException ex){
            System.out.println(ex.getMessage());
        }




        em.close();
        emf.close();
    }
}
