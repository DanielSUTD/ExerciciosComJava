package model;

public class Jornal extends ItemBiblioteca{
    private String dataPublicacao;

    public Jornal(String titulo, String autor, int anoPublicacao, String dataPublicacao) {
        super(titulo, autor, anoPublicacao);
        this.dataPublicacao = dataPublicacao;
    }

    public void exibirManchetes() {
        System.out.println("Manchetes principais do jornal " + getTitulo() + " (" + dataPublicacao + ")");
    }

    public String toString(){
        return " |Jornal: " +titulo+ " |Autor: " +autor+ " |Ano: " +anoPublicacao+ " |Data de publicação: " +dataPublicacao;
    }
}
