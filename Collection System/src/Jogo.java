/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author l3huz
 */
public class Jogo {
    private String nome;
    private String dataLancamento;
    private String descricao;
    private Desenvolvedora desenvolvedora; // Relacionamento com a tabela Desenvolvedora

    public Jogo(String nome, String dataLancamento, String descricao, Desenvolvedora desenvolvedora) {
        this.nome = nome;
        this.dataLancamento = dataLancamento;
        this.descricao = descricao;
        this.desenvolvedora = desenvolvedora;
    }

    public String getNome() {
        return nome;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public Desenvolvedora getDesenvolvedora() {
        return desenvolvedora;
    }
    

    public void exibirInfos() {
        System.out.println("Jogo: " + nome + " | Lancado em: " + dataLancamento + " | Dev: " + desenvolvedora.getNome());
    }
}
