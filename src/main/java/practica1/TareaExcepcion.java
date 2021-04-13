package practica1;

public class TareaExcepcion extends RuntimeException{
    public TareaExcepcion(){
        System.out.println("La tarea ya existe en el proyecto actual");
    }
}
