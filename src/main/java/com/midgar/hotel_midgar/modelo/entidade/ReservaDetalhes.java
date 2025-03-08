
package com.midgar.hotel_midgar.modelo.entidade;

import java.math.BigDecimal;


public class ReservaDetalhes {

    private Reserva reserva;
    private Suite suite;
    private int quantidade;
    private BigDecimal desconto;
    private BigDecimal total;

    public ReservaDetalhes() {
    }

    public ReservaDetalhes(Reserva reserva, Suite suite, int quantidade, BigDecimal desconto, BigDecimal total) {
        this.reserva = reserva;
        this.suite = suite;
        this.quantidade = quantidade;
        this.desconto = desconto;
        this.total = total;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Suite getSuite() {
        return suite;
    }

    public void setSuite(Suite suite) {
        this.suite = suite;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    
}
