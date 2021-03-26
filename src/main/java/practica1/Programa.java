package practica1;

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
}
