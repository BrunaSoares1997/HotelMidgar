
package com.midgar.hotel_midgar.controller;


import com.midgar.hotel_midgar.modelo.conexao.Conexao;
import com.midgar.hotel_midgar.modelo.conexao.ConexaoMysql;
import com.midgar.hotel_midgar.modelo.dao.AutenticacaoDao;
import com.midgar.hotel_midgar.modelo.dao.CategoriaDao;
import com.midgar.hotel_midgar.modelo.dao.SuiteDao;
import com.midgar.hotel_midgar.modelo.dao.UsuarioDao;
import com.midgar.hotel_midgar.modelo.entidade.Categoria;
import com.midgar.hotel_midgar.modelo.entidade.Suite;
import com.midgar.hotel_midgar.modelo.entidade.Usuario;
import com.midgar.hotel_midgar.modelo.excecao.NegocioException;
import com.midgar.hotel_midgar.modelo.util.SuiteTableModel;
import com.midgar.hotel_midgar.visualizacao.formulario.Dashboard;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;


public class SuiteController implements ActionListener, MouseListener, KeyListener{
    
    private final Conexao conexao;
    private final Dashboard dashboard;
    private final AutenticacaoDao autenticacaoDao;
    private final UsuarioDao usuarioDao;
    private final CategoriaDao categoriaDao;
    private final SuiteDao suiteDao;
    private SuiteTableModel suiteTableModel;
    private Suite suite;
   
    public SuiteController(Dashboard dashboard) {
        this.conexao = new ConexaoMysql();
        this.usuarioDao = new UsuarioDao();
        this.autenticacaoDao = new AutenticacaoDao();
        this.dashboard = dashboard;
        this.categoriaDao = new CategoriaDao();
        this.suiteDao = new SuiteDao();
        atualizarTabela(suiteDao.todosSuites());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String accao = ae.getActionCommand().toLowerCase();
        
        switch(accao) {
            case "adicionar": adicionar(); break;
            case "editar": editar(); break;
            case "apagar": apagar(); break;
            case "adicionarcategoria": mostrarTelaCategoria(); break;
            case "salvar": salvar(); break;
            case "cancelar": cancelar(); break;
        }
    }

    private void adicionar() {
        Usuario usuario = usuarioLogado();
        if(autenticacaoDao.temPermissao(usuario))
            mostrarTelaSuite();
    }
    
    private Usuario usuarioLogado() {
        Long usuarioLogadoId = Long.valueOf(this.dashboard.getLabelUsuarioLogadoId().getText());
        return usuarioDao.buscarUsuarioPeloId(usuarioLogadoId);
    }
    
    private void mostrarTelaSuite() {
        this.dashboard.getDialogSuite().pack();
        this.dashboard.getDialogSuite().setLocationRelativeTo(dashboard);
        this.dashboard.getDialogSuite().setVisible(true);
    }

    private void mostrarTelaCategoria() {
        this.dashboard.getDialogCategoria().pack();
        this.dashboard.getDialogCategoria().setLocationRelativeTo(dashboard);
        this.dashboard.getDialogCategoria().setVisible(true);
        ocultaTelaSuite();
    }
    
    private void ocultaTelaSuite() {
        this.dashboard.getDialogSuite().setVisible(false);
    }
    
    private void validacaoDoCampo(String campo, String nomeDaVariavel) {
        if(campo.isEmpty()) {
            String mensagem = String.format("Preencher o campo %s", nomeDaVariavel);
            mensagemNaTela(mensagem, Color.RED);
            throw new NegocioException(mensagem);
        }
    }
    
    private void validacaoDaQuantidade(Integer quantidade) {
        if(quantidade < 0) {
            String mensagem = String.format("Quantidade nao pode ser um numero negativo(Menor que zero) ");
            mensagemNaTela(mensagem, Color.RED);
            throw new NegocioException(mensagem);
        }
    }
    
    private void validacaoDoPreco(BigDecimal preco) {
        if(preco.doubleValue() < 1) {
            String mensagem = String.format("Preco nao pode ser menor que zero ");
            mensagemNaTela(mensagem, Color.RED);
            throw new NegocioException(mensagem);
        }
    }
    
    private void validacaoDaCategoria() {
        if(this.dashboard.getComboBoxSuiteCategoria().getSelectedIndex() == 0) {
            String mensagem = "Preencher a categoria";
            mensagemNaTela(mensagem, Color.RED);
            throw new NegocioException(mensagem);
        }
    }
    
    private Integer validacaoDaQuantidadeSeENumero(String quantidadeString) {
        try {
            Integer quantidade = Integer.valueOf(quantidadeString);
            return quantidade;
        } catch (NumberFormatException e) {
            mensagemNaTela("Inserir apenas numero.", Color.RED);
            return 0;
        }
    }
    
    private BigDecimal validacaoDaPrecoSeENumero(String precoString) {
        try {
            BigDecimal preco = new BigDecimal(precoString);
            return preco;
        } catch (Exception e) {
            mensagemNaTela("Inserir apenas numero.", Color.RED);
            return BigDecimal.ONE;
        }
    }
    
    private Suite pegarValoresDoFormulario() {
        Usuario usuario = usuarioLogado();
        
        String idString = this.dashboard.getTxtSuiteId().getText();
        String nome = this.dashboard.getTxtSuiteNome().getText();
        String descricao = this.dashboard.getTxtSuiteDescricao().getText();
        String precoString = this.dashboard.getTxtSuitePreco().getText();
        String quantidadeString = this.dashboard.getTxtSuiteQuantidade().getValue().toString();
        String categoriaTemp = this.dashboard.getComboBoxSuiteCategoria().getSelectedItem().toString();
               
        validacaoDoCampo(nome, "nome");
        validacaoDoCampo(precoString, "preco");
        validacaoDoCampo(quantidadeString, "quantidade");
        validacaoDaCategoria();
        
        Long id = Long.valueOf(idString);
        Integer quantidade = validacaoDaQuantidadeSeENumero(quantidadeString);
        BigDecimal preco = validacaoDaPrecoSeENumero(precoString);
        Categoria categoria = categoriaDao.buscarCategoriaPeloNome(categoriaTemp);
        
        validacaoDaQuantidade(quantidade);
        validacaoDoPreco(preco);
        
                
        return new Suite(id, nome, descricao, preco, categoria, quantidade, usuario, null);
    }

    private void salvar() {
        Suite suiteTemp = pegarValoresDoFormulario();
        
        String mensagem = suiteDao.salvar(suiteTemp);
        
        if(mensagem.startsWith("Suite")) {
            mensagemNaTela(mensagem, Color.GREEN);
            limpaCampo();
        }else {
            mensagemNaTela(mensagem, Color.RED);
        }
    }

    private void cancelar() {
        this.dashboard.getDialogSuite().setVisible(false);
        limpaCampo();
        mensagemNaTela("", Color.WHITE);
    }

    private void mensagemNaTela(String mensagem, Color color) {
         this.dashboard.getLabelSuiteMensagem().setBackground(color);
         this.dashboard.getLabelSuiteMensagem().setText(mensagem);
    }
    
    private void limpaCampo() {
        this.dashboard.getTxtSuiteId().setText("0");
        this.dashboard.getTxtSuiteNome().setText("");
        this.dashboard.getTxtSuiteDescricao().setText("");
        this.dashboard.getTxtSuitePreco().setText("1");
        this.dashboard.getTxtSuiteQuantidade().setValue(0);
        this.dashboard.getComboBoxSuiteCategoria().setSelectedIndex(0);
        atualizarTabela(suiteDao.todosSuites());
        this.suite = null;
    }
    
    private void atualizarTabela(List<Suite> suites) {
        this.suiteTableModel = new SuiteTableModel(suites);
        this.dashboard.getTabelaSuite().setModel(suiteTableModel);
        this.dashboard.getLabelHomeSuite().setText(String.format("%d", suites.size()));
    }

    private void editar() {
        Usuario usuario = usuarioLogado();
        if(autenticacaoDao.temPermissao(usuario)){
            if(this.suite != null) {
                mostrarTelaSuite();
            } else {
                JOptionPane.showMessageDialog(dashboard, "Selecionar uma suite na tabela", "Seleciona uma suite", 0);
            }
        }
    }

    private void apagar() {
        Usuario usuario = usuarioLogado();
        if(autenticacaoDao.temPermissao(usuario)){
            if(this.suite != null) {
                int confirmar = JOptionPane.showConfirmDialog(dashboard, 
                        String.format("Tem certeza que deseja apagar? \nNome: %s", this.suite.getNome()), 
                        "Apagar suite", JOptionPane.YES_NO_OPTION);
                
                    if(confirmar == JOptionPane.YES_OPTION) {
                        String mensagem = suiteDao.deletaSuitePeloId(this.suite.getId());
                        JOptionPane.showMessageDialog(dashboard, mensagem);
                        limpaCampo();
                    }
            } else {
                JOptionPane.showMessageDialog(dashboard, "Selecionar uma suite na tabela", "Seleciona uma suite", 0);
            }
        }
    }

    private void preencherOsValoresNoFormulario() {
        this.dashboard.getTxtSuiteId().setText(Long.toString(this.suite.getId()));
        this.dashboard.getTxtSuiteNome().setText(this.suite.getNome());
        this.dashboard.getTxtSuiteDescricao().setText(this.suite.getDescricao());
        this.dashboard.getTxtSuitePreco().setText(this.suite.getPreco().toString());
        this.dashboard.getTxtSuiteQuantidade().setValue(this.suite.getQuantidade());
        this.dashboard.getComboBoxSuiteCategoria().setSelectedItem(this.suite.getCategoria().getNome());
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        int linhaSelecionada = this.dashboard.getTabelaSuite().getSelectedRow();
        this.suite = this.suiteTableModel.getSuites().get(linhaSelecionada);
        preencherOsValoresNoFormulario();
    }

    @Override
    public void mousePressed(MouseEvent me) {}

    @Override
    public void mouseReleased(MouseEvent me) {}

    @Override
    public void mouseEntered(MouseEvent me) {}

    @Override
    public void mouseExited(MouseEvent me) {}

    @Override
    public void keyTyped(KeyEvent ke) {}

    @Override
    public void keyPressed(KeyEvent ke) {}

    @Override
    public void keyReleased(KeyEvent ke) { 
        String pesquisar = this.dashboard.getTxtSuitePesquisar().getText();
        
        if(pesquisar.isEmpty()) {
            atualizarTabela(suiteDao.todosSuites());
        } else {
            List<Suite> suiteTemp = this.suiteDao.todosSuites()
                    .stream()
                    .filter((Suite s) -> {
                        return s.getNome().toLowerCase().contains(pesquisar.toLowerCase()) || 
                                s.getCategoria().getNome().toLowerCase().contains(pesquisar.toLowerCase());
                    })
                    .collect(Collectors.toList());
            
            atualizarTabela(suiteTemp);
        }
    }
    
}
