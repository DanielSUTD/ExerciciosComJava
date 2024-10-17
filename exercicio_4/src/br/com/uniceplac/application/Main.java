package br.com.uniceplac.application;

import br.com.uniceplac.service.GerenciaPedido;

public class Main {
    public static void main(String[] args) {
        GerenciaPedido gerenciaPedido = new GerenciaPedido();
        gerenciaPedido.iniciar();
    }
}
