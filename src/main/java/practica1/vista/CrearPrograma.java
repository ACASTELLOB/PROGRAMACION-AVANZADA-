package practica1.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearPrograma {

    JFrame ventana;

    JLabel lenguajeProg = new JLabel("Introduce el Lenguaje del programa");
    JLabel numLineas = new JLabel("Introduce el numero de líneas del programa");
    JLabel modulos = new JLabel("Introduce el numero de modulos");

    JTextField introducirLenguajeProg = new JTextField(20);
    JTextField introducirNumLineas = new JTextField(20);
    JTextField introducirModulos = new JTextField(20);

    JButton aceptar;

    public void ejecutar(){
        ventana = new JFrame();

        aceptar = new JButton("Aceptar");

        ventana.setLayout(new GridLayout(4, 2));
        ventana.add(lenguajeProg);
        ventana.add(introducirLenguajeProg);
        ventana.add(modulos);
        ventana.add(introducirModulos);
        ventana.add(numLineas);
        ventana.add(introducirNumLineas);
        ventana.add(aceptar);

        ventana.pack();
        ventana.setVisible(true);
    }

    public String getNumLineasCodigo(){
        return introducirNumLineas.getText();
    }
    public String getLenguajeProg(){
        return introducirLenguajeProg.getText();
    }
    public String getNumModulos(){
        return introducirModulos.getText();
    }

    class actionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {

        }
    }
}
