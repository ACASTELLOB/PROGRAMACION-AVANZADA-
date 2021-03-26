package practica1;

public class PagWeb extends Resultado{
    Boolean estatica;
    String lenguaje;
    String backEnd;

    public PagWeb(String identificador, int horas, boolean interno, Boolean estatica, String lenguaje, String backEnd) {
        super(identificador, horas, interno);
        this.estatica = estatica;
        this.lenguaje = lenguaje;
        this.backEnd = backEnd;
    }
}
