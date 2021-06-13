package practica1.modelo;

import practica1.vista.Vista;

import java.io.Serializable;
import java.util.List;

public interface Modelo extends Serializable {
    void setVista(Vista vista);
    void añadirPersona(Persona persona);

    void guardar();

    Boolean cambiarCosteTarea(String titulo, double coste);

    Boolean finalizarTarea(String titulo);

    void responsable(String nombrePersona, String tituloTarea);

    void añadirEliminarPersona(String nombrePersona, String tituloTarea);

    String getNombre();

    void añadirTarea(Tarea tarea);

    List<Persona> listarPersonas();
    List<Tarea> listarTareas();
    List<Persona> listarPersonasSinTarea();
    List<Tarea> listarTareasSinResponsable();

}
