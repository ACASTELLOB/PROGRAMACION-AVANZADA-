package practica1.modelo;

import practica1.modelo.listas.tieneClave;
import practica1.modelo.listas.tieneLista;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Persona implements tieneLista<Tarea>, tieneClave<String>, Serializable{
    public String nombre;
    String correo;
    List<Tarea> tareasResponsable;

    public Persona (String nombre, String correo){
        this.nombre = nombre;
        this.correo = correo;
        tareasResponsable = new ArrayList<>();
    }

    @Override
    public List<Tarea> getLista() {
        return tareasResponsable;
    }

    public String toString(){
        return nombre+":"+ correo;
    }

    @Override
    public String getClave() {
        return nombre;
    }
}
