package service;

import enums.TipoFuncionario;
import model.Funcionario;
import model.Pessoa;
import model.Cadastro;

import java.util.ArrayList;
import java.util.Scanner;
public class FuncionarioServise implements Cadastro {

    Scanner input = new Scanner(System.in);
    public static ArrayList<Funcionario> funcionarios = new ArrayList<>();

    @Override
    public void cadastrar() {

        System.out.println("Digite o nome do funcionário: ");
        String nome = input.nextLine();

        System.out.println("Digite o telefone do funcionário: ");
        String tel = input.nextLine();

        System.out.println("Digite o tipo de funcionário (RECEPCIONISTA, GERENTE, LIMPEZA): ");
        String tipoF = input.nextLine().toUpperCase();
        TipoFuncionario tipoFuncionario;

        try {
            tipoFuncionario = TipoFuncionario.valueOf(tipoF);
        } catch (IllegalArgumentException e) {
            System.out.println("Tipo de funcionário inválido!");
            return;
        }
        Pessoa funcionario = new Funcionario(nome, tel,  tipoFuncionario);
        funcionarios.add((Funcionario) funcionario);
        System.out.println("FUNCIONÁRIO CADASTRADO!!");
    }

    @Override
    public void remover(String nome) {

    }

    @Override
    public void listar() {
        System.out.println("Funcionários Cadastrados: ");
        for(Funcionario funcionario : funcionarios){
            System.out.println(funcionario);
        }
    }
}
