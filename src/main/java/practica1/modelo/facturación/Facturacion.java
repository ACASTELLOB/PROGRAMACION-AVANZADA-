package practica1.modelo.facturación;

import java.io.Serializable;

public interface Facturacion extends Serializable {
    double calculoFacturación(double coste);
}
