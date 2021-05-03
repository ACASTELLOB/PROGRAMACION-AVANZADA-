package practica1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practica1.Resultados.Documentacion;
import practica1.Resultados.Resultado;
import practica1.facturación.ConsumoInterno;
import practica1.facturación.Descuento;
import practica1.facturación.Facturacion;
import practica1.facturación.Urgente;
import practica1.listas.UtilidadesParaListas;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;


class ProyectoTest {
    static Persona p1,p2,p3;
    static Resultado r1,r2,r3;
    static ArrayList<Persona> personas;
    static ArrayList<Tarea> tareas;
    static Proyecto proyecto1;
    static Tarea t1,t2,t3;
    static Facturacion f1,f2,f3;

    @BeforeEach
    void setUp() {
        p1 = new Persona("nombre1","nombre1@correo.es");
        p2 = new Persona("nombre2","nombre2@correo.es");
        p3 = new Persona("nombre3","nombre3@correo.es");

        personas = new ArrayList<>();
        tareas = new ArrayList<>();

        r1 = new Documentacion("Doc1",24,true,"txt",100,10);
        r2 = new Documentacion("Doc2",30,true,"java",50,17);
        r3 = new Documentacion("Doc3",34,true,"pdf",150,12);

        f1 = new Descuento();
        f2 = new Urgente();
        f3 = new ConsumoInterno();

        t1 = new Tarea("tarea1","descripción1",r1,1,3.00, f1);
        t2 = new Tarea("tarea2","descripción2",r2,2, 19.35, f2);
        t3 = new Tarea("tarea3","descripción3",r3,3,30.5, f3);

        proyecto1 = new Proyecto("proyecto1");
    }

    @Test
    void listasPersonasProyecto(){
        assertEquals(personas,proyecto1.listarPersonas());
        proyecto1.añadirPersona(p1);
        personas.add(p1);
        assertEquals(personas,proyecto1.listarPersonas());
        personas.add(p2);
        personas.add(p3);
        proyecto1.añadirPersona(p2);
        proyecto1.añadirPersona(p3);
        assertEquals(personas, proyecto1.listarPersonas());
    }

    @Test
    void añadirTarea(){
        assertEquals(tareas,proyecto1.listarTareas());
        proyecto1.añadirTarea(t1);
        tareas.add(t1);
        assertEquals(tareas,proyecto1.listarTareas());
        tareas.add(t2);
        tareas.add(t3);
        proyecto1.añadirTarea(t2);
        proyecto1.añadirTarea(t3);
        assertEquals(tareas,proyecto1.listarTareas());
    }

    @Test
    void finalizarTarea(){
        t1.finalizar();
        assertTrue(t1.finalizada);
        assertFalse(t2.finalizada);
    }

    @Test
    void facturacion() {
        assertEquals(2.25,f1.calculoFacturación(3));
        assertEquals(24.1875,f2.calculoFacturación(19.35));
        assertEquals(30.5,f3.calculoFacturación(30.5));
    }

    @Test
    void cambiarCosteTarea() {
        t1.cambiarCoste(4);
        assertEquals(4,t1.coste);
        assertEquals(3,t1.factura);

        t2.cambiarCoste(4);
        assertEquals(4,t2.coste);
        assertEquals(5,t2.factura);

        t3.cambiarCoste(4);
        assertEquals(4,t3.coste);
        assertEquals(4,t3.factura);
    }

    @Test
    void UtilidadesParaListas() {
        proyecto1.añadirPersona(p1);
        assertEquals(proyecto1.listarPersonas(),proyecto1.listarPersonasSinTarea());

        proyecto1.añadirPersona(p2);
        proyecto1.añadirTarea(t1);
        proyecto1.responsable(p2.nombre,t1.titulo);
        assertNotEquals(proyecto1.listarPersonas(),proyecto1.listarPersonasSinTarea());

        assertTrue(UtilidadesParaListas.claveUnica(p1,proyecto1));
        assertTrue(UtilidadesParaListas.claveUnica(p2,proyecto1));
        assertFalse(UtilidadesParaListas.claveUnica(p3,proyecto1));
    }
}