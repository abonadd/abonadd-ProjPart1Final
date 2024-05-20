package org.example.model;

import org.example.interfaceAndAbtract.Acomodacao;
import org.example.interfaceAndAbtract.Reservavel;

public class SuiteLuxo extends Acomodacao implements Reservavel {
    private boolean reservado;

    public boolean isReservado() {
        return reservado;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }

    @Override
    public void reservar() {
        if (!reservado) {
            reservado = true;
            System.out.println("Quarto Simples reservado com sucesso.");
        } else {
            System.out.println("Quarto Simples já está reservado.");
        }
    }

    @Override
    public void cancelarReserva() {
        if (reservado) {
            reservado = false;
            System.out.println("Reserva do Quarto Simples cancelada com sucesso.");
        } else {
            System.out.println("Quarto Simples não está reservado.");
        }
    }
}
