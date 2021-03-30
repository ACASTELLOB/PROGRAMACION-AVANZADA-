package practica1;

public class UtilidadesParaListas<E>{

    public static <T,E extends tieneClave<T>> Boolean claveUnica(E elem, tieneLista<E> objetoConLista) {
        for (E aux : objetoConLista.getLista()) {
            if (aux.getClave().equals(elem.getClave())) {
                return false;
            }
        }
        return true;
    }
}
