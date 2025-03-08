
package com.midgar.hotel_midgar.modelo.util;

import com.midgar.hotel_midgar.modelo.entidade.Suite;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class SuiteTableModel extends AbstractTableModel {
    
    private List<Suite> suites;
    private final String [] colunas = {"ID", "NOME", "PRECO", "QUANTIDADE", "CATEGORIA", "DATA", "CRIADO POR"};

    public SuiteTableModel(List<Suite> suites) {
        this.suites = suites;
    }

    @Override
    public int getRowCount() {
        return suites.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Suite suite = suites.get(linha);
        
        switch(coluna) {
            case 0: return suite.getId();
            case 1: return suite.getNome();
            case 2: return suite.getPreco();
            case 3: return suite.getQuantidade();
            case 4: return suite.getCategoria().getNome();
            case 5: return suite.getDataHoraCriaco();
            case 6: return suite.getUsuario().getNome();
            default: return "";
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public List<Suite> getSuites() {
        return suites;
    }

    public void setSuites(List<Suite> suites) {
        this.suites = suites;
    }
    
}
