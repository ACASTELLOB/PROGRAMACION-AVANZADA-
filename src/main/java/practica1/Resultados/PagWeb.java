package practica1.Resultados;

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

    @Override
    public String toString() {
        return "Resultado:\n" + "identificador=" + identificador + '\n' + "horas=" + horas + "\n" + "interno=" + interno + "\n" + "estatica=" + estatica + '\n' + "lenguaje=" + lenguaje + "\n" + "backEnd=" + backEnd;
    }
}
