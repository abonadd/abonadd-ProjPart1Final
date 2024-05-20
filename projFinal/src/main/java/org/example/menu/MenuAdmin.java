package org.example.menu;

import org.example.dao.AdminDAO;
import org.example.model.Admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuAdmin {

    public void menu() {
        Scanner input = new Scanner(System.in);
        int op;
        //gerenciar menu do admin
        do {
            System.out.println("\n****CRUD da tabela admin****");
            System.out.println("\nSelecione uma das opcoes:\n1-Inserir\n2-Listar\n3-Atualizar\n4-Deletar\n5-Sair");
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
                    System.out.println("Opcao inválida");
                    break;
            }
        } while (op != 5);
    }
//inserir admin
    public void inserir() {
        Scanner input = new Scanner(System.in);
        AdminDAO adminDAO = new AdminDAO();
        Admin admin = new Admin();
        System.out.println("\n\n***Inserir***");
        System.out.println("\nNome:");
        String nome = input.nextLine();
        admin.setNome(nome);
        System.out.println("\nPassword:");
        String password = input.nextLine();
        admin.setPassword(password);

        adminDAO.inserir(admin);
        System.out.println("Inserido com sucesso");
    }
//obtter registro de admin
    public void listar() {
        AdminDAO adminDAO = new AdminDAO();
        List<Admin> listAdmin = new ArrayList<>();
        listAdmin = adminDAO.listar();
        System.out.println("id | nome | password ");
        for (Admin admin : listAdmin) {
            System.out.println(admin.getId() + " | " + admin.getNome() + " | " + admin.getPassword());
        }
    }
//remover admin
    public void deletar() {
        AdminDAO adminDAO = new AdminDAO();
        Scanner input = new Scanner(System.in);
        int op;
        System.out.println("\n\n***Deletar***");
        listar();
        System.out.println("Qual deseja deletar:");
        op = input.nextInt();
        adminDAO.deletar(op);
        System.out.println("Deletado com sucesso");
    }
//atualizar admin
    public void atualizar() {
        AdminDAO adminDAO = new AdminDAO();
        Admin admin = new Admin();
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
        admin.setNome(str);
        System.out.println("\nPassword:");
        str = input.nextLine();
        admin.setPassword(str);

        adminDAO.atualizar(admin, op);
        System.out.println("Atualizado com sucesso");
    }
}
