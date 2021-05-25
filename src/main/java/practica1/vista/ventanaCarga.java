package practica1.vista;

import practica1.modelo.Proyecto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ventanaCarga{

    JLabel texto = new JLabel("Cargar un proyecto?");
    JButton cargar = new JButton("Cargar");
    JButton nuevo = new JButton("Nuevo");

    public void ejecutar(){
        JFrame ventana = new JFrame("Cargar proyecto");
        Escuchador evento = new Escuchador();

        cargar.addActionListener(evento);
        nuevo.addActionListener(evento);

        JPanel panel = new JPanel();
        panel.add(texto);
        panel.add(cargar);
        panel.add(nuevo);

        ventana.add(panel);
        ventana.pack();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);

    }

    private class Escuchador implements ActionListener{

        public void actionPerformed(ActionEvent actionEvent) {
            JButton boton = (JButton) actionEvent.getSource();
            String texto = boton.getText();
            if (texto.equals("Cargar")){
                System.out.println("Soy el boton cargar");
            }else{
                Proyecto proyecto = new Proyecto("Pruebas");
                ventanaPrincipal ventanaP = new ventanaPrincipal(proyecto);
                ventanaP.ejecutar();
            }
        }

    }

}
