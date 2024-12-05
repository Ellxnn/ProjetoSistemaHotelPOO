package model;

import java.time.LocalDate;
public class Reserva {
    private Cliente cliente;
    private Quarto quarto;
    private LocalDate dataEntrada, dataSaida;
    private boolean ativa;

    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Quarto getQuarto() {
        return quarto;
    }
    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }
    public LocalDate getDataEntrada() {
        return dataEntrada;
    }
    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }
    public LocalDate getDataSaida() {
        return dataSaida;
    }
    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public Reserva(Cliente cliente, Quarto quarto, LocalDate dataEntrada, LocalDate dataSaida) {
        this.cliente = cliente;
        this.quarto = quarto;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        //  quarto.setDisponivel(false);
    }


    @Override
    public String toString() {
        return "Reserva: " +
                "Cliente:" + cliente + '\'' +
                "Quarto:" + quarto + '\''+
                "Check-in:" + dataEntrada + '\'' +
                "Check-out:" + dataSaida + '\'';
    }
}