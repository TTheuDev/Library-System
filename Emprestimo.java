package Library_System;

import java.time.LocalDate;

class Emprestimo {
    private int id;
    private Livro livro;
    private String nomeUsuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    public Emprestimo(int id, Livro livro, String nomeUsuario) {
        this.id = id;
        this.livro = livro;
        this.nomeUsuario = nomeUsuario;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucao = LocalDate.now().plusDays(15); // 15 dias para devolução
    }

    // Getters
    public int getId() { return id; }
    public Livro getLivro() { return livro; }
    public String getNomeUsuario() { return nomeUsuario; }
    public LocalDate getDataEmprestimo() { return dataEmprestimo; }
    public LocalDate getDataDevolucao() { return dataDevolucao; }

    @Override
    public String toString() {
        return "Empréstimo #" + id + " - Livro: \"" + livro.getTitulo() +
                "\" emprestado para " + nomeUsuario + " em " + dataEmprestimo +
                " (Devolução até: " + dataDevolucao + ")";
    }

}

