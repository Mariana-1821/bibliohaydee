package br.escola.bibliohaydee.model;

public class Livro {

    String titulo;
    String isbn;
    Autor autor;
    int anoPublicacao;
    String genero;
    boolean disponibilidade;

    public Livro(String titulo, String isbn, Autor autor, int anoPublicacao, String genero) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.genero = genero;
        this.disponibilidade = true;
    }

    public Livro(String titulo, String isbn, Autor autor, int anoPublicacao) {
        this(titulo, isbn, autor, anoPublicacao, "Não informado");
    }

    @Override
    public String toString() {
        return "Livro: " + titulo +
                ", ISBN: " + isbn +
                ", Autor: " + autor.nome +
                ", Ano de publicação: " + anoPublicacao +
                ", Gênero: " + genero +
                ", Disponível: " + disponibilidade;
    }
}