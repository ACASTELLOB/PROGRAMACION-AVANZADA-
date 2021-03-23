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
            System.out.print("\nElige una opcion (0..7): ");
            opcion = teclado.nextInt();
        } while ( (opcion<0) || (opcion>7) );
        teclado.nextLine(); // Elimina retorno de carro del buffer de entrada
        return opcion;
    }


    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce el nombre del proyecto: ");
        String titulo = teclado.nextLine();
        Proyecto proyecto = new Proyecto(titulo);
        int opcion;
        do {
            opcion = menu(teclado);
            switch (opcion) {
                case 0:
                    System.out.println(" Cerramos el gestor");
                    break;
                case 1:
                    System.out.println("Introduce el nombre de la persona: ");
                    String nombre = teclado.nextLine();
                    System.out.println("Introduce el correo de la persona: ");
                    String correo = teclado.nextLine();
                    Persona persona = new Persona(nombre, correo);
                    proyecto.añadirPersona(persona);
                    break;
                case 2:
                    Date fecha= new Date();
                    System.out.print("Introduce el título de la tarea");
                    String tituloTarea =teclado.nextLine();
                    System.out.println("Introduce el tipo de resultado: D para documentación, W para web, P para programa: ");
                    String tipoResultado= teclado.nextLine();
                    if(tipoResultado.equals("D")){
                        Documentacion documento =new Documentacion();
                        Tarea tarea =new Tarea(tituloTarea,fecha.getDay(),documento );
                    }
                    else if(tipoResultado.equals("W")){
                        PagWeb web = new PagWeb();
                        Tarea tarea =new Tarea(tituloTarea,fecha.getDay(), web);
                    }
                    else{
                        Programa prog = new Programa();
                        Tarea tarea =new Tarea(tituloTarea,fecha.getDay(), prog);
                    }







            }
        }while (opcion != 0);

    }

}
