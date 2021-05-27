package practica1.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class AñadirTarea {

    JFrame ventana;

    JLabel texto = new JLabel("Añadir una tarea");
    JLabel titulo = new JLabel("Introduce el título de la tarea:");
    JLabel identificador = new JLabel("Introduce el identificador de la tarea:");
    JLabel prioridad = new JLabel("Introducir la prioridad de la tarea:");
    JLabel descripcion = new JLabel("Introduce la descripción de la tarea");
    JLabel coste = new JLabel("Introducre el coste de la tarea");

    JTextField introducirTitulo = new JTextField(20);
    JTextField introducirIdentificador = new JTextField(20);
    JTextField introducirPrioridad = new JTextField(20);
    JTextField introducirCoste = new JTextField(20);
    JTextField introducirDescripcion = new JTextField(20);

    JRadioButton si = new JRadioButton("Sí");
    JRadioButton no = new JRadioButton("no");

    JRadioButton documento = new JRadioButton("Documentación");
    JRadioButton web = new JRadioButton("Web");
    JRadioButton programa = new JRadioButton("Programa");

    JRadioButton descuento = new JRadioButton("descuento");
    JRadioButton urgente = new JRadioButton("urgente");

    JButton siguiente;

    public void ejecutar() {

        ventana = new JFrame(" Añadir una tarea");

        JPanel superior = new JPanel();
        superior.add(texto);

        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new GridLayout(5, 2));
        panelTitulo.add(titulo);
        panelTitulo.add(introducirTitulo);
        panelTitulo.add(descripcion);
        panelTitulo.add(introducirDescripcion);
        panelTitulo.add(identificador);
        panelTitulo.add(introducirIdentificador);
        panelTitulo.add(prioridad);
        panelTitulo.add(introducirPrioridad);
        panelTitulo.add(coste);
        panelTitulo.add(introducirCoste);

        JPanel panelResultado = new JPanel();
        JLabel result = new JLabel("Introduce el tipo de resultado que deseas:");

        ButtonGroup resultado = new ButtonGroup();
        resultado.add(documento);
        resultado.add(web);
        resultado.add(programa);

        documento.addActionListener(new actionListener());
        web.addActionListener(new actionListener());
        programa.addActionListener(new actionListener());

        panelResultado.add(result);
        panelResultado.add(documento);
        panelResultado.add(web);
        panelResultado.add(programa);

        JPanel panelSouth = new JPanel();
        panelSouth.setLayout(new GridLayout(2, 1));
        JPanel panelInterno = new JPanel();//si es interno no debe salir facturación
        JLabel interno = new JLabel("Esta tarea es interna?");
        panelInterno.add(interno);
        ButtonGroup esInterno = new ButtonGroup();
        esInterno.add(si);
        esInterno.add(no);
        panelInterno.add(si);
        panelInterno.add(no);
        //ventana.add(panelInterno);

        JPanel panelFacturacion = new JPanel();//si es interno no debe salir esta pantalla
        panelFacturacion.setLayout(new GridLayout(1, 2));
        JLabel facturacion = new JLabel("Introduce el tipo de facturación");
        ButtonGroup esFacturacion = new ButtonGroup();
        esFacturacion.add(descuento);
        esFacturacion.add(urgente);
        panelFacturacion.add(facturacion);
        panelFacturacion.add(descuento);
        panelFacturacion.add(urgente);
        //ventana.add(panelFacturacion);
        panelSouth.add(panelInterno);
        panelSouth.add(panelFacturacion);

        ventana.add(panelTitulo, BorderLayout.NORTH);
        ventana.add(panelResultado, BorderLayout.CENTER);
        ventana.add(panelSouth, BorderLayout.SOUTH);

        ventana.pack();
        ventana.setVisible(true);

    }

    public class actionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            JRadioButton boton = (JRadioButton) actionEvent.getSource();
            String resultado = boton.getText();
            switch (resultado) {
                case "Documentación":
                    System.out.println("hola patato");

                    break;
                case "Web":
                    System.out.println("hola patato1");

                    break;
                case "Programa":

                    break;
                case "Siguiente":

                    break;
            }
        }
    }
}
