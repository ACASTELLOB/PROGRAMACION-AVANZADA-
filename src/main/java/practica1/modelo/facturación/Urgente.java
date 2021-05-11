package practica1.modelo.facturación;

public class Urgente implements Facturacion {

    double descuento=1.25;

    @Override
    public double calculoFacturación(double coste) {
        return coste * descuento;
    }
}
