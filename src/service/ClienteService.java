package service;

import model.Cliente;
import model.Pessoa;
import model.Cadastro;

import java.util.ArrayList;
import java.util.Scanner;
public class  ClienteService implements Cadastro {

    Scanner input = new Scanner(System.in);
    public static ArrayList<Cliente> clientes = new ArrayList<>();

    @Override
    public void cadastrar() {

        System.out.println("Digite o nome do cliente: ");
        String nome = input.nextLine();

        System.out.println("Digite o telefone do cliente: ");
        String tel = input.nextLine();

        System.out.println("Digite o CPF do cliente: ");
        String cpf = input.nextLine();

        Pessoa cliente = new Cliente(nome, tel, cpf);
        clientes.add((Cliente) cliente);
        System.out.println("CLIENTE CADASTRADO!!");
    }

    @Override
    public void remover(String nome) {

    }

    @Override
    public void listar() {
        System.out.println("Clientes Cadastrados: ");
        for(Cliente cliente : clientes){
            System.out.println(cliente);
        }
    }

    public static Cliente buscarCliente(String nome) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                return cliente;
            }
        }
        System.out.println("Cliente não encontrado.");
        return null;
    }
}
