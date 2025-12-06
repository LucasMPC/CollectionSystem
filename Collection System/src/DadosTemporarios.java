/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author l3huz
 */
import java.util.ArrayList;
import java.util.List;

public class DadosTemporarios {
    // Lista estática para funcionar como "Banco de Dados" em memória
    public static List<Usuario> listaUsuarios = new ArrayList<>();
    
    // Lista de Desenvolvedoras (para preencher seu ComboBox depois)
    public static List<Desenvolvedora> listaDesenvolvedoras = new ArrayList<>();
    
    // Variável para saber quem está logado no momento
    public static Usuario usuarioLogado = null;

    // Bloco estático para iniciar com alguns dados de teste (Opcional)
    static {
        // Cria um admin padrão para você não ter que cadastrar toda vez que rodar
        listaUsuarios.add(new Usuario("Administrador", "admin@sistema.com", "admin", "admin", "01/01/2000"));
        
        // Cria algumas desenvolvedoras padrão
        listaDesenvolvedoras.add(new Desenvolvedora("Nintendo", "Japão", "1889"));
        listaDesenvolvedoras.add(new Desenvolvedora("Sony Santa Monica", "EUA", "1999"));
        listaDesenvolvedoras.add(new Desenvolvedora("Ubisoft", "França", "1986"));
    }
}