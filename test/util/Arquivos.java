package util;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Arquivos {

    public static ArrayList<String> leTabela(String nomeArquivo) throws FileNotFoundException, IOException {
        ArrayList<String> result = new ArrayList<String>();

        DataInputStream in = new DataInputStream(new FileInputStream(nomeArquivo));
        try {
            while (true) {
                result.add(in.readUTF());
            }
        } catch (EOFException e) {
        }
        in.close();

        return result;
    }

    public static void deletaArquivo(String nomeArquivo) {
        File arquivo = new File(nomeArquivo);
        if (arquivo.exists()) {
            arquivo.delete();
        }
    }
}
