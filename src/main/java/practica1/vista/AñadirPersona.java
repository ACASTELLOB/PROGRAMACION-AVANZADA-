package practica1.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AñadirPersona {

    JLabel texto = new JLabel("Añadir una persona");
    JLabel nombre = new JLabel("Introduce el nombre:");
    JLabel correo = new JLabel("Introduce el correo:");
    JTextField introducirNombre = new JTextField(20);
    JTextField introducirCorreo = new JTextField(20);
    public void ejecutar(){
        JFrame ventana= new JFrame(" Añadir una persona");


        JPanel superior = new JPanel();
        superior.add(texto);


        JPanel centro = new JPanel();
        centro.setLayout(new GridLayout(2,2));
        centro.add(nombre);
        centro.add(introducirNombre);
        centro.add(correo);
        centro.add(introducirCorreo);


        ventana.add(superior, BorderLayout.PAGE_START);
        ventana.add(centro, BorderLayout.CENTER);
        ventana.pack();
        ventana.setVisible(true);
    }





    private class Escuchador implements ActionListener {

        public void actionPerformed(ActionEvent actionEvent) {
            JButton boton = (JButton) actionEvent.getSource();
            String texto = boton.getText();
            if (texto.equals("Cargar")){
                System.out.println("Soy el boton cargar");
            }else{
                System.out.println("Soy el boton nuevo");
            }
        }

    }
}
