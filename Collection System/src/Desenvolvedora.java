/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author l3huz
 */
public class Desenvolvedora {
    private int id;
    private String nome;
    private String pais;
    private String dataFundacao;

    public Desenvolvedora(String nome, String pais, String dataFundacao) {
        this.nome = nome;
        this.pais = pais;
        this.dataFundacao = dataFundacao;
    }
    
    // Construtor auxiliar para o Banco de Dados (Só ID e Nome)
    public Desenvolvedora(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.pais = "N/A"; // Valor padrão
        this.dataFundacao = "N/A";
    }

    public String getNome() {
        return nome;
    }

    public String getPais() {
        return pais;
    }

    public String getDataFundacao() {
        return dataFundacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
