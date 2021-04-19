package practica1.excepciones;

public class PersonasException extends RuntimeException {
    public PersonasException(String mensaje){
        System.out.println(mensaje);
    }
}
