package practica1;

import java.util.Scanner;

public class EntradaSalida {

    Scanner  teclado;

    public EntradaSalida(){
        teclado = new Scanner(System.in);
    }
    public int menu() {
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

    public String leer(){
        String titulo = teclado.nextLine();
        return titulo;
    }
    public void mostrar(String texto){
        System.out.println(texto);
    }

}
