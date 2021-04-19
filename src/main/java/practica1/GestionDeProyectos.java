package practica1;

import practica1.excepciones.FechasException;
import practica1.excepciones.PersonasException;
import practica1.excepciones.TareaExcepcion;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Date;
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
        System.out.println("5.Listar las personas asignadas a un proyecto");
        System.out.println("6.Listar las tareas de un proyecto.");
        System.out.println("7.Listar tareas sin personas");
        System.out.println("8.Listar personas no responsables de ninguna tarea");
        do {
            System.out.print("\nElige una opcion (0..8): ");
            opcion = teclado.nextInt();
        } while ( (opcion<0) || (opcion>7) );
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
                                System.err.printf(e.getMessage());
                            }
                            break;
                        case 2:
                            try{
                                introducirTarea(proyecto, teclado);
                            }catch (TareaExcepcion e){
                                System.err.printf(e.getMessage());
                            }

                            break;

                        case 3:
                            System.out.println("Introduce el título de la tarea:");
                            String Finalizada = teclado.nextLine();
                            Boolean hecha = false;
                            try {
                                hecha = proyecto.finalizarTarea(Finalizada);
                            }catch (FechasException e){
                                System.err.printf(e.getMessage());
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
                            }catch(PersonasException e){
                                System.err.printf(e.getMessage());
                            }
                            break;
                        case 5:
                            for (Persona elem : proyecto.personas) {
                                System.out.println(elem.toString());
                            }
                            break;
                        case 6:
                            for (Tarea elem : proyecto.tareas) {
                                System.out.println(elem.toString());
                            }
                            break;
                        case 7:
                            List<Persona> listaPersonasSinTarea= proyecto.listarPersonasSinTarea();
                            for(Persona elem:listaPersonasSinTarea){
                                elem.toString();
                            }
                            break;

                        case 8:
                            List<Tarea> listaTareasSinREsponsable= proyecto.listarTareasSinResponsable();
                            for(Tarea elem:listaTareasSinREsponsable){
                                elem.toString();
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
                System.out.println("Introduce el formato del resultado");
                String format = teclado.nextLine();
                System.out.println("Introduce el número de páginas del resultado");
                int pag = Integer.parseInt(teclado.nextLine());
                System.out.println("Introduce el espacio en disco para tu resultado");
                int esp = Integer.parseInt(teclado.nextLine());
                Documentacion documento = new Documentacion(ident, horas, esInterno, format, pag, esp);
                Tarea tarea = new Tarea(tituloTarea,descripcion, documento, prioridad);
                try {
                    proyecto.añadirTarea(tarea);
                }catch (TareaExcepcion e){
                    System.err.printf(e.getMessage());
                }
                break;

            case "W":
                System.out.println("Introduce el lenguaje de la web");
                String lenguaje = teclado.nextLine();
                System.out.println("Introduce el backend de la web");
                String backend = teclado.nextLine();
                System.out.println("Quieres que sea estática la web si es que sí, escribe S, sino escribe N");
                String estatica = teclado.nextLine();
                boolean esEstatica = estatica.equals("S");
                PagWeb web = new PagWeb(ident, horas, esInterno, esEstatica, lenguaje, backend);
                tarea = new Tarea(tituloTarea,descripcion, web, prioridad);
                try {
                    proyecto.añadirTarea(tarea);
                }catch (TareaExcepcion e){
                    System.err.printf(e.getMessage());
                }
                break;


            case "P":
                System.out.println("Introduce el lenguaje del programa");
                lenguaje = teclado.nextLine();
                System.out.println("Introduce el número el lineas de código");
                int numLineasCodigo = Integer.parseInt(teclado.nextLine());
                System.out.println("Introduce el número de módulos");
                int numModulos = Integer.parseInt(teclado.nextLine());
                Programa prog = new Programa(ident, horas, esInterno, lenguaje, numLineasCodigo, numModulos);
                tarea = new Tarea(tituloTarea,descripcion, prog, prioridad);
                try {
                    proyecto.añadirTarea(tarea);
                }catch (TareaExcepcion e){
                    System.err.printf(e.getMessage());
                }
                break;
        }
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
                System.out.println("No se ha encontrado el fichero");
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
