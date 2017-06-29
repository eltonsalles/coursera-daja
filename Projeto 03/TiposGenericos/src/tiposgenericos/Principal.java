package tiposgenericos;

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
        Cesta<Fruta> frutas = new Cesta<>();
        frutas.adiciona(new Fruta("Maçã"));
        frutas.adiciona(new Fruta("Banana"));
        frutas.adiciona(new Fruta("Mamão"));
        frutas.adiciona(new Fruta("Pera"));
        frutas.adiciona(new Fruta("Uva"));
        frutas.adiciona(new FrutaVermelha("Morango"));
        
        List<FrutaVermelha> vermelhas = new ArrayList<>();
        vermelhas.add(new FrutaVermelha("Amora"));
        vermelhas.add(new FrutaVermelha("Cereja"));
        
        frutas.adicionaTodos(vermelhas);
        
        while (frutas.temItens()) {            
            System.out.println(frutas.retira());
        }
    }
}
