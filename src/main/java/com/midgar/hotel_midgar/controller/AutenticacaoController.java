
package com.midgar.hotel_midgar.controller;

import com.midgar.hotel_midgar.modelo.dao.AutenticacaoDao;
import com.midgar.hotel_midgar.modelo.entidade.Usuario;
import com.midgar.hotel_midgar.visualizacao.dto.LoginDto;
import com.midgar.hotel_midgar.visualizacao.formulario.Dashboard;
import com.midgar.hotel_midgar.visualizacao.formulario.LoginForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class AutenticacaoController implements ActionListener {
    
    private final LoginForm loginForm;
    private final AutenticacaoDao autenticacao;

    public AutenticacaoController(LoginForm loginForm) {
        this.loginForm = loginForm;
        autenticacao = new AutenticacaoDao();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String accao = ae.getActionCommand().toLowerCase();
        
        switch(accao) {
            case "login": login(); break;
            case "cancelar": cancelar(); break;                                
        }
    }
    

    private void login() {
        String username = loginForm.getTxtLoginUsername().getText();
        String senha = loginForm.getTxtLoginSenha().getText();
        
        if(username.equals("") || senha.equals("")) {
            loginForm.getLabelLoginMensagem().setText("Username e senha devem ser preenchidos");
            return;
        }
        
        LoginDto login = new LoginDto(username, senha);
        Usuario usuario = autenticacao.login(login);
        
        if(usuario != null) {
            System.out.println("Sucesso: " + usuario.getUsername());
            Dashboard dashboard = new Dashboard();
            dashboard.setVisible(true);
            dashboard.getLabelBemvindoUsuario().setText(String.format("Bem-vindo %s", usuario.getNome()));
            dashboard.getLabelUsuarioLogadoId().setText(Long.toString(usuario.getId()));
            this.loginForm.setVisible(false);
            limpaTela();
        }else{
            loginForm.getLabelLoginMensagem().setText("Username ou senha incorreto.");
//            JOptionPane.showMessageDialog(null, "Username ou senha incorreto.");
        }
    }

    private void cancelar() {
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?","Sair do login", JOptionPane.YES_NO_OPTION);
        
        if(confirma == JOptionPane.YES_OPTION) System.exit(0);
    }
    
    private void limpaTela() {
        loginForm.getLabelLoginMensagem().setText("");
        loginForm.getTxtLoginUsername().setText("");
        loginForm.getTxtLoginSenha().setText("");
    }
    
    
}
