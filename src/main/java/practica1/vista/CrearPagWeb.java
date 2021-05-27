package practica1.vista;

import javax.swing.*;
import java.awt.*;

public class CrearPagWeb {

    JFrame ventana;

    JLabel lenguajeWeb = new JLabel("Introduce el lenguaje de la web");
    JLabel backend = new JLabel("Introduce el backend de la web");

    JTextField introducirLenguajeWeb = new JTextField(20);
    JTextField introducirBackend = new JTextField(20);

    JRadioButton si = new JRadioButton("Sí");
    JRadioButton no = new JRadioButton("no");

    public void ejecutar(){
        ventana = new JFrame();

        ButtonGroup esEstatica = new ButtonGroup();
        esEstatica.add(si);
        esEstatica.add(no);

        ventana.setLayout(new GridLayout(3,2));
        ventana.add(lenguajeWeb);
        ventana.add(introducirLenguajeWeb);
        ventana.add(backend);
        ventana.add(introducirBackend);
        ventana.add(si);
        ventana.add(no);

        ventana.pack();
        ventana.setVisible(true);
    }

}
