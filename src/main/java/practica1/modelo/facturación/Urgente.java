package practica1.modelo.facturación;

public class Urgente implements Facturacion {

    @Override
    public double calculoFacturación(double coste) {
        return coste * 1.25;
    }
}
