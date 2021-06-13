package practica1.vista;

import practica1.controlador.Controlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class CambiarCoste implements Serializable {

    JFrame ventana;
    Controlador controlador;
    JLabel coste = new JLabel("Introduce el coste:");
    JTextField introducirCoste = new JTextField(20);
    JButton aceptar;

    public void ejecutar(Controlador controlador){
        this.controlador = controlador;

        ventana= new JFrame(" Cambiar coste");
        aceptar = new JButton("Aceptar");
        aceptar.addActionListener(new Escuchador());

        JPanel superior = new JPanel();

        JPanel centro = new JPanel();
        centro.setLayout(new GridLayout(1,3));
        centro.add(coste);
        centro.add(introducirCoste);
        centro.add(aceptar);

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
