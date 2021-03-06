package practica1.controlador;

import practica1.modelo.Modelo;
import practica1.vista.Vista;

import java.io.Serializable;

public interface Controlador extends Serializable {
    void setModelo(Modelo modelo);
    void setVista(Vista vista);
    void añadirPersona();
    void añadirTarea();
    void cambiarCoste();
    void añadirResponsable();
    void finalizarTarea();
    void guardar();

    void IntrodELiminaPersonaTarea();
}
