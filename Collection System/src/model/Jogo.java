package model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author l3huz
 */
public class Jogo {
    private int id;
    private String nome;
    private String dataLancamento;
    private String descricao;
    private Desenvolvedora desenvolvedora;
    private String genero;
    private String tipoMidia;

    public Jogo(String nome, String dataLancamento, String descricao, Desenvolvedora desenvolvedora, String genero, String tipoMidia) {
        this.nome = nome;
        this.dataLancamento = dataLancamento;
        this.descricao = descricao;
        this.desenvolvedora = desenvolvedora;
        this.genero = genero;
        this.tipoMidia = tipoMidia;
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
    
    public String getGenero() { 
        return genero; 
    }
    public String getTipoMidia() {
        return tipoMidia;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDesenvolvedora(Desenvolvedora desenvolvedora) {
        this.desenvolvedora = desenvolvedora;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setTipoMidia(String tipoMidia) {
        this.tipoMidia = tipoMidia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void exibirInfos() {
        System.out.println("Jogo: " + nome + " | Gen: " + genero + " | Midia: " + tipoMidia);
    }
}
