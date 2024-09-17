package util;

import model.Funcionario;
import java.util.ArrayList;

public class Ordenacao {

    public static void bubbleSort(ArrayList<Funcionario> funcionarios) {
        int n = funcionarios.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (funcionarios.get(j).getNome().compareTo(funcionarios.get(j + 1).getNome()) > 0) {
                    Funcionario temp = funcionarios.get(j);
                    funcionarios.set(j, funcionarios.get(j + 1));
                    funcionarios.set(j + 1, temp);
                }
            }
        }
    }
}
