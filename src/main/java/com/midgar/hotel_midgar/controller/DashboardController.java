
package com.midgar.hotel_midgar.controller;


import com.midgar.hotel_midgar.modelo.dao.UsuarioDao;
import com.midgar.hotel_midgar.modelo.util.UsuarioTableModel;
import com.midgar.hotel_midgar.visualizacao.formulario.Dashboard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public final class DashboardController implements ActionListener{
    
    private final Dashboard dashboard;
    private final UsuarioDao usuarioDao;
    private UsuarioTableModel usuarioTableModel;

    public DashboardController(Dashboard dashboard) {
        this.dashboard = dashboard;
        this.usuarioDao = new UsuarioDao();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String accao = ae.getActionCommand().toLowerCase();
        
        switch(accao) {
            case "home": panelHome(); break;
            case "hospedes": panelHospedes(); break;
            case "suites": panelSuites(); break;
            case "reservas": panelReservas(); break;
            case "usuarios": panelUsuarios(); break;
            case "sair": sair(); break;            
        }
    }
    
    private void painelComponentes(JPanel panel) {
        this.dashboard.getPanelBody().removeAll();
        this.dashboard.getPanelBody().repaint();
        this.dashboard.getPanelBody().revalidate();
        this.dashboard.getPanelBody().add(panel);
        this.dashboard.getPanelBody().repaint();
        this.dashboard.getPanelBody().revalidate();
    }

    private void panelHospedes() {
        painelComponentes(this.dashboard.getPanelHospede());
    }

    private void panelSuites() {
        painelComponentes(this.dashboard.getPanelSuite());
    }

    private void sair() {
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?","Sair do login", JOptionPane.YES_NO_OPTION);
        
        if(confirma == JOptionPane.YES_OPTION) System.exit(0);
    }

    private void panelUsuarios() {
        painelComponentes(this.dashboard.getPanelUsuario());
    }

    private void panelReservas() {
        painelComponentes(this.dashboard.getPanelReserva());
    }

    private void panelHome() {
        painelComponentes(this.dashboard.getPanelHome());
    }
    
}
