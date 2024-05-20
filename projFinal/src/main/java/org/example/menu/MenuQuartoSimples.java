package org.example.menu;

import org.example.dao.HotelDAO;
import org.example.dao.QuartoSimplesDAO;
import org.example.model.Hotel;
import org.example.model.QuartoSimples;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuQuartoSimples {

    public void menu() {
        Scanner input = new Scanner(System.in);
        int op;
        //gerenciar menu para quarto simples
        do {
            System.out.println("\n****CRUD da tabela quarto_simples****");
            System.out.println("\nSelecione uma das opções:\n1-Inserir\n2-Listar\n3-Atualizar\n4-Deletar\n5-Sair");
            System.out.println("\nEscolher:");
            op = input.nextInt();
            switch (op) {
                case 1:
                    inserir();
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    atualizar();
                    break;
                case 4:
                    deletar();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (op != 5);
    }
//inserir novo quarto simples
    public void inserir() {
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        Scanner input3 = new Scanner(System.in);
        QuartoSimplesDAO quartoSimplesDAO = new QuartoSimplesDAO();
        QuartoSimples quarto = new QuartoSimples();
        HotelDAO hotelDAO = new HotelDAO();
        List<Hotel> listHotel = new ArrayList<>();
        MenuHotel menuHotel = new MenuHotel();
        boolean verf = false;

        System.out.println("\n\n***Inserir***");
        menuHotel.listar();
        System.out.println("Escolha um dos Hoteis disponiveis:");
        listHotel = hotelDAO.listar();
        System.out.println("\nHotel ID:");
        quarto.setHote_id(input2.nextInt());
        for (Hotel x : listHotel) {
            if (x.getId() == quarto.getHote_id()) {
                verf = true;
                break;
            }
        }
        if (!verf) {
            System.out.println("Opção inválida");
            inserir();
            return; // Adicionei return para evitar continuar a execução após a chamada recursiva
        }

        System.out.println("\nTipo:");
        quarto.setTipo(input.nextLine());

        System.out.println("\nPreço Base:");
        quarto.setPreco_base(input.nextLine());

        System.out.println("\nQuantidade de Leitos:");
        quarto.setQuantidadeDeLeitos(input.nextLine());

        System.out.println("\nDescrição:");
        quarto.setDescricao(input.nextLine());

        System.out.println("\nEstá reservado (true/false):");
        quarto.setReservado(input3.nextBoolean());

        quartoSimplesDAO.inserir(quarto);
        System.out.println("Inserido com sucesso");
    }
//atualizar quarto simples
    public void atualizar() {
        QuartoSimplesDAO quartoSimplesDAO = new QuartoSimplesDAO();
        QuartoSimples quarto = new QuartoSimples();
        MenuHotel menuHotel = new MenuHotel();
        List<Hotel> listHotel = new ArrayList<>();
        HotelDAO hotelDAO = new HotelDAO();
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        Scanner input3 = new Scanner(System.in);
        int op;
        boolean verf = false;
        System.out.println("\n\n***Atualizar***");
        listar();
        System.out.println("\nQual deseja atualizar:");
        op = input2.nextInt();

        System.out.println("\nInserir os novos dados");
        menuHotel.listar();
        System.out.println("Escolha um dos Hoteis disponiveis:");
        listHotel = hotelDAO.listar();
        System.out.println("\nHotel ID:");
        quarto.setHote_id(input2.nextInt());
        for (Hotel x : listHotel) {
            if (x.getId() == quarto.getHote_id()) {
                verf = true;
                break;
            }
        }
        if (!verf) {
            System.out.println("Opção inválida");
            atualizar();
            return; // Adicionei return para evitar continuar a execução após a chamada recursiva
        }

        System.out.println("\nTipo:");
        quarto.setTipo(input.nextLine());

        System.out.println("\nPreço Base:");
        quarto.setPreco_base(input.nextLine());

        System.out.println("\nQuantidade de Leitos:");
        quarto.setQuantidadeDeLeitos(input.nextLine());

        System.out.println("\nDescrição:");
        quarto.setDescricao(input.nextLine());

        System.out.println("\nEstá reservado (true/false):");
        quarto.setReservado(input3.nextBoolean());

        quartoSimplesDAO.atualizar(quarto, op);
        System.out.println("Atualizado com sucesso");
    }
//obter registro de quarto simples
    public void listar() {
        QuartoSimplesDAO quartoSimplesDAO = new QuartoSimplesDAO();
        List<QuartoSimples> listQuartoSimples = quartoSimplesDAO.listar();
        System.out.println("id | hotel_id | tipo | preco_base | quantidade_de_leitos | descricao | reservado ");
        for (QuartoSimples quarto : listQuartoSimples) {
            System.out.println(quarto.getId() + " " + quarto.getHote_id() + " " + quarto.getTipo() + " " + quarto.getPreco_base() + " " + quarto.getQuantidadeDeLeitos() + " " + quarto.getDescricao() + " " + quarto.isReservado());
        }
    }

    public void deletar() {
        QuartoSimplesDAO quartoSimplesDAO = new QuartoSimplesDAO();
        Scanner input = new Scanner(System.in);
        int op;
        System.out.println("\n\n***Deletar***");
        listar();
        System.out.println("Qual deseja deletar:");
        op = input.nextInt();
        quartoSimplesDAO.deletar(op);
        System.out.println("Deletado com sucesso");
    }
}
