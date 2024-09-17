package br.com.uniceplac.service;

import br.com.uniceplac.model.Paciente;
import br.com.uniceplac.model.enums.Prioridade;

import java.util.Scanner;

public class MenuUsuario {
    private GerenciadorFila gerenciadorFila;
    private final Scanner scanner = new Scanner(System.in);

    public MenuUsuario(GerenciadorFila gerenciadorFila) {
        this.gerenciadorFila = gerenciadorFila;
    }

    private void exibirMenu() {
        System.out.println("\nSistema de Gerenciamento da Clínica Médica");
        System.out.println("1. Adicionar Paciente");
        System.out.println("2. Chamar Próximo Paciente");
        System.out.println("3. Exibir Fila de Pacientes");
        System.out.println("0. Sair");
    }

    public void iniciar() {
        int opcao;
        do {
            exibirMenu();
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> adicionarPaciente();
                case 2 -> chamarProximoPaciente();
                case 3 -> gerenciadorFila.exibirFila();
                case 0 -> System.out.println("Saindo do sistema...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void adicionarPaciente() {
        System.out.print("Nome do paciente: ");
        String nome = scanner.nextLine();

        System.out.print("Idade do paciente: ");
        int idade = scanner.nextInt();
        scanner.nextLine();

        System.out.print("CPF do paciente: ");
        String CPF = scanner.nextLine();

        System.out.print("Tipo de consulta: ");
        String tipoConsulta = scanner.nextLine();

        System.out.println("Escolha a prioridade: ");
        System.out.println("1. Alta\n2. Média\n3. Baixa");
        int prioridadeEscolhida = scanner.nextInt();
        scanner.nextLine();

        Prioridade prioridade;
        switch (prioridadeEscolhida) {
            case 1 -> prioridade = Prioridade.ALTA;
            case 2 -> prioridade = Prioridade.MEDIA;
            case 3 -> prioridade = Prioridade.BAIXA;
            default -> {
                System.out.println("Prioridade inválida. Definindo como Baixa.");
                prioridade = Prioridade.BAIXA;
            }
        }

        Paciente paciente = new Paciente(nome, idade, CPF, tipoConsulta, prioridade);
        gerenciadorFila.adicionarPaciente(paciente);
    }

    private void chamarProximoPaciente() {
        gerenciadorFila.chamarProximoPaciente();
    }
}
