package practica1.modelo.Resultados;

import java.io.Serializable;

public class Resultado implements Serializable {
    String identificador;
    int horas;
    boolean interno;

    public Resultado(String identificador, int horas, boolean interno) {
        this.identificador = identificador;
        this.horas = horas;
        this.interno = interno;
    }

}
