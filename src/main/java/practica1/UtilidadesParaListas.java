package practica1;

import java.util.ArrayList;
import java.util.List;

public class UtilidadesParaListas{
    public static < E extends tieneLista<?>> List<E> elementosConListaVacia(List<E> lista){
        List<E> res= new ArrayList<>();
        for(E elem:lista) {
            if (elem.getLista().size() == 0) {
                res.add(elem);
            }
        }
        return res;
    }

    public static <T,E extends tieneClave<T>> Boolean claveUnica(E elem, tieneLista<E> objetoConLista) {
        for (E aux : objetoConLista.getLista()) {
            if (aux.getClave().equals(elem.getClave())) {
                return false;
            }
        }
        return  true;
    }
}
