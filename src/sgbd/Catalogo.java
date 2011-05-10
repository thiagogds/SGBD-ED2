package sgbd;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
        DataOutputStream out = new DataOutputStream(new FileOutputStream("tabelas.dat", true));
        try {
            out.writeUTF(this.nome);
            out.writeUTF(Integer.toString(atributos.size()));
            for (String key : atributos.keySet()) {
                out.writeUTF(key);
                out.writeUTF(atributos.get(key));
            }
        } catch (Exception e) {
        } finally {
            out.close();
        }
    }

    public HashMap<String, HashMap> leTabelas() throws FileNotFoundException, IOException {
        DataInputStream in = new DataInputStream(new FileInputStream("tabelas.dat"));
        HashMap<String, HashMap> tabelas = new HashMap<String, HashMap>();
        try {
            HashMap<String, String> atributos_tabela;
            String nome_tabela;
            String numero_atributos_str;
            int numero_atributos;
            while (true) {
                atributos_tabela = new HashMap<String, String>();
                nome_tabela = in.readUTF();
                numero_atributos_str = in.readUTF();
                numero_atributos = Integer.valueOf(numero_atributos_str);
                for (int i = 0; i < numero_atributos; i++) {
                    atributos_tabela.put(in.readUTF(), in.readUTF());
                }
                tabelas.put(nome_tabela, atributos_tabela);
            }
        }catch(Exception e){

        }finally{
            in.close();
            return tabelas;
        }
    }
//    public void leTabela() {
//        HashMap<String, HashMap> tabelas = new HashMap<String, HashMap>();
//        HashMap<String, String> atributos_tabela = new HashMap<String, String>();
//        while (True) {
//            nome = in.readUTF()
//            max = in.readInt()
//            for (i = 0, i < max, i++ ) {
//                atributos_tabela.put(in.readtUTF, in.readUTF)
//            }
//            tabelas.put("Clientes", atributos_tabela);
//
//        }
//        return;
//    }
}
