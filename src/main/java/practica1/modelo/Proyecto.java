package practica1.modelo;

import practica1.modelo.excepciones.PersonasException;
import practica1.modelo.excepciones.TareaExcepcion;
import practica1.modelo.listas.UtilidadesParaListas;
import practica1.modelo.listas.tieneLista;
import practica1.vista.Vista;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Proyecto implements tieneLista<Persona>, Serializable, Modelo {
    String nombre;
    public List<Tarea> tareas;
    public List<Persona> personas;
    private Vista vista;

    public Proyecto (String nombre){
        this.nombre=nombre;
        tareas = new ArrayList<>();
        personas = new ArrayList<>();
    }

    @Override
    public void setVista(Vista vista) {
        this.vista=vista;
    }

    public void añadirPersona(Persona persona){
        if(UtilidadesParaListas.claveUnica(persona, this)){
            throw new PersonasException("La persona ya esta añadida al proyecto");
        }

        personas.add(persona);
    }

    public void añadirTarea(Tarea tarea) {
        for(Tarea elem:tareas){
            if(tarea.titulo.equals(elem.titulo)){
                throw new TareaExcepcion("La tarea ya existe");
            }
        }
        tareas.add(tarea);
    }

    public List<Persona> listarPersonas(){
        return personas;
    }

    public List<Tarea> listarTareas(){
        return tareas;
    }

    public List<Persona> listarPersonasSinTarea(){
        return UtilidadesParaListas.elementosConListaVacia(this.listarPersonas());
    }

    public List<Tarea> listarTareasSinResponsable(){
        return UtilidadesParaListas.elementosConListaVacia(this.listarTareas());
    }

    public Boolean cambiarCosteTarea(String titulo, double coste){
        for(Tarea elem:tareas){
            if(elem.titulo.equals(titulo)){
                elem.cambiarCoste(coste);
                return true;
            }
        }
        return false;
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


    public void responsable(String nombrePersona, String tituloTarea){
        Persona persona =null;
        for(Persona elem:personas) {
            if (elem.nombre.equals(nombrePersona))
                persona = elem;
        }
        if(persona==null){
            throw new PersonasException("La persona no esta dada de alta en el proyecto");
        }else{
            for(Tarea elem:tareas){
                if(tituloTarea.equals(elem.titulo)){
                    elem.responsable=persona;
                    persona.tareasResponsable.add(elem);
                }
            }
        }


    }

    public void añadirEliminarPersona(String nombrePersona, String tituloTarea){
        Persona persona= null;
        for(Persona elem:personas) {
            if (elem.nombre.equals(nombrePersona))
                persona = elem;
        }
        if(persona==null){
            throw new PersonasException("La persona no esta dada de alta en el proyecto");
        }else{
            for(Tarea elem:tareas){
                if(tituloTarea.equals(elem.titulo)){
                    if(UtilidadesParaListas.claveUnica(persona, elem)){
                        elem.eliminarPersona(persona);
                    }
                    else{
                        elem.introducirPersona(persona);
                    }
                }
            }
        }
    }

    @Override
    public List<Persona> getLista() {
        return this.personas;
    }

    public String getNombre() {
        return nombre;
    }
}