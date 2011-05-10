
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
        Arquivos.deletaArquivo("tabelas.dat");
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
    public void testeCriaPrimeiroArquivoCatalogoComOsAtributosCorretos() throws FileNotFoundException, IOException {
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

    @Test
    public void testeCriaPrimeiroArquivoCatalogoComArquivoJaExistenteComOsAtributosCorretos() throws FileNotFoundException, IOException {
        String nome_clientes = "Cliente";
        HashMap<String, String> atributos_cliente = new HashMap<String, String>();
        atributos_cliente.put("Nome", "String");
        atributos_cliente.put("Idade", "Integer");

        Catalogo tabela = new Catalogo(nome_clientes, atributos_cliente);
        tabela.salvaTabela();

        String nome_alunos = "Alunos";
        HashMap<String, String> atributos_alunos = new HashMap<String, String>();
        atributos_alunos.put("Matricula", "TipoMatricula");
        atributos_alunos.put("CPF", "TipoCPF");

        Catalogo tabela_alunos = new Catalogo(nome_alunos, atributos_alunos);
        tabela_alunos.salvaTabela();

        ArrayList<String> arrTabela = Arquivos.leTabela("tabelas.dat");

        assertTrue(arrTabela.contains("Cliente"));
        assertTrue(arrTabela.contains("Nome"));
        assertTrue(arrTabela.contains("Idade"));
        assertTrue(arrTabela.contains("String"));
        assertTrue(arrTabela.contains("Integer"));
        assertTrue(arrTabela.contains("Matricula"));
        assertTrue(arrTabela.contains("TipoMatricula"));
        assertTrue(arrTabela.contains("CPF"));
        assertTrue(arrTabela.contains("TipoCPF"));
    }

    @Test
    public void testLeUmaTabeladoArquivoParaGerarHashMap() throws IOException {
        String nome_clientes = "Cliente";
        HashMap<String, String> atributos_cliente = new HashMap<String, String>();
        atributos_cliente.put("Nome", "String");
        atributos_cliente.put("Idade", "Integer");

        Catalogo tabelas = new Catalogo(nome_clientes, atributos_cliente);
        tabelas.salvaTabela();

        HashMap<String, HashMap> tabelas_hash = tabelas.leTabelas();


        HashMap<String, HashMap> tabelas_hash_controle = new HashMap<String, HashMap>();
        tabelas_hash_controle.put("Cliente", atributos_cliente);

        assertEquals(tabelas_hash_controle, tabelas_hash);
    }

    @Test
    public void testLeMaisDeUmaTabeladoArquivoParaGerarHashMap() throws IOException {
        String nome_clientes = "Cliente";
        HashMap<String, String> atributos_cliente = new HashMap<String, String>();
        atributos_cliente.put("Nome", "String");
        atributos_cliente.put("Idade", "Integer");

        Catalogo tabelas = new Catalogo(nome_clientes, atributos_cliente);
        tabelas.salvaTabela();

        String nome_alunos = "Alunos";
        HashMap<String, String> atributos_alunos = new HashMap<String, String>();
        atributos_alunos.put("Matricula", "TipoMatricula");
        atributos_alunos.put("CPF", "TipoCPF");
        atributos_alunos.put("Sobrenome", "TipoSobrenome");

        Catalogo tabela_alunos = new Catalogo(nome_alunos, atributos_alunos);
        tabela_alunos.salvaTabela();

        HashMap<String, HashMap> tabelas_hash = tabelas.leTabelas();


        HashMap<String, HashMap> tabelas_hash_controle = new HashMap<String, HashMap>();
        tabelas_hash_controle.put("Cliente", atributos_cliente);
        tabelas_hash_controle.put("Alunos", atributos_alunos);

        assertEquals(tabelas_hash_controle, tabelas_hash);
    }
}
