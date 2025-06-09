package Library_System;

import java.time.LocalDate;

class Livro {
    private int id;
    private String titulo;
    private Autor autor;
    private boolean disponivel;
    private LocalDate dataCadastro;
    private LocalDate dataAtualizacao;

    public Livro(int id, String titulo, Autor autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;
        this.dataCadastro = LocalDate.now();
        this.dataAtualizacao = LocalDate.now();
    }

    // Getters
    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public Autor getAutor() { return autor; }
    public boolean isDisponivel() { return disponivel; }
    public LocalDate getDataCadastro() { return dataCadastro; }
    public LocalDate getDataAtualizacao() { return dataAtualizacao; }

    // Setters
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
        this.dataAtualizacao = LocalDate.now();
    }

    @Override
    public String toString() {
        return "ID: " + id + " - \"" + titulo + "\" por " + autor.getNome() +
                " (Status: " + (disponivel ? "Disponível" : "Emprestado") + ")";
    }
}
