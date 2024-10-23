package br.com.uniceplac.model;

import br.com.uniceplac.model.enums.Categoria;

public class ImcModel {
    private double peso;
    private double altura;

    public ImcModel(double peso, double altura) {
        this.peso = peso;
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double calcularImc() {
        return peso / (altura * altura);
    }

    public Categoria getCategoriaImc() {
        double imc = calcularImc();
        return Categoria.getCategoria(imc);
    }

}
