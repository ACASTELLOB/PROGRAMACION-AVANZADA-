package practica1.vista;

import practica1.controlador.Controlador;

import practica1.modelo.Modelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AñadirPersona implements  Vista{
    private Controlador controlador;
    private Modelo modelo;

    JLabel texto = new JLabel("Añadir una persona");
    JLabel nombre = new JLabel("Introduce el nombre:");
    JLabel correo = new JLabel("Introduce el correo:");
    JButton enviar = new JButton("Enviar");
    JTextField introducirNombre = new JTextField(20);
    JTextField introducirCorreo = new JTextField(20);

    public void ejecutar(Controlador controlador){
        this.controlador = controlador;



        JFrame ventana= new JFrame(" Añadir una persona");


        JPanel superior = new JPanel();
        superior.add(texto);


        JPanel centro = new JPanel();
        centro.setLayout(new GridLayout(2,2));
        centro.add(nombre);
        centro.add(introducirNombre);
        centro.add(correo);
        centro.add(introducirCorreo);

        JPanel inferior =new JPanel();
        inferior.add(enviar);



        ventana.add(superior, BorderLayout.PAGE_START);
        ventana.add(centro, BorderLayout.CENTER);
        ventana.add(inferior, BorderLayout.PAGE_END);
        ventana.pack();
        ventana.setVisible(true);

        final ActionListener añadirPersona = e -> controlador.añadirPersona();

        introducirNombre.addActionListener(e -> introducirNombre.requestFocusInWindow());
        introducirCorreo.addActionListener(añadirPersona);
        enviar.addActionListener(añadirPersona);


    }

    @Override
    public void setControlador(Controlador controlador) {
        this.controlador=controlador;
    }

    @Override
    public void setModelo(Modelo modelo) {
        this.modelo=modelo;
    }

    public String getNombre() { return introducirNombre.getText(); }

    public String getCorreo(){ return introducirCorreo.getText(); }
}
