package practica1;

import java.util.ArrayList;
import java.util.List;

public class Proyecto {
    String nombre;
    List<Tarea> tareas;
    List<Persona> personas;

    public Proyecto (String nombre){
        this.nombre=nombre;
        tareas = new ArrayList<>();
        personas = new ArrayList<>();
    }

    public void añadirPersona(Persona persona){
        personas.add(persona);
    }

    public void añadirTarea(Tarea tarea) { tareas.add(tarea);}

    public List<Persona> listarPersonas(){
        return personas;
    }

    public List<Tarea> listarTareas(){
        return tareas;
    }

    public Boolean finalizarTarea(String titulo){
        for(Tarea elem:tareas){
            if(elem.titulo.equals(titulo)){
                elem.finalizar();
                return true;
            }
        }
        return false;

    }
    public Boolean añadirEliminarPersona(String nombrePersona, String tituloTarea){

    }


}