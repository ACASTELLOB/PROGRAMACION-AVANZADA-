package practica1.vista;

import practica1.controlador.Controlador;
import practica1.modelo.Modelo;

public interface Vista {

    void setControlador(Controlador controlador);
    void setModelo(Modelo modelo);

    void ejecutar();

    String getNombre();
    String getCorreo();

    void actualizarVista();

}
