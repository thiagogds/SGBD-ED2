import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;
import sgbd.Catalogo;
import util.Arquivos;
/**
 *
 * @author Grupo 1
 */

public class TestCatalogo extends Assert {
    

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testeDeveCriarUmObjetodaClasseCatalogoComOsAtributosCorretos() {
        String nome = "Cliente";
        HashMap<String, String> atributos = new HashMap<String, String>();
        atributos.put("Nome", "String");
        atributos.put("Idade", "Integer");

        Catalogo tabela = new Catalogo(nome, atributos);
        
        assertNotNull(null, tabela);
    }

    @Test
    public void testeCriaPrimeiroArquivoCatalogoComOsAtributosCorretos() throws FileNotFoundException, IOException{
        String nome = "Cliente";
        HashMap<String, String> atributos = new HashMap<String, String>();
        atributos.put("Nome", "String");
        atributos.put("Idade", "Integer");

        Catalogo tabela = new Catalogo(nome, atributos);
        tabela.salvaTabela();
        
        ArrayList<String> arrTabela = Arquivos.leTabela("tabelas.dat");

        assertTrue(arrTabela.contains("Cliente"));
        assertTrue(arrTabela.contains("Nome"));
        assertTrue(arrTabela.contains("Idade"));
        assertTrue(arrTabela.contains("String"));
        assertTrue(arrTabela.contains("Integer"));
    }
}
