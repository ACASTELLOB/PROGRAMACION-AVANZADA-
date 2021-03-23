package practica1;

import java.util.ArrayList;
import java.util.List;

public class Persona {
    String nombre;
    String correo;
    List<Tarea> tareasResponsable;

    Persona (String nombre, String correo){
        this.nombre = nombre;
        this.correo = correo;
        tareasResponsable = new ArrayList<>();
    }

    public String toString(){
        return nombre+":"+ correo;
    }
}
