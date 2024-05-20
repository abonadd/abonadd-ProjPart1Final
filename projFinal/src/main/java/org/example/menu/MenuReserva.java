package org.example.menu;

import org.example.dao.ReservaDAO;
import org.example.model.Reserva;

import java.util.List;
import java.util.Scanner;

public class MenuReserva {

    public void menu() {
        Scanner input = new Scanner(System.in);
        int op;
        ReservaDAO reservaDAO = new ReservaDAO();

        do {
            System.out.println("\n****Menu de Reservas****");
            System.out.println("1 - Listar Reservas");
            System.out.println("2 - Criar Reserva");
            System.out.println("3 - Atualizar Reserva");
            System.out.println("4 - Deletar Reserva");
            System.out.println("5 - Sair");
            System.out.println("Escolha uma opção:");

            op = input.nextInt();

            switch (op) {
                case 1:
                    listarReservas();
                    break;
                case 2:
                    criarReserva();
                    break;
                case 3:
                    atualizarReserva();
                    break;
                case 4:
                    deletarReserva();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (op != 5);
    }

    public void listarReservas() {
        ReservaDAO reservaDAO = new ReservaDAO();
        List<Reserva> reservas = reservaDAO.listar();

        if (reservas.isEmpty()) {
            System.out.println("Não há reservas cadastradas.");
        } else {
            System.out.println("Lista de Reservas:");
            for (Reserva reserva : reservas) {
                System.out.println(reserva.getId() + " | Cliente: " + reserva.getCliente_id() + " | Acomodação: " + reserva.getAcomodacao_id() + " | Data Início: " + reserva.getData_inicio() + " | Data Fim: " + reserva.getData_fim() + " | Valor Total: " + reserva.getValor_total());
            }
        }
    }

    public void criarReserva() {
        Scanner input = new Scanner(System.in);
        ReservaDAO reservaDAO = new ReservaDAO();
        Reserva reserva = new Reserva();

        System.out.println("\n****Criar Reserva****");
        System.out.println("ID do Cliente:");
        reserva.setCliente_id(input.nextInt());
        System.out.println("ID da Acomodação:");
        reserva.setAcomodacao_id(input.nextInt());
        input.nextLine(); // Consume newline
        System.out.println("Data de Início (YYYY-MM-DD):");
        reserva.setData_inicio(input.nextLine());
        System.out.println("Data de Fim (YYYY-MM-DD):");
        reserva.setData_fim(input.nextLine());
        System.out.println("Valor Total:");
        reserva.setValor_total(input.nextLine());

        if (reservaDAO.inserir(reserva)) {
            System.out.println("Reserva criada com sucesso.");
        } else {
            System.out.println("Falha ao criar reserva.");
        }
    }

    public void atualizarReserva() {
        Scanner input = new Scanner(System.in);
        ReservaDAO reservaDAO = new ReservaDAO();
        Reserva reserva = new Reserva();

        System.out.println("\n****Atualizar Reserva****");
        System.out.println("ID da Reserva:");
        int id = input.nextInt();
        System.out.println("ID do Cliente:");
        reserva.setCliente_id(input.nextInt());
        System.out.println("ID da Acomodação:");
        reserva.setAcomodacao_id(input.nextInt());
        input.nextLine(); // Consume newline
        System.out.println("Data de Início (YYYY-MM-DD):");
        reserva.setData_inicio(input.nextLine());
        System.out.println("Data de Fim (YYYY-MM-DD):");
        reserva.setData_fim(input.nextLine());
        System.out.println("Valor Total:");
        reserva.setValor_total(input.nextLine());

        if (reservaDAO.atualizar(reserva, id)) {
            System.out.println("Reserva atualizada com sucesso.");
        } else {
            System.out.println("Falha ao atualizar reserva.");
        }
    }

    public void deletarReserva() {
        Scanner input = new Scanner(System.in);
        ReservaDAO reservaDAO = new ReservaDAO();

        System.out.println("\n****Deletar Reserva****");
        System.out.println("ID da Reserva:");
        int id = input.nextInt();

        if (reservaDAO.deletar(id)) {
            System.out.println("Reserva deletada com sucesso.");
        } else {
            System.out.println("Falha ao deletar reserva.");
        }
    }
}
