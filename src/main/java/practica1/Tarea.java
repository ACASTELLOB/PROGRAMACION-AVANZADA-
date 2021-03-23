package practica1;

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
    }
}
