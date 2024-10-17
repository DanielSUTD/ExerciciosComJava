package br.com.uniceplac.model;

import br.com.uniceplac.model.enums.Categoria;

public class Sobremesa extends Produto {
    private boolean desconto;

    public Sobremesa(String nome, double precoBase, boolean desconto) {
        super(nome, precoBase, Categoria.SOBREMESA);
        this.desconto = desconto;
    }

    @Override
    public double calcularPreco() {
        if (desconto) {
            return precoBase * 0.80;
        }
        return precoBase;
    }

    public void setDesconto(boolean desconto) {
        this.desconto = desconto;
    }


    public boolean isDescontoAplicado() {
        return this.desconto;
    }
}