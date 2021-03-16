package practica1;

import java.util.List;

public class Proyecto {
    String nombre;
    List<Tarea> tareas;
    List<Persona> personas;



    public Proyecto (String nombre){
        this.nombre=nombre;
    }

    public void añadirPersona(Persona persona){
        System.out.println("hola");
    }
}