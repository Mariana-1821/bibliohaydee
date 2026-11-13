
package br.escola.bibliohaydee.model;

public class Autor {

    private String nome;
    private String nacionalidade;
    private int anoNascimento;

    public Autor() {
    }

    public Autor(String nome, String nacionalidade, int anoNascimento) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.anoNascimento = anoNascimento;
    }

    public String getNome() {
        return nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    @Override
    public String toString() {
        return "Autor: " + nome +
                ", Nacionalidade: " + nacionalidade +
                ", Ano de nascimento: " + anoNascimento;
    }
}
