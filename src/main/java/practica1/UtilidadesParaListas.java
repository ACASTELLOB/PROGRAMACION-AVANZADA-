package practica1;

import java.util.ArrayList;
import java.util.List;

public class UtilidadesParaListas<E>{
    public static <E extends tieneLista<E>> List<E> elementosConListaVacia(List<E> lista){
        List<E> res= new ArrayList<>();
        for(E elem:lista) {
            if (elem.getLista().size() == 0) {
                res.add(elem);
            }
        }
        return res;
    }

}
