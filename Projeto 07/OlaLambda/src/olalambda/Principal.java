package olalambda;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Elton
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Produto> lista = new ArrayList<>();
        lista.add(new Produto("Tenis", 300));
        lista.add(new Produto("Camiseta", 80));
        lista.add(new Produto("Cinto", 50));
        
        Carrinho c = new Carrinho(lista);
        
        c.darDesconto(20, p -> p.caro());
        
        c.getLista().forEach(p -> System.out.println(p));
    }
    
}
