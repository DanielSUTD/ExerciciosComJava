package service;

import model.*;
import java.util.Scanner;

public class MenuBiblioteca {
    private Biblioteca biblioteca;
    private final Scanner scanner = new Scanner(System.in);

    public MenuBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void exibirMenu() {
        int opcao;

        do {
            System.out.println("\nSistema de Gestão de Biblioteca");
            System.out.println("1. Adicionar Livro");
            System.out.println("2. Adicionar Revista");
            System.out.println("3. Adicionar Jornal");
            System.out.println("4. Listar Itens");
            System.out.println("5. Emprestar Livro");
            System.out.println("6. Adicionar Item na Fila");
            System.out.println("7. Atender Fila");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarLivro();
                    break;
                case 2:
                    adicionarRevista();
                    break;
                case 3:
                    adicionarJornal();
                    break;
                case 4:
                    biblioteca.listarItens();
                    break;
                case 5:
                    emprestarLivro();
                    break;
                case 6:
                    adicionarNaFila();
                    break;
                case 7:
                    biblioteca.atenderFila();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
    }

    private void adicionarLivro() {
        System.out.print("Título do Livro: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Ano de Publicação: ");
        int ano = scanner.nextInt();
        System.out.print("Número de Páginas: ");
        int paginas = scanner.nextInt();

        Livro livro = new Livro(titulo, autor, ano, paginas);
        biblioteca.adicionarItem(livro);
        System.out.println("Livro adicionado com sucesso!");
    }

    private void adicionarRevista() {
        System.out.print("Título da Revista: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Ano de Publicação: ");
        int ano = scanner.nextInt();
        System.out.print("Edição: ");
        int edicao = scanner.nextInt();

        Revista revista = new Revista(titulo, autor, ano, edicao);
        biblioteca.adicionarItem(revista);
        System.out.println("Revista adicionada com sucesso!");
    }

    private void adicionarJornal() {
        System.out.print("Título do Jornal: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Ano de Publicação: ");
        int ano = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Data de Publicação (DD/MM/AAAA): ");
        String data = scanner.nextLine();

        Jornal jornal = new Jornal(titulo, autor, ano, data);
        biblioteca.adicionarItem(jornal);
        System.out.println("Jornal adicionado com sucesso!");
    }

    private void emprestarLivro() {
        System.out.print("Título do Livro a ser emprestado: ");
        String titulo = scanner.nextLine();
        for (ItemBiblioteca item : biblioteca.getItens()) {
            if (item instanceof Livro && item.getTitulo().equalsIgnoreCase(titulo)) {
                ((Livro) item).emprestar();
                return;
            }
        }
        System.out.println("Livro não encontrado.");
    }

    private void adicionarNaFila() {
        System.out.print("Título do Item para adicionar na fila: ");
        String titulo = scanner.nextLine();
        for (ItemBiblioteca item : biblioteca.getItens()) {
            if (item.getTitulo().equalsIgnoreCase(titulo)) {
                biblioteca.adicionarNaFila(item);
                System.out.println("Item adicionado à fila.");
                return;
            }
        }
        System.out.println("Item não encontrado.");
    }
}