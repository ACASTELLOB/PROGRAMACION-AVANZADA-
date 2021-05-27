package practica1.vista;

import practica1.controlador.Controlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CambiarCoste {

    JFrame ventana;
    Controlador controlador;
    JLabel texto = new JLabel("Cambiar coste de la tarea");
    JLabel coste = new JLabel("Introduce el coste:");
    JTextField introducirCoste = new JTextField(20);
    JButton aceptar;

    public void ejecutar(Controlador controlador){
        this.controlador = controlador;

        ventana= new JFrame(" Cambiar coste");
        aceptar = new JButton("Aceptar");

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

    public class Escuchador implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            controlador.cambiarCoste();
            ventana.dispose();
        }
    }
}
