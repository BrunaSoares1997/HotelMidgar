
package com.midgar.hotel_midgar.modelo.dao;

import com.midgar.hotel_midgar.modelo.entidade.PERFIL;
import com.midgar.hotel_midgar.modelo.entidade.Usuario;
import com.midgar.hotel_midgar.modelo.excecao.NegocioException;
import com.midgar.hotel_midgar.visualizacao.dto.LoginDto;
import javax.swing.JOptionPane;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class AutenticacaoDao {
    
    private final UsuarioDao usuarioDao;

    public AutenticacaoDao() {
        this.usuarioDao = new UsuarioDao();
    }
    
    public boolean temPermissao(Usuario usuario) {
        try {
            permissao(usuario);
            return true;
        } catch (NegocioException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Usuario sem permissão", 0);
            System.out.println("ERROR: " + e.getMessage());
            return false;
        }
    }
    
    private void permissao(Usuario usuario) {
        if(!PERFIL.ADMIN.equals(usuario.getPerfil())) {
            throw new NegocioException("Sem permissao para realizar essa ação.");
        }
    }

    public Usuario login(LoginDto login) {
        Usuario usuario = usuarioDao.buscarUsuarioPeloUsername(login.getUsername());
        
        if(usuario == null || !usuario.isStatus()) 
            return null;
       
        if(usuario.isStatus() && validaSenha(usuario.getSenha(), login.getSenha())) {
            usuarioDao.atualizarUltimoLogin(usuario);
            return usuario;
        }
        return null;
    }
    
//    private boolean validaSenha(String usuarioSenha, String loginSenha) {
//        return usuarioSenha.equals(loginSenha);
//    }
    
    private boolean validaSenha(String usuarioSenha, String loginSenha) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(loginSenha, usuarioSenha);
    }
    
}
