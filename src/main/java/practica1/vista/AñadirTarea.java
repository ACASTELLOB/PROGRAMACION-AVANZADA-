package practica1.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class AñadirTarea {

    JFrame ventana;

    JPanel panelWeb;
    JPanel panelDocumento;
    JPanel panelPrograma;
    JPanel panelCentral;

    JLabel texto = new JLabel("Añadir una tarea");
    JLabel titulo = new JLabel("Introduce el título de la tarea:");
    JLabel identificador = new JLabel("Introduce el identificador de la tarea:");
    JLabel prioridad = new JLabel("Introducir la prioridad de la tarea:");
    JLabel descripcion = new JLabel("Introduce la descripción de la tarea");
    JLabel coste = new JLabel("Introducre el coste de la tarea");

    JLabel formato = new JLabel("Introduce el formato del documento");
    JLabel espacioEnDisco = new JLabel("Introduce el espacioEnDisco del documento");
    JLabel numPag = new JLabel("Introduce el espacio en disco de tu documento");

    JLabel lenguajeWeb = new JLabel("Introduce el lenguaje de la web");
    JLabel backend = new JLabel("Introduce el backend de la web");

    JLabel lenguajeProg = new JLabel("Introduce el Lenguaje del programa");
    JLabel numLineas = new JLabel("Introduce el numero de líneas del programa");
    JLabel modulos = new JLabel("Introduce el numero de modulos");

    JTextField introducirTitulo = new JTextField(20);
    JTextField introducirIdentificador = new JTextField(20);
    JTextField introducirPrioridad = new JTextField(20);
    JTextField introducirCoste = new JTextField(20);
    JTextField introducirDescripcion = new JTextField(20);

    JTextField introducirFormato = new JTextField(20);
    JTextField introducirEspacioEnDisco = new JTextField(20);
    JTextField introducirNumPag = new JTextField(20);

    JTextField introducirLenguajeWeb = new JTextField(20);
    JTextField introducirBackend = new JTextField(20);

    JTextField introducirLenguajeProg = new JTextField(20);
    JTextField introducirNumLineas = new JTextField(20);
    JTextField introducirModulos = new JTextField(20);


    JRadioButton documento = new JRadioButton("Documentación");
    JRadioButton web = new JRadioButton("Web");
    JRadioButton programa = new JRadioButton("Programa");
    JRadioButton si = new JRadioButton("Sí");
    JRadioButton no = new JRadioButton("no");

    JRadioButton descuento = new JRadioButton("descuento");
    JRadioButton urgente = new JRadioButton("urgente");


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

        panelDocumento = new JPanel();

        panelDocumento.setLayout(new GridLayout(3, 2));
        panelDocumento.add(formato);
        panelDocumento.add(introducirFormato);
        panelDocumento.add(numPag);
        panelDocumento.add(introducirNumPag);
        panelDocumento.add(espacioEnDisco);
        panelDocumento.add(introducirEspacioEnDisco);

        panelWeb = new JPanel();

        ButtonGroup esEstatica = new ButtonGroup();
        esEstatica.add(si);
        esEstatica.add(no);

        panelWeb.setLayout(new GridLayout(3,2));
        panelWeb.add(lenguajeWeb);
        panelWeb.add(introducirLenguajeWeb);
        panelWeb.add(backend);
        panelWeb.add(introducirBackend);
        panelWeb.add(si);
        panelWeb.add(no);

        panelPrograma = new JPanel();

        panelPrograma.add(lenguajeProg);
        panelPrograma.add(introducirLenguajeProg);
        panelPrograma.add(modulos);
        panelPrograma.add(introducirModulos);
        panelPrograma.add(numLineas);
        panelPrograma.add(introducirNumLineas);

        JPanel panelResultado = new JPanel();
        JLabel result = new JLabel("Introduce el tipo de resultado que deseas:");

        ButtonGroup resultado = new ButtonGroup();
        resultado.add(documento);
        resultado.add(web);
        resultado.add(programa);

        documento.addItemListener(new itemListener());
        web.addItemListener(new itemListener());
        programa.addItemListener(new itemListener());

        panelResultado.add(result);
        panelResultado.add(documento);
        panelResultado.add(web);
        panelResultado.add(programa);

        panelCentral = new JPanel();
        panelCentral.setLayout(new BorderLayout());

        panelCentral.add(panelResultado,BorderLayout.PAGE_START);
        panelCentral.add(panelDocumento, BorderLayout.CENTER);

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
        ventana.add(panelCentral, BorderLayout.CENTER);
        ventana.add(panelSouth, BorderLayout.SOUTH);

        ventana.pack();
        ventana.setVisible(true);

    }

    public class itemListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent itemEvent) {
            JRadioButton boton = (JRadioButton) itemEvent.getItem();
            String resultado = boton.getText();
            switch (resultado) {
                case "Documentación":
                    System.out.println("hola patato");
                    panelCentral.add(panelDocumento, BorderLayout.CENTER);
                    ventana.add(panelCentral, BorderLayout.CENTER);
                    SwingUtilities.updateComponentTreeUI(panelCentral);
                    break;
                case "Web":
                    System.out.println("hola patato1");
                    panelCentral.add(panelWeb, BorderLayout.CENTER);
                    ventana.add(panelCentral, BorderLayout.CENTER);
                    SwingUtilities.updateComponentTreeUI(panelCentral);
                    break;
                case "Programa":
                    panelCentral.add(panelPrograma, BorderLayout.CENTER);
                    ventana.add(panelCentral, BorderLayout.CENTER);
                    SwingUtilities.updateComponentTreeUI(panelCentral);
                    break;
            }
        }
    }
}
