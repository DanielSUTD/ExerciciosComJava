package br.com.uniceplac.model;

import br.com.uniceplac.model.enums.Categoria;

public class Bebida extends Produto{
    private boolean alcoolica;

    public Bebida(String nome, double precoBase, boolean alcoolica) {
        super(nome, precoBase, Categoria.BEBIDA);
        this.alcoolica = alcoolica;
    }

    public boolean isAlcoolica() {
        return alcoolica;
    }

    public void setAlcoolica(boolean alcoolica) {
        this.alcoolica = alcoolica;
    }

    @Override
    public double calcularPreco() {
        if (alcoolica) {
            return precoBase * 1.10; // 10% de imposto se for alcoólica
        }
        return precoBase;
    }
}
