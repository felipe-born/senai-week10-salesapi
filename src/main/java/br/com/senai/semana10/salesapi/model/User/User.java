package br.com.senai.semana10.salesapi.model.User;

import br.com.senai.semana10.salesapi.parameter.UserPostParameter;

public class User {

    private int id;
    private String nome;
    private String email;
    private String senha;
    private Integer idade;


    public User(Integer id, UserPostParameter userPostParameter) {
        this.id = id;
        this.nome = userPostParameter.getNome();
        this.email = userPostParameter.getEmail();
        this.senha = userPostParameter.getSenha();
        this.idade = userPostParameter.getIdade();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}
