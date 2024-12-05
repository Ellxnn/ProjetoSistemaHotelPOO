package model;

import enums.TipoFuncionario;

public final class Funcionario extends Pessoa {

    private TipoFuncionario tipo;

    public Funcionario(String nome, String telefone, TipoFuncionario tipo) {
        super(nome, telefone);
        this.tipo = tipo;
    }

    public TipoFuncionario getTipo() {
        return tipo;
    }
    public void setTipo(TipoFuncionario tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "Nome:" + nome + '\'' +
                "Telefone:" + telefone + '\'' +
                "Tipo:" + tipo;
    }
}