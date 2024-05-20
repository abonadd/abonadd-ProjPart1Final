package org.example.menu;

import org.example.dao.HotelDAO;
import org.example.model.Hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuHotel {

    public void menu() {
        Scanner input = new Scanner(System.in);
        int op;
        do {
            System.out.println("\n****CRUD da tabela hotel****");
            System.out.println("\n Selecione uma da opcoes:\n1-Inserir\n2-listar\n3-atualizar\n4-deletar\n5-Sair");
            System.out.println("\nEscolher:");
            op = input.nextInt();
            switch (op){
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
                    System.out.println("Opcao inválida");
                    break;
            }
        }while (op!=5);

    }
    public void inserir(){
        Scanner input = new Scanner(System.in);
        String str;
        HotelDAO hotelDAO = new HotelDAO();
        Hotel hotel = new Hotel();
        System.out.println("\n\n***Inserir***");
        System.out.println("\nNome:");
        str = input.nextLine();
        hotel.setNome(str);
        System.out.println("\nlocalizacao:");
        str = input.nextLine();
        hotel.setLocalizacao(str);

        hotelDAO.inserir(hotel);
        System.out.println("Inserido com sucesso");
    }

    public void listar(){
        Hotel hotel = new Hotel();
        HotelDAO hotelDAO = new HotelDAO();
        List<Hotel> listHotel = new ArrayList<>();
        listHotel = hotelDAO.listar();
        System.out.println("id | nome | localizacao ");
        for (Hotel hotl:listHotel){
            System.out.println(hotl.getId()+" "+hotl.getNome()+" "+hotl.getLocalizacao());
        }
    }

    public void deletar(){
        HotelDAO hotelDAO = new HotelDAO();
        Scanner input = new Scanner(System.in);
        int op;
        System.out.println("\n\n***Deletar***");
        listar();
        System.out.println("Qual deseja deletar:");
        op = input.nextInt();
        hotelDAO.deletar(op);
        System.out.println("Deletado com sucesso");
    }

    public void  atualizar(){
        HotelDAO hotelDAO = new HotelDAO();
        Hotel hotel = new Hotel();
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        int op;
        String str;
        System.out.println("\n\n***Atualizar***");
        listar();
        System.out.println("\nQual deseja atualizar:");
        op = input2.nextInt();
        System.out.println("\nInserir os novos dados");
        System.out.println("\nNome:");
        str = input.nextLine();
        hotel.setNome(str);

        System.out.println("\nlocalizacao:");
        str = input.nextLine();
        hotel.setLocalizacao(str);



        hotelDAO.atualizar(hotel,op);
        System.out.println("Atualizado com sucesso");
    }
}
