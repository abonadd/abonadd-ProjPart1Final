package org.example.interfaceAndAbtract;

public abstract class Acomodacao {
    private int id;
    private int hote_id;
    private String tipo;
    private String preco_base;
    private String quantidadeDeLeitos;
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getHote_id() {
        return hote_id;
    }

    public void setHote_id(int hote_id) {
        this.hote_id = hote_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPreco_base() {
        return preco_base;
    }

    public void setPreco_base(String preco_base) {
        this.preco_base = preco_base;
    }

    public String getQuantidadeDeLeitos() {
        return quantidadeDeLeitos;
    }

    public void setQuantidadeDeLeitos(String quantidadeDeLeitos) {
        this.quantidadeDeLeitos = quantidadeDeLeitos;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}

