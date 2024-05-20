package org.example.menu;

import org.example.dao.HotelDAO;
import org.example.dao.SuiteLuxoDAO;
import org.example.model.Hotel;
import org.example.model.SuiteLuxo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuSuiteLuxo {

    public void menu() {
        Scanner input = new Scanner(System.in);
        int op;
        do {
            System.out.println("\n****CRUD da tabela suite_luxo****");
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

    public void inserir() {
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        Scanner input3 = new Scanner(System.in);
        SuiteLuxoDAO suiteLuxoDAO = new SuiteLuxoDAO();
        SuiteLuxo suite = new SuiteLuxo();
        HotelDAO hotelDAO = new HotelDAO();
        List<Hotel> listHotel = new ArrayList<>();
        MenuHotel menuHotel = new MenuHotel();
        boolean verf = false;

        System.out.println("\n\n***Inserir***");
        menuHotel.listar();
        System.out.println("Escolha um dos Hoteis disponiveis:");
        listHotel = hotelDAO.listar();
        System.out.println("\nHotel ID:");
        suite.setHote_id(input2.nextInt());
        for (Hotel x: listHotel){
           if (x.getId()==suite.getHote_id()){
               verf = true;
                break;
            }
        }
        if (verf==false){
            System.out.println("Opção inválida");
            inserir();
        }

        System.out.println("\nTipo:");
        suite.setTipo(input.nextLine());

        System.out.println("\nPreço Base:");
        suite.setPreco_base(input.nextLine());

        System.out.println("\nQuantidade de Leitos:");
        suite.setQuantidadeDeLeitos(input.nextLine());

        System.out.println("\nDescrição:");
        suite.setDescricao(input.nextLine());

        System.out.println("\nEstá reservado (true/false):");
        suite.setReservado(input3.nextBoolean());

        suiteLuxoDAO.inserir(suite);
        System.out.println("Inserido com sucesso");
    }

    public void listar() {
        SuiteLuxoDAO suiteLuxoDAO = new SuiteLuxoDAO();
        List<SuiteLuxo> listSuiteLuxo = suiteLuxoDAO.listar();
        System.out.println("id | hotel_id | tipo | preco_base | quantidade_de_leitos | descricao | reservado ");
        for (SuiteLuxo suite : listSuiteLuxo) {
            System.out.println(suite.getId() + " " + suite.getHote_id() + " " + suite.getTipo() + " " + suite.getPreco_base() + " " + suite.getQuantidadeDeLeitos() + " " + suite.getDescricao() + " " + suite.isReservado());
        }
    }

    public void deletar() {
        SuiteLuxoDAO suiteLuxoDAO = new SuiteLuxoDAO();
        Scanner input = new Scanner(System.in);
        int op;
        System.out.println("\n\n***Deletar***");
        listar();
        System.out.println("Qual deseja deletar:");
        op = input.nextInt();
        suiteLuxoDAO.deletar(op);
        System.out.println("Deletado com sucesso");
    }

    public void atualizar() {
        SuiteLuxoDAO suiteLuxoDAO = new SuiteLuxoDAO();
        SuiteLuxo suite = new SuiteLuxo();
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
        suite.setHote_id(input2.nextInt());
        for (Hotel x: listHotel){
            if (x.getId()==suite.getHote_id()){
                verf = true;
                break;
            }
        }
        if (verf==false){
            System.out.println("Opção inválida");
            inserir();
        }

        System.out.println("\nTipo:");
        suite.setTipo(input.nextLine());

        System.out.println("\nPreço Base:");
        suite.setPreco_base(input.nextLine());

        System.out.println("\nQuantidade de Leitos:");
        suite.setQuantidadeDeLeitos(input.nextLine());

        System.out.println("\nDescrição:");
        suite.setDescricao(input.nextLine());

        System.out.println("\nEstá reservado (true/false):");
        suite.setReservado(input3.nextBoolean());

        suiteLuxoDAO.atualizar(suite, op);
        System.out.println("Atualizado com sucesso");
    }
}
