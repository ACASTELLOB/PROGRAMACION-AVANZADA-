package practica1.vista;

import practica1.controlador.Controlador;
import practica1.modelo.Modelo;
import practica1.modelo.Persona;
import practica1.modelo.Tarea;

public interface Vista {

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
    //String getInterno();
    int getPrioridad();
    int getHora();
//gets de resultaods
    String getFormato();
    int getNumPag();
    int getEspDisc();
    //Boolean getEstatica();
    String getLenguajeWeb();
    String getLenguajeProg();
    String getBackend();
    int getNumLineasCodigo();
    int getNumModulos();
    double getCoste();

//gets personas y tareas
    Persona getPersonaActual();
    Tarea getTareaActual();
    double getCosteCambiado();








    void actualizarVista();

}
