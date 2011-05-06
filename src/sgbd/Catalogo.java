package sgbd;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author Grupo 1
 */
public class Catalogo {

    private String nome;
    private HashMap<String, String> atributos;

    public Catalogo(String nome, HashMap<String, String> atributos) {
        this.nome = nome;
        this.atributos = atributos;
    }

    public void salvaTabela() throws IOException {
        DataOutputStream out = new DataOutputStream(new FileOutputStream("tabelas.dat"));
        try {
            out.writeUTF(this.nome);
            for (String key : atributos.keySet()) {
                out.writeUTF(key);
                out.writeUTF(atributos.get(key));
            }
        } catch (Exception e) {
        } finally {
            out.close();
        }
    }
}
