package br.com.uniceplac.service;

import br.com.uniceplac.model.Produto;
import br.com.uniceplac.model.Sobremesa;
import br.com.uniceplac.model.enums.Categoria;

import java.util.ArrayList;

public class Pedido {
    private ArrayList<Produto> itens;

    public Pedido() {
        this.itens = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        itens.add(produto);
    }

    public void removerProduto(Produto produto) {
        itens.remove(produto);
    }

    public double calcularTotal() {
        double total = 0;
        for (Produto produto : itens) {
            total += produto.calcularPreco();
        }

        if (total > 100) {
            aplicarDescontoSobremesa();
        }

        return total;
    }

    private void aplicarDescontoSobremesa() {
        for (Produto produto : itens) {
            if (produto.getCategoria() == Categoria.SOBREMESA) {
                ((Sobremesa) produto).setDesconto(true);
            }
        }
    }

    public void exibirItens() {
        for (Produto produto : itens) {
            System.out.println(produto.getNome() + " - " + produto.getCategoria() + ": R$ " + String.format("%.2f", produto.calcularPreco()));
        }
    }

    public int getQuantidadeItens() {
        return itens.size();
    }

    public boolean contemSobremesa() {
        for (Produto produto : itens) {
            if (produto.getCategoria() == Categoria.SOBREMESA) {
                return true;
            }
        }
        return false;
    }
}
