package model;

public final class Cliente extends Pessoa {

    private String CPF;

    public Cliente(String nome, String telefone, String cpf) {
        super(nome, telefone);
        this.CPF = cpf;
    }
    public String getCPF() {
        return CPF;
    }
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    @Override
    public String toString() {
        return "Cliente: " +
                "Nome:'" + nome + '\'' +
                "Telefone:'" + telefone + '\'' +
                "CPF:" + CPF;
    }
}

