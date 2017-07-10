package acessobancodedados;

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
        List<UsuarioModel> lista = UsuarioDao.todosUsuarios();
        
        lista.forEach(System.out::println);
    }
    
}
