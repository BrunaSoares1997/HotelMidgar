
package com.midgar.hotel_midgar.modelo.util;

import com.midgar.hotel_midgar.modelo.entidade.Reserva;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class ReservaTableModel extends AbstractTableModel {
    
    private List<Reserva> reservas;
    private String [] colunas = {"ID", "HOSPEDE", "TOTAL", "VALOR PAGO", "DESCONTO", "TROCO", "DATA", "VENDIDO POR"};

    public ReservaTableModel(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    @Override
    public int getRowCount() {
        return reservas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Reserva reserva = reservas.get(linha);
        
        switch(coluna) {
            case 0: return reserva.getId();
            case 1: return reserva.getHospede().getNome();
            case 2: return reserva.getTotalReserva();
            case 3: return reserva.getValorPago();
            case 4: return reserva.getDesconto();
            case 5: return reserva.getTroco();
            case 6: return reserva.getDataHoraCriacao();
            case 7: return reserva.getUsuario().getNome();
            default: return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setVendas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false; 
    }
    
}
