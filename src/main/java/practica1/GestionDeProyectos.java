package practica1;

import java.util.Scanner;
import java.util.Date;
public class GestionDeProyectos {


    public static int menu(Scanner teclado) {
        int opcion;
        System.out.println("\n\n");
        System.out.println("=====================================================");
        System.out.println("============            MENU        =================");
        System.out.println("=====================================================");
        System.out.println("0. Salir");
        System.out.println("1.Dar de alta a las personas que trabajan en el proyecto");
        System.out.println("2.Dar de alta las tareas con sus datos");
        System.out.println("3.Marcar una tarea como finalizada");
        System.out.println("4.Introducir o eliminar una persona de una tarea");
        System.out.println("5.Listar las personas asignadas a un proyecto");
        System.out.println("6.Listar las tareas de un proyecto.");
        do {
            System.out.print("\nElige una opcion (0..6): ");
            opcion = teclado.nextInt();
        } while ( (opcion<0) || (opcion>7) );
        teclado.nextLine(); // Elimina retorno de carro del buffer de entrada
        return opcion;
    }


    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        EntradaSalida EntSal = new EntradaSalida();
        System.out.print("Introduce el nombre del proyecto: ");
        String titulo = EntSal.leer();
        Proyecto proyecto = new Proyecto(titulo);
        int opcion;
        do {
            opcion = menu(teclado);
            switch (opcion) {
                case 0:
                    EntSal.mostrar("Cerramos el gestor");
                    break;
                case 1:
                    EntSal.mostrar("Introduce el nombre de la persona");
                    String nombre = EntSal.leer();
                    EntSal.mostrar("Introduce el correo de la persona: ");
                    String correo = EntSal.leer();
                    Persona persona = new Persona(nombre, correo);
                    proyecto.añadirPersona(persona);
                    break;
                case 2:
                    Date fecha= new Date();
                    EntSal.mostrar("Introduce el título de la tarea");
                    String tituloTarea =EntSal.leer();
                    EntSal.mostrar("Introduce el tipo de resultado: D para documentación, W para web, P para programa: ");
                    String tipoResultado= EntSal.leer();
                    if(tipoResultado.equals("D")){
                        Documentacion documento =new Documentacion();
                        Tarea tarea =new Tarea(tituloTarea,fecha.getDay(),documento );
                        proyecto.añadirTarea(tarea);
                    }
                    else if(tipoResultado.equals("W")){
                        PagWeb web = new PagWeb();
                        Tarea tarea =new Tarea(tituloTarea,fecha.getDay(), web);
                        proyecto.añadirTarea(tarea);

                    }
                    else {
                        Programa prog = new Programa();
                        Tarea tarea = new Tarea(tituloTarea, fecha.getDay(), prog);
                        proyecto.añadirTarea(tarea);
                    }
                    break;
                case 3:
                    EntSal.mostrar("Introduce el título de la tarea:");
                    String Finalizada= EntSal.leer();
                    Boolean hecha = proyecto.finalizarTarea(Finalizada);
                    if (hecha){
                        EntSal.mostrar("Tarea Finalizada");
                    }
                    else{
                        EntSal.mostrar("No se encuentra el titulo de la tarea");
                    }
                    break;
                case 4:
                    EntSal.mostrar("Introudce el nombre de la persona");
                    String nombrePersona= EntSal.leer();
                    EntSal.mostrar("Introduce el titulo de la tarea donde la quieras añadir o eliminar:");
                    String tituloAñadirEliminar= EntSal.leer();
            }
        }while (opcion != 0);

    }

}
