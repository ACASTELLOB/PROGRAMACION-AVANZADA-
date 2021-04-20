package practica1;

import practica1.listas.tieneClave;
import practica1.listas.tieneLista;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Persona implements tieneLista<Tarea>, tieneClave<String>, Serializable{
    String nombre;
    String correo;
    List<Tarea> tareasResponsable;

    Persona (String nombre, String correo){
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
