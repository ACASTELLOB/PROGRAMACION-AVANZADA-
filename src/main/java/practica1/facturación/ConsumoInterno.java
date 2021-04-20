package practica1.facturación;

public class ConsumoInterno implements Facturacion {

    @Override
    public double calculoFacturación(double coste) {
        return coste;
    }
}
