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

public class Colecao {
    private String nome;
    private Usuario usuario; // Chave estrangeira id_usuario
    private List<Jogo> listaJogos; // Representa a tabela colecao_jogo_midia de forma simplificada

    public Colecao(String nome, Usuario usuario) {
        this.nome = nome;
        this.usuario = usuario;
        this.listaJogos = new ArrayList<>();
    }

    public void adicionarJogo(Jogo jogo) {
        listaJogos.add(jogo);
    }

    public void listarItens() {
        System.out.println("\n--- Colecao: " + nome + " (Usuario: " + usuario.getUsername() + ") ---");
        for (Jogo jogo : listaJogos) {
            jogo.exibirInfos();
        }
    }
}