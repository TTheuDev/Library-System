package Library_System;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

class Biblioteca {
    private List<Livro> livros = new ArrayList<>();
    private List<Autor> autores = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();
    private int proximoIdEmprestimo = 1;

    public Biblioteca() {
        inicializarDados();
    }

    private void inicializarDados() {
        // Criando alguns autores
        Autor autor1 = new Autor(1, "J.K. Rowling", LocalDate.of(1965, 7, 31));
        Autor autor2 = new Autor(2, "George Orwell", LocalDate.of(1903, 6, 25));
        Autor autor3 = new Autor(3, "Machado de Assis", LocalDate.of(1839, 6, 21));
        Autor autor4 = new Autor(4, "Clarice Lispector", LocalDate.of(1920, 12, 10));

        autores.add(autor1);
        autores.add(autor2);
        autores.add(autor3);
        autores.add(autor4);

        // Criando alguns livros
        livros.add(new Livro(1, "Harry Potter e a Pedra Filosofal", autor1));
        livros.add(new Livro(2, "Harry Potter e a Câmara Secreta", autor1));
        livros.add(new Livro(3, "1984", autor2));
        livros.add(new Livro(4, "A Revolução dos Bichos", autor2));
        livros.add(new Livro(5, "Dom Casmurro", autor3));
        livros.add(new Livro(6, "O Cortiço", autor3));
        livros.add(new Livro(7, "A Hora da Estrela", autor4));
        livros.add(new Livro(8, "Água Viva", autor4));
    }

    public void listarLivrosDisponiveis() {
        System.out.println("\n=== LIVROS DISPONÍVEIS ===");
        boolean temLivrosDisponiveis = false;

        for (Livro livro : livros) {
            if (livro.isDisponivel()) {
                System.out.println(livro);
                temLivrosDisponiveis = true;
            }
        }

        if (!temLivrosDisponiveis) {
            System.out.println("Nenhum livro disponível no momento.");
        }
        System.out.println("==========================\n");
    }

    public Livro buscarLivroPorId(int id) {
        for (Livro livro : livros) {
            if (livro.getId() == id) {
                return livro;
            }
        }
        return null;
    }

    public boolean realizarEmprestimo(int idLivro, String nomeUsuario) {
        Livro livro = buscarLivroPorId(idLivro);

        if (livro == null) {
            System.out.println("Livro não encontrado!");
            return false;
        }

        if (!livro.isDisponivel()) {
            System.out.println("Este livro já está emprestado!");
            return false;
        }

        // Realizando o empréstimo
        livro.setDisponivel(false);
        Emprestimo emprestimo = new Emprestimo(proximoIdEmprestimo++, livro, nomeUsuario);
        emprestimos.add(emprestimo);

        System.out.println("\n✅ EMPRÉSTIMO REALIZADO COM SUCESSO! ✅");
        System.out.println("Livro: \"" + livro.getTitulo() + "\"");
        System.out.println("Autor: " + livro.getAutor().getNome());
        System.out.println("Emprestado para: " + nomeUsuario);
        System.out.println("Data do empréstimo: " + LocalDate.now());
        System.out.println("==========================================\n");

        return true;
    }

    public void listarEmprestimos() {
        if (emprestimos.isEmpty()) {
            System.out.println("Nenhum empréstimo realizado.");
            return;
        }

        System.out.println("\n=== HISTÓRICO DE EMPRÉSTIMOS ===");
        for (Emprestimo emprestimo : emprestimos) {
            System.out.println(emprestimo);
        }
        System.out.println("================================\n");
    }
}
