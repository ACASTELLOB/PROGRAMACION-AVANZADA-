package practica1.modelo.facturación;

public class ConsumoInterno implements Facturacion {

    @Override
    public double calculoFacturación(double coste) {
        return coste;
    }
}
