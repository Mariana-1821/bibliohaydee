
package br.escola.bibliohaydee.model;

public class Usuario {

    public static final int LIMITE_PADRAO = 3;

    private String nome;
    private String matricula;
    private String tipo;
    private Integer limiteEmprestimos;
    private Integer emprestimosAtivos;

    public Usuario(String nome, String matricula, String tipo, int limite) {

        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser vazio.");
        }

        if (tipo == null ||
                (!tipo.equalsIgnoreCase("ALUNO")
                        && !tipo.equalsIgnoreCase("PROFESSOR"))) {
            throw new IllegalArgumentException(
                    "O tipo deve ser ALUNO ou PROFESSOR."
            );
        }

        if (limite < 1) {
            throw new IllegalArgumentException(
                    "O limite deve ser maior que zero."
            );
        }

        this.nome = nome.trim();
        this.matricula = matricula;
        this.tipo = tipo.toUpperCase();
        this.limiteEmprestimos = limite;
        this.emprestimosAtivos = 0;
    }

    public Usuario(String nome, String matricula, String tipo) {
        this(nome, matricula, tipo, LIMITE_PADRAO);
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getTipo() {
        return tipo;
    }

    public Integer getLimiteEmprestimos() {
        return limiteEmprestimos;
    }

    public Integer getEmprestimosAtivos() {
        return emprestimosAtivos;
    }

    @Override
    public String toString() {
        return "Usuário: " + nome
                + ", Matrícula: " + matricula
                + ", Tipo: " + tipo
                + ", Limite de empréstimos: " + limiteEmprestimos
                + ", Empréstimos ativos: " + emprestimosAtivos;
    }
}
