package dao;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author l3huz
 */
import model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class UsuarioDAO {
    
    // 1. Método para CADASTRAR (INSERT)
    public void cadastrar(Usuario u) {
        String sql = "INSERT INTO usuario (nome, email, username, senha, data_nascimento) VALUES (?, ?, ?, ?, ?)";
        
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            conn = Conexao.getConexao();
            ps = conn.prepareStatement(sql);
            
            ps.setString(1, u.getNome());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getUsername());
            ps.setString(4, u.getSenha()); // Em um sistema real, aqui criptografaríamos a senha
            ps.setString(5, u.getDataNascimento());
            
            ps.execute();
            // Não precisa mostrar mensagem aqui, deixamos para a tela
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário: " + e.getMessage());
        } finally {
            // Fechar conexões para não pesar o banco
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // 2. Método para LOGIN (SELECT)
    // Retorna o objeto Usuario se achar, ou null se não achar
    public Usuario login(String user, String senha) {
        String sql = "SELECT * FROM usuario WHERE username = ? AND senha = ?";
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            conn = Conexao.getConexao();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, senha);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                // Se entrou aqui, achou o usuário! Vamos reconstruir o objeto
                Usuario u = new Usuario(
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("username"),
                    rs.getString("senha"),
                    rs.getString("data_nascimento")
                );
                
                u.setId(rs.getInt("id")); // Pega o ID do banco (1, 2, 3...) e guarda no Java
                
                // DICA: Aqui futuramente carregaremos o ID e o Histórico do banco
                return u;
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao logar: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return null; // Não achou ninguém
    }
    
    // 3. Método Auxiliar: Verificar se usuário já existe (para evitar duplicatas no cadastro)
    public boolean usuarioExiste(String username) {
        String sql = "SELECT id FROM usuario WHERE username = ?";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            return rs.next(); // Retorna true se encontrou alguém
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
