package model;

import enums.TipoQuarto;

public class Quarto {

    private int numero;
    private double preco;
    private TipoQuarto tipo;
    private boolean disponivel;

    public Quarto(int numero, TipoQuarto tipo, double preco) {
        this.numero = numero;
        this.tipo = tipo;
        this.preco = preco;
        this.disponivel = true;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public TipoQuarto getTipo() {
        return tipo;
    }

    public void setTipo(TipoQuarto tipo) {
        this.tipo = tipo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return "Quarto: '\''" +
                "Numero:" + numero + '\''+
                "Valor:" + preco + '\'' +
                "Tipo:" + tipo;
    }
}
