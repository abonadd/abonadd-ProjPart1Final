package org.example.login;

import org.example.dao.UtilizadorDAO;
import org.example.menu.MenuPrincipal;
import org.example.menu.menuCliente.MenuCliente;
import org.example.menu.menuFuncionario.MenuFuncionario;
import org.example.model.Utilizador;

import java.util.List;
import java.util.Scanner;

public class Logar {
    public void logar() {
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        MenuCliente menuCliente = new MenuCliente();
        MenuFuncionario menuFuncionario = new MenuFuncionario();
        Scanner input = new Scanner(System.in);
        int op;
        String nome, pass;
        Utilizador.tipoUtilizador tipo = null;
//opcoes de login
        do {
            System.out.println("\n1-Administrador\n2-Utilizador\n3-Sair");
            System.out.println("Escolher:");
            op = input.nextInt();
            input.nextLine(); // Consumir a nova linha

            switch (op) {
                case 1:
                    menuPrincipal.menuPrincipal();
                    break;
                case 2:
                    System.out.println("Nome:");
                    nome = input.nextLine();
                    System.out.println("Password:");
                    pass = input.nextLine();
                    tipo = verificarUtilizador(nome, pass);
                    if (tipo != null) {
                        switch (tipo) {
                            case cliente:
                                menuCliente.menu();
                                break;
                            case funcionario:
                                menuFuncionario.menu();
                                break;
                        }
                    } else {
                        System.out.println("Utilizador não encontrado ou credenciais inválidas");
                    }
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (op != 3);
    }
//verificar se o utlizador existe no sistema
    public Utilizador.tipoUtilizador verificarUtilizador(String nome, String pass) {
        UtilizadorDAO dao = new UtilizadorDAO();
        List<Utilizador> list = dao.listar();
        for (Utilizador user : list) {
            if (user.getNome().equals(nome) && user.getPassword().equals(pass)) {
                return user.getTipo();
            }
        }
        return null;
    }
}
