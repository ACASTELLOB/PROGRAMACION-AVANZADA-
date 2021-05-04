package practica1.controlador;

import practica1.modelo.Persona;
import practica1.modelo.Proyecto;
import practica1.modelo.Resultados.Documentacion;
import practica1.modelo.Resultados.PagWeb;
import practica1.modelo.Resultados.Programa;
import practica1.modelo.Tarea;
import practica1.modelo.excepciones.FechasException;
import practica1.modelo.excepciones.PersonasException;
import practica1.modelo.excepciones.TareaExcepcion;
import practica1.modelo.facturación.ConsumoInterno;
import practica1.modelo.facturación.Descuento;
import practica1.modelo.facturación.Facturacion;
import practica1.modelo.facturación.Urgente;



import java.io.*;
import java.util.List;
import java.util.Scanner;

public class GestionDeProyectos {

    public static int menu(Scanner teclado) {
        int opcion;
        System.out.println("\n\n");
        System.out.println("=====================================================");
        System.out.println("============            MENU        =================");
        System.out.println("=====================================================");
        System.out.println("0.Guardar el proyecto");
        System.out.println("1.Dar de alta a las personas que trabajan en el proyecto");
        System.out.println("2.Dar de alta las tareas con sus datos");
        System.out.println("3.Marcar una tarea como finalizada");
        System.out.println("4.Introducir o eliminar una persona de una tarea");
        System.out.println("5.Añadir responsable");
        System.out.println("6.Listar las personas asignadas a un proyecto");
        System.out.println("7.Listar las tareas de un proyecto.");
        System.out.println("8.Listar personas no responsables de ninguna tarea");
        System.out.println("9.Listar tareas sin personas");
        System.out.println("10.Cambiar coste de una tarea");
        do {
            System.out.print("\nElige una opcion (0..10): ");
            opcion = teclado.nextInt();
        } while ( (opcion<0) || (opcion>10) );
        teclado.nextLine(); // Elimina retorno de carro del buffer de entrada
        return opcion;
    }


    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

       Proyecto proyecto= crearProyecto(teclado);
        int opcion;
                do {
                    opcion = menu(teclado);
                    switch (opcion) {
                        case 0:
                            try {
                                FileOutputStream fos = new FileOutputStream("proyecto.bin");
                                ObjectOutputStream oos = new ObjectOutputStream(fos);
                                oos.writeObject(proyecto);
                                oos.close();
                            } catch (IOException e) {
                                System.out.println("Error al guardar el proyecto");
                            }
                            break;
                        case 1:
                            System.out.println("Introduce el nombre de la persona");
                            String nombre = teclado.nextLine();
                            System.out.println("Introduce el correo de la persona: ");
                            String correo = teclado.nextLine();
                            Persona persona = new Persona(nombre, correo);
                            try {
                                proyecto.añadirPersona(persona);
                            }catch (PersonasException e){
                                System.err.println(e.getMessage());
                            }
                            break;
                        case 2:
                            try{
                                introducirTarea(proyecto, teclado);
                            }catch (TareaExcepcion e){
                                System.err.println(e.getMessage());
                            }

                            break;

                        case 3:
                            System.out.println("Introduce el título de la tarea:");
                            String Finalizada = teclado.nextLine();
                            Boolean hecha = false;
                            try {
                                hecha = proyecto.finalizarTarea(Finalizada);
                            }catch (FechasException e){
                                System.err.println(e.getMessage());
                            }
                            if (hecha) {
                                System.out.println("Tarea Finalizada");
                            } else {
                                System.out.println("No se encuentra el titulo de la tarea");
                            }
                            break;
                        case 4:
                            System.out.println("Introudce el nombre de la persona");
                            String nombrePersona = teclado.nextLine();
                            System.out.println("Introduce el titulo de la tarea donde la quieras añadir o eliminar:");
                            String tituloProyecto = teclado.nextLine();
                            try {
                                proyecto.añadirEliminarPersona(nombrePersona, tituloProyecto);
                                System.out.println("Persona añadida o eliminada");
                            }catch(PersonasException e){
                                System.err.println(e.getMessage());
                            }
                            break;
                        case 5:
                            System.out.println("Introduce el título de la tarea");
                            String tituloResponsable=teclado.nextLine();
                            System.out.println("Introduce el nombre de la persona responsabale:");
                            String responsable= teclado.nextLine();
                            try{
                                proyecto.responsable(responsable,tituloResponsable);
                                System.out.println("Responsable añadido");
                            }catch(PersonasException e){
                                System.err.println(e.getMessage());
                            }
                            break;


                        case 6:
                            for (Persona elem : proyecto.personas) {
                                System.out.println(elem.toString());
                            }
                            break;
                        case 7:
                            for (Tarea elem : proyecto.tareas) {
                                System.out.println(elem.toString());
                            }
                            break;
                        case 8:
                            List<Persona> listaPersonasSinTarea= proyecto.listarPersonasSinTarea();
                            for(Persona elem:listaPersonasSinTarea){
                                System.out.print(elem);
                            }
                            break;

                        case 9:
                            List<Tarea> listaTareasSinREsponsable= proyecto.listarTareasSinResponsable();
                            for(Tarea elem:listaTareasSinREsponsable){
                                System.out.print(elem);
                            }
                            break;

                        case 10:
                            System.out.println("Introduce el titulo de la tarea");
                            String titulo = teclado.nextLine();
                            System.out.println("Introduce el nuevo coste de la tarea");
                            double coste = teclado.nextDouble();

                            Boolean costeCambiado = false;

                            try {
                                costeCambiado = proyecto.cambiarCosteTarea(titulo,coste);
                            }catch (TareaExcepcion e){
                                System.err.printf("No se ha podido cambiar el coste de la tarea " + e.getMessage());
                            }
                            if (costeCambiado) {
                                System.out.println("Coste de la tarea cambiado con exito");
                            } else {
                                System.out.println("No se ha podido cambiar el coste de la tarea");
                            }
                            break;
                    }
                } while (opcion != 0);

        }




    public static void introducirTarea(Proyecto proyecto, Scanner teclado){
        System.out.println("Introduce el título de la tarea");
        String tituloTarea =teclado.nextLine();
        System.out.println("Introduce el tipo de resultado: d o D para documentación, w o W para web, p o P para programa: ");
        String tipoResultado= teclado.nextLine().toUpperCase();
        System.out.println("Introduce la prioridad de la tarea");
        int prioridad=Integer.parseInt(teclado.nextLine());
        System.out.println("Introduce la descripción de la tarea");
        String descripcion = teclado.nextLine();
        System.out.println("Introduce el identificador del documento");
        String ident=teclado.nextLine();
        System.out.println("Introduce las horas");
        int horas=Integer.parseInt(teclado.nextLine());
        System.out.println("Quieres que sea interno el resultado si es que sí, escribe S o s, sino escribe N o n");
        String interno=teclado.nextLine().toUpperCase();
        boolean esInterno=interno.equals("S");
        switch (tipoResultado) {

            case "D":
                Tarea tarea = crearDocumentación(teclado,ident, horas, esInterno, tituloTarea, descripcion, prioridad);
                try {
                    proyecto.añadirTarea(tarea);
                }catch (TareaExcepcion e){
                    System.err.println(e.getMessage());
                }
                break;
            case "W":
                tarea = crearWeb(teclado,ident, horas, esInterno, tituloTarea, descripcion, prioridad);
                try {
                    proyecto.añadirTarea(tarea);
                }catch (TareaExcepcion e){
                    System.err.println (e.getMessage());
                }
                break;
            case "P":
                 tarea = crearPrograma(teclado,ident, horas, esInterno, tituloTarea, descripcion, prioridad);
                try {
                    proyecto.añadirTarea(tarea);
                }catch (TareaExcepcion e){
                    System.err.println(e.getMessage());
                }
                break;
        }
    }


    public static Tarea crearDocumentación(Scanner teclado, String ident, int horas, boolean esInterno, String tituloTarea, String descripcion, int prioridad){
        System.out.println("Introduce el formato del resultado");
        String format = teclado.nextLine();
        System.out.println("Introduce el número de páginas del resultado");
        int pag = Integer.parseInt(teclado.nextLine());
        System.out.println("Introduce el espacio en disco para tu resultado");
        int esp = Integer.parseInt(teclado.nextLine());
        Documentacion documento = new Documentacion(ident, horas,  esInterno, format, pag, esp);
        System.out.println("Introduce el coste del proyecto");
        double coste= Double.parseDouble(teclado.nextLine());
        Facturacion facturacion = crearFacturacion(teclado);
        Tarea tarea = new Tarea(tituloTarea,descripcion, documento, prioridad, coste, facturacion);
        return tarea;

    }

    public static Tarea crearWeb(Scanner teclado, String ident, int horas, boolean esInterno, String tituloTarea, String descripcion, int prioridad){
        System.out.println("Introduce el lenguaje de la web");
        String lenguaje = teclado.nextLine();
        System.out.println("Introduce el backend de la web");
        String backend = teclado.nextLine();
        System.out.println("Quieres que sea estática la web si es que sí, escribe S, sino escribe N");
        String estatica = teclado.nextLine();
        boolean esEstatica = estatica.equals("S");
        PagWeb web = new PagWeb(ident, horas, esInterno, esEstatica, lenguaje, backend);
        System.out.println("Introduce el coste del proyecto");
        double coste= Double.parseDouble(teclado.nextLine());
        Facturacion facturacion = crearFacturacion(teclado);
        Tarea tarea = new Tarea(tituloTarea,descripcion, web, prioridad,coste, facturacion);
        return tarea;
    }

    public static Tarea crearPrograma(Scanner teclado, String ident, int horas, boolean esInterno, String tituloTarea, String descripcion, int prioridad){
        System.out.println("Introduce el lenguaje del programa");
        String lenguaje = teclado.nextLine();
        System.out.println("Introduce el número el lineas de código");
        int numLineasCodigo = Integer.parseInt(teclado.nextLine());
        System.out.println("Introduce el número de módulos");
        int numModulos = Integer.parseInt(teclado.nextLine());
        Programa prog = new Programa(ident, horas, esInterno, lenguaje, numLineasCodigo, numModulos);
        System.out.println("Introduce el coste del proyecto");
        double coste= Double.parseDouble(teclado.nextLine());
        Facturacion facturacion = crearFacturacion(teclado);
        Tarea tarea = new Tarea(tituloTarea,descripcion, prog, prioridad,coste, facturacion);
        return tarea;
    }

    public static Facturacion crearFacturacion(Scanner teclado){
        System.out.println("Que tipo de facturación desea: Escribe c o C para consumo interno,  d o D para descuentos y u o U para urgentes");
        String tipoFacturación = teclado.nextLine().toUpperCase();
        switch( tipoFacturación){
            case "C":
                Facturacion facturacion = new ConsumoInterno();
                return facturacion;
            case "D":
                 facturacion = new Descuento();
                 return facturacion;
            case "U":
                 facturacion =new Urgente();
                 return facturacion;
        }
        return null;
    }



    public static Proyecto crearProyecto (Scanner teclado){
        System.out.println("Si quieres cargar el último proyecto pulsa c o C si quieres uno nuevo pulsa n o N");
        String cargado = teclado.nextLine().toUpperCase();
        Proyecto proyecto;

        if(cargado.equals("C")) {
            try {
                FileInputStream fis = new FileInputStream("proyecto.bin");
                ObjectInputStream ois = new ObjectInputStream(fis);
                proyecto = (Proyecto) ois.readObject();
                ois.close();
                return proyecto;
            } catch (IOException e) {
                System.out.println("No se ha encontrado el fichero, debes crear uno nuevo:");
                System.out.print("Introduce el nombre del proyecto: ");
                String titulo = teclado.nextLine();
                proyecto = new Proyecto(titulo);
                return proyecto;

            } catch (ClassNotFoundException ce) {
                System.out.println("No se ha encontrado la clase necesaria para cargar el fichero");
            }
        }
        else {
            System.out.print("Introduce el nombre del proyecto: ");
            String titulo = teclado.nextLine();
            proyecto = new Proyecto(titulo);
            return proyecto;

        }
        return null;
    }

}
