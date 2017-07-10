package acessobancodedados;

/**
 *
 * @author Elton
 */
public class PrincipalInsert {
    public static void main(String[] args) {
        UsuarioModel u = new UsuarioModel();
        u.setLogin("duda");
        u.setNome("Maria Eduarda");
        u.setEmail("duda@gmail.com");
        
        UsuarioDao.inserirUsuario(u);
    }
}
