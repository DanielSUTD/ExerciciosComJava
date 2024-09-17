package application;

import model.Funcionario;
import model.Gerente;
import model.Operador;
import util.Ordenacao;
import util.ArquivoTexto;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        boolean op = true;
        while (op) {
            exibirMenu();
            int alternativa = scanner.nextInt();
            scanner.nextLine();


            op = switch (alternativa) {
                case 1 -> {
                    cadastrarFuncionario(scanner, funcionarios);
                    yield true;
                }
                case 2 -> {
                    Ordenacao.bubbleSort(funcionarios);
                    System.out.println("Funcionários ordenados com sucesso!");
                    yield true;
                }
                case 3 -> {
                    ArquivoTexto.salvarArquivo(funcionarios);
                    System.out.println("Funcionários salvos em arquivo com sucesso!");
                    yield true;
                }
                case 4 -> {
                    exibirBonusFuncionarios(funcionarios);
                    yield true;
                }
                case 5 -> {
                    System.out.println("Saindo do sistema...");
                    yield false;
                }
                default -> {
                    System.out.println("Opção inválida! Tente novamente.");
                    yield true;
                }
            };
        }

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("1 - Cadastrar funcionário");
        System.out.println("2 - Ordenar funcionários");
        System.out.println("3 - Salvar funcionários em arquivo");
        System.out.println("4 - Exibir bônus dos funcionários");
        System.out.println("5 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarFuncionario(Scanner scanner, ArrayList<Funcionario> funcionarios) {
        System.out.print("Digite o nome do funcionário: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o salário do funcionário: ");
        double salario = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Digite o cargo do funcionário (Gerente ou Operador): ");
        String cargo = scanner.nextLine();

        Funcionario funcionario = criarFuncionario(nome, salario, cargo);
        if (funcionario != null) {
            funcionarios.add(funcionario);
        } else {
            System.out.println("Cargo inválido! Tente novamente.");
        }
    }

    private static Funcionario criarFuncionario(String nome, double salario, String cargo) {
        if (cargo.equalsIgnoreCase("Gerente")) {
            return new Gerente(nome, salario, cargo);
        } else if (cargo.equalsIgnoreCase("Operador")) {
            return new Operador(nome, salario, cargo);
        } else {
            return null;
        }
    }

    private static void exibirBonusFuncionarios(ArrayList<Funcionario> funcionarios) {
        System.out.println("Bônus dos funcionários:");
        for (Funcionario funcionario : funcionarios) {
            double bonus = funcionario.calcularBonus();
            System.out.println(funcionario.getNome() + ": R$ " + bonus);
        }
    }
}
