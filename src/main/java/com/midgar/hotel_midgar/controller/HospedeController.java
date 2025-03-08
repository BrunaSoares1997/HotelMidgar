
package com.midgar.hotel_midgar.controller;


import com.midgar.hotel_midgar.modelo.dao.HospedeDao;
import com.midgar.hotel_midgar.modelo.entidade.Hospede;
import com.midgar.hotel_midgar.modelo.util.HospedeTableModel;
import com.midgar.hotel_midgar.visualizacao.formulario.Dashboard;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class HospedeController implements ActionListener{
    
    private Dashboard dashboard;
    private HospedeDao hospedeDao;
    private HospedeTableModel hospedeTableModel;

    public HospedeController(Dashboard dashboard) {
        this.dashboard = dashboard;
        this.hospedeDao = new HospedeDao();
        atualizarTabelaHospede();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String accao = ae.getActionCommand().toLowerCase();
        
        switch(accao) {
            case "adicionar": adicionar(); break;
            case "salvar": salvar(); break;
            case "cancelar": cancelar();break;
        }
    }

    public void salvar() {
        String idString = this.dashboard.getTxtHospedeId().getText();
        String nome = this.dashboard.getTxtHospedeNome().getText();
        String telefone = this.dashboard.getTxtHospedeTelefone().getText();
        String email = this.dashboard.getTxtHospedeEmail().getText();
        
        Long id = Long.valueOf(idString);
        
        Hospede hospede = new Hospede(id, nome, telefone, email);
        String mensagem = hospedeDao.salvar(hospede);
        
        if(mensagem.startsWith("Hospede")) {
            mensagemNaTela(mensagem, Color.GREEN);
            atualizarTabelaHospede();
        }else {
            mensagemNaTela(mensagem, Color.RED);
        }
    }
    
    private void mensagemNaTela(String mensagem, Color color) {
         this.dashboard.getLabelHospedeMensagem().setBackground(color);
         this.dashboard.getLabelHospedeMensagem().setText(mensagem);
    }

    private void cancelar() {
        limpar();
        this.dashboard.getDialogHospede().setVisible(false);
    }
    
    private void limpar() {
        this.dashboard.getTxtHospedeId().setText("0");
        this.dashboard.getTxtHospedeNome().setText("");
        this.dashboard.getTxtHospedeTelefone().setText("");
        this.dashboard.getTxtHospedeEmail().setText("");
    }
    
    private void mostrarTela() {
        this.dashboard.getDialogHospede().pack();
        this.dashboard.getDialogHospede().setLocationRelativeTo(dashboard);
        this.dashboard.getDialogHospede().setVisible(true);
    }

    private void adicionar() {
        mostrarTela();
    }

    private void atualizarTabelaHospede() {
        List<Hospede> hospedes = hospedeDao.todosHospede();
        this.hospedeTableModel = new HospedeTableModel(hospedes);
        this.dashboard.getTabelaHospede().setModel(hospedeTableModel);
        this.dashboard.getLabelHomeHospede().setText(String.format("%d", hospedes.size()));
    }
    
    
    
}
