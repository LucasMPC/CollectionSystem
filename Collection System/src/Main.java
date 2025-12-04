/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author l3huz
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Collection System (v0.5) ===\n");

        // 1. Criando Desenvolvedora (Tabela Desenvolvedora)
        Desenvolvedora nintendo = new Desenvolvedora("Nintendo", "Japão", "1889-09-23");

        // 2. Criando Jogo (Tabela Jogo)
        Jogo mario = new Jogo("Super Mario Odyssey", "2017-10-27", "Jogo de plataforma 3D", nintendo);

        // 3. Criando Usuário (Tabela Usuario)
        Usuario lucas = new Usuario("Lucas Camargo", "lucas@email.com", "lucas_master", "1234", "1995-01-01");

        // 4. Criando Coleção (Tabela Colecao)
        Colecao minhaLista = new Colecao("Jogos Zerados", lucas);
        
        // 5. Associando (Simulando a tabela colecao_jogo_midia)
        minhaLista.adicionarJogo(mario);

        // 6. Saída
        minhaLista.listarItens();
    }
}