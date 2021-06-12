package practica1.vista;

import practica1.controlador.Controlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearPagWeb {

    Controlador controlador;

    JFrame ventana;

    JLabel lenguajeWeb = new JLabel("Introduce el lenguaje de la web");
    JLabel backend = new JLabel("Introduce el backend de la web");

    JTextField introducirLenguajeWeb = new JTextField(20);
    JTextField introducirBackend = new JTextField(20);

    JRadioButton si = new JRadioButton("Sí");
    JRadioButton no = new JRadioButton("no");

    JButton aceptar;

    public void ejecutar(Controlador controlador){
        this.controlador = controlador;
        ventana = new JFrame();

        aceptar = new JButton("Aceptar");

        ButtonGroup esEstatica = new ButtonGroup();
        esEstatica.add(si);
        esEstatica.add(no);

        ventana.setLayout(new GridLayout(4,2));
        ventana.add(lenguajeWeb);
        ventana.add(introducirLenguajeWeb);
        ventana.add(backend);
        ventana.add(introducirBackend);
        ventana.add(si);
        ventana.add(no);
        ventana.add(aceptar);

        aceptar.addActionListener(new actionListener());

        ventana.pack();
        ventana.setVisible(true);
    }

    public String getLenguajeWeb(){
        return introducirLenguajeWeb.getText();
    }
    public String getBackend(){
        return introducirBackend.getText();
    }
    public Boolean getEstatica(){
        if (si.isSelected()) return true;
        else return false;
    }

    class actionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            controlador.añadirTarea();
            ventana.dispose();
        }
    }
}
