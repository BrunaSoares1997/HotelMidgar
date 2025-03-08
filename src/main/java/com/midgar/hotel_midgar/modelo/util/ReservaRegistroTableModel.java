
package com.midgar.hotel_midgar.modelo.util;

import com.midgar.hotel_midgar.modelo.entidade.ReservaDetalhes;
import java.util.HashMap;
import java.util.stream.Collectors;
import javax.swing.table.AbstractTableModel;


public class ReservaRegistroTableModel extends AbstractTableModel  {
    
    private HashMap<String, ReservaDetalhes> reservaDetalhes;
    private String [] colunas = {"SUITE", "PREÇO", "QTD", "DESCONTO", "TOTAL"};
    
    public ReservaRegistroTableModel(HashMap<String, ReservaDetalhes> reservaDetalhes) {
        this.reservaDetalhes = reservaDetalhes;
    }

    @Override
    public int getRowCount() {
        return reservaDetalhes.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        ReservaDetalhes reservaDetalhess = reservaDetalhes
                .values()
                .stream()
                .collect(Collectors.toList()).get(linha);
        
        switch(coluna) {
            case 0: return reservaDetalhess.getSuite().getNome();
            case 1: return reservaDetalhess.getSuite().getPreco();
            case 2: return reservaDetalhess.getQuantidade();
            case 3: return reservaDetalhess.getDesconto();
            case 4: return reservaDetalhess.getTotal();
            default: return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public HashMap<String, ReservaDetalhes> getReservaDetalhes() {
        return reservaDetalhes;
    }

    public void setVendaDetalhes(HashMap<String, ReservaDetalhes> vendaDetalhes) {
        this.reservaDetalhes = reservaDetalhes;
    }
    
}
