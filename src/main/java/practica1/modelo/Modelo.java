package practica1.modelo;

import practica1.vista.Vista;

import java.util.List;

public interface Modelo {
    void setVista(Vista vista);
    void añadirPersona(Persona persona);

    String getNombre();
    List<Persona> listarPersonas();
    List<Tarea> listarTareas();
    List<Persona> listarPersonasSinTarea();
    List<Tarea> listarTareasSinResponsable();
}
