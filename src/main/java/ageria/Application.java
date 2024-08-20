package ageria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.engine.spi.EntityUniqueKey;

public class Application {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4s3l2");
    public static void main(String[] args) {

        System.out.println("Avvio");
    }
}
