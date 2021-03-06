package practica1.modelo;

import practica1.modelo.Resultados.Resultado;
import practica1.modelo.excepciones.FechasException;
import practica1.modelo.facturación.Facturacion;
import practica1.modelo.listas.tieneClave;
import practica1.modelo.listas.tieneLista;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tarea implements tieneLista<Persona>, tieneClave<String>, Serializable {
    public String titulo;
    String descripcion;
    List<Persona> asignadas;
    Persona responsable;
    int prioridad;
    Date fechaIni;
    Date fechaFin;
    public Boolean finalizada=false;
    Resultado resultadoEsperado;
    List<String> etiquetas;
    public double coste;
    Facturacion facturacion;
    public double factura;

    public Tarea (String titulo,String descripcion, Resultado resultadoEsperado, int prioridad, double coste, Facturacion facturacion){
        this.titulo = titulo;
        this.prioridad = prioridad;
        this.fechaIni = new Date();
        this.descripcion= descripcion;
        this.resultadoEsperado= resultadoEsperado;
        asignadas = new ArrayList<Persona>();
        etiquetas = new ArrayList<String>();
        this.coste = coste;
        this.facturacion = facturacion;
        this.factura = facturacion.calculoFacturación(coste);
    }

    public Boolean finalizar(){
        this.fechaFin=new Date();
        if(fechaIni.after(fechaFin))
            throw new FechasException();
        this.finalizada = true;
        return finalizada;
    }

    public void introducirPersona(Persona persona){
        asignadas.add(persona);
    }

    public void eliminarPersona(Persona persona){
        asignadas.remove(persona);
    }

    public void cambiarCoste(double coste){
        this.coste = coste;
        factura = facturacion.calculoFacturación(coste);
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
        tarea.append("Descripción:" +descripcion + "\n");
        tarea.append(resultadoEsperado.toString()+"\n");
        tarea.append("Facturación:"+ factura+"\n");
        tarea.append("Coste:" + coste);

        return tarea.toString();
    }

    @Override
    public List<Persona> getLista(){
        return asignadas;
    }

    @Override
    public String getClave() {
        return titulo;
    }
}
