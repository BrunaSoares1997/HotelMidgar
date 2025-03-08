
package com.midgar.hotel_midgar.modelo.dao;

import com.midgar.hotel_midgar.modelo.conexao.Conexao;
import com.midgar.hotel_midgar.modelo.conexao.ConexaoMysql;
import com.midgar.hotel_midgar.modelo.entidade.Hospede;
import com.midgar.hotel_midgar.modelo.entidade.Reserva;
import com.midgar.hotel_midgar.modelo.entidade.ReservaDetalhes;
import com.midgar.hotel_midgar.modelo.entidade.Suite;
import com.midgar.hotel_midgar.modelo.entidade.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class ReservaDao {
    
    private final Conexao conexao;
    private SuiteDao suiteDao;

    public ReservaDao() {
        this.conexao = new ConexaoMysql();
        this.suiteDao = new SuiteDao();
    }
    
    public String salvar(Reserva reserva) {
        return reserva.getId() == 0L ? adicionar(reserva) : editar(reserva);
    }

    private String adicionar(Reserva reserva) {
        String sql = "INSERT INTO reserva(total_reserva, valor_pago, troco, desconto, hospede_id, usuario_id) VALUES (?, ?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);
            
            preparedStatementSet(preparedStatement, reserva);
            
            int resultado = preparedStatement.executeUpdate();
            
            if(resultado == 1) {
                Long idDaReserva = buscarIdDaUltimaReserva();
                System.out.println("ID DA RESERVA: " + idDaReserva);
                
                reserva.setId(idDaReserva);
                
                reserva.getReservasDetalhes()
                        .values()
                        .stream()
                        .forEach(rd -> {
                            rd.setReserva(reserva);
                            
                            final int quantidade = rd.getSuite().getQuantidade() - rd.getQuantidade();
                            
                            String mensagem = suiteDao.atualizarQuantidade(rd.getSuite().getId(), 
                                    quantidade, rd.getReserva().getUsuario().getId());
                            
                            System.out.println(mensagem);
                            adicionarReservaDetalhe(rd);
                        });
                
                return "Reserva adicionada com sucesso.";
            } else {
                return "Nao foi possivel adicionar reserva";
            }
            
        } catch (SQLException e) {
            return String.format("Error: %s", e.getMessage());
        }
    }

    private String editar(Reserva reserva) {
        String sql = "UPDATE venda SET total_reserva = ?, valor_pago = ?, troco = ?, desconto = ?, hospede_id = ?, usuario_id = ?, ultima_atualizacao = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);
            
            preparedStatementSet(preparedStatement, reserva);
            
            int resultado = preparedStatement.executeUpdate();
            
            if(resultado == 1) {
                reserva.getReservasDetalhes()
                        .values()
                        .stream()
                        .forEach(rd -> editarReservaDetalhe(rd));
                
                return "Reserva editada com sucesso.";
            } else {
                return "Nao foi possivel editar reserva";
            }
            
        } catch (SQLException e) {
            return String.format("Error: %s", e.getMessage());
        }
    }
    
    private void preparedStatementSet(PreparedStatement preparedStatement, Reserva reserva) throws SQLException {
       preparedStatement.setBigDecimal(1, reserva.getTotalReserva());
       preparedStatement.setBigDecimal(2, reserva.getValorPago());
       preparedStatement.setBigDecimal(3, reserva.getTroco());
       preparedStatement.setBigDecimal(4, reserva.getDesconto());
       preparedStatement.setLong(5, reserva.getHospede().getId());
       preparedStatement.setLong(6, reserva.getUsuario().getId());
       
       if(reserva.getId() != 0L) {
           preparedStatement.setObject(7, LocalDateTime.now());
           preparedStatement.setLong(8, reserva.getId());
       }
       
    }
    
    private void adicionarReservaDetalhe(ReservaDetalhes reservaDetalhes) {
        String sql = "INSERT INTO reserva_detalhe(quantidade, total, desconto, reserva_id, suite_id) VALUES(?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);
            
            preparedStatementSetDetalhes(preparedStatement, reservaDetalhes);
            
            int resultado = preparedStatement.executeUpdate();
            
            String mensagem = resultado == 1 ? "Detalhes da reserva adicionado com sucesso." : "Nao foi possivel adicionar os detalhes da reserva";
            System.out.println(mensagem);
        } catch (SQLException e) {
            System.out.println(String.format("Error: %s", e.getMessage()));
        }
    }
    
    private void editarReservaDetalhe(ReservaDetalhes reservaDetalhes) {
        String sql = "UPDATE reserva_detalhe SET quantidade  = ?, total  = ?, desconto  = ? WHERE reserva_id = ? AND suite_id = ?";
        
        try {
            PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);
            
            preparedStatementSetDetalhes(preparedStatement, reservaDetalhes);
            
            int resultado = preparedStatement.executeUpdate();
            
            String mensagem = resultado == 1 ? "Detalhes da reserva editados com sucesso." : "Nao foi possivel editar os detalhes da reserva";
            System.out.println(mensagem);
        } catch (SQLException e) {
            System.out.println(String.format("Error: %s", e.getMessage()));
        }
    }
    
    private void preparedStatementSetDetalhes(PreparedStatement preparedStatement, ReservaDetalhes reservaDetalhes) throws SQLException {
       preparedStatement.setInt(1, reservaDetalhes.getQuantidade());
       preparedStatement.setBigDecimal(2, reservaDetalhes.getTotal());
       preparedStatement.setBigDecimal(3, reservaDetalhes.getDesconto());
       preparedStatement.setLong(4, reservaDetalhes.getReserva().getId());
       preparedStatement.setLong(5, reservaDetalhes.getSuite().getId());
    }
    
    
    public List<Reserva> todosReservas() {
        String sql = "SELECT * FROM reserva r, hospede h, usuario u WHERE r.hospede_id = h.id AND r.usuario_id = u.id ORDER BY r.id";
        List<Reserva> reservas = new ArrayList<>();
        
        try {
            ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
            
            while(result.next()) {
                reservas.add(getReserva(result));
            }
            
        } catch (SQLException e) {
            System.out.println(String.format("Error: %s", e.getMessage()));
        }
        
        return reservas;
    }
    
    public List<ReservaDetalhes> buscaDetalhesDaReservaPeloId(Long id) {
        String sql = String.format("select * from reserva r, reserva_detalhe rd, suite s, hospede h, usuario u where r.hospede_id = h.id and r.usuario_id = u.id and rd.reserva_id = r.id \n" +
" and rd.suite_id = s.id and r.id = %d", id);
        List<ReservaDetalhes> reservaDetalhes = new ArrayList<>();
        
        try {
            ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
            
            while(result.next()) {
                reservaDetalhes.add(getReservaDetalhes(result));
            }
            
        } catch (SQLException e) {
            System.out.println(String.format("Error: %s", e.getMessage()));
        }
        
        return reservaDetalhes;
    }
    
    private ReservaDetalhes getReservaDetalhes(ResultSet result) throws SQLException {
        ReservaDetalhes reservaDetalhes = new ReservaDetalhes();
        Reserva reserva = new Reserva();
        Hospede hospede = new Hospede();
        Usuario usuario = new Usuario();
        Suite suite = new Suite();
        
        hospede.setId(result.getLong("h.id"));
        hospede.setNome(result.getString("h.nome"));
        
        usuario.setId(result.getLong("u.id"));
        usuario.setNome(result.getString("u.nome"));
        
        reserva.setId(result.getLong("r.id"));
        reserva.setTotalReserva(result.getBigDecimal("r.total_reserva"));
        reserva.setValorPago(result.getBigDecimal("r.valor_pago"));
        reserva.setTroco(result.getBigDecimal("r.troco"));
        reserva.setDesconto(result.getBigDecimal("r.desconto"));
        reserva.setDataHoraCriacao(result.getObject("r.data_hora_criacao", LocalDateTime.class));
        
        reserva.setCliente(hospede);
        reserva.setUsuario(usuario);
        
        suite.setId(result.getLong("s.id"));
        suite.setNome(result.getString("s.nome"));
        suite.setPreco(result.getBigDecimal("s.preco"));
        
        reservaDetalhes.setQuantidade(result.getInt("rd.quantidade"));
        reservaDetalhes.setDesconto(result.getBigDecimal("rd.desconto"));
        reservaDetalhes.setTotal(result.getBigDecimal("rd.total"));
        reservaDetalhes.setReserva(reserva);
        reservaDetalhes.setSuite(suite);

        return reservaDetalhes;
    }
    
    private Reserva getReserva(ResultSet result) throws SQLException {
        Reserva reserva = new Reserva();
        Hospede hospede = new Hospede();
        Usuario usuario = new Usuario();
        
        hospede.setId(result.getLong("h.id"));
        hospede.setNome(result.getString("h.nome"));
        
        usuario.setId(result.getLong("u.id"));
        usuario.setNome(result.getString("u.nome"));
        
        reserva.setId(result.getLong("r.id"));
        reserva.setTotalReserva(result.getBigDecimal("r.total_reserva"));
        reserva.setValorPago(result.getBigDecimal("r.valor_pago"));
        reserva.setTroco(result.getBigDecimal("r.troco"));
        reserva.setDesconto(result.getBigDecimal("r.desconto"));
        reserva.setDataHoraCriacao(result.getObject("r.data_hora_criacao", LocalDateTime.class));
        
        reserva.setCliente(hospede);
        reserva.setUsuario(usuario);

        return reserva;
    }
    
    public Usuario buscarUsuarioPeloId(Long id) {
        String sql = String.format("SELECT * FROM usuario WHERE id = %d", id);
        
        try {
            ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
            
            if(result.next()) {
//                return getUsuario(result);
            }
            
        } catch (SQLException e) {
            System.out.println(String.format("Error: %s", e.getMessage()));
        }
        
        return null;
    }
    
    public String deleteUsuarioPeloId(Long id) {
        String sql = String.format("DELETE FROM usuario WHERE id = %d", id);
        
        try {
            PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);
            
            int resultado = preparedStatement.executeUpdate();
            
            return resultado == 1 ? "Usuario deletado com sucesso" : "Nao foi possivel deletar";
            
        } catch (SQLException e) {
            return String.format("Error: %s", e.getMessage());
        }
    }

    private Long buscarIdDaUltimaReserva() {
        String sql = "SELECT max(id) FROM reserva";
        
        try {
            ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
            
            if(result.next()) {
                return result.getLong(1);
            }
        } catch (SQLException e) {
            System.out.println(String.format("Error: %s", e.getMessage()));
        }
        
        return null;
    }
    
}
