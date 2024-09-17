package br.com.uniceplac.application;

import br.com.uniceplac.service.GerenciadorFila;
import br.com.uniceplac.service.MenuUsuario;

public class Principal {

    public static void main(String[] args){
        GerenciadorFila gerenciadorFila = new GerenciadorFila();
        MenuUsuario menuUsuario = new MenuUsuario(gerenciadorFila);
        menuUsuario.iniciar();
    }
}
