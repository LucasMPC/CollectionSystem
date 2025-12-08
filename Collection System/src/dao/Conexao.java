package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexao {
    
    // Configurações do Banco
    // Se o seu MySQL tiver senha, mude o campo PASSWORD abaixo
    private static final String URL = "jdbc:mysql://localhost:3306/collection_system_db";
    private static final String USER = "root";
    private static final String PASSWORD = "LMPc14082009!"; 
    
    // Método que abre e devolve a conexão
    public static Connection getConexao() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            return conn;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar no banco:\n" + e.getMessage());
            return null;
        }
    }
    
    // MÉTODO DE TESTE (Só para saber se está funcionando agora)
    public static void main(String[] args) {
        if (getConexao() != null) {
            JOptionPane.showMessageDialog(null, "Conexão realizada com sucesso! 🟢");
        }
    }
}
