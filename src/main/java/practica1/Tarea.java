package practica1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tarea {
    String titulo;
    String descripcion;
    List<Persona> asignadas;
    Persona responsable;
    int prioridad;
    int fechaIni;
    Date fechaFin;
    Boolean finalizada=false;
    Resultado resultadoEsperado;
    List<String> etiquetas;

    public Tarea (String titulo, int fechaIni, Resultado resultadoEsperado){
        this.titulo = titulo;
        this.fechaIni = fechaIni;
        this.resultadoEsperado= resultadoEsperado;
        asignadas = new ArrayList<Persona>();
        etiquetas = new ArrayList<String>();
    }

    public Boolean finalizar(){
        finalizada = true;
        return finalizada;
    }

    public void introducirPersona(Persona persona){
        asignadas.add(persona);
    }

    public void eliminarPersona(Persona persona){
        asignadas.remove(persona);
    }

    public void toMyString(){
        System.out.println(titulo);
        System.out.println("Personas asignadas:");
        for (int i = 0; i < asignadas.size(); i++){
            System.out.println(asignadas.get(i).toString());
        }
        if (finalizada){
            System.out.println("Finalizada");
        }else{
            System.out.println("Sin finalizar");
        }

    }
}
