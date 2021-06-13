package practica1.vista;

import practica1.controlador.Controlador;
import practica1.modelo.Modelo;
import practica1.modelo.Persona;
import practica1.modelo.Tarea;

import java.io.Serializable;

public interface Vista extends Serializable {

    void setControlador(Controlador controlador);
    void setModelo(Modelo modelo);

    void ejecutar();
//gets de añadir Personas
    String getNombre();
    String getCorreo();

//gets de añadir Tareas
    String getTitulo();
    String getDescripcion();
    String getIdentificador();
    Boolean getInterno();
    int getPrioridad();
    int getHora();
//gets de resultaods
    String getFormato();
    int getNumPag();
    int getEspDisc();
    Boolean getEstatica();
    String getLenguajeWeb();
    String getLenguajeProg();
    String getBackend();
    int getNumLineasCodigo();
    int getNumModulos();
    double getCoste();
    String getRes();
    String getFacturación();

//gets personas y tareas
    Persona getPersonaActual();
    Tarea getTareaActual();
    double getCosteCambiado();

    void actualizarVista();

    void mostrarMensajeError(String mensaje, String titulo);
    void mostrarMensajeInformativo(String mensaje, String titulo);
}
