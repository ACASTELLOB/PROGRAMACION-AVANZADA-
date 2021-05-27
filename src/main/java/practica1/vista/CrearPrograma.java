package practica1.vista;

import javax.swing.*;
import java.awt.*;

public class CrearPrograma {

    JFrame ventana;

    JLabel lenguajeProg = new JLabel("Introduce el Lenguaje del programa");
    JLabel numLineas = new JLabel("Introduce el numero de líneas del programa");
    JLabel modulos = new JLabel("Introduce el numero de modulos");

    JTextField introducirLenguajeProg = new JTextField(20);
    JTextField introducirNumLineas = new JTextField(20);
    JTextField introducirModulos = new JTextField(20);

    public void ejecutar(){
        ventana = new JFrame();

        ventana.add(lenguajeProg);
        ventana.add(introducirLenguajeProg);
        ventana.add(modulos);
        ventana.add(introducirModulos);
        ventana.add(numLineas);
        ventana.add(introducirNumLineas);

        ventana.pack();
        ventana.setVisible(true);
    }
}
