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
    public void testeDeveCriarUmObjetodaClasseCatalogo() {
        Catalogo tabela = new Catalogo();
        assertNotNull(null, tabela);
    }
}
