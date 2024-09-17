package model;

public class Revista extends ItemBiblioteca{
    private int edicao;

    public Revista(String titulo, String autor, int anoPublicacao, int edicao) {
        super(titulo, autor, anoPublicacao);
        this.edicao = edicao;
    }

    public void visualizarCapa() {
        System.out.println("Visualizando capa da revista " + getTitulo() + " edição " + edicao);
    }

    @Override
    public String toString(){
        return " |Revista: " +titulo+ " |Autor: " +autor+ " |Ano: " +anoPublicacao+ " |Edição: " +edicao;
    }
}
