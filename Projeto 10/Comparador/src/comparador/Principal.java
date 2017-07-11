package comparador;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 *
 * @author Elton
 */
public class Principal {
    public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Pessoa p1 = new Pessoa("Eduardo", "Guerra", 36);
        Pessoa p2 = new Pessoa("Eduardo", "Guerra", 37);
        
        List<Diferenca> difs = Comparador.comparar(p1, p2);
        
        difs.forEach(System.out::println);
    }
}
