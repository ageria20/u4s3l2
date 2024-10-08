package dao;

import entities.Evento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.transaction.Transaction;
import jdk.jfr.Event;

public class EventoDAO {
    private EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }


    public void save(Evento event){
        EntityTransaction transaction = em.getTransaction(); // Chiediamo all'entity la transazione
        transaction.begin();
        em.persist(event); // Aggiungiamo il dato al Persist Context, ma ancora non risulta salvato
        // Conlucdiamo la transazione, salvando il dato nel DB
        transaction.commit(); // dato salavto
    }


    public Evento getById(long id){
        Evento found = em.find(Evento.class, id);
        if( found == null) throw new RuntimeException("Evento non trovato");
        else return found;
    }

    public void delete(long id){
        Evento eventToDelete = getById(id); // Cerchiamo l'id del dato
        EntityTransaction transaction = em.getTransaction(); // Chidiamo all'eneity di aprire una transaction
        transaction.begin(); // iniziamo la Transaction
        em.remove(eventToDelete); // Rimuoviamo il dato dal Persist Context (qui ancora non risulta eliminato dal Database)
        transaction.commit(); // Qui il dato è rimosso.
    }
}
