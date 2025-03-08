
package com.midgar.hotel_midgar;

import com.midgar.hotel_midgar.modelo.conexao.Conexao;
import com.midgar.hotel_midgar.modelo.conexao.ConexaoMysql;
import com.midgar.hotel_midgar.modelo.entidade.Categoria;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Main {
    
    public static void main(String[] args) throws SQLException {
        
        String sql = "Select * from categoria";
        
        Conexao conexao = new ConexaoMysql();
        
        Categoria categoria = new Categoria(null, "Simples", "Insercao no netbeans");
        
        String inserirSQL = "INSERT INTO categoria(nome, descricao) VALUES(?, ?)";
        
        PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(inserirSQL);
        
        preparedStatement.setString(1, categoria.getNome());
        preparedStatement.setString(2, categoria.getDescricao());
        
        int resultadoDoCadastro = preparedStatement.executeUpdate();
        
        System.out.println(resultadoDoCadastro);
        
        ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
        
      
        
        while(result.next()) {
            System.out.print(result.getString("nome"));       
    
    }    }  
}
