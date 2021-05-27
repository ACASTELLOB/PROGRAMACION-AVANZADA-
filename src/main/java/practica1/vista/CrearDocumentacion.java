package practica1.vista;

import javax.swing.*;
import java.awt.*;

public class CrearDocumentacion {

    JFrame ventana;

    JLabel formato = new JLabel("Introduce el formato del documento");
    JLabel espacioEnDisco = new JLabel("Introduce el espacioEnDisco del documento");
    JLabel numPag = new JLabel("Introduce el espacio en disco de tu documento");

    JTextField introducirFormato = new JTextField(20);
    JTextField introducirEspacioEnDisco = new JTextField(20);
    JTextField introducirNumPag = new JTextField(20);

    public void ejecutar(){
        ventana = new JFrame();

        ventana.setLayout(new GridLayout(3, 2));
        ventana.add(formato);
        ventana.add(introducirFormato);
        ventana.add(numPag);
        ventana.add(introducirNumPag);
        ventana.add(espacioEnDisco);
        ventana.add(introducirEspacioEnDisco);

        ventana.pack();
        ventana.setVisible(true);
    }
}
