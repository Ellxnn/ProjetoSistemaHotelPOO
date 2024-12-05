package service;

import model.Funcionario;
import model.Cliente;

import model.Quarto;
import model.Reserva;

import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;

public class ReservaService {

    private static ArrayList<Reserva> reservas = new ArrayList<>();

    Scanner input = new Scanner(System.in);
    Scanner sc = new Scanner(System.in);


    public void reservar() {
        System.out.println("Digite o nome do cliente: ");
        String nomeCliente = input.nextLine();

        Cliente cliente = ClienteService.buscarCliente(nomeCliente);
        if (cliente == null) {
            System.out.println("Cliente não encontrado. Cadastre-o primeiro.");
            return;
        }

        System.out.println("Quartos disponíveis: ");
        ArrayList<Quarto> quartosDisponiveis = QuartoService.listarQuartosDisponiveis();
        if (quartosDisponiveis.isEmpty()) {
            System.out.println("Nenhum quarto disponível no momento.");
            return;
        }

        for (int i = 0; i < quartosDisponiveis.size(); i++) {
            System.out.println((i + 1) + " - " + quartosDisponiveis.get(i).getTipo() + " - R$ " + quartosDisponiveis.get(i).getPreco());
        }

        System.out.println("Escolha um quarto (digite o número): ");
        int escolhaQuarto = sc.nextInt();

        if (escolhaQuarto < 1 || escolhaQuarto > quartosDisponiveis.size()) {
            System.out.println("Opção inválida.");
            return;
        }

        Quarto quartoEscolhido = quartosDisponiveis.get(escolhaQuarto - 1);


        Reserva reserva = new Reserva(cliente, quartoEscolhido, LocalDate.now(), LocalDate.now().plusDays(3));
        reservas.add(reserva);
        QuartoService.ocupar(quartoEscolhido);

        System.out.println("Reserva realizada com sucesso para " + cliente.getNome() + " no quarto " + quartoEscolhido.getTipo());
    }



    public void checkin() {
        System.out.println("Digite o nome do cliente para check-in: ");
        String nomeCliente = input.nextLine();

        Reserva reserva = buscarReservaPorCliente(nomeCliente);
        if (reserva == null) {
            System.out.println("Reserva não encontrada para esse cliente.");
            return;
        }

        if (reserva.isAtiva()) {
            System.out.println("Check-in já realizado.");
        } else {
            reserva.setAtiva(true);
            System.out.println("Check-in realizado com sucesso para " + nomeCliente);
        }
    }



    public void checkout() {
        System.out.println("Digite o nome do cliente para check-out: ");
        String nomeCliente = input.nextLine();

        Reserva reserva = buscarReservaPorCliente(nomeCliente);
        if (reserva == null) {
            System.out.println("Reserva não encontrada para esse cliente.");
            return;
        }

        if (!reserva.isAtiva()) {
            System.out.println("Check-in ainda não foi realizado.");
        } else {
            reserva.setAtiva(false);
            QuartoService.liberar(reserva.getQuarto());
            reservas.remove(reserva);
            System.out.println("Check-out realizado com sucesso para " + nomeCliente);
        }
    }



    private Reserva buscarReservaPorCliente(String nomeCliente) {
        for (Reserva reserva : reservas) {
            if (reserva.getCliente().getNome().equalsIgnoreCase(nomeCliente)) {
                return reserva;
            }
        }
        return null;
    }
}
