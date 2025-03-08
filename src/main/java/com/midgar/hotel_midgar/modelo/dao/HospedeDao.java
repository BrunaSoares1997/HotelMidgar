
package com.midgar.hotel_midgar.modelo.dao;

import com.midgar.hotel_midgar.modelo.conexao.Conexao;
import com.midgar.hotel_midgar.modelo.conexao.ConexaoMysql;
import com.midgar.hotel_midgar.modelo.entidade.Hospede;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class HospedeDao {
    
    private final Conexao conexao;

    public HospedeDao() {
        this.conexao = new ConexaoMysql();
    }
    
    public String salvar(Hospede hospede) {
        
        if(hospede.getId() == 0L) {
            String sql = "INSERT INTO hospede(nome, telefone, email) VALUES (?, ?, ?)";
            return registar(hospede, sql);
        }else{
            String sql = "UPDATE hospede SET nome = ?, telefone = ?, email = ? WHERE id = ?";
            return registar(hospede, sql);
        }
    }
    
    private String registar(Hospede hospede, String sql) {
        try {
            PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);
            
            preparedStatementSet(preparedStatement, hospede);
            
            int resultado = preparedStatement.executeUpdate();
            
            return resultado == 1 ? "Hospede adicionado com sucesso." : "Nao foi possivel adicionar hospede";
        } catch (SQLException e) {
            return String.format("Error: %s", e.getMessage());
        }
    }
    
    private void preparedStatementSet(PreparedStatement preparedStatement, Hospede hospede) throws SQLException {
       
        preparedStatement.setString(1, hospede.getNome());
        preparedStatement.setString(2, hospede.getTelefone());
        preparedStatement.setString(3, hospede.getEmail());
        
       if(hospede.getId() != 0L) {
           preparedStatement.setLong(4, hospede.getId());
       }
       
    }
    
    public List<Hospede> todosHospede() {
        String sql = "SELECT * FROM hospede";
        List<Hospede> hospedes = new ArrayList<>();
        
        try {
            ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
            
            while(result.next()) {
                hospedes.add(getHospede(result));
            }
            
        } catch (SQLException e) {
            System.out.println(String.format("Error: %s", e.getMessage()));
        }
        
        return hospedes;
    }
    
    public Hospede buscarHospedePeloId(Long id) {
        String sql = String.format("SELECT * FROM hospede WHERE id=%d", id);
        System.out.println(sql);
        try {
            ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
            
            while(result.next()) {
                return getHospede(result);
            }
            
        } catch (SQLException e) {
            System.out.println(String.format("Error: %s", e.getMessage()));
        }
        System.out.println("XXXXXXX");
        return null;
    }
    
    public Hospede buscarUltimoHospede() {
        String sql = "SELECT * FROM hospede WHERE id= (SELECT max(id) FROM hospede)";
        
        try {
            ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
            
            while(result.next()) {
                return getHospede(result);
            }
            
        } catch (SQLException e) {
            System.out.println(String.format("Error: %s", e.getMessage()));
        }
        
        return null;
    }
    
    private Hospede getHospede(ResultSet result) throws SQLException {
        Hospede hospede = new Hospede();
        
        hospede.setId(result.getLong("id"));
        hospede.setNome(result.getString("nome"));
        hospede.setTelefone(result.getString("telefone"));
        hospede.setEmail(result.getString("email"));

        System.out.println(hospede);
        return hospede;
    }
    
    public String deleteHospedePeloId(Long id) {
        String sql = String.format("DELETE FROM hospede WHERE id = %d", id);
        
        try {
            PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);
            
            int resultado = preparedStatement.executeUpdate();
            
            return resultado == 1 ? "Hospede excluido com sucesso" : "Nao foi possivel excluir hospede";
            
        } catch (SQLException e) {
            return String.format("Error: %s", e.getMessage());
        }
    }
    
}
