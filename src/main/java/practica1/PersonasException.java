package practica1;

public class PersonasException extends RuntimeException {
    public PersonasException(){
        System.out.println("La persona ya esta en este proyecto");
    }
}
