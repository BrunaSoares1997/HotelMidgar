
package com.midgar.hotel_midgar.modelo.dao;

import com.midgar.hotel_midgar.modelo.conexao.Conexao;
import com.midgar.hotel_midgar.modelo.conexao.ConexaoMysql;
import com.midgar.hotel_midgar.modelo.entidade.Categoria;
import com.midgar.hotel_midgar.modelo.entidade.Suite;
import com.midgar.hotel_midgar.modelo.entidade.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class SuiteDao {
    
    private final Conexao conexao;

    public SuiteDao() {
        this.conexao = new ConexaoMysql();
    }
    
    
    public String salvar(Suite suite) {
        return suite.getId() == 0L ? adicionar(suite) : editar(suite);
    }

    private String adicionar(Suite suite) {
        String sql = "INSERT INTO suite(nome, descricao, preco, categoria_id, quantidade, usuario_id) VALUES (?, ?, ?, ?, ?, ?)";
        
        Suite suiteTemp = buscarSuitePeloNome(suite.getNome());
        
        if(suiteTemp != null) {
            return String.format("Suite %s ja existe no banco de dados.", suite.getNome());
        }
        
        try {
            PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);
            
            preparedStatementSet(preparedStatement, suite);
            
            int resultado = preparedStatement.executeUpdate();
            
            return resultado == 1 ? "Suite adicionada com sucesso" : "Nao foi possivel adicionar a suite";
            
        } catch (SQLException e) {
            return String.format("Error: %s", e.getMessage());
        }
    }

    private String editar(Suite suite) {
        String sql = "UPDATE suite SET nome = ?, descricao  = ?, preco  = ?, categoria_id  = ?, quantidade  = ?, usuario_id  = ? WHERE id  = ?";
        try {
            PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);
            
            preparedStatementSet(preparedStatement, suite);
            
            int resultado = preparedStatement.executeUpdate();
            
            return resultado == 1 ? "Suite editada com sucesso" : "Nao foi possivel editar a suite";
            
        } catch (SQLException e) {
            return String.format("Error: %s", e.getMessage());
        }
    }
    
    public String atualizarQuantidade(Long idSuite, Integer quantidade, Long usuarioId) {
        String sql = "UPDATE suite SET quantidade = ?, usuario_id = ? WHERE id  = ?";
        System.out.println("Reserva: " + idSuite + "QTD: " +quantidade + "USUARIO: "+usuarioId);
        try {
            PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);
            
            preparedStatement.setInt(1, quantidade);
            preparedStatement.setLong(2, usuarioId);
            preparedStatement.setLong(3, idSuite);
            
            int resultado = preparedStatement.executeUpdate();
            
            return resultado == 1 ? "Quantidade de suite editada com sucesso" : "Nao foi possivel editar a quantidade de suite";
            
        } catch (SQLException e) {
            e.printStackTrace();
            return String.format("Error: %s", e.getMessage());
        }
    }

    private void preparedStatementSet(PreparedStatement preparedStatement, Suite suite) throws SQLException {
        preparedStatement.setString(1, suite.getNome());
        preparedStatement.setString(2, suite.getDescricao());
        preparedStatement.setBigDecimal(3, suite.getPreco());
        preparedStatement.setLong(4, suite.getCategoria().getId());
        preparedStatement.setInt(5, suite.getQuantidade());
        preparedStatement.setLong(6, suite.getUsuario().getId());
        
        if(suite.getId() != 0L)
            preparedStatement.setLong(7, suite.getId());
    }
    
    public List<Suite> todosSuites() {
        String sql = "SELECT * FROM suite s, categoria c, usuario u WHERE s.categoria_id = c.id AND s.usuario_id = u.id";
        List<Suite> suites = new ArrayList<>();
        try {
            ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
            
            while(result.next()) {
                suites.add(getSuite(result));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(String.format("Error: %s", e.getMessage()));
        }
        return suites;
    }
    
    public Suite buscarSuitePeloId(Long id) {
        String sql = String.format("SELECT * FROM suite s, categoria c, usuario u WHERE s.categoria_id = c.id AND s.usuario_id = u.id AND s.id = %d", id);
        
        try {
            ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
            
            if(result.next()) {
                return getSuite(result);
            }
        } catch (SQLException e) {
            System.out.println(String.format("Error: %s", e.getMessage()));
        }
        return null;
    }
    
    public List<Suite> buscarSuitesPeloCategoria(String categoria) {
        String sql = String.format("SELECT * FROM suite s, categoria c, usuario u WHERE s.categoria_id = c.id AND s.usuario_id = u.id AND c.nome = '%s'", categoria);
        List<Suite> suites = new ArrayList<>();
        
        try {
            ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
            
            while(result.next()) {
                 suites.add(getSuite(result));
            }
        } catch (SQLException e) {
            System.out.println(String.format("Error: %s", e.getMessage()));
        }
        return suites;
    }
    
    public Suite buscarSuitePeloNome(String nome) {
        String sql = String.format("SELECT * FROM suite s, categoria c, usuario u WHERE s.categoria_id = c.id AND s.usuario_id = u.id AND s.nome = '%s'", nome);
        
        try {
            ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
            
            if(result.next()) {
                return getSuite(result);
            }
        } catch (SQLException e) {
            System.out.println(String.format("Error: %s", e.getMessage()));
        }
        return null;
    }

    private Suite getSuite(ResultSet result) throws SQLException {
        Suite suite = new Suite();
        Categoria categoria = new Categoria();
        Usuario usuario = new Usuario();
        
        categoria.setId(result.getLong("c.id"));
        categoria.setNome(result.getString("c.nome"));
        categoria.setDescricao(result.getString("c.descricao"));
        
        usuario.setId(result.getLong("u.id"));
        usuario.setNome(result.getString("u.nome"));
        
        suite.setId(result.getLong("s.id"));
        suite.setNome(result.getString("s.nome"));
        suite.setDescricao(result.getString("s.descricao"));
        suite.setPreco(result.getBigDecimal("s.preco"));
        suite.setQuantidade(result.getInt("s.quantidade"));
        suite.setDataHoraCriaco(result.getObject("s.data_hora_criacao", LocalDateTime.class));
        suite.setCategoria(categoria);
        suite.setUsuario(usuario);
        
        return suite;
    }
    
    public String deletaSuitePeloId(Long id) {
        String sql = String.format("DELETE FROM suite WHERE id = %d", id);
        
        try {
            PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);
            
            int resultado = preparedStatement.executeUpdate();
            
            return resultado == 1 ? "Suite deletada com sucesso" : "Nao foi possivel deletar suite";
            
        } catch (SQLException e) {
            return String.format("Error: %s", e.getMessage());
        }
    }
    
}
