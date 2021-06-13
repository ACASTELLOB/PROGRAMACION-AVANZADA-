package practica1.controlador;

import practica1.modelo.Modelo;
import practica1.modelo.Persona;
import practica1.modelo.Resultados.Documentacion;
import practica1.modelo.Resultados.PagWeb;
import practica1.modelo.Resultados.Programa;
import practica1.modelo.Tarea;
import practica1.modelo.excepciones.TareaExcepcion;
import practica1.modelo.facturación.ConsumoInterno;
import practica1.modelo.facturación.Descuento;
import practica1.modelo.facturación.Facturacion;
import practica1.modelo.facturación.Urgente;
import practica1.vista.Vista;

import java.io.Serializable;

public class ControladorProyectos implements Controlador{
    Modelo modelo;
    Vista vista;

    public void setModelo(Modelo modelo){
        this.modelo= modelo;
    }

    public void setVista(Vista vista){
        this.vista=vista;
    }

    @Override
    public void guardar(){
        modelo.guardar();
    }

    @Override
    public void añadirPersona() {
        String nombre= vista.getNombre();
        String correo= vista.getCorreo();
        Persona persona = new Persona(nombre, correo);
        modelo.añadirPersona(persona);
    }



    @Override
    public void añadirTarea() {
        String tituloTarea = vista.getTitulo();
        String tipoResultado =vista.getRes();
        int prioridad = vista.getPrioridad();
        String descripcion =vista.getDescripcion();
        String ident = vista.getIdentificador();
        int horas= vista.getHora();
        Boolean esInterno= vista.getInterno();
        if (horas >= 0 && prioridad >= 0){
            switch (tipoResultado) {
                case "Documentación":
                    Tarea tarea = crearDocumentación(ident, horas, esInterno, tituloTarea, descripcion, prioridad);
                    try {
                        modelo.añadirTarea(tarea);
                    }catch (TareaExcepcion e){
                    }
                    break;
                case "Web":
                    tarea = crearWeb(ident, horas, esInterno, tituloTarea, descripcion, prioridad);
                    try {
                        modelo.añadirTarea(tarea);
                    }catch (TareaExcepcion e){
                    }
                    break;
                case "Programa":
                    tarea = crearPrograma(ident, horas, esInterno, tituloTarea, descripcion, prioridad);
                    try {
                        modelo.añadirTarea(tarea);
                    }catch (TareaExcepcion e){
                    }
                    break;
            }
        }


    }
    public  Tarea crearDocumentación(String ident, int horas, boolean esInterno, String tituloTarea, String descripcion, int prioridad){

        String format = vista.getFormato();
        int pag = vista.getNumPag();
        int esp = vista.getEspDisc();
        double coste= vista.getCoste();
        if (pag < 0 || esp < 0 || coste < 0){
            return null;
        }
        Documentacion documento = new Documentacion(ident, horas,  esInterno, format, pag, esp);
        Facturacion facturacion = crearFacturacion();
        Tarea tarea = new Tarea(tituloTarea,descripcion, documento, prioridad, coste, facturacion);
        return tarea;
    }

    public  Tarea crearWeb( String ident, int horas, boolean esInterno, String tituloTarea, String descripcion, int prioridad){
        String lenguaje = vista.getLenguajeWeb();
        String backend = vista.getBackend();
        double coste= vista.getCoste();
        if (coste < 0){
            return null;
        }
        boolean esEstatica = vista.getEstatica();
        PagWeb web = new PagWeb(ident, horas, esInterno, esEstatica, lenguaje, backend);
        Facturacion facturacion = crearFacturacion();
        Tarea tarea = new Tarea(tituloTarea,descripcion, web, prioridad,coste, facturacion);
        return tarea;
    }
    public  Tarea crearPrograma( String ident, int horas, boolean esInterno, String tituloTarea, String descripcion, int prioridad){
        String lenguaje = vista.getLenguajeProg();
        int numLineasCodigo = vista.getNumLineasCodigo();
        int numModulos = vista.getNumModulos();
        double coste= vista.getCoste();
        if (numLineasCodigo < 0 || numModulos < 0 || coste < 0){
            return null;
        }
        Programa prog = new Programa(ident, horas, esInterno, lenguaje, numLineasCodigo, numModulos);
        Facturacion facturacion = crearFacturacion();
        Tarea tarea = new Tarea(tituloTarea,descripcion, prog, prioridad,coste, facturacion);
        return tarea;
    }

    public  Facturacion crearFacturacion(){
        String tipoFacturación = vista.getFacturación();
        switch( tipoFacturación){
            case "Interno":
                Facturacion facturacion = new ConsumoInterno();
                return facturacion;
            case "Descuento":
                facturacion = new Descuento();
                return facturacion;
            case "Urgente":
                facturacion =new Urgente();
                return facturacion;
        }
        return null;
    }

    public void cambiarCoste(){
        try {
            Tarea tarea= vista.getTareaActual();
            String titulo = tarea.titulo;
            double coste = vista.getCosteCambiado();
            if (coste >= 0){
                modelo.cambiarCosteTarea(titulo,coste);
            }
        }catch (NullPointerException e){
        }
    }

    @Override
    public void añadirResponsable() {
        Tarea tarea = vista.getTareaActual();
        Persona persona = vista.getPersonaActual();
        try{
            modelo.responsable(persona.nombre,tarea.titulo);
        }catch (NullPointerException e){
        }

    }

    @Override
    public void finalizarTarea(){
        Tarea tarea = vista.getTareaActual();
        try {
            modelo.finalizarTarea(tarea.titulo);
        }catch (NullPointerException e){
        }
    }

    @Override
    public void IntrodELiminaPersonaTarea(){
        Persona persona= vista.getPersonaActual();
        Tarea tarea= vista.getTareaActual();
        try {
            modelo.añadirEliminarPersona(persona.nombre, tarea.titulo);
        }catch(NullPointerException e){
        }
    }

}
