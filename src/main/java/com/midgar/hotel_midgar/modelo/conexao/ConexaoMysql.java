
package com.midgar.hotel_midgar.modelo.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoMysql implements Conexao {
    
    private final String USUARIO = "root";
    private final String SENHA = "Kiro@2025";
    private final String URL = "jdbc:mysql://localhost/hotelmidgar";
    private Connection conectar;

    @Override
    public Connection obterConexao() throws SQLException {
        
        if(conectar == null) {
            conectar = DriverManager.getConnection(URL, USUARIO, SENHA);
            
        }
        return conectar;
    }
    
}
