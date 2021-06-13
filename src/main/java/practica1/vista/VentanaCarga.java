package practica1.vista;

import practica1.controlador.Controlador;
import practica1.controlador.ControladorProyectos;
import practica1.modelo.Proyecto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class VentanaCarga {

    JFrame ventana;
    JLabel texto = new JLabel("Cargar un proyecto?");
    JButton cargar = new JButton("Cargar");
    JButton nuevo = new JButton("Nuevo");

    public void ejecutar(){
        ventana = new JFrame("Cargar proyecto");
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
                try {
                    FileInputStream fis = new FileInputStream("proyecto.bin");
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    Proyecto proyecto = (Proyecto) ois.readObject();
                    ois.close();

                    Controlador controlador = new ControladorProyectos();
                    Vista ventanaP = new VentanaPrincipal();

                    controlador.setModelo(proyecto);
                    controlador.setVista(ventanaP);

                    ventanaP.setControlador(controlador);
                    ventanaP.setModelo(proyecto);

                    proyecto.setVista(ventanaP);

                    ventanaP.ejecutar();
                    ventana.dispose();
                } catch (IOException e) {
                    System.out.println("No se ha encontrado el fichero, debes crear uno nuevo:");
                }catch (ClassNotFoundException e){
                    System.out.println("Error al cargar el proyecto");
                }
            }else{
                VentanaNombre ventanaN = new VentanaNombre();
                ventanaN.ejecutar();
                ventana.dispose();
            }
        }
    }

}
