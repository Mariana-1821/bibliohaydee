package br.escola.bibliohaydee.app;

import br.escola.bibliohaydee.model.Autor;
import br.escola.bibliohaydee.model.Livro;

import java.util.ArrayList;

class Main {

    public static void main(String[] args) {

        ArrayList<Autor> autores = new ArrayList<>();
        ArrayList<Livro> livros = new ArrayList<>();

        Autor autor = new Autor();
        autor.nome = "Dostoevsky";
        autor.nacionalidade = "Russo";
        autor.anoNascimento = 1821;

        autores.add(autor);

        Livro livro = new Livro(
                "Noites Brancas",
                "978-6550970284",
                autor,
                1848,
                "Novela"
        );

        livros.add(livro);

        System.out.println("===== AUTORES =====");

        for (Autor a : autores) {
            System.out.println(a);
        }

        System.out.println();

        System.out.println("===== ACERVO =====");

        if (livros.isEmpty()) {
            System.out.println("O acervo está vazio.");
        } else {
            for (Livro l : livros) {
                System.out.println(l);
            }
        }
    }
}
