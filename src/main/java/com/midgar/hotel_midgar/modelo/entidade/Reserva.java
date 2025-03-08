
package com.midgar.hotel_midgar.modelo.entidade;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Objects;

public class Reserva {
    
    private Long id;
    private Hospede hospede;
    private Usuario usuario;
    private BigDecimal totalReserva;
    private BigDecimal valorPago;
    private BigDecimal troco;
    private BigDecimal desconto;
    private LocalDateTime dataHoraCriacao;
    private LocalDateTime ultimaAtualizacao;
    private HashMap<String, ReservaDetalhes> reservasDetalhes;

    public Reserva() {
    }

    public Reserva(Long id, Hospede hospede, Usuario usuario, BigDecimal totalReserva, BigDecimal valorPago, BigDecimal troco, BigDecimal desconto, LocalDateTime dataHoraCriacao, LocalDateTime ultimaAtualizacao, HashMap<String, ReservaDetalhes> reservasDetalhes) {
        this.id = id;
        this.hospede = hospede;
        this.usuario = usuario;
        this.totalReserva = totalReserva;
        this.valorPago = valorPago;
        this.troco = troco;
        this.desconto = desconto;
        this.dataHoraCriacao = dataHoraCriacao;
        this.ultimaAtualizacao = ultimaAtualizacao;
        this.reservasDetalhes = reservasDetalhes;
    }       

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setCliente(Hospede hospede) {
        this.hospede = hospede;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getDataHoraCriacao() {
        return dataHoraCriacao;
    }

    public void setDataHoraCriacao(LocalDateTime dataHoraCriacao) {
        this.dataHoraCriacao = dataHoraCriacao;
    }

    public LocalDateTime getUltimaActualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaActualizacao(LocalDateTime ultimaActualizacao) {
        this.ultimaAtualizacao = ultimaActualizacao;
    }

    public BigDecimal getTotalReserva() {
        return totalReserva;
    }

    public void setTotalReserva(BigDecimal totalReserva) {
        this.totalReserva = totalReserva;
    }

    public BigDecimal getValorPago() {
        return valorPago;
    }

    public void setValorPago(BigDecimal valorPago) {
        this.valorPago = valorPago;
    }

    public BigDecimal getTroco() {
        return troco;
    }

    public void setTroco(BigDecimal troco) {
        this.troco = troco;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reserva other = (Reserva) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public HashMap<String, ReservaDetalhes> getReservasDetalhes() {
        return reservasDetalhes;
    }

    public void setReservasDetalhes(HashMap<String, ReservaDetalhes> reservasDetalhes) {
        this.reservasDetalhes = reservasDetalhes;
    }

    @Override
    public String toString() {
        return "Reserva{" + "id=" + id + ", hospede=" + hospede + ", usuario=" + usuario + ", totalReserva=" + totalReserva + ", valorPago=" + valorPago + ", troco=" + troco + ", desconto=" + desconto + ", dataHoraCriacao=" + dataHoraCriacao + ", ultimaAtualizacao=" + ultimaAtualizacao + ", reservasDetalhes=" + reservasDetalhes + '}';
    }
    
}
