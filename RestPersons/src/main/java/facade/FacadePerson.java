package facade;

import entity.Persons;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FacadePerson implements IPersonFacade {

    private EntityManagerFactory emf;
    
    @Override
    public void addEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }   

    @Override
    public Persons addPerson(Persons p) {
        EntityManagerFactory emfn = Persistence.createEntityManagerFactory("PA");
        EntityManager em = emfn.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            return p;
        } finally {
            em.close();
        }
    }

    @Override
    public Persons deletePerson(int id) {
        EntityManagerFactory emfn = Persistence.createEntityManagerFactory("PA");
        EntityManager em = emfn.createEntityManager();

        try {
            em.getTransaction().begin();
            Persons p = em.find(Persons.class, id);
            if (p != null) {
                em.remove(p);
            }
            em.getTransaction().commit();
            return p;
        } finally {
            em.close();
        }
    }

    @Override
    public Persons getPerson(int id) {
        EntityManagerFactory emfn = Persistence.createEntityManagerFactory("PA");
        EntityManager em = emfn.createEntityManager();
        try {
            em.getTransaction().begin();
            Persons p = em.find(Persons.class, id);
            em.getTransaction().commit();
            return p;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Persons> getPersons() {
        EntityManagerFactory emfn = Persistence.createEntityManagerFactory("PA");
        EntityManager em = emfn.createEntityManager();
        Query query = em.createQuery("SELECT e FROM Persons e");

        return (List<Persons>) query.getResultList();
    }

    @Override
    public Persons editPerson(Persons p) {
        EntityManagerFactory emfn = Persistence.createEntityManagerFactory("PA");
        EntityManager em = emfn.createEntityManager();

        try {
            em.getTransaction().begin();
            Persons person = em.find(Persons.class, p.getId());
            if (person != null) {
                em.merge(p);
            }
            em.getTransaction().commit();
            return person;
        } finally {
            em.close();
        }
    }

}