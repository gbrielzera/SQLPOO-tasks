package br.com.tasks;

import java.util.Scanner;

public class Menu {

    public static void exibirMenuPrincipal() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Inserir Dados");
            System.out.println("2. Atualizar Dados");
            System.out.println("3. Consultar Dados");
            System.out.println("4. Excluir Dados");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    exibirMenuTabelas("inserir");
                    break;
                case 2:
                    exibirMenuTabelas("atualizar");
                    break;
                case 3:
                    exibirMenuTabelas("consultar");
                    break;
                case 4:
                    exibirMenuTabelas("excluir");
                    break;
                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    public static void exibirMenuTabelas(String acao) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha a tabela:");
        System.out.println("1. Usuario");
        System.out.println("2. Projeto");
        System.out.println("3. Projetos_Usuario");
        System.out.println("4. Tarefa");
        System.out.println("5. Relatorio_Progresso");
        System.out.print("Escolha uma tabela: ");

        int tabelaEscolhida = scanner.nextInt();
        switch (tabelaEscolhida) {
            case 1:
                if (acao.equals("inserir")) Metodos.inserirUsuario();
                if (acao.equals("atualizar")) Metodos.atualizarUsuario();
                if (acao.equals("consultar")) Metodos.consultarUsuario();
                if (acao.equals("excluir")) Metodos.excluirUsuario();
                break;
            case 2:
                // Implementar para Projeto
                break;
            case 3:
                // Implementar para Projetos_Usuario
                break;
            case 4:
                // Implementar para Tarefa
                break;
            case 5:
                // Implementar para Relatorio_Progresso
                break;
            default:
                System.out.println("Tabela inválida.");
        }
    }
}