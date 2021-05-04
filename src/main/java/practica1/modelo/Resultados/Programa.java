package practica1.modelo.Resultados;

public class Programa extends Resultado{
    String lenguaje;
    int numLineasCodigo;
    int numModulos;

    public Programa(String identificador, int horas, boolean interno, String lenguaje, int numLineasCodigo, int numModulos) {
        super(identificador, horas, interno);
        this.lenguaje = lenguaje;
        this.numLineasCodigo = numLineasCodigo;
        this.numModulos = numModulos;
    }

    @Override
    public String toString() {
        return "Resultado:\n" + "identificador=" + identificador + '\n' + "horas=" + horas + "\n" + "interno=" + interno + "\n" + "lenguaje=" + lenguaje + '\n' + "Num. Lineas de codigo=" + numLineasCodigo + "\n" +"Num. de Modulos=" + numModulos;
    }
}
