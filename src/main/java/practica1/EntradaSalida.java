package practica1;

import java.util.Scanner;

public class EntradaSalida {

    Scanner teclado;

    public EntradaSalida(){
        teclado = new new Scanner(System.in);
    }

    public String leer(){
        String titulo = teclado.nextLine();
        return titulo;
    }
    public void mostrar(String texto){
        System.out.println(texto);
    }

}
