package practica1;

import java.util.Scanner;
public class GestionDeProyectos {


    public static int menu(Scanner teclado) {
        int opcion;
        System.out.println("\n\n");
        System.out.println("=====================================================");
        System.out.println("============            MENU        =================");
        System.out.println("=====================================================");
        System.out.println("0. Salir");
        System.out.println("1.Crear proyecto");
        System.out.println("2.Dar de alta a las personas que trabajan en el proyecto");
        System.out.println("3.Dar de alta las tareas con sus datos");
        System.out.println("4.Marcar una tarea como finalizada");
        System.out.println("5.Introducir o eliminar una persona de una tarea");
        System.out.println("6.Listar las personas asignadas a un proyecto");
        System.out.println("7.Listar las tareas de un proyecto.");
        do {
            System.out.print("\nElige una opcion (0..7): ");
            opcion = teclado.nextInt();
        } while ( (opcion<0) || (opcion>7) );
        teclado.nextLine(); // Elimina retorno de carro del buffer de entrada
        return opcion;
    }


    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        int opcion;
        do {
            opcion = menu(teclado);
            switch (opcion) {
                case 0:
                    System.out.println(" Cerramos el gestor");
                    break;
                case 1:
                    System.out.print("Introduce el nombre del proyecto: ");
                    String titulo = teclado.nextLine();
                    Proyecto proyecto = new Proyecto(titulo);
                case 2:




            }
        }while (opcion != 0);

    }

}
