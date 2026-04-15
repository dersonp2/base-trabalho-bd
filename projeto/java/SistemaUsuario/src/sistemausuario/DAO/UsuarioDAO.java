package sistemausuario.DAO;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import sistemausuario.connection.Conexao;
import sistemausuario.model.Usuario;

public class UsuarioDAO {

    public void salvarComSqlExplicito(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nome, email) VALUES ('"
                + usuario.getNome() + "', '"
                + usuario.getEmail() + "')";

        try (Connection conn = Conexao.conectar();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("✅ Usuario cadastrado (SQL explícito)!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void salvar(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nome, email) VALUES (?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());

            stmt.executeUpdate();
            System.out.println("✅ Usuario cadastrado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listar() {
        String sql = "SELECT * FROM usuarios";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("\n📋 Lista de Usuarios:");

            while (rs.next()) {
                System.out.println("----------------------");
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("Email: " + rs.getString("email"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // UPDATE
    public void atualizar(int id, Usuario usuario) {
        String sql = "UPDATE usuarios SET nome = ?, email = ? WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setInt(3, id);

            int linhas = stmt.executeUpdate();

            if (linhas > 0) {
                System.out.println("✅ Usuario atualizado!");
            } else {
                System.out.println("⚠️ Usuario não encontrado!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deletar(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            int linhas = stmt.executeUpdate();

            if (linhas > 0) {
                System.out.println("🗑️ Usuário removido!");
            } else {
                System.out.println("⚠️ Usuario não encontrado!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // BUSCAR POR NOME
    public void buscarPorNome(String nome) {
        String sql = "SELECT * FROM usuarios WHERE nome ILIKE ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + nome + "%");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println("----------------------");
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("Email: " + rs.getString("email"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // BUSCAR POR EMAIL
    public void buscarPorEmail(String email) {
        String sql = "SELECT * FROM usuarios WHERE email ILIKE ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + email + "%");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println("----------------------");
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("Email: " + rs.getString("email"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void listarOrdenado(String campo, String direcao) {

    // validação básica pra evitar SQL Injection
    if (!campo.equalsIgnoreCase("nome") && !campo.equalsIgnoreCase("email")) {
        System.out.println("Campo invalido!");
        return;
    }

    if (!direcao.equalsIgnoreCase("ASC") && !direcao.equalsIgnoreCase("DESC")) {
        System.out.println("Direcao invalida!");
        return;
    }

    String sql = "SELECT * FROM usuarios ORDER BY " + campo + " " + direcao;

    try (Connection conn = Conexao.conectar();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {

        System.out.println("\n📋 Lista ordenada por " + campo + " (" + direcao + "):");

        while (rs.next()) {
            System.out.println("----------------------");
            System.out.println("ID: " + rs.getInt("id"));
            System.out.println("Nome: " + rs.getString("nome"));
            System.out.println("Email: " + rs.getString("email"));
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}
}
