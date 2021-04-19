package practica1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Persona implements tieneLista, tieneClave, Serializable{
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
