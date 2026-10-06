package practicajpa.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import practicajpa.entidades.Persona;

public class PersonaDaoImpl implements PersonaDao {

    private EntityManagerFactory emf;

    public PersonaDaoImpl() {
        // "PracticaPU" debe llamarse exactamente igual a la Persistence Unit
        this.emf = Persistence.createEntityManagerFactory("PracticaPU");
    }

    @Override
    public List<Persona> listarPersonas() {
        EntityManager em = emf.createEntityManager();
        List<Persona> lista = null;
        try {
            lista = em.createQuery("SELECT p FROM Persona p", Persona.class).getResultList();
        } finally {
            em.close();
        }
        return lista;
    }
}