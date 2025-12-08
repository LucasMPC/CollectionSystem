package dao;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author l3huz
 */
import model.Desenvolvedora;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DesenvolvedoraDAO {

    // Listar todas para o ComboBox
    public List<Desenvolvedora> listarTodas() {
        List<Desenvolvedora> lista = new ArrayList<>();
        String sql = "SELECT * FROM desenvolvedora";
        
        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                // Usamos o construtor auxiliar que criamos
                lista.add(new Desenvolvedora(id, nome));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    // Buscar ID pelo nome (para saber qual salvar no jogo)
    public Desenvolvedora buscarPorNome(String nomeBusca) {
        String sql = "SELECT * FROM desenvolvedora WHERE nome = ?";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, nomeBusca);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return new Desenvolvedora(rs.getInt("id"), rs.getString("nome"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Não achou
    }
}
