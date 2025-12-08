package model;

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
    private int id;
    private String nome;
    private String icone;
    private Usuario usuario; // Chave estrangeira id_usuario

    public Colecao(String nome, String icone, Usuario usuario) {
        this.nome = nome;
        this.icone = icone;
        this.usuario = usuario;
    }
    
    public String getNome() {
        return nome;
    }

    public String getIcone() {
        return icone;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}