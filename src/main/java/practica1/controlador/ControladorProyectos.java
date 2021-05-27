package practica1.controlador;

import practica1.modelo.Modelo;
import practica1.modelo.Persona;
import practica1.modelo.excepciones.PersonasException;
import practica1.vista.Vista;

public class ControladorProyectos implements Controlador{
    Modelo modelo;
    Vista vista;

    public void setModelo(Modelo modelo){
        this.modelo= modelo;
    }

    public void setVista(Vista vista){
        this.vista=vista;
    }

    @Override
    public void añadirPersona() {

        String nombre= vista.getNombre();
        String correo= vista.getCorreo();
        Persona persona = new Persona(nombre, correo);
        try {
            modelo.añadirPersona(persona);
            System.out.println("Persona añadida");
        }catch (PersonasException e){
            System.err.println(e.getMessage());
        }

    }
}
