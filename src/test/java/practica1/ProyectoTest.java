package practica1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;


class ProyectoTest {
    static Persona p1,p2,p3;
    static Resultado r1,r2,r3;
    static ArrayList<Persona> personas;
    static ArrayList<Tarea> tareas;
    static Proyecto proyecto1;
    static Tarea t1,t2,t3;

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

        t1 = new Tarea("tarea1",r1,1);
        t2 = new Tarea("tarea2",r2,2);
        t3 = new Tarea("tarea3",r3,3);

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
    void añadirPersonaATarea(){
        proyecto1.añadirPersona(p1);
        proyecto1.añadirPersona(p2);
        proyecto1.añadirTarea(t1);
        proyecto1.añadirTarea(t2);
        assertTrue(proyecto1.añadirEliminarPersona("nombre1","tarea1"));
        assertFalse(proyecto1.añadirEliminarPersona("nombre1","tarea1"));
        assertFalse(proyecto1.añadirEliminarPersona("nombre4","tarea2"));
        assertFalse(proyecto1.añadirEliminarPersona("nombre2","tarea4"));
    }


}