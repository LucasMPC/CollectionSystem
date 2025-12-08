/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author l3huz
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class JogoDAO {

    public void cadastrar(Jogo jogo, int idColecao) {
        // Atenção: id_desenvolvedora pode ser null se não tiver dev selecionada
        String sql = "INSERT INTO jogo (nome, data_lancamento, descricao, genero, tipo_midia, id_colecao, id_desenvolvedora) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, jogo.getNome());
            ps.setString(2, jogo.getDataLancamento());
            ps.setString(3, jogo.getDescricao());
            ps.setString(4, jogo.getGenero());
            ps.setString(5, jogo.getTipoMidia());
            ps.setInt(6, idColecao);
            
            // Lógica para a Desenvolvedora
            if (jogo.getDesenvolvedora() != null) {
                ps.setInt(7, jogo.getDesenvolvedora().getId());
            } else {
                ps.setNull(7, java.sql.Types.INTEGER);
            }
            
            ps.execute();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar jogo: " + e.getMessage());
        }
    }
    
    // 2. Listar Jogos de uma Coleção Específica
    public java.util.List<Jogo> listarPorColecao(int idColecao) {
        java.util.List<Jogo> lista = new java.util.ArrayList<>();
        
        // Faz o JOIN para pegar o nome da desenvolvedora junto com os dados do jogo
        String sql = "SELECT j.*, d.nome AS nome_dev " +
                     "FROM jogo j " +
                     "LEFT JOIN desenvolvedora d ON j.id_desenvolvedora = d.id " +
                     "WHERE j.id_colecao = ?";
        
        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, idColecao);
            java.sql.ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                // 1. Recupera dados básicos
                int idJogo = rs.getInt("id");
                String nome = rs.getString("nome");
                String data = rs.getString("data_lancamento");
                String desc = rs.getString("descricao");
                String gen = rs.getString("genero");
                String midia = rs.getString("tipo_midia");
                
                // 2. Reconstrói a Desenvolvedora
                int idDev = rs.getInt("id_desenvolvedora");
                String nomeDev = rs.getString("nome_dev");
                if (nomeDev == null) nomeDev = "N/A"; // Caso venha null do banco
                
                Desenvolvedora dev = new Desenvolvedora(idDev, nomeDev);
                
                // 3. Cria o objeto Jogo
                Jogo j = new Jogo(nome, data, desc, dev, gen, midia);
                j.setId(idJogo); // Importante guardar o ID para edição/exclusão futura
                
                lista.add(j);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    // 3. EXCLUIR (DELETE)
    public void excluir(int idJogo) {
        String sql = "DELETE FROM jogo WHERE id = ?";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, idJogo);
            ps.execute();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir jogo: " + e.getMessage());
        }
    }

    // 4. ATUALIZAR (UPDATE)
    public void atualizar(Jogo j) {
        String sql = "UPDATE jogo SET nome=?, data_lancamento=?, descricao=?, genero=?, tipo_midia=?, id_desenvolvedora=? WHERE id=?";
        
        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, j.getNome());
            ps.setString(2, j.getDataLancamento());
            ps.setString(3, j.getDescricao());
            ps.setString(4, j.getGenero());
            ps.setString(5, j.getTipoMidia());
            
            // Desenvolvedora (trata se for nulo)
            if (j.getDesenvolvedora() != null) {
                ps.setInt(6, j.getDesenvolvedora().getId());
            } else {
                ps.setNull(6, java.sql.Types.INTEGER);
            }
            
            ps.setInt(7, j.getId()); // Onde o ID for igual ao do jogo
            
            ps.execute();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + e.getMessage());
        }
    }
    
    // 5. NOVO MÉTODO: Conta quantos jogos tem na coleção (sem carregar a lista toda)
    public int contarJogosPorColecao(int idColecao) {
        String sql = "SELECT COUNT(*) FROM jogo WHERE id_colecao = ?";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, idColecao);
            java.sql.ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return rs.getInt(1); // Retorna o número total
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    // Método auxiliar para descobrir o nome da coleção a partir do ID do jogo
    public String buscarNomeColecaoPorIdJogo(int idJogo) {
        String sql = "SELECT c.nome FROM colecao c INNER JOIN jogo j ON c.id = j.id_colecao WHERE j.id = ?";
        
        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, idJogo);
            java.sql.ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return rs.getString("nome");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Não achou
    }
}
