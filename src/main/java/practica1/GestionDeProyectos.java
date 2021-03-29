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

        System.out.print("Introduce el nombre del proyecto: ");
        String titulo = teclado.nextLine();
        Proyecto proyecto = new Proyecto(titulo);
        int opcion;
        do {
            opcion = menu(teclado);
            switch (opcion) {
                case 0:
                    System.out.println("Cerramos el gestor");
                    break;
                case 1:
                    System.out.println("Introduce el nombre de la persona");
                    String nombre = teclado.nextLine();
                    System.out.println("Introduce el correo de la persona: ");
                    String correo = teclado.nextLine();
                    Persona persona = new Persona(nombre, correo);
                    proyecto.añadirPersona(persona);
                    break;
                case 2:
                    System.out.println("Introduce el título de la tarea");
                    String tituloTarea =teclado.nextLine();
                    System.out.println("Introduce el tipo de resultado: D para documentación, W para web, P para programa: ");
                    String tipoResultado= teclado.nextLine();
                    System.out.println("Introduce la prioridad de la tarea");
                    int prioridad=Integer.parseInt(teclado.nextLine());
                    System.out.println("Introduce el identificador del documento");
                    String ident=teclado.nextLine();
                    System.out.println("Introduce las horas");
                    int horas=Integer.parseInt(teclado.nextLine());
                    System.out.println("Quieres que sea interno el resultado si es que sí, escribe S, sino escribe N");
                    String interno=teclado.nextLine();
                    boolean esInterno=false;
                    if (interno.equals("S")){
                        esInterno=true;
                    }

                    if(tipoResultado.equals("D")){

                        System.out.println("Introduce el formato del resultado");
                        String format= teclado.nextLine();
                        System.out.println("Introduce el número de páginas del resultado");
                        int pag= Integer.parseInt(teclado.nextLine());
                        System.out.println("Introduce el espacio en disco para tu resultado");
                        int esp=Integer.parseInt(teclado.nextLine());
                        Documentacion documento =new Documentacion(ident,horas,esInterno,format,pag,esp );
                        Tarea tarea =new Tarea(tituloTarea,documento, prioridad);
                        proyecto.añadirTarea(tarea);
                    }
                    else if(tipoResultado.equals("W")){
                        System.out.println("Introduce el lenguaje de la web");
                        String lenguaje= teclado.nextLine();
                        System.out.println("Introduce el backend de la web");
                        String backend= teclado.nextLine();
                        System.out.println("Quieres que sea estática la web si es que sí, escribe S, sino escribe N");
                        String estatica=teclado.nextLine();
                        boolean esEstatica=false;
                        if (estatica.equals("S")){
                            esEstatica=true;
                        }
                        PagWeb web = new PagWeb(ident, horas, esInterno,  esEstatica,lenguaje,backend);
                        Tarea tarea =new Tarea(tituloTarea,web,prioridad);
                        proyecto.añadirTarea(tarea);

                    }
                    else {
                        System.out.println("Introduce el lenguaje del programa");
                        String lenguaje= teclado.nextLine();
                        System.out.println("Introduce el número el lineas de código");
                        int numLineasCodigo= Integer.parseInt(teclado.nextLine());
                        System.out.println("Introduce el número de módulos");
                        int numModulos=Integer.parseInt(teclado.nextLine());
                        Programa prog = new Programa(ident, horas, esInterno, lenguaje,numLineasCodigo, numModulos);
                        Tarea tarea = new Tarea(tituloTarea,  prog, prioridad);
                        proyecto.añadirTarea(tarea);
                    }
                    break;
                case 3:
                    System.out.println("Introduce el título de la tarea:");
                    String Finalizada= teclado.nextLine();
                    Boolean hecha = proyecto.finalizarTarea(Finalizada);
                    if (hecha){
                        System.out.println("Tarea Finalizada");
                    }
                    else{
                        System.out.println("No se encuentra el titulo de la tarea");
                    }
                    break;
                case 4:
                    System.out.println("Introudce el nombre de la persona");
                    String nombrePersona= teclado.nextLine();
                    System.out.println("Introduce el titulo de la tarea donde la quieras añadir o eliminar:");
                    String tituloProyecto= teclado.nextLine();
                    System.out.println(proyecto.añadirEliminarPersona(nombrePersona,tituloProyecto));
                    break;
                case 5:
                    for(Persona elem:proyecto.personas){
                        System.out.println(elem.toString());
                    }
                case 6:
                    for(Tarea elem:proyecto.tareas){
                        System.out.println(elem.toString());
                    }

            }
        }while (opcion != 0);

    }

}
