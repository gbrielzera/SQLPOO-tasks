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
        System.out.println("3. Tarefa");
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
                if (acao.equals("inserir")) Metodos.inserirProjeto();
                if (acao.equals("atualizar")) Metodos.atualizarProjeto();
                if (acao.equals("consultar")) Metodos.consultarProjeto();
                if (acao.equals("excluir")) Metodos.excluirProjeto();
                break;
            case 3:
                if (acao.equals("inserir")) Metodos.inserirTarefa();
                if (acao.equals("atualizar")) Metodos.atualizarTarefa();
                if (acao.equals("consultar")) Metodos.consultarTarefa();
                if (acao.equals("excluir")) Metodos.excluirTarefa();
                break;
            default:
                System.out.println("Tabela inválida.");
        }
    }
}