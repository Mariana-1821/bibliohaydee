package br.escola.bibliohaydee.app;

import br.escola.bibliohaydee.model.Autor;
import br.escola.bibliohaydee.model.Livro;
import br.escola.bibliohaydee.model.Usuario;

import java.util.ArrayList;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Autor> autores = new ArrayList<>();
        ArrayList<Livro> livros = new ArrayList<>();
        ArrayList<Usuario> usuarios = new ArrayList<>();

        System.out.println("Digite seu nome:");
        String nome = scanner.nextLine();

        System.out.println("Digite sua matrícula:");
        String matricula = scanner.nextLine();

        System.out.println("Digite seu tipo (ALUNO/PROFESSOR):");
        String tipo = scanner.nextLine();

        System.out.println("Deseja definir o limite de empréstimos? S/N");
        String resposta = scanner.nextLine();

        Usuario usuario;

        if (resposta.equalsIgnoreCase("S")) {
            System.out.println("Digite o limite de empréstimos:");
            int limite = Integer.parseInt(scanner.nextLine());

            usuario = new Usuario(nome, matricula, tipo, limite);
        } else {
            usuario = new Usuario(nome, matricula, tipo);
        }

        usuarios.add(usuario);

        System.out.println(usuario);
        System.out.println("Usuário cadastrado!");

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

        Livro livroTeste = new Livro(
                "O Retrato de Dorian Gray",
                "978-6555522175",
                autor,
                1890
        );

        livros.add(livro);
        livros.add(livroTeste);

        System.out.println("AUTORES");

        for (Autor a : autores) {
            System.out.println(a);
        }

        System.out.println("ACERVO");

        if (livros.isEmpty()) {
            System.out.println("O acervo está vazio.");
        } else {
            for (Livro l : livros) {
                System.out.println(l);
            }
        }

        scanner.close();
    }
}