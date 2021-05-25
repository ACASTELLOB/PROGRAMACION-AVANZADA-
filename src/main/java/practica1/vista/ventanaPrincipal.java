package practica1.vista;

import practica1.modelo.Persona;
import practica1.modelo.Proyecto;
import practica1.modelo.Tarea;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.List;

public class ventanaPrincipal {

    Proyecto proyecto;

    public ventanaPrincipal(Proyecto proyecto){
        this.proyecto = proyecto;
    }

    public void ejecutar(){
        List<Persona> personas = proyecto.listarPersonas();
        String[] datosPersona = new String[personas.size()];

        for (int i = 0; i < datosPersona.length; i++){
            datosPersona[i] = personas.get(i).getClave();
        }

        List<Tarea> tareas = proyecto.listarTareas();
        String[] datosTarea = new String[tareas.size()];

        for (int i = 0; i < datosTarea.length; i++){
            datosTarea[i] = tareas.get(i).getClave();
        }

        JFrame ventana = new JFrame(proyecto.getNombre());

        JButton guardar = new JButton("Guardar");

        JPanel central = new JPanel();
        central.setLayout(new GridLayout(2,2));

        //Creación de los paneles de botones de persona y tarea
        JPanel panelBotonesPersona = new JPanel();
        panelBotonesPersona.setLayout(new GridLayout(2,1));
        JPanel panelBotonesTarea = new JPanel();
        panelBotonesTarea.setLayout(new GridLayout(3,2));

        //Creación de los JTextArea de persona y tarea
        JTextArea persona = new JTextArea();
        persona.setEditable(false);
        JTextArea tarea = new JTextArea();
        tarea.setEditable(false);

        //Creacion de la lista de personas
        JList listaPersonas = new JList(datosPersona);
        JScrollPane panelPersonas = new JScrollPane(listaPersonas);
        listaPersonas.setVisibleRowCount(5);
        listaPersonas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaPersonas.addListSelectionListener(new EscuchadorListaPersona(personas,persona));

        //Creacion de la lisa de tareas
        JList listaTareas = new JList(datosTarea);
        JScrollPane panelTareas = new JScrollPane(listaTareas);
        listaTareas.setVisibleRowCount(5);
        listaTareas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaTareas.addListSelectionListener(new EscuchadorListaTarea(tareas,tarea));

        //Crear botones y añadirlos al panel de botones de persona
        panelBotonesPersona.add(new Button("Añadir persona"));
        panelBotonesPersona.add(new Button("Mosotrar personas sin tarea"));

        //Crear botones y añadirlos al panel de botones de tarea
        panelBotonesTarea.add(new Button("Añadir tarea"));
        panelBotonesTarea.add(new Button("Finalizar tarea"));
        panelBotonesTarea.add(new Button("Añadir responsable"));
        panelBotonesTarea.add(new Button("Cambiar coste"));
        panelBotonesTarea.add(new Button("Mostrar tareas sin persona"));

        //Añadir Botones y JTextArea al panel central
        central.add(persona);
        central.add(tarea);
        central.add(panelBotonesPersona);
        central.add(panelBotonesTarea);

        //Añadir elementos al contenedor del JFrame
        Container contenedor = ventana.getContentPane();
        contenedor.add(panelPersonas, BorderLayout.LINE_START);
        contenedor.add(panelTareas, BorderLayout.LINE_END);
        contenedor.add(central, BorderLayout.CENTER);
        contenedor.add(guardar,BorderLayout.PAGE_END);

        ventana.pack();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }

    public class EscuchadorListaPersona implements ListSelectionListener {

        List<Persona> personas;
        JTextArea persona;

        public EscuchadorListaPersona (List<Persona> personas, JTextArea persona){
            this.personas = personas;
            this.persona = persona;
        }

        @Override
        public void valueChanged(ListSelectionEvent listSelectionEvent) {
            JList lista = (JList) listSelectionEvent.getSource();
            int indice = lista.getSelectedIndex();
            persona.setText(personas.get(indice).toString());
            SwingUtilities.updateComponentTreeUI(persona);
        }
    }

    public class EscuchadorListaTarea implements ListSelectionListener {

        List<Tarea> tareas;
        JTextArea tarea;

        public EscuchadorListaTarea (List<Tarea> tareas, JTextArea tarea){
            this.tareas = tareas;
            this.tarea = tarea;
        }

        @Override
        public void valueChanged(ListSelectionEvent listSelectionEvent) {
            JList lista = (JList) listSelectionEvent.getSource();
            int indice = lista.getSelectedIndex();
            tarea.setText(tareas.get(indice).toString());
            SwingUtilities.updateComponentTreeUI(tarea);
        }
    }

}
