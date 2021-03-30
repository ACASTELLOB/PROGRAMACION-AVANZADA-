package practica1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tarea implements tieneLista<Persona>{
    String titulo;
    String descripcion;
    List<Persona> asignadas;
    Persona responsable;
    int prioridad;
    Date fechaIni;
    Date fechaFin;
    Boolean finalizada=false;
    Resultado resultadoEsperado;
    List<String> etiquetas;

    public Tarea (String titulo, Resultado resultadoEsperado, int prioridad){
        this.titulo = titulo;
        this.prioridad = prioridad;
        this.fechaIni = new Date();
        this.resultadoEsperado= resultadoEsperado;
        asignadas = new ArrayList<Persona>();
        etiquetas = new ArrayList<String>();
    }

    public List<Persona> getLista(){

        return asignadas;
    }

    public Boolean finalizar(){
        finalizada = true;
        this.fechaFin = new Date();
        return finalizada;
    }

    public void introducirPersona(Persona persona){
        asignadas.add(persona);
    }

    public void eliminarPersona(Persona persona){
        asignadas.remove(persona);
    }

    public String toString(){
        String tarea = ("Titulo: "+titulo+"\n");
        tarea.concat("Personas asignadas: \n");
        for (int i = 0; i < asignadas.size(); i++){
            tarea.concat(asignadas.get(i).toString());
            if(asignadas.get(i) == responsable){
                tarea.concat("(RESPONSABLE)");
            }
            tarea.concat("\n");
        }
        if (finalizada){
            tarea.concat("Finalizada \n");
        }else{
            tarea.concat("Sin finalizar \n");
        }

        tarea.concat(resultadoEsperado.toString());

        return tarea;
    }
}
