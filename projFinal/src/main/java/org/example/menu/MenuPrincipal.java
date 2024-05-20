package org.example.menu;

import org.example.dao.AdminDAO;
import org.example.model.Admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {
    //fazer login como administrador
    public void loginAdmin(){
        AdminDAO dao = new AdminDAO();
        List<Admin> list = new ArrayList<>();
        list = dao.listar();
        Scanner input2 = new Scanner(System.in);
        String nom,pass;
        boolean login=false;
        System.out.println("Admin:");
        nom = input2.nextLine();
        System.out.println("\npass:");
        pass = input2.nextLine();
        for (Admin admi:list){
            if (admi.getNome().equals(nom)&&admi.getPassword().equals(pass)){
                System.out.println("\nlogado!");
                login = true;
                break;
            }
        }
        if (!login){
            menuPrincipal();
        }
    }
    //gerenciar menuprincipal
    public void menuPrincipal(){
        MenuAcomodacao menuAcomodacao = new MenuAcomodacao();
        MenuHotel menuHotel = new MenuHotel();
        MenuUtilizador menuUtilizador = new MenuUtilizador();
        MenuQuartoSimples menuQuartoSimples = new MenuQuartoSimples();
        MenuSuiteLuxo menuSuiteLuxo = new MenuSuiteLuxo();
        MenuReserva menuReserva = new MenuReserva();
        Scanner input = new Scanner(System.in);
        int op;
        loginAdmin();
        do {
            System.out.println("****//Menu Principal//****");
            System.out.println("\n1-Acomodacao\n2-Hotel\n3-Reserva\n4-Utilizador\n5-Sair");
            System.out.println("\nEscolha uma das tabelas para fazer CRUD:");
            op = input.nextInt();
            switch (op) {
                case 1:
                    System.out.println("\n\nTipo de acomodacao\n1-Quarto Simples\n2-Suite de Luxo");
                    System.out.println("\nEscolher:");
                    op = input.nextInt();
                    if (op==1){
                        menuQuartoSimples.menu();
                    } else if (op==2) {
                        menuSuiteLuxo.menu();
                    }
                    else
                        System.out.println("Escolha inválida");
                        op=0;
                    break;
                case 2:
                    menuHotel.menu();
                    break;
                case 3:
                    menuReserva.menu();
                    break;
                case 4:
                    menuUtilizador.menu();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Escolha inválida");
                    break;
            }
        }while (op!=5);
    }
}
