package practica1.modelo;

import practica1.modelo.excepciones.PersonasException;
import practica1.modelo.excepciones.TareaExcepcion;
import practica1.modelo.listas.UtilidadesParaListas;
import practica1.modelo.listas.tieneLista;
import practica1.vista.Vista;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
        vista.actualizarVista();
    }

    @Override
    public void añadirTarea(Tarea tarea) {
        for(Tarea elem:tareas){
            if(tarea.titulo.equals(elem.titulo)){
                throw new TareaExcepcion("La tarea ya existe");
            }
        }
        tareas.add(tarea);
        vista.actualizarVista();
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

    @Override
    public Boolean cambiarCosteTarea(String titulo, double coste){
        for(Tarea elem:tareas){
            if(elem.titulo.equals(titulo)){
                elem.cambiarCoste(coste);
                return true;
            }
        }
        vista.actualizarVista();
        return false;
    }

    @Override
    public Boolean finalizarTarea(String titulo){
        for(Tarea elem:tareas){
            if(elem.titulo.equals(titulo)){
                elem.finalizar();
                vista.actualizarVista();
                return true;
            }
        }
        return false;
    }

    @Override
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
        vista.actualizarVista();
    }

    @Override
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
        vista.actualizarVista();
    }

    @Override
    public void guardar(){
        try {
            FileOutputStream fos = new FileOutputStream("proyecto.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            oos.close();
            vista.mostrarMensajeInformativo("Guardado con exito", "Información");
        } catch (IOException e) {
            vista.mostrarMensajeError("Error al guardar", "Error");
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