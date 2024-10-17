package br.com.uniceplac.model;

import br.com.uniceplac.model.enums.Categoria;

public class Comida extends Produto{
    private double taxaServico;

    public Comida(String nome, double precoBase, double taxaServico) {
        super(nome, precoBase, Categoria.COMIDA);
        this.taxaServico = taxaServico;
    }

    public double getTaxaServico() {
        return taxaServico;
    }

    public void setTaxaServico(double taxaServico) {
        this.taxaServico = taxaServico;
    }

    @Override
    public double calcularPreco() {
        return precoBase + taxaServico;
    }
}
