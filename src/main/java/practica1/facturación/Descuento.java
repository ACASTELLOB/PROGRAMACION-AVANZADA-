package practica1.facturación;

public class Descuento implements Facturacion {

    @Override
    public double calculoFacturación(double coste) {
        return coste * 0.75;
    }
}
