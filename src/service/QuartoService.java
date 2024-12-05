package service;

import enums.TipoQuarto;
import model.Cadastro;
import model.Quarto;

import java.util.ArrayList;
import java.util.Scanner;

public class QuartoService {

    Scanner input = new Scanner(System.in);
    Scanner sc = new Scanner(System.in);
    public static ArrayList<Quarto> quartos = new ArrayList<>();


    public void cadastrar() {

        System.out.println("Digite o número do quarto: ");
        int numero = sc.nextInt();

        System.out.println("Digite o tipo de quarto (SIMPLES,DUPLO, LUXO): ");
        String tipo = input.nextLine().toUpperCase();
        TipoQuarto tipoQuarto;

        try {
            tipoQuarto = TipoQuarto.valueOf(tipo);
        } catch (IllegalArgumentException e) {
            System.out.println("Tipo de quarto inválido!");
            return;
        }

        System.out.println("Digite o preço do quarto: ");
        double preco = sc.nextDouble();
        input.nextLine();

        Quarto quarto= new Quarto(numero, tipoQuarto, preco);
        quartos.add((Quarto) quarto);
        System.out.println("FUNCIONÁRIO CADASTRADO!!");
    }

    public void remover(String nome) {

    }


    public void listar() {
        System.out.println("Funcionários Cadastrados: ");
        for(Quarto quarto : quartos){
            System.out.println(quarto);
        }
    }

    public static ArrayList<Quarto> listarQuartosDisponiveis() {
        ArrayList<Quarto> quartosDisponiveis = new ArrayList<>();
        for (Quarto quarto : quartos) {
            if (quarto.isDisponivel()) {
                quartosDisponiveis.add(quarto);
            }
        }
        return quartosDisponiveis;
    }


    public static void ocupar(Quarto quarto) {
        quarto.setDisponivel(false);
        System.out.println("Quarto " + quarto.getNumero() + " agora está ocupado.");
    }


    public static void liberar(Quarto quarto) {
        quarto.setDisponivel(true);
        System.out.println("Quarto " + quarto.getNumero() + " liberado.");
    }
}