package Library_System;

import java.util.Scanner;

class Principal {
    private static Scanner scanner = new Scanner(System.in);
    private static Biblioteca biblioteca = new Biblioteca();

    public static void main(String[] args) {
        System.out.println("🏛️  BEM-VINDO AO SISTEMA DA BIBLIOTECA! 🏛️\n");

        boolean continuar = true;

        while (continuar) {
            System.out.print("Deseja ver os livros disponíveis?: ");
            String resposta = scanner.nextLine().trim().toUpperCase();

            if (resposta.equals("S") || resposta.equals("SIM")) {
                biblioteca.listarLivrosDisponiveis();
                realizarEmprestimo();
            } else if (resposta.equals("N") || resposta.equals("NAO") || resposta.equals("NÃO")) {
                continuar = false;
            } else {
                System.out.println("❌ Resposta inválida! Digite S para SIM ou N para NÃO.\n");
            }
        }

        System.out.println("📚 Obrigado por usar o Sistema da Biblioteca! 📚");
        System.out.println("🔚 Encerrando a aplicação... Até logo! 🔚");
        scanner.close();
    }

    private static void realizarEmprestimo() {
        try {
            System.out.print("Digite o ID do livro que deseja: ");
            int idLivro = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Digite seu nome completo: ");
            String nomeUsuario = scanner.nextLine().trim();

            if (nomeUsuario.isEmpty()) {
                System.out.println("❌ Nome não pode estar vazio!\n");
                return;
            }

            biblioteca.realizarEmprestimo(idLivro, nomeUsuario);

        } catch (NumberFormatException e) {
            System.out.println("❌ ID inválido! Digite apenas números.\n");
        } catch (Exception e) {
            System.out.println("❌ Erro inesperado: " + e.getMessage() + "\n");
        }
    }
}
