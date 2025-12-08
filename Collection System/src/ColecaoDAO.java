import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ColecaoDAO {

    // 1. Cadastrar Coleção (Agora recebendo o Ícone também)
    public void cadastrar(String nomeColecao, String icone, int idUsuario) {
        // Atualizei o SQL para salvar o icone
        String sql = "INSERT INTO colecao (nome, icone, id_usuario) VALUES (?, ?, ?)";
        
        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, nomeColecao);
            ps.setString(2, icone); // Salva o icone (ex: "PC")
            ps.setInt(3, idUsuario);
            
            ps.execute();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar coleção: " + e.getMessage());
        }
    }

    // 2. Listar Coleções de um Usuário
    public List<Colecao> listarPorUsuario(int idUsuario) {
        List<Colecao> lista = new ArrayList<>();
        String sql = "SELECT * FROM colecao WHERE id_usuario = ?";
        
        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                String nome = rs.getString("nome");
                String icone = rs.getString("icone"); // Busca o icone do banco
                int idDaColecao = rs.getInt("id");
                
                // Agora sim o construtor funciona (Nome, Icone, Usuario)
                Colecao c = new Colecao(nome, icone, DadosTemporarios.usuarioLogado);
                c.setId(idDaColecao);
                
                lista.add(c);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}