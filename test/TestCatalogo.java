import java.util.HashMap;
import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;
import sgbd.Catalogo;

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
}
