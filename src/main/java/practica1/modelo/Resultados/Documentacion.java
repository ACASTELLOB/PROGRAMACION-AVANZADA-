package practica1.modelo.Resultados;

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

    @Override
    public String toString() {
        return "Resultado:\n" + "identificador=" + identificador + '\n' + "horas=" + horas + "\n" + "interno=" + interno + "\n" + "formato=" + formato + '\n' + "Paginas=" + numPaginas + "\n" + "Espacio en disco=" + espacioDisco;
    }
}
