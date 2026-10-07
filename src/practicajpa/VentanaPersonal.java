package practicajpa;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import practicajpa.dao.PersonaDao;
import practicajpa.dao.PersonaDaoImpl;
import practicajpa.entidades.Persona;

public class VentanaPersonal extends JFrame {

    private JTable tabla;
    private DefaultTableModel modeloTabla;
    private PersonaDao personaDao;

    public VentanaPersonal() {
        // Configuración de la ventana Swing
        setTitle("Lista de Personas - PracticaJPA");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Configurar columnas de la tabla según tu entidad Persona
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Correo");

        tabla = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tabla);
        add(scrollPane, BorderLayout.CENTER);

        // Botón inferior para recargar los datos
        JButton btnCargar = new JButton("Cargar / Actualizar Datos");
        btnCargar.addActionListener(e -> cargarDatos());
        add(btnCargar, BorderLayout.SOUTH);

        // Instanciar tu DAO existente
        personaDao = new PersonaDaoImpl();

        // Cargar los registros al iniciar la ventana
        cargarDatos();
    }

    private void cargarDatos() {
        try {
            // Limpiar filas anteriores en la tabla gráfica
            modeloTabla.setRowCount(0);

            // Consultar datos usando tu método listarPersonas()
            List<Persona> personas = personaDao.listarPersonas();

            if (personas != null) {
                for (Persona p : personas) {
                    modeloTabla.addRow(new Object[]{
                        p.getId(),
                        p.getNombre(),
                        p.getCorreo()
                    });
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar datos: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VentanaPersonal().setVisible(true);
        });
    }
}