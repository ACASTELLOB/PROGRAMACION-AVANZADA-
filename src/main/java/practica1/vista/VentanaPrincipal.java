package practica1.vista;

import practica1.controlador.Controlador;
import practica1.modelo.Modelo;
import practica1.modelo.Persona;
import practica1.modelo.Tarea;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.List;

public class VentanaPrincipal implements Vista{

    VentanaPrincipal ventanaPrincipal = this;
    Persona personaActual;
    Tarea tareaActual;

    JList listaPersonas;
    JList listaTareas;

    JFrame ventana;
    AñadirPersona añadirPersona;
    AñadirTarea añadirTarea;
    CambiarCoste cambiarCoste;
    CrearDocumentacion crearDocumentacion;
    CrearPagWeb crearPagWeb;
    CrearPrograma crearPrograma;

    private Controlador controlador;
    private Modelo proyecto;

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

        ventana = new JFrame(proyecto.getNombre());

        JPanel central = new JPanel();
        central.setLayout(new GridLayout(2,3));

        //Creación de botones
        JButton guardar = new JButton("Guardar");
        guardar.addActionListener(new Escuchador());

        JButton añadirP = new JButton("Añadir persona");
        añadirP.addActionListener(new Escuchador());

        JButton mostrarPersonasSinTarea = new JButton("Mostrar personas sin tarea");
        mostrarPersonasSinTarea.addActionListener(new Escuchador());

        JButton añadirT = new JButton("Añadir tarea");
        añadirT.addActionListener(new Escuchador());

        JButton finalizarT = new JButton("Finalizar tarea");
        finalizarT.addActionListener(new Escuchador());

        JButton añadirResponsable = new JButton("Añadir responsable");
        añadirResponsable.addActionListener(new Escuchador());

        JButton cambiarCoste = new JButton("Cambiar coste de la tarea");
        cambiarCoste.addActionListener(new Escuchador());

        JButton mostrarTareasSinPersonas = new JButton("Mostrar tareas sin responsable");
        mostrarTareasSinPersonas.addActionListener(new Escuchador());

        JButton añadirEliminarPersonaTarea = new JButton("Añadir o elimnar persona de tarea");
        añadirEliminarPersonaTarea.addActionListener(new Escuchador());

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
        listaPersonas = new JList(datosPersona);
        JScrollPane panelPersonas = new JScrollPane(listaPersonas);
        listaPersonas.setVisibleRowCount(5);
        listaPersonas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaPersonas.addListSelectionListener(new EscuchadorListaPersona(personas,persona));

        //Creacion de la lisa de tareas
        listaTareas = new JList(datosTarea);
        JScrollPane panelTareas = new JScrollPane(listaTareas);
        listaTareas.setVisibleRowCount(5);
        listaTareas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaTareas.addListSelectionListener(new EscuchadorListaTarea(tareas,tarea));

        //Añadir botones al panel de botones de persona
        panelBotonesPersona.add(añadirP);
        panelBotonesPersona.add(mostrarPersonasSinTarea);

        //Añadir botones al panel de botones de tarea
        panelBotonesTarea.add(añadirT);
        panelBotonesTarea.add(finalizarT);
        panelBotonesTarea.add(añadirResponsable);
        panelBotonesTarea.add(cambiarCoste);
        panelBotonesTarea.add(mostrarTareasSinPersonas);
        panelBotonesTarea.add(añadirEliminarPersonaTarea);

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

    @Override
    public void mostrarMensajeError(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.WARNING_MESSAGE);
    }

    @Override
    public void mostrarMensajeInformativo(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void actualizarVista(){
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

        listaPersonas.setListData(datosPersona);
        listaTareas.setListData(datosTarea);

        SwingUtilities.updateComponentTreeUI(listaPersonas);
        SwingUtilities.updateComponentTreeUI(listaTareas);
    }

    @Override
    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    @Override
    public void setModelo(Modelo modelo) {
        this.proyecto = modelo;
    }

    @Override
    public String getNombre() { return añadirPersona.getNombre(); }

    @Override
    public String getCorreo() {
        return añadirPersona.getCorreo();
    }

    public Persona getPersonaActual(){return personaActual;}

    public Tarea getTareaActual(){return tareaActual;}

    @Override
    public String getTitulo() {
        return añadirTarea.getTitulo();
    }

    @Override
    public String getDescripcion() {
        return añadirTarea.getDescripcion();
    }

    @Override
    public String getIdentificador() {
        return añadirTarea.getIdentificador();
    }

    @Override
    public Boolean getInterno() {
        return añadirTarea.getInterno();
    }

    @Override
    public int getPrioridad() {
        try{
            return Integer.parseInt(añadirTarea.getPrioridad());
        }catch (NumberFormatException e){
            mostrarMensajeError("Se ha detectado un campo con el formato erroneo","Formato erroneo");
        }
        return -1;
    }

    @Override
    public int getHora() {
        try{
            return Integer.parseInt(añadirTarea.getHora());
        }catch (NumberFormatException e){
            mostrarMensajeError("Se ha detectado un campo con el formato erroneo","Formato erroneo");
        }
        return -1;
    }

    @Override
    public String getFormato() {
        return crearDocumentacion.getFormato();
    }

    @Override
    public int getNumPag() {
        try{
            return Integer.parseInt(crearDocumentacion.getNumPag());
        }catch (NumberFormatException e){
            mostrarMensajeError("Se ha detectado un campo con el formato erroneo","Formato erroneo");
        }
        return -1;
    }

    @Override
    public int getEspDisc() {
        try{
            return Integer.parseInt(crearDocumentacion.getEspDisc());
        }catch (NumberFormatException e){
            mostrarMensajeError("Se ha detectado un campo con el formato erroneo","Formato erroneo");
        }
        return -1;
    }

    @Override
    public Boolean getEstatica() {
        return crearPagWeb.getEstatica();
    }

    @Override
    public String getLenguajeWeb() {
        return crearPagWeb.getLenguajeWeb();
    }

    @Override
    public String getBackend() {
        return crearPagWeb.getBackend();
    }

    @Override
    public int getNumLineasCodigo() {
        try{
            return Integer.parseInt(crearPrograma.getNumLineasCodigo());
        }catch (NumberFormatException e){
            mostrarMensajeError("Se ha detectado un campo con el formato erroneo","Formato erroneo");
        }
        return -1;
    }

    @Override
    public int getNumModulos() {
        try{
            return Integer.parseInt(crearPrograma.getNumModulos());
        }catch (NumberFormatException e){
            mostrarMensajeError("Se ha detectado un campo con el formato erroneo","Formato erroneo");
        }
        return -1;
    }

    @Override
    public String getLenguajeProg(){return crearPrograma.getLenguajeProg();}

    @Override
    public double getCoste(){
        try{
            return Double.parseDouble(añadirTarea.getCoste());
        }catch (NumberFormatException e){
            mostrarMensajeError("Se ha detectado un campo con el formato erroneo","Formato erroneo");
        }
        return -1;
    }

    @Override
    public String getRes() {
        return añadirTarea.getRes() ;
    }

    @Override
    public String getFacturación() {
        return añadirTarea.getFacturación();
    }

    @Override
    public double getCosteCambiado(){
        try{
            return Double.parseDouble(cambiarCoste.getCoste());
        }catch (NumberFormatException e){
            mostrarMensajeError("Se ha detectado un campo con el formato erroneo","Formato erroneo");
        }
        return -1;
    }

    public void setCrearDocumentacion(CrearDocumentacion crearDocumentacion){
        this.crearDocumentacion = crearDocumentacion;
    }

    public void setCrearPagWeb(CrearPagWeb crearPagWeb) {
        this.crearPagWeb = crearPagWeb;
    }

    public void setCrearPrograma(CrearPrograma crearPrograma) {
        this.crearPrograma = crearPrograma;
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
            if(indice == -1) return;
            personaActual = personas.get(indice);
            persona.setText(personaActual.toString());
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
            if(indice == -1) return;
            tareaActual = tareas.get(indice);
            tarea.setText(tareaActual.toString());
            SwingUtilities.updateComponentTreeUI(tarea);
        }
    }

    private class Escuchador implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            JButton boton = (JButton) actionEvent.getSource();
            String texto = boton.getText();
            switch (texto) {
                case "Añadir persona":
                    añadirPersona = new AñadirPersona();
                    añadirPersona.ejecutar(controlador);
                    break;
                case "Mostrar personas sin tarea":
                    MostrarPersonasSinTarea mostrarPersonasSinTarea = new MostrarPersonasSinTarea();
                    mostrarPersonasSinTarea.setModelo(proyecto);
                    mostrarPersonasSinTarea.ejecutar();
                    break;
                case "Añadir tarea":
                    añadirTarea = new AñadirTarea();
                    añadirTarea.ejecutar(controlador, ventanaPrincipal);
                    break;
                case "Finalizar tarea":
                    controlador.finalizarTarea();
                    break;
                case "Añadir responsable":
                    controlador.añadirResponsable();
                    break;
                case "Cambiar coste de la tarea":
                    cambiarCoste = new CambiarCoste();
                    cambiarCoste.ejecutar(controlador);
                    break;
                case "Mostrar tareas sin responsable":
                    MostrarTareaSinPersonas mostrarTareaSinPersonas = new MostrarTareaSinPersonas();
                    mostrarTareaSinPersonas.setModelo(proyecto);
                    mostrarTareaSinPersonas.ejecutar();
                    break;
                case "Añadir o elimnar persona de tarea":
                    controlador.IntrodELiminaPersonaTarea();
                    break;
                case "Guardar":
                    controlador.guardar();
                    break;
            }
        }
    }
}
