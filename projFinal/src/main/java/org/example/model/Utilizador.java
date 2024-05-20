package org.example.model;

public class Utilizador {
    private int id;
    private String nome;
    private String email;
    private String password;
    private String telefone;
    private tipoUtilizador tipo;

    public enum tipoUtilizador {
        cliente,
        funcionario
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public tipoUtilizador getTipo() {
        return tipo;
    }

    public void setTipo(tipoUtilizador tipo) {
        this.tipo = tipo;
    }
}
