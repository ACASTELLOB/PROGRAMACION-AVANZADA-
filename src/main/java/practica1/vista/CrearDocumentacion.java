package practica1.vista;

import practica1.controlador.Controlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearDocumentacion {

    Controlador controlador;

    JFrame ventana;

    JLabel formato = new JLabel("Introduce el formato del documento");
    JLabel espacioEnDisco = new JLabel("Introduce el número de páginas");
    JLabel numPag = new JLabel("Introduce el espacio en disco de tu documento");

    JTextField introducirFormato = new JTextField(20);
    JTextField introducirEspacioEnDisco = new JTextField(20);
    JTextField introducirNumPag = new JTextField(20);

    JButton aceptar;

    public void ejecutar(Controlador controlador){
        this.controlador = controlador;
        ventana = new JFrame();

        aceptar = new JButton("Aceptar");

        ventana.setLayout(new GridLayout(4, 2));
        ventana.add(formato);
        ventana.add(introducirFormato);
        ventana.add(numPag);
        ventana.add(introducirNumPag);
        ventana.add(espacioEnDisco);
        ventana.add(introducirEspacioEnDisco);
        ventana.add(aceptar);

        aceptar.addActionListener(new actionListener());

        ventana.pack();
        ventana.setVisible(true);
    }

    public String getFormato(){ return introducirFormato.getText(); }
    public String getNumPag(){
        return introducirNumPag.getText();
    }
    public String getEspDisc(){
        return introducirEspacioEnDisco.getText();
    }

    class actionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            controlador.añadirTarea();
            ventana.dispose();
        }
    }
}
