package practica1;

import practica1.Resultados.Resultado;
import practica1.excepciones.FechasException;
import practica1.listas.tieneClave;
import practica1.listas.tieneLista;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tarea implements tieneLista<Persona>, tieneClave<String>, Serializable {
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

    public Tarea (String titulo,String descripcion, Resultado resultadoEsperado, int prioridad){
        this.titulo = titulo;
        this.prioridad = prioridad;
        this.fechaIni = new Date();
        this.descripcion= descripcion;
        this.resultadoEsperado= resultadoEsperado;
        asignadas = new ArrayList<Persona>();
        etiquetas = new ArrayList<String>();
    }

    public List<Persona> getLista(){

        return asignadas;
    }

    public Boolean finalizar(){
        if(fechaIni.after(fechaFin))
            throw new FechasException();
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
        StringBuilder tarea = new StringBuilder("Titulo: "+titulo+"\n");
        tarea.append("Personas asignadas: \n");
        for (int i = 0; i < asignadas.size(); i++){
            tarea.append(asignadas.get(i).toString());
            if(asignadas.get(i) == responsable){
                tarea.append("(RESPONSABLE)");
            }
            tarea.append("\n");
        }
        if (finalizada){
            tarea.append("Finalizada \n");
        }else{
            tarea.append("Sin finalizar \n");
        }
        tarea.append(descripcion);
        tarea.append(resultadoEsperado.toString());

        return tarea.toString();
    }

    @Override
    public String getClave() {
        return titulo;
    }
}
