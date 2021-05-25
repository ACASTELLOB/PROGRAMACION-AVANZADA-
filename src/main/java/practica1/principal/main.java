package practica1.principal;

import practica1.modelo.Persona;
import practica1.modelo.Proyecto;
import practica1.modelo.Resultados.Resultado;
import practica1.modelo.Tarea;
import practica1.modelo.facturación.ConsumoInterno;
import practica1.modelo.facturación.Facturacion;
import practica1.vista.ventanaCarga;
import practica1.vista.ventanaPrincipal;

public class main {
    public static void main(String args[]){
        ventanaCarga ventana = new ventanaCarga();
        ventana.ejecutar();

        Proyecto proyecto = new Proyecto("Pruebas");
        Persona persona = new Persona("Paco","@Paco");
        Persona persona1 = new Persona("Paco1","@Paco1");
        Persona persona2 = new Persona("Paco2","@Paco2");
        proyecto.añadirPersona(persona);
        proyecto.añadirPersona(persona1);
        proyecto.añadirPersona(persona2);
        Resultado res = new Resultado("res", 10, true);
        Facturacion fac = new ConsumoInterno();
        Tarea t1 = new Tarea("Tarea", "Una tarea", res, 1, 10, fac);
        Tarea t2 = new Tarea("Tarea1", "Una tarea", res, 1, 10, fac);
        Tarea t3 = new Tarea("Tarea2", "Una tarea", res, 1, 10, fac);
        proyecto.añadirTarea(t1);
        proyecto.añadirTarea(t2);
        proyecto.añadirTarea(t3);
        //ventanaPrincipal ventanaP = new ventanaPrincipal(proyecto);
        //ventanaP.ejecutar();
    }
}
