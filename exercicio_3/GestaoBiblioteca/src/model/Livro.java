package model;

public class Livro extends ItemBiblioteca{
    private int numeroPaginas;
    private boolean emprestado;

    public Livro(String titulo, String autor, int anoPublicacao, int numeroPaginas) {
        super(titulo, autor, anoPublicacao);
        this.numeroPaginas = numeroPaginas;
        this.emprestado = false;
    }

    public void emprestar() {
        if (!emprestado) {
            emprestado = true;
            System.out.println("O livro foi emprestado.");
        } else {
            System.out.println("O livro já está emprestado.");
        }
    }

    public void devolver() {
        emprestado = false;
        System.out.println("O livro foi devolvido.");
    }

    @Override
    public String toString() {
        return " |Livro: " +titulo+ " |Autor: " +autor+ " |Ano: " +anoPublicacao+ " |Páginas: " +numeroPaginas;
    }
}
