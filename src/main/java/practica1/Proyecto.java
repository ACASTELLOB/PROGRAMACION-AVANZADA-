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
    public String añadirEliminarPersona(String nombrePersona, String tituloTarea){
        Persona persona= null;
        for(Persona elem:personas) {
            if (elem.equals(nombrePersona))
                persona = elem;
        }
        if(persona==null){
            return "La persona no esta dada de alta ene l proyecto";

        }else{
            for(Tarea elem:tareas){
                if(tituloTarea.equals(elem.titulo)){
                    if(elem.asignadas.contains(persona)){
                        elem.asignadas.remove(persona);
                        return "Se ha eliminado a la persona del proyecto";
                    }
                    else{
                        elem.asignadas.add(persona);
                        return "Se ha añadido a la persona al proyecto";
                    }
                }
            }
        }
        return "no existe la tarea";
    }


}