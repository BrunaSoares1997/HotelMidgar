
package com.midgar.hotel_midgar.modelo.util;

import com.midgar.hotel_midgar.modelo.entidade.Hospede;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class HospedeTableModel extends AbstractTableModel {
    
    private List<Hospede> hospedes;
    private String [] colunas = {"ID", "NOME", "TELEFONE", "EMAIL"};

    public HospedeTableModel(List<Hospede> hospedes) {
        this.hospedes = hospedes;
    }

    @Override
    public int getRowCount() {
        return hospedes.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Hospede hospede = hospedes.get(linha);
        
        switch(coluna) {
            case 0: return hospede.getId();
            case 1: return hospede.getNome();
            case 2: return hospede.getTelefone();
            case 3: return hospede.getEmail();
            default: return "";
        }
    }

    public List<Hospede> getClientes() {
        return hospedes;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    
}
