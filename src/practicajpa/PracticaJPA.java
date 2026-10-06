package practicajpa;

import java.util.List;
import practicajpa.dao.PersonaDao;
import practicajpa.dao.PersonaDaoImpl;
import practicajpa.entidades.Persona;

public class PracticaJPA {

    public static void main(String[] args) {
        PersonaDao personaDao = new PersonaDaoImpl();
        List<Persona> lista = personaDao.listarPersonas();

        System.out.println("=== DATOS OBTENIDOS DESDE XAMPP / JPA ===");
        if (lista != null && !lista.isEmpty()) {
            for (Persona p : lista) {
                System.out.println(p);
            }
        } else {
            System.out.println("No hay registros en la tabla 'persona'.");
        }
    }
}
