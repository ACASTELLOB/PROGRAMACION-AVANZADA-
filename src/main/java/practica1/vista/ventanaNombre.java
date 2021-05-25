package practica1.vista;

import practica1.modelo.Proyecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ventanaNombre {

    JFrame ventana;
    JTextField nombreProyecto;

    public void ejecutar(){
        ventana = new JFrame("Crear proyecto nuevo");
        Container contenedor = ventana.getContentPane();

        nombreProyecto = new JTextField(20);
        JLabel nombreLabel = new JLabel("Nombre del proyecto: ");
        JButton aceptar = new JButton("Aceptar");
        aceptar.addActionListener(new Escuchador());

        contenedor.setLayout(new FlowLayout());
        contenedor.add(nombreLabel);
        contenedor.add(nombreProyecto);
        contenedor.add(aceptar);

        ventana.pack();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }

    private class Escuchador implements ActionListener {

        public void actionPerformed(ActionEvent actionEvent) {
            Proyecto proyecto = new Proyecto(nombreProyecto.getText());
            ventanaPrincipal ventanaP = new ventanaPrincipal(proyecto);
            ventanaP.ejecutar();
            ventana.dispose();
        }
    }
}
