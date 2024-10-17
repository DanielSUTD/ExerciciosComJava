package br.com.uniceplac.service;

import br.com.uniceplac.model.Bebida;
import br.com.uniceplac.model.Comida;
import br.com.uniceplac.model.Sobremesa;

import java.util.Scanner;

public class GerenciaPedido {
    private Pedido pedido;
    private Scanner scanner;

    public GerenciaPedido() {
        this.pedido = new Pedido();
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Adicionar Comida");
        System.out.println("2. Adicionar Bebida");
        System.out.println("3. Adicionar Sobremesa");
        System.out.println("4. Exibir Pedido");
        System.out.println("5. Finalizar Pedido");
        System.out.println("Escolha uma opção:");
    }

    public void adicionarComida() {
        System.out.print("Nome da comida: ");
        String nomeComida = scanner.nextLine();
        System.out.print("Preço base: ");
        double precoComida = scanner.nextDouble();
        System.out.print("Taxa de serviço: ");
        double taxaServico = scanner.nextDouble();
        scanner.nextLine();
        pedido.adicionarProduto(new Comida(nomeComida, precoComida, taxaServico));
    }

    public void adicionarBebida() {
        System.out.print("Nome da bebida: ");
        String nomeBebida = scanner.nextLine();
        System.out.print("Preço base: ");
        double precoBebida = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("É bebida alcoólica? (S - sim/N - não): ");
        String alternativa = scanner.nextLine();
        boolean alcoolica = alternativa.equalsIgnoreCase("S");

        pedido.adicionarProduto(new Bebida(nomeBebida, precoBebida, alcoolica));
    }

    public void adicionarSobremesa() {
        System.out.print("Nome da sobremesa: ");
        String nomeSobremesa = scanner.nextLine();
        System.out.print("Preço base: ");
        double precoSobremesa = scanner.nextDouble();
        scanner.nextLine();
        pedido.adicionarProduto(new Sobremesa(nomeSobremesa, precoSobremesa, false));
    }

    public void exibirPedido() {
        pedido.exibirItens();
        double total = pedido.calcularTotal();
        System.out.println("Total: R$ " + String.format("%.2f", total));
    }

    public void finalizarPedido() {
        System.out.println("Finalizando pedido...");
        exibirPedido();
        verificarBonusSobremesa();
        verificarDescontoSobremesa();
        System.out.println("Obrigado pela preferência!");
        scanner.close();
    }

    private void verificarBonusSobremesa() {
        if (pedido.getQuantidadeItens() > 5) {
            System.out.println("Você ganhou uma sobremesa grátis!");
        }
    }

    private void verificarDescontoSobremesa() {
        if (pedido.calcularTotal() > 100) {
            System.out.println("Você recebeu 20% de desconto na sobremesa.");
        }
    }

    public void iniciar() {
        while (true) {
            exibirMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarComida();
                    break;
                case 2:
                    adicionarBebida();
                    break;
                case 3:
                    adicionarSobremesa();
                    break;
                case 4:
                    exibirPedido();
                    break;
                case 5:
                    finalizarPedido();
                    return;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}
