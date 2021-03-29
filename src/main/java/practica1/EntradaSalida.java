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
    public int leerInt(){
        String titulo = teclado.nextLine();
        int resultado= Integer.parseInt(titulo);
        return resultado;
    }
    public void mostrar(String texto){
        System.out.println(texto);
    }
    public void cerrarGestor(){System.out.println("Cerramos el gestor");}
    public String[] añadirPer(){
        String[] res = new String[2];
        System.out.println("Introduce el nombre de la persona");
        String nombre = leer();
        res[0]=nombre;
        System.out.println("Introduce el correo de la persona: ");
        String correo = leer();
        res[1]=correo;
        return res;

    }


    public String[] añadirTar(){
        System.out.println("Introduce el título de la tarea");
        String tituloTarea =leer();
        System.out.println("Introduce el tipo de resultado: D para documentación, W para web, P para programa: ");
        String tipoResultado= leer();
        System.out.println("Introduce la prioridad de la tarea");
        int prioridad=leerInt();
        if(tipoResultado.equals("D")){


            System.out.println("Introduce el identificador del documento");
            String ident=leer();

            System.out.println("Introduce las horas");
            int horas=leerInt();
            System.out.println("Introduce el número de páginas");
            int pag= leerInt();
            System.out.println("Introduce el espacio en disco para tu documento");
            int esp=leerInt();
            System.out.println("Introduce el formato del documento");
            String format= leer();
            System.out.println("Quieres que sea interno el resultado si es que sí, escribe S, sino escribe N");
            String interno=leer();
            boolean esInterno=false;
            if (interno.equals("S")){
                esInterno=true;
            }
            Documentacion documento =new Documentacion(ident, horas, esInterno, format,pag,esp);
            Tarea tarea =new Tarea(tituloTarea,documento, prioridad);

        }
        else if(tipoResultado.equals("W")){

            System.out.println("Introduce el identificador del documento");
            String ident=leer();

            System.out.println("Introduce las horas");
            int horas=leerInt();
            System.out.println("Introduce el número de páginas");
            int pag= leerInt();
            System.out.println("Introduce el espacio en disco para tu documento");
            int esp=leerInt();
            System.out.println("Introduce el formato del documento");
            String format= leer();
            System.out.println("Quieres que sea interno el resultado si es que sí, escribe S, sino escribe N");
            String interno=leer();
            boolean esInterno=false;
            if (interno.equals("S")){
                esInterno=true;
            }
            Documentacion documento =new Documentacion(ident, horas, esInterno, format,pag,esp);


            PagWeb web = new PagWeb();
            Tarea tarea =new Tarea(tituloTarea,web,prioridad);


        }
        else {
            Programa prog = new Programa();

            Tarea tarea = new Tarea(tituloTarea,  prog, prioridad);

        }

        return tarea;
    }

}
