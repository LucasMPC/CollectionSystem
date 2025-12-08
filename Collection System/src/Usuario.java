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

public class Usuario {
    private int id;
    private String nome;
    private String email;
    private String username;
    private String senha;
    private String dataNascimento;
    private String ultimoJogoCadastrado = "Nenhum";
    private List<String> historicoAcesso = new ArrayList<>();

    public Usuario(String nome, String email, String username, String senha, String dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.username = username;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
    }

    public String getUsername() {
        return username;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getUltimoJogoCadastrado() {
        return ultimoJogoCadastrado;
    }

    public void setUltimoJogoCadastrado(String ultimoJogoCadastrado) {
        this.ultimoJogoCadastrado = ultimoJogoCadastrado;
    }

    public List<String> getHistoricoAcesso() {
        return historicoAcesso;
    }

    public void setHistoricoAcesso(List<String> historicoAcesso) {
        this.historicoAcesso = historicoAcesso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
