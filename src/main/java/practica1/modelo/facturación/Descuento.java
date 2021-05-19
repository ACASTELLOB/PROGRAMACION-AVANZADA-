package practica1.modelo.facturación;

public class Descuento implements Facturacion {

    double descuento=0.75;
    @Override
    public double calculoFacturación(double coste) {
        return coste * descuento;
    }
}
