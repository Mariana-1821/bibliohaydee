
package br.escola.bibliohaydee.app;

import br.escola.bibliohaydee.model.Autor;
import br.escola.bibliohaydee.model.Livro;
import br.escola.bibliohaydee.model.Usuario;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

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

        cadastrarLivrosTeste(autores, livros);

        int opcao;

        do {
            System.out.println("\n===== BIBLIOTECA BIBLIOHAYDEE =====");
            System.out.println("1 - Pesquisar livro por título");
            System.out.println("2 - Pesquisar livro por autor");
            System.out.println("3 - Gerar relatório do acervo");
            System.out.println("0 - Sair");
            System.out.println("Escolha uma opção:");

            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    pesquisarPorTitulo(livros, scanner);
                    break;

                case 2:
                    pesquisarPorAutor(livros, scanner);
                    break;

                case 3:
                    gerarRelatorio(livros);
                    break;

                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        scanner.close();
    }

    private static void cadastrarLivrosTeste(
            ArrayList<Autor> autores, ArrayList<Livro> livros) {

        Autor machado = new Autor(
                "Machado de Assis", "Brasileiro", 1839);

        Autor graciliano = new Autor(
                "Graciliano Ramos", "Brasileiro", 1892);

        Autor aluisio = new Autor(
                "Aluísio Azevedo", "Brasileiro", 1857);

        Autor jorge = new Autor(
                "Jorge Amado", "Brasileiro", 1912);

        autores.add(machado);
        autores.add(graciliano);
        autores.add(aluisio);
        autores.add(jorge);

        livros.add(new Livro(
                "Dom Casmurro", "978000000001",
                machado, 1899));

        livros.add(new Livro(
                "Memórias Póstumas de Brás Cubas", "978000000002",
                machado, 1881));

        livros.add(new Livro(
                "Quincas Borba", "978000000003",
                machado, 1891));

        livros.add(new Livro(
                "Vidas Secas", "978000000004",
                graciliano, 1938));

        livros.add(new Livro(
                "O Cortiço", "978000000005",
                aluisio, 1890));

        livros.add(new Livro(
                "Capitães da Areia", "978000000006",
                jorge, 1937));
    }

    private static void pesquisarPorTitulo(
            ArrayList<Livro> livros, Scanner scanner) {

        System.out.println("Digite parte do título do livro:");
        String termo = scanner.nextLine();

        if (termo.isBlank()) {
            System.out.println("O termo de pesquisa não pode ser vazio.");
            return;
        }

        termo = termo.trim().toLowerCase();

        boolean encontrou = false;
        int quantidade = 0;

        for (Livro livro : livros) {

            String titulo = livro.getTitulo().toLowerCase();

            if (titulo.contains(termo)) {
                System.out.println(livro);
                encontrou = true;
                quantidade++;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum livro encontrado.");
        } else {
            System.out.println("Livros encontrados: " + quantidade);
        }
    }

    private static void pesquisarPorAutor(
            ArrayList<Livro> livros, Scanner scanner) {

        System.out.println("Digite o nome ou sobrenome do autor:");
        String termo = scanner.nextLine();

        if (termo.isBlank()) {
            System.out.println("O nome do autor não pode ser vazio.");
            return;
        }

        termo = termo.trim().toLowerCase();

        boolean encontrou = false;
        int quantidade = 0;

        for (Livro livro : livros) {

            String nomeAutor = livro.getAutor()
                    .getNome()
                    .trim()
                    .toLowerCase();

            boolean corresponde = nomeAutor.equals(termo);

            String[] partes = nomeAutor.split("\\s+");

            for (String parte : partes) {
                if (parte.equals(termo)) {
                    corresponde = true;
                }
            }

            if (corresponde) {
                System.out.println(livro);
                encontrou = true;
                quantidade++;
            }
        }

        if (!encontrou) {
            System.out.println("Autor não encontrado.");
        } else {
            System.out.println("Livros encontrados: " + quantidade);
        }
    }

    private static void gerarRelatorio(ArrayList<Livro> livros) {

        StringBuilder relatorio = new StringBuilder();

        relatorio.append("\n===== RELATÓRIO DO ACERVO =====\n");

        if (livros.isEmpty()) {

            relatorio.append("Não há livros cadastrados no acervo.\n");

        } else {

            int numero = 1;

            for (Livro livro : livros) {

                relatorio.append("\nLivro ").append(numero).append("\n");
                relatorio.append("Título: ")
                        .append(livro.getTitulo()).append("\n");

                relatorio.append("Autor: ")
                        .append(livro.getAutor().getNome()).append("\n");

                relatorio.append("Disponibilidade: ")
                        .append(livro.isDisponibilidade()
                                ? "Disponível" : "Indisponível")
                        .append("\n");

                numero++;
            }

            relatorio.append("\nTotal de livros: ")
                    .append(livros.size()).append("\n");
        }

        System.out.println(relatorio.toString());
    }

    public static Usuario buscarUsuario(
            ArrayList<Usuario> usuarios, String matricula) {

        for (Usuario usuario : usuarios) {
            if (usuario.getMatricula().equals(matricula)) {
                return usuario;
            }
        }

        return null;
    }
}
