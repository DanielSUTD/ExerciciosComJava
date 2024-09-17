package application;

import model.Biblioteca;
import service.MenuBiblioteca;

public class Principal {
    public static void main(String[] args){
        Biblioteca biblioteca = new Biblioteca();
        MenuBiblioteca menuBiblioteca = new MenuBiblioteca(biblioteca);
        menuBiblioteca.exibirMenu();
    }
}
