package testes;

import acessobd.ImpUsuarioDAO;
import acessobd.Usuario;
import java.io.File;
import java.util.List;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Elton
 */
public class TesteImpUsuarioDao {
    
    JdbcDatabaseTester jdt;
        
    @Before
    public void setUp() throws Exception {
        jdt = new JdbcDatabaseTester("com.mysql.jdbc.Driver", "jdbc:mysql://127.0.0.1:3306/coursera", "root", "root");
        
        FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
        IDataSet dataset = builder.build(new File("C:\\sandbox\\javadev\\ITA\\coursera-daja\\Projeto 11\\AcessoBD\\test\\testes\\inicio.xml"));
        jdt.setDataSet(dataset);
        
        jdt.onSetup();
    }
    
    @Test
    public void inserir() {
        ImpUsuarioDAO dao = new ImpUsuarioDAO();
        
        Usuario u1 = new Usuario("duda", "duda@gmail.com", "Maria Eduarda", "1234", 10);
        
        dao.inserir(u1);
        
        Usuario u2 = dao.recuperar("duda");
        
        assertEquals("Maria Eduarda", u2.getNome());
    }
    
    @Test
    public void recuperar() {
        ImpUsuarioDAO dao = new ImpUsuarioDAO();
        
        Usuario u = dao.recuperar("guerra");
        
        assertEquals("guerra", u.getLogin());
    }
    
    @Test
    public void adicionarPontos() {
        ImpUsuarioDAO dao = new ImpUsuarioDAO();
        
        dao.adicionarPontos("guerra", 1);
        
        Usuario u = dao.recuperar("guerra");
        
        // No xml ele inicia com 9
        assertEquals(10, u.getPontos());
    }
    
    @Test
    public void ranking() {
        ImpUsuarioDAO dao = new ImpUsuarioDAO();
        
        Usuario u1 = new Usuario("duda", "duda@gmail.com", "Maria Eduarda", "1234", 10);
        
        dao.inserir(u1);
        
        List<Usuario> lista = dao.ranking();
        
        // A duda é inserida com 10 ficando em primeiro, o guerra inicia com 9 e o clovis inicia com 8
        assertEquals("duda", lista.get(0).getLogin());
        assertEquals("guerra", lista.get(1).getLogin());
        assertEquals("clovis", lista.get(2).getLogin());
    }
}
