package practica1;

public class Documentacion extends Resultado {
    String formato;
    int numPaginas;
    int espacioDisco;

    public Documentacion(String identificador, int horas, boolean interno, String formato, int numPaginas, int espacioDisco) {
        super(identificador, horas, interno);
        this.formato = formato;
        this.numPaginas = numPaginas;
        this.espacioDisco = espacioDisco;
    }
}
