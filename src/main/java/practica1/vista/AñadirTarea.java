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
    JLabel hora = new JLabel("Introduce el número de hroas de la tarea:");

    JTextField introducirTitulo = new JTextField(20);
    JTextField introducirIdentificador = new JTextField(20);
    JTextField introducirPrioridad = new JTextField(20);
    JTextField introducirCoste = new JTextField(20);
    JTextField introducirDescripcion = new JTextField(20);
    JTextField introducirHora = new JTextField(20);

    JRadioButton documento = new JRadioButton("Documentación");
    JRadioButton web = new JRadioButton("Web");
    JRadioButton programa = new JRadioButton("Programa");

    JRadioButton siInterno = new JRadioButton("Sí");
    JRadioButton noInterno = new JRadioButton("No");

    JRadioButton descuento = new JRadioButton("descuento");
    JRadioButton urgente = new JRadioButton("urgente");

    String res;

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
        esInterno.add(siInterno);
        esInterno.add(noInterno);

        panelInterno.add(siInterno);
        panelInterno.add(noInterno);

        JPanel panelFacturacion = new JPanel();//si es interno no debe salir esta pantalla
        panelFacturacion.setLayout(new GridLayout(1, 2));
        JLabel facturacion = new JLabel("Introduce el tipo de facturación");
        ButtonGroup esFacturacion = new ButtonGroup();
        esFacturacion.add(descuento);
        esFacturacion.add(urgente);
        descuento.setEnabled(false);
        urgente.setEnabled(false);

        panelFacturacion.add(facturacion);
        panelFacturacion.add(descuento);
        panelFacturacion.add(urgente);
        //ventana.add(panelFacturacion);
        panelSouth.add(panelInterno);
        panelSouth.add(panelFacturacion);

        ventana.add(panelTitulo, BorderLayout.NORTH);
        ventana.add(panelFacturacion, BorderLayout.CENTER);
        ventana.add(panelSouth, BorderLayout.SOUTH);

        ventana.pack();
        ventana.setVisible(true);

    }

    public String getTitulo(){
        return introducirTitulo.getText();
    }
    public String getDescripcion(){
        return introducirDescripcion.getText();
    }
    public String getPrioridad(){
        return introducirPrioridad.getText();
    }
    public String getIdentificador(){
        return introducirIdentificador.getText();
    }
    public String getHora(){
        return introducirHora.getText();
    }
    public String getCoste(){
        return introducirCoste.getText();
    }
    public String getRes(){return res;}
    public Boolean getInterno(){
        if (siInterno.isSelected()) return true;
        else return false;
    }
    public String getFacturación(){
        if (urgente.isSelected()){
            return "Urgente";
        }else if (descuento.isSelected()){
            return "Descuento";
        }else{
            return "Interno";
        }
    }

    public class actionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            JRadioButton boton = (JRadioButton) actionEvent.getSource();
            String resultado = boton.getText();
            switch (resultado) {
                case "Documentación":
                    res = "Documentación";
                    break;
                case "Web":
                    res = "Web";
                    break;
                case "Programa":
                    res = "Programa";
                    break;
                case "Si":
                    descuento.setEnabled(false);
                    urgente.setEnabled(false);
                    break;
                case "No":
                    descuento.setEnabled(true);
                    urgente.setEnabled(true);
                    break;
            }
        }
    }
}
