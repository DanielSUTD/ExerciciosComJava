package util;

import model.Funcionario;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArquivoTexto {

    public static void salvarArquivo(ArrayList<Funcionario> funcionarios) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("funcionarios.txt"));
            for (Funcionario funcionario : funcionarios) {
                System.out.println(funcionario);
                writer.write(funcionario.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao salvar o arquivo", e);
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}