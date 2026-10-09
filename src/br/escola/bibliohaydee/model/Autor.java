package br.escola.bibliohaydee.model;

public class Autor {

    public String nome;
    public String nacionalidade;
    public int anoNascimento;

    public void autor() {
    }

    @Override
    public String toString() {
        return "Autor: " + nome +
                ", Nacionalidade: " + nacionalidade +
                ", Ano de nascimento: " + anoNascimento;
    }
}