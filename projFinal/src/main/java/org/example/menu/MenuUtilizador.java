package org.example.menu;

import org.example.dao.UtilizadorDAO;
import org.example.model.Utilizador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuUtilizador {

    public void menu() {
        Scanner input = new Scanner(System.in);
        int op;
        do {
            System.out.println("\n****CRUD da tabela utilizador****");
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

    public void inserir() {
        Scanner input = new Scanner(System.in);
        UtilizadorDAO utilizadorDAO = new UtilizadorDAO();
        Utilizador utilizador = new Utilizador();
        System.out.println("\n\n***Inserir***");
        System.out.println("\nNome:");
        String nome = input.nextLine();
        utilizador.setNome(nome);
        System.out.println("\nEmail:");
        String email = input.nextLine();
        utilizador.setEmail(email);
        System.out.println("\nPassword:");
        String password = input.nextLine();
        utilizador.setPassword(password);
        System.out.println("\nTelefone:");
        String telefone = input.nextLine();
        utilizador.setTelefone(telefone);
        System.out.println("\nTipo (cliente/funcionario):");
        String tipoStr = input.nextLine();
        Utilizador.tipoUtilizador tipo = Utilizador.tipoUtilizador.valueOf(tipoStr);
        utilizador.setTipo(tipo);

        utilizadorDAO.inserir(utilizador);
        System.out.println("Inserido com sucesso");
    }

    public void listar() {
        UtilizadorDAO utilizadorDAO = new UtilizadorDAO();
        List<Utilizador> listUtilizador = utilizadorDAO.listar();
        System.out.println("id | nome | email | telefone | tipo ");
        for (Utilizador utilizador : listUtilizador) {
            System.out.println(utilizador.getId() + " | " + utilizador.getNome() + " | " + utilizador.getEmail() + " | " + utilizador.getTelefone() + " | " + utilizador.getTipo());
        }
    }

    public void deletar() {
        UtilizadorDAO utilizadorDAO = new UtilizadorDAO();
        Scanner input = new Scanner(System.in);
        int op;
        System.out.println("\n\n***Deletar***");
        listar();
        System.out.println("Qual deseja deletar:");
        op = input.nextInt();
        utilizadorDAO.deletar(op);
        System.out.println("Deletado com sucesso");
    }

    public void atualizar() {
        UtilizadorDAO utilizadorDAO = new UtilizadorDAO();
        Utilizador utilizador = new Utilizador();
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
        utilizador.setNome(str);
        System.out.println("\nEmail:");
        str = input.nextLine();
        utilizador.setEmail(str);
        System.out.println("\nPassword:");
        str = input.nextLine();
        utilizador.setPassword(str);
        System.out.println("\nTelefone:");
        str = input.nextLine();
        utilizador.setTelefone(str);
        System.out.println("\nTipo (cliente/funcionario):");
        str = input.nextLine();
        Utilizador.tipoUtilizador tipo = Utilizador.tipoUtilizador.valueOf(str);
        utilizador.setTipo(tipo);

        utilizadorDAO.atualizar(utilizador, op);
        System.out.println("Atualizado com sucesso");
    }
}
