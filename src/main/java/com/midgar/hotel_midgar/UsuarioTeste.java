
package com.midgar.hotel_midgar;

import com.midgar.hotel_midgar.modelo.dao.UsuarioDao;
import com.midgar.hotel_midgar.modelo.entidade.PERFIL;
import com.midgar.hotel_midgar.modelo.entidade.Usuario;


public class UsuarioTeste {
    
    public static void main(String[] args) {
        Usuario usuario = new Usuario(0L, "Bruna Soares", "Soares", "3451", PERFIL.ADMIN, null, null);
        
        UsuarioDao usuarioDao = new UsuarioDao();
        String mensagem = usuarioDao.salvar(usuario);
        System.out.print(mensagem);
    }
    
}
