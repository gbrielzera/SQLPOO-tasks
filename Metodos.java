package br.com.tasks;

import java.sql.*;
import java.util.Scanner;

public class Metodos {

    public static void inserirUsuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Cargo: ");
        String cargo = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();
        System.out.print("Data de criação (AAAA-MM-DD): ");
        String criadoEm = scanner.nextLine();

        try (Connection conn = Conexao.connect()) {
            String sqlInsert = "INSERT INTO Usuario (Nome, Email, Cargo, Senha, Criado_Em) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sqlInsert);
            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setString(3, cargo);
            stmt.setString(4, senha);
            stmt.setDate(5, Date.valueOf(criadoEm));
            stmt.executeUpdate();
            System.out.println("Usuário inserido com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } // Funcionando

    public static void atualizarUsuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID do Usuário a ser atualizado: ");
        int idUsuario = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        System.out.print("Novo Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Novo Email: ");
        String email = scanner.nextLine();
        System.out.print("Novo Cargo: ");
        String cargo = scanner.nextLine();
        System.out.print("Nova Senha: ");
        String senha = scanner.nextLine();

        try (Connection conn = Conexao.connect()) {
            String sqlUpdate = "UPDATE Usuario SET Nome = ?, Email = ?, Cargo = ?, Senha = ? WHERE ID_Usuario = ?";
            PreparedStatement stmt = conn.prepareStatement(sqlUpdate);
            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setString(3, cargo);
            stmt.setString(4, senha);
            stmt.setInt(5, idUsuario);
            stmt.executeUpdate();
            System.out.println("Usuário atualizado com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } // Funcionando

    public static void consultarUsuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID do Usuário a ser consultado: ");
        int id = scanner.nextInt();

        try (Connection conn = Conexao.connect()) {
            String sqlSelect = "SELECT * FROM Usuario WHERE ID_Usuario = ?";
            PreparedStatement stmt = conn.prepareStatement(sqlSelect);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("ID_Usuario"));
                System.out.println("Nome: " + rs.getString("Nome"));
                System.out.println("Email: " + rs.getString("Email"));
                System.out.println("Cargo: " + rs.getString("Cargo"));
                System.out.println("Data de Criação: " + rs.getDate("Criado_Em"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } // Funcionando

    public static void excluirUsuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID do Usuário a ser excluído: ");
        int id = scanner.nextInt();

        try (Connection conn = Conexao.connect()) {
            String sqlDelete = "DELETE FROM Usuario WHERE ID_Usuario = ?";
            PreparedStatement stmt = conn.prepareStatement(sqlDelete);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Usuário excluído com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } // Funcionando

    public static void inserirProjeto() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nome do Projeto: ");
        String nome = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Criado por (ID do usuário): ");
        int criadoPor = scanner.nextInt();
        scanner.nextLine(); // Para capturar o \n
        System.out.print("Status: ");
        String status = scanner.nextLine();
        System.out.print("Data de criação (AAAA-MM-DD): ");
        String dataCriacao = scanner.nextLine();

        try (Connection conn = Conexao.connect()) {
            String sqlInsert = "INSERT INTO Projeto (Nome_Projeto, Descricao, Criado_Por, Status_Projeto, Data_Criacao) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sqlInsert);
            stmt.setString(1, nome);
            stmt.setString(2, descricao);
            stmt.setInt(3, criadoPor);
            stmt.setString(4, status);
            stmt.setDate(5, Date.valueOf(dataCriacao));
            stmt.executeUpdate();
            System.out.println("Projeto inserido com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } // Funcionando

    public static void atualizarProjeto() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID do Projeto a ser atualizado: ");
        int idProjeto = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        System.out.print("Novo Nome do Projeto: ");
        String nomeProjeto = scanner.nextLine();
        System.out.print("Nova Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Novo Status: ");
        String statusProjeto = scanner.nextLine();
        System.out.print("Nova Data de Término (AAAA-MM-DD): ");
        String dataTermino = scanner.nextLine();

        try (Connection conn = Conexao.connect()) {
            String sqlUpdate = "UPDATE Projeto SET Nome_Projeto = ?, Descricao = ?, Status_Projeto = ?, Data_Termino = ? WHERE ID_Projeto = ?";
            PreparedStatement stmt = conn.prepareStatement(sqlUpdate);
            stmt.setString(1, nomeProjeto);
            stmt.setString(2, descricao);
            stmt.setString(3, statusProjeto);
            stmt.setString(4, dataTermino);
            stmt.setInt(5, idProjeto);
            stmt.executeUpdate();
            System.out.println("Projeto atualizado com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } // Funcionando

    public static void consultarProjeto() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID do Projeto a ser consultado: ");
        int id = scanner.nextInt();

        try (Connection conn = Conexao.connect()) {
            String sqlSelect = "SELECT * FROM Projeto WHERE ID_Projeto = ?";
            PreparedStatement stmt = conn.prepareStatement(sqlSelect);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("ID_Projeto"));
                System.out.println("Nome: " + rs.getString("Nome_Projeto"));
                System.out.println("Descrição: " + rs.getString("Descricao"));
                System.out.println("Criado por: " + rs.getInt("Criado_Por"));
                System.out.println("Status: " + rs.getString("Status_Projeto"));
                System.out.println("Data de Criação: " + rs.getDate("Data_Criacao"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } // Funcionando

    public static void excluirProjeto() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID do Projeto a ser excluído: ");
        int id = scanner.nextInt();

        try (Connection conn = Conexao.connect()) {
            String sqlDelete = "DELETE FROM Projeto WHERE ID_Projeto = ?";
            PreparedStatement stmt = conn.prepareStatement(sqlDelete);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Projeto excluído com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } // Funcionando

    public static void inserirTarefa() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nome da Tarefa: ");
        String nome = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Prioridade (1-5): ");
        int prioridade = scanner.nextInt();
        System.out.print("ID do Projeto relacionado: ");
        int idProjeto = scanner.nextInt();
        System.out.print("Responsável (ID do usuário): ");
        int responsavel = scanner.nextInt();
        scanner.nextLine(); // Para capturar o \n
        System.out.print("Status: ");
        String status = scanner.nextLine();
        System.out.print("Data de criação (AAAA-MM-DD): ");
        String criadoEm = scanner.nextLine();

        try (Connection conn = Conexao.connect()) {
            String sqlInsert = "INSERT INTO Tarefa (Nome_Tarefa, Descricao, Prioridade, ID_Projeto, Responsavel, Status_Tarefa, Criado_Em) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sqlInsert);
            stmt.setString(1, nome);
            stmt.setString(2, descricao);
            stmt.setInt(3, prioridade);
            stmt.setInt(4, idProjeto);
            stmt.setInt(5, responsavel);
            stmt.setString(6, status);
            stmt.setDate(7, Date.valueOf(criadoEm));
            stmt.executeUpdate();
            System.out.println("Tarefa inserida com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } // Funcionando

    public static void atualizarTarefa() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID da Tarefa a ser atualizada: ");
        int idTarefa = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        System.out.print("Novo Nome da Tarefa: ");
        String nomeTarefa = scanner.nextLine();
        System.out.print("Nova Descrição da Tarefa: ");
        String descricaoTarefa = scanner.nextLine();
        System.out.print("Novo Status da Tarefa: ");
        String statusTarefa = scanner.nextLine();
        System.out.print("Nova Prioridade: ");
        int prioridade = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        System.out.print("Nova Data de Criação (AAAA-MM-DD): ");
        String criadoEmTarefa = scanner.nextLine();

        try (Connection conn = Conexao.connect()) {
            String sqlUpdate = "UPDATE Tarefa SET Nome_Tarefa = ?, Descricao = ?, Status_Tarefa = ?, Prioridade = ?, Criado_Em = ? WHERE ID_Tarefa = ?";
            PreparedStatement stmt = conn.prepareStatement(sqlUpdate);
            stmt.setString(1, nomeTarefa);
            stmt.setString(2, descricaoTarefa);
            stmt.setString(3, statusTarefa);
            stmt.setInt(4, prioridade);
            stmt.setDate(5, Date.valueOf(criadoEmTarefa));
            stmt.setInt(6, idTarefa);
            stmt.executeUpdate();
            System.out.println("Tarefa atualizada com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } // Funcionando

    public static void consultarTarefa() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID da Tarefa a ser consultada: ");
        int id = scanner.nextInt();

        try (Connection conn = Conexao.connect()) {
            String sqlSelect = "SELECT * FROM Tarefa WHERE ID_Tarefa = ?";
            PreparedStatement stmt = conn.prepareStatement(sqlSelect);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("ID_Tarefa"));
                System.out.println("Nome: " + rs.getString("Nome_Tarefa"));
                System.out.println("Descrição: " + rs.getString("Descricao"));
                System.out.println("Prioridade: " + rs.getInt("Prioridade"));
                System.out.println("ID do Projeto: " + rs.getInt("ID_Projeto"));
                System.out.println("Responsável: " + rs.getInt("Responsavel"));
                System.out.println("Status: " + rs.getString("Status_Tarefa"));
                System.out.println("Data de Criação: " + rs.getDate("Criado_Em"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } // Funcionando

    public static void excluirTarefa() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID da Tarefa a ser excluída: ");
        int id = scanner.nextInt();

        try (Connection conn = Conexao.connect()) {
            String sqlDelete = "DELETE FROM Tarefa WHERE ID_Tarefa = ?";
            PreparedStatement stmt = conn.prepareStatement(sqlDelete);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Tarefa excluída com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } // Funcionando


}


