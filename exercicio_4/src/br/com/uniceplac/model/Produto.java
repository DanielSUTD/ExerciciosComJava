package br.com.uniceplac.model;

import br.com.uniceplac.model.enums.Categoria;
import br.com.uniceplac.uti.PrecoCalculavel;

public abstract class Produto implements PrecoCalculavel {
    protected String nome;
    protected double precoBase;
    protected Categoria categoria;

    public Produto(String nome, double precoBase, Categoria categoria) {
        this.nome = nome;
        this.precoBase = precoBase;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPrecoBase(double precoBase) {
        this.precoBase = precoBase;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public abstract double calcularPreco();
}
