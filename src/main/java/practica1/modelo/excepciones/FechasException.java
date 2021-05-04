package practica1.modelo.excepciones;

public class FechasException extends RuntimeException{
    public FechasException(){
        System.out.println("La fecha de finalización es mas antigua que la de inicio");
    }
}
