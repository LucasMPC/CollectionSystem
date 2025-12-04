/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author l3huz
 */
public class Usuario {
    private String nome;
    private String email;
    private String username;
    private String senha;
    private String dataNascimento;

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
    
}
