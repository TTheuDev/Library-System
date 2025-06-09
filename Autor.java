package Library_System;

import java.time.LocalDate;

class Autor {
    private int id;
    private String nome;
    private LocalDate dataNascimento;

    public Autor(int id, String nome, LocalDate dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    // Getters
    public int getId() { return id; }
    public String getNome() { return nome; }
    public LocalDate getDataNascimento() { return dataNascimento; }

    @Override
    public String toString() {
        return nome;
    }
}
