import service.ClienteService;
import service.FuncionarioServise;
import service.QuartoService;
import service.ReservaService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ClienteService clienteService = new ClienteService();
        FuncionarioServise funcionarioService = new FuncionarioServise();
        QuartoService quartoService = new QuartoService();
        ReservaService reservaService = new ReservaService();

        int opcao;
        int opcao2;


        System.out.println("\n***** Sistema de Gerenciamento do Hotel *****");
        do {
            System.out.println("-----Menu-----");
            System.out.println("1- Cadastrar Cliente");
            System.out.println("2- Cadastrar Funcionário");
            System.out.println("3- Cadastrar Quarto");
            System.out.println("4- Reservar Quarto");
            System.out.println("5- Realizar Check-in");
            System.out.println("6- Realizar Check-out");
            System.out.println("7- Listar Clientes");
            System.out.println("8- Listar Funcionários");
            System.out.println("9- Listar Quartos");

            System.out.print("Escolha uma opção: ");
            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("\n--- Cadastro de Cliente ---");
                    clienteService.cadastrar();
                    break;

                case 2:
                    System.out.println("\n--- Cadastro de Funcionário ---");
                    funcionarioService.cadastrar();
                    break;

                case 3:
                    System.out.println("\n--- Cadastro de Quarto ---");
                    quartoService.cadastrar();
                    break;

                case 4:
                    System.out.println("\n--- Reserva de Quarto ---");
                    reservaService.reservar();
                    break;

                case 5:
                    System.out.println("\n--- Check-in ---");
                    reservaService.checkin();
                    break;

                case 6:
                    System.out.println("\n--- Check-out ---");
                    reservaService.checkout();
                    break;

                case 7:
                    System.out.println("\n--- Lista de Clientes ---");
                    clienteService.listar();
                    break;

                case 8:
                    System.out.println("\n--- Lista de Funcionários ---");
                    funcionarioService.listar();
                    break;

                case 9:
                    System.out.println("\n--- Lista de Quartos ---");
                    quartoService.listar();
                    break;

                case 0:
                    System.out.println("Saindo do sistema... Até mais!");
                    input.close();
                    System.exit(0);

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }

            System.out.println("O que deseja fazer: \n 1 - Voltar ao Menu \n 2 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao2 = input.nextInt();

            if (opcao2 == 1) {
                System.out.println("Você escolheu continuar!");
            } else if (opcao2 == 2) {
                System.out.println("Programa encerrado!");
            } else {
                System.out.println("Opção inválida! Tente novamente.");
            }

        } while (opcao2 == 1);
    }
}
