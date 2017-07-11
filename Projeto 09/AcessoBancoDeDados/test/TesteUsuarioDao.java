import acessobancodedados.UsuarioDao;
import acessobancodedados.UsuarioModel;
import java.io.File;
import java.util.List;
import org.dbunit.Assertion;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Elton
 */
public class TesteUsuarioDao {
    
    JdbcDatabaseTester jdt;
    
    @Before
    public void setUp() throws Exception {
        jdt = new JdbcDatabaseTester("com.mysql.jdbc.Driver", "jdbc:mysql://127.0.0.1:3306/usuarios", "root", "root123");
        
        FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
        IDataSet dataset = builder.build(new File("C:\\sandbox\\javadev\\ITA\\coursera-daja\\Projeto 09\\AcessoBancoDeDados\\test\\inicio.xml"));
        jdt.setDataSet(dataset);
        
//         Não funcionou. Nem passando o caminho absoluto!
//        FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
//        jdt.setDataSet(loader.load("C:\\inicio.xml"));
        
        jdt.onSetup();
    }
    
    @Test
    public void recuperaTodos() {
        List<UsuarioModel> lista = UsuarioDao.todosUsuarios();
        assertEquals(2, lista.size());
        assertEquals("joao", lista.get(0).getLogin());
    }
    
    @Test
    public void inserirNovo() throws Exception {
        UsuarioModel u = new UsuarioModel();
        u.setLogin("duda");
        u.setNome("Maria Eduarda");
        u.setEmail("duda@gmail.com");
        
        UsuarioDao.inserirUsuario(u);
        
        IDataSet currentDataset = jdt.getConnection().createDataSet();
        ITable currentTable = currentDataset.getTable("USUARIO");
        
        FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
        IDataSet expectedDataset = builder.build(new File("C:\\sandbox\\javadev\\ITA\\coursera-daja\\Projeto 09\\AcessoBancoDeDados\\test\\verifica.xml"));
        ITable expectedTable = expectedDataset.getTable("USUARIO");
        
        Assertion.assertEquals(expectedTable, currentTable);
    }
}
