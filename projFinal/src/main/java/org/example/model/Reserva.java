package org.example.model;

import java.util.Date;

public class Reserva {
    private int id;
    private int cliente_id;
    private int acomodacao_id;
    private String data_inicio;
    private String data_fim;
    private String valor_total;

    public int getAcomodacao_id() {
        return acomodacao_id;
    }

    public void setAcomodacao_id(int acomodacao_id) {
        this.acomodacao_id = acomodacao_id;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public String getData_fim() {
        return data_fim;
    }

    public void setData_fim(String data_fim) {
        this.data_fim = data_fim;
    }

    public String getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(String data_inicio) {
        this.data_inicio = data_inicio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValor_total() {
        return valor_total;
    }

    public void setValor_total(String valor_total) {
        this.valor_total = valor_total;
    }
}


