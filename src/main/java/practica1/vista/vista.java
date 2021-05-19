package practica1.vista;

import javax.swing.*;

public class vista {
    public static void main(String args[]){
        JFrame ventana = new JFrame("Nueva ventana");

        String[] datos = {"p1","p2"};
        JList personas = new JList(datos);
        JScrollPane panelPersonas = new JScrollPane(personas);
        personas.setVisibleRowCount(5);

        ventana.getContentPane().add(panelPersonas);
        ventana.pack();
        ventana.setVisible(true);
    }
}
