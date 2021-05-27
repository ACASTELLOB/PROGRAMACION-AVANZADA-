package practica1.vista;

import practica1.modelo.Modelo;
import practica1.modelo.Persona;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.List;

public class MostrarPersonasSinTarea {

    JList lista;
    JFrame ventana;
    private Modelo proyecto;

    public void ejecutar(){
        ventana = new JFrame("Personas responsables de ninguna tarea");

        List<Persona> listaDatos = proyecto.listarPersonasSinTarea();
        String[] vectorDatos = new String[listaDatos.size()];

        for (int i = 0; i < vectorDatos.length; i++){
            vectorDatos[i] = listaDatos.get(i).getClave();
        }

        JTextArea areaDatos = new JTextArea();
        areaDatos.setEditable(false);

        lista.setListData(vectorDatos);
        lista.addListSelectionListener(new EscuchadorLista(listaDatos, areaDatos));

        ventana.add(lista, BorderLayout.LINE_START);
        ventana.add(areaDatos, BorderLayout.CENTER);

        ventana.pack();
        ventana.setVisible(true);
    }

    public void setModelo(Modelo modelo) {
        this.proyecto = modelo;
    }

    public class EscuchadorLista implements ListSelectionListener {

        List<Persona> listaDatos;
        JTextArea areaDatos;

        public EscuchadorLista (List<Persona> listaDatos, JTextArea areaDatos){
            this.listaDatos = listaDatos;
            this.areaDatos = areaDatos;
        }

        @Override
        public void valueChanged(ListSelectionEvent listSelectionEvent) {
            JList lista = (JList) listSelectionEvent.getSource();
            int indice = lista.getSelectedIndex();
            areaDatos.setText(listaDatos.get(indice).toString());
            SwingUtilities.updateComponentTreeUI(areaDatos);
        }
    }

}
