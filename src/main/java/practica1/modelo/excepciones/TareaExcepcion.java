package practica1.modelo.excepciones;

public class TareaExcepcion extends RuntimeException{
    public TareaExcepcion(String mensaje){
        super(mensaje);
    }
}
