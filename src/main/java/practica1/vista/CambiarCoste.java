package practica1.vista;

import javax.swing.*;
import java.awt.*;

public class CambiarCoste {

    JLabel texto = new JLabel("Cambiar coste de la tarea");
    JLabel coste = new JLabel("Introduce el coste:");
    JTextField introducirCoste = new JTextField(20);

    public void ejecutar(){

        JFrame ventana= new JFrame(" Cambiar coste");

        JPanel superior = new JPanel();
        superior.add(texto);

        JPanel centro = new JPanel();
        centro.setLayout(new GridLayout(1,2));
        centro.add(coste);
        centro.add(introducirCoste);

        ventana.add(superior, BorderLayout.PAGE_START);
        ventana.add(centro, BorderLayout.CENTER);

        ventana.pack();
        ventana.setVisible(true);

    }
    public String getCoste(){return introducirCoste.getText();}
}
