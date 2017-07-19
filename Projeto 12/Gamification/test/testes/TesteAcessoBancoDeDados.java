package testes;

import gamification.dao.ComentarioDao;
import gamification.dao.TopicoDao;
import gamification.dao.UsuarioDao;
import gamification.model.Comentario;
import gamification.model.Topico;
import gamification.model.Usuario;
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
public class TesteAcessoBancoDeDados {
    
    JdbcDatabaseTester jdt;
    
    @Before
    public void setUp() throws Exception {
        jdt = new JdbcDatabaseTester("org.postgresql.Driver", "jdbc:postgresql://localhost/coursera", "postgres", "root");
        
        FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
        IDataSet dataset = builder.build(new File("C:\\sandbox\\javadev\\ITA\\coursera-daja\\Projeto 12\\Gamification\\test\\testes\\inicio.xml"));
        jdt.setDataSet(dataset);
        jdt.onSetup();
    }
    
    @Test
    public void obterUsuario() {
        Usuario usuario = UsuarioDao.obterUsuario("paulo");
        assertEquals("Paulo Jr", usuario.getNome());
    }
    
    @Test
    public void obterTopico() {
        Topico topico = TopicoDao.obterTopico(2);
        assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam placerat laoreet arcu ac suscipit. Maecenas vel nulla quis tortor elementum rhoncus non sed tortor. Duis porttitor finibus mattis. Nulla facilisi. Donec a aliquam neque. Praesent pretium, neque id hendrerit efficitur, erat leo blandit mi, ac gravida turpis tellus nec libero. Quisque ullamcorper mattis purus nec viverra. Hahahaha. Pellentesque sit amet finibus risus. Nunc in tempor ex. Integer mollis sed turpis sit amet elementum. Suspendisse aliquam felis vel nisl iaculis, in dignissim sapien pretium. Donec sodales luctus fermentum. Proin gravida venenatis diam id lacinia.", topico.getConteudo());
    }
    
    @Test
    public void obterComentario() {
        // Todos os comentários do tópico com id 1
        List<Comentario> comentarios = ComentarioDao.recuperar(1);
        assertEquals(4, comentarios.size());
    }
}
