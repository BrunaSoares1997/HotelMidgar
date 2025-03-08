
package com.midgar.hotel_midgar.controller;


import com.midgar.hotel_midgar.modelo.dao.AutenticacaoDao;
import com.midgar.hotel_midgar.modelo.dao.CategoriaDao;
import com.midgar.hotel_midgar.modelo.dao.HospedeDao;
import com.midgar.hotel_midgar.modelo.dao.ReservaDao;
import com.midgar.hotel_midgar.modelo.dao.SuiteDao;
import com.midgar.hotel_midgar.modelo.dao.UsuarioDao;
import com.midgar.hotel_midgar.modelo.entidade.Hospede;
import com.midgar.hotel_midgar.modelo.entidade.Reserva;
import com.midgar.hotel_midgar.modelo.entidade.ReservaDetalhes;
import com.midgar.hotel_midgar.modelo.entidade.Suite;
import com.midgar.hotel_midgar.modelo.entidade.Usuario;
import com.midgar.hotel_midgar.modelo.excecao.NegocioException;
import com.midgar.hotel_midgar.modelo.util.AbstractMouseListener;
import com.midgar.hotel_midgar.modelo.util.ReservaRegistroTableModel;
import com.midgar.hotel_midgar.modelo.util.ReservaTableModel;
import com.midgar.hotel_midgar.visualizacao.formulario.Dashboard;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;


public class ReservaController extends AbstractMouseListener implements ActionListener, KeyListener {
    
    private Dashboard dashboard;
    private SuiteDao suiteDao;
    private List<Suite> suites;
    private CategoriaDao categoriaDao;
    private HashMap<String, ReservaDetalhes> reservaDetalhesCesto;
    private ReservaRegistroTableModel reservaRegistroTableModel;
    private Suite suite;
    private String nomeDaSuite;
    private AutenticacaoDao autenticacaoDao;
    private HospedeDao hospedeDao;
    private UsuarioDao usuarioDao;
    private ReservaDao reservaDao;
    private List<ReservaDetalhes> reservaDetalhes;
    private ReservaTableModel reservaTableModel;

    public ReservaController(Dashboard dashboard) {
        this.dashboard = dashboard;
        suiteDao = new SuiteDao();
        suites = suiteDao.todosSuites();
        inicializarCategoria();
        this.reservaDetalhesCesto = new HashMap<>();
        atualizarCesto(reservaDetalhesCesto);
        autenticacaoDao = new AutenticacaoDao();
        usuarioDao = new UsuarioDao();
        hospedeDao = new HospedeDao();
        reservaDao = new ReservaDao();
        atualizarTabelaReserva();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String accao = ae.getActionCommand().toLowerCase();
        
        switch(accao) {
            case "adicionar": mostrarTelaRegistro(); break;
            case "comboboxreservacategoria": pesquisarSuitePeloCategoria(); break;
            case "comboboxreservasuite": selecionarSuiteNaComboBox(); break;
            case "adicionarnocesto": adicionarSuiteNoCesto(); break;
            case "checkboxreservadesconto": ativaCheckBoxDesconto(); break;
            case "remover": removerSuiteDoCesto(); break;
            case "reservar": reservar(); break;
            case "cancelar": cancelar(); break;
            case "detalhes": detalhes(); break;
        }
    }

    private void mostrarTelaRegistro() {
        this.dashboard.getDialogReserva().pack();
        this.dashboard.getDialogReserva().setLocationRelativeTo(dashboard);
        this.dashboard.getDialogReserva().setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent ke) {}

    @Override
    public void keyPressed(KeyEvent ke) {}

    @Override
    public void keyReleased(KeyEvent ke) {
        String pesquisar = this.dashboard.getTxtReservaPesquisarSuite().getText();
        Optional<Suite> suitesTemp = suites.stream()
                .filter((s) -> {
                    return s.getId().toString().equals(pesquisar)
                            || s.getNome().equalsIgnoreCase(pesquisar);
                })
                .findFirst();

        if (suitesTemp.isPresent()) {
            this.suite = suitesTemp.get();
            detalhesDaSuite();
        } else {
            informacaoPadraoDaLabelSuiteReserva();
        }
    }
    
    private void detalhesDaSuite() {
        this.dashboard.getLabelReservaPrecoDaSuite().setText(this.suite.getPreco().toString());
        this.dashboard.getLabelReservaQuantidadeDaSuite().setText(this.suite.getQuantidade().toString());
        this.dashboard.getLabelReservaNomeDaSuite().setText(suite.getNome());
    }
    
    private void informacaoPadraoDaLabelSuiteReserva() {
        this.dashboard.getLabelReservaPrecoDaSuite().setText("0,00");
        this.dashboard.getLabelReservaQuantidadeDaSuite().setText("0");
        this.dashboard.getLabelReservaNomeDaSuite().setText("");
        this.suite = null;
    }
    
    private void inicializarCategoria() {
        categoriaDao = new CategoriaDao();
        
        this.dashboard.getComboBoxReservaPesquisarSuitePelaCategoria().removeAllItems();
        this.dashboard.getComboBoxReservaPesquisarSuitePelaCategoria().addItem("Selecione");
        
        inicializarSuite();
        
        categoriaDao.todasCategorias()
                .stream()
                .forEach(c -> this.dashboard.getComboBoxReservaPesquisarSuitePelaCategoria()
                              .addItem(c.getNome()));
        
    }
    
    private void inicializarSuite() {
        suiteDao = new SuiteDao();
        
        this.dashboard.getComboBoxReservaSuite().removeAllItems();
        this.dashboard.getComboBoxReservaSuite().addItem("Selecione");
        
        
        suiteDao.todosSuites()
                .stream()
                .forEach(s -> this.dashboard.getComboBoxReservaSuite()
                              .addItem(s.getNome()));
        
        
    }

    private void pesquisarSuitePeloCategoria() {
        inicializarSuite();
        String categoria = this.dashboard.getComboBoxReservaPesquisarSuitePelaCategoria().getSelectedItem().toString();
        
        if(!categoria.equals("Selecione")) {
            List<Suite> suitesTemp = suiteDao.buscarSuitesPeloCategoria(categoria);
            suitesTemp
                    .stream()
                    .forEach(s -> this.dashboard.getComboBoxReservaSuite().addItem(s.getNome()));
        }        
    }

    private void selecionarSuiteNaComboBox() {
        if(this.dashboard.getComboBoxReservaSuite().getSelectedIndex() > 0) {
            String suiteSelecionada = this.dashboard.getComboBoxReservaSuite().getSelectedItem().toString();
            this.suite = suiteDao.buscarSuitePeloNome(suiteSelecionada);
            if(suite != null)
                detalhesDaSuite();
        }
    }
    
    private void validacaoDoCampo(String campo, String nomeDaVariavel) {
        if(campo.isEmpty()) {
            String mensagem = String.format("Preencher o campo %s", nomeDaVariavel);
            mensagemNaTela(mensagem, Color.RED);
            throw new NegocioException(mensagem);
        }
    }
    
    
    private void validacaoDaQuantidade(Integer quantidade) {
        if(quantidade <= 0) {
            String mensagem = String.format("Quantidade nao pode ser um numero negativo ou menor que zero");
            mensagemNaTela(mensagem, Color.RED);
            throw new NegocioException(mensagem);
        }
    }
    
    private void validacaoDaQuantidadeDaSuiteMaiorQueSolicitado(int quantidade) {
        if(this.suite.getQuantidade() < quantidade) {
            mensagemNaTela("Quantidade indisponivel", Color.RED);
            throw new NegocioException("Quantidade indisponivel");
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
    
    private BigDecimal validacaoDoPrecoSeENumero(String precoString) {
        try {
            BigDecimal preco = new BigDecimal(precoString);
            return preco;
        } catch (Exception e) {
            mensagemNaTela("Inserir apenas numero.", Color.RED);
            return BigDecimal.ONE;
        }
    }
    
    private void mensagemNaTela(String mensagem, Color color) {
         this.dashboard.getLabelReservaMensagem().setBackground(color);
         this.dashboard.getLabelReservaMensagem().setText(mensagem);
    }

    private void adicionarSuiteNoCesto() {
        if(suite != null) {
            int quantidadeExistente = 0;
            
            if(reservaDetalhesCesto.containsKey(this.suite.getNome())) {
                quantidadeExistente = reservaDetalhesCesto.get(this.suite.getNome()).getQuantidade();
            }
            
            ReservaDetalhes reservaDetalhesTemp  = new  ReservaDetalhes();
            String quantidadeString = this.dashboard.getTxtReservaQuantidade().getValue().toString();
            String descontoString = this.dashboard.getTxtReservaDesconto().getText();
            
            validacaoDoCampo(quantidadeString, "quantidade");
            validacaoDoCampo(descontoString, "desconto");
            
            Integer quantidade = validacaoDaQuantidadeSeENumero(quantidadeString);
            quantidade += quantidadeExistente;
            
            validacaoDaQuantidade(quantidade);
            validacaoDaQuantidadeDaSuiteMaiorQueSolicitado(quantidade);
            
            BigDecimal desconto = validacaoDoPrecoSeENumero(descontoString);
            BigDecimal total = this.suite.getPreco().subtract(desconto)
                    .multiply(BigDecimal.valueOf((quantidade)));
            
            
            reservaDetalhesTemp.setSuite(this.suite);
            reservaDetalhesTemp.setQuantidade(quantidade);
            reservaDetalhesTemp.setDesconto(desconto.multiply(BigDecimal.valueOf(quantidade)));
            reservaDetalhesTemp.setTotal(total);
            
            this.reservaDetalhesCesto.put(this.suite.getNome(), reservaDetalhesTemp);
            
            atualizarCesto(reservaDetalhesCesto);
            atualizarTotalDaReserva();
            
        } else {
            mensagemNaTela("Nao tem suite selecionada", Color.RED);
        }
    }
    
    private void atualizarCesto(HashMap<String, ReservaDetalhes> reservaDetalhess) {
        this.reservaRegistroTableModel = new ReservaRegistroTableModel(reservaDetalhess);
        this.dashboard.getTabelaReservaRegistro().setModel(reservaRegistroTableModel);
    }
    
    private void atualizarTotalDaReserva() {
        double totalReserva = this.reservaDetalhesCesto.values()
                .stream()
                .collect(Collectors.summingDouble(r -> r.getTotal().doubleValue()));
        
        double totalDesconto = this.reservaDetalhesCesto.values()
                .stream()
                .collect(Collectors.summingDouble(r -> r.getDesconto().doubleValue()));
        
        this.dashboard.getLabelReservaTotalDaReserva().setText(new BigDecimal(totalReserva).toString());
        this.dashboard.getLabelReservaTotalDoDesconto().setText(new BigDecimal(totalDesconto).toString());
    }

    private void removerSuiteDoCesto() {
        if(this.nomeDaSuite != null && !this.nomeDaSuite.isEmpty()) {
            this.reservaDetalhesCesto.remove(this.nomeDaSuite);
            atualizarTotalDaReserva();
            atualizarCesto(this.reservaDetalhesCesto);
        }else{
            mensagemNaTela("Selecionar a suite que deseja remover", Color.RED);
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        try {
            int linhaSelecionadaReserva = this.dashboard.getTabelaReserva().getSelectedRow();
            Long idReserva = this.reservaTableModel.getReservas().get(linhaSelecionadaReserva).getId();
            this.reservaDetalhes = this.reservaDao.buscaDetalhesDaReservaPeloId(idReserva);
        } catch (Exception e) {
            System.out.println(String.format("Error: ", e));
        }
        try {
            int linhaSelecionada = this.dashboard.getTabelaReservaRegistro().getSelectedRow();
            this.nomeDaSuite = (String) this.dashboard.getTabelaReservaRegistro().getModel().getValueAt(linhaSelecionada, 0);
            
        } catch (Exception e) {
            System.out.println(String.format("Error registro: %s", e));
        }
    }
    
    private Usuario usuarioLogado() {
        Long usuarioLogadoId = Long.valueOf(this.dashboard.getLabelUsuarioLogadoId().getText());
        return usuarioDao.buscarUsuarioPeloId(usuarioLogadoId);
    }

    private void ativaCheckBoxDesconto() {
        if(this.autenticacaoDao.temPermissao(usuarioLogado()) && this.dashboard.getCheckBoxReservaDesconto().isSelected()) {
            this.dashboard.getTxtReservaDesconto().setEditable(true);
        } else {
            this.dashboard.getTxtReservaDesconto().setEditable(false);
        }
    }

    private void reservar() {
        Hospede hospede = new Hospede();
        String valorPagoString = this.dashboard.getTxtReservaValorPago().getText();
        String totalDaReservaString = this.dashboard.getLabelReservaTotalDaReserva().getText();
        String descontoTotalString = this.dashboard.getLabelReservaTotalDoDesconto().getText();
        String trocoString = this.dashboard.getLabelReservaTroco().getText();
        String idString = this.dashboard.getTxtReservaId().getText();
        String idHospedeString = this.dashboard.getTxtReservaHospede().getText();
                
        BigDecimal valorPago = validacaoDoPrecoSeENumero(valorPagoString);
        BigDecimal totalDaReserva = validacaoDoPrecoSeENumero(totalDaReservaString);
        BigDecimal descontoTotal = new BigDecimal(descontoTotalString);
        BigDecimal troco = new BigDecimal(trocoString);
        
        Long id = Long.valueOf(idString);
        
        if(reservaDetalhesCesto.isEmpty()) {
            mensagemNaTela("Nao ha suites na lista", Color.RED);
            throw new NegocioException("Nao ha suites na lista");
        }
        
        validacaoDoCampo(valorPagoString, "valor pago");
        validacaoDoCampo(idHospedeString, "buscar hospede");        
        
        if(valorPago.doubleValue() >= totalDaReserva.doubleValue()) {
            try {
                Long idHospede = Long.valueOf(idHospedeString);
                System.out.println("ID: " + idHospede);
                hospede = hospedeDao.buscarHospedePeloId(idHospede);
                
                if (hospede == null) {
                    mensagemNaTela(String.format("Hospede com id %d nao existe. Insira o nome do hospde para registar", idHospede), Color.RED);
                    throw new NegocioException("Hospede com o id não existe");
                }
            } catch (NumberFormatException e) {
                hospede.setId(0L);
                hospede.setNome(idHospedeString);
                System.out.println(hospede);
                hospedeDao.salvar(hospede);
                hospede = hospedeDao.buscarUltimoHospede();
            }
            
            troco = valorPago.subtract(totalDaReserva);

            Reserva reserva = new Reserva(id, hospede, usuarioLogado(), totalDaReserva, valorPago, troco, descontoTotal, LocalDateTime.now(), LocalDateTime.now(), reservaDetalhesCesto);
            System.out.println(reserva);
            String mensagem = reservaDao.salvar(reserva);
            
            if(mensagem.startsWith("Reserva")) {
                this.dashboard.getLabelReservaValorPago().setText(valorPago.toString());
                this.dashboard.getLabelReservaTroco().setText(troco.toString());
                mensagemNaTela(mensagem, Color.GREEN);
                atualizarTabelaReserva();
                this.dashboard.getLabelHomeHospede().setText(String.format("%d", hospedeDao.todosHospede().size()));
                limparCampo();
            } else {
                mensagemNaTela(mensagem, Color.RED);
            }
        }else {
            mensagemNaTela("Valor pago nao pode ser menor que o total da reserva", Color.RED);
        }
        
    }
    
    private void atualizarTabelaReserva() {
        List<Reserva> reservas = reservaDao.todosReservas();
        this.reservaTableModel = new ReservaTableModel(reservas);
        this.dashboard.getTabelaReserva().setModel(reservaTableModel);
        this.dashboard.getLabelHomeReserva().setText(String.format("%d", reservas.size()));
    }

    private void cancelar() {
        limparCampo();
        this.dashboard.getDialogReserva().setVisible(false);
    }

    private void detalhes() {
        if(this.reservaDetalhes != null) {
            StringBuilder suiteDaReserva = new StringBuilder();
            
            reservaDetalhes.stream().forEach(r -> {
                suiteDaReserva.append(String.format("%s - ", r.getSuite().getNome()));
                suiteDaReserva.append(String.format("%f - ", r.getSuite().getPreco().setScale(2, RoundingMode.DOWN)));
                suiteDaReserva.append(String.format("%d - ", r.getQuantidade()));
                suiteDaReserva.append(String.format("%f - ", r.getDesconto().setScale(2, RoundingMode.DOWN)));
                suiteDaReserva.append(String.format("%f  ", r.getTotal().setScale(2, RoundingMode.DOWN)));
                suiteDaReserva.append("\n");
            });
            
            JOptionPane.showMessageDialog(dashboard, 
                String.format("Detalhes da reserva com id: %d \n\n"
                        + "__________________________________________\n"
                        + "Nome do hospede: %s \n"
                        + "Total da reserva: %s \n"
                        + "Data da reserva: %s \n"
                        + "Reservado por: %s \n"
                        + "__________________________________________\n"
                        + "Suite - Preco - Quantidade - Desconto - Total \n"
                        + "__________________________________________\n"
                        + "%s", 
                      this.reservaDetalhes.get(0).getReserva().getId(),
                      this.reservaDetalhes.get(0).getReserva().getHospede().getNome(),
                      this.reservaDetalhes.get(0).getReserva().getTotalReserva(),
                      this.reservaDetalhes.get(0).getReserva().getDataHoraCriacao(),
                      this.reservaDetalhes.get(0).getReserva().getUsuario().getNome(),
                      suiteDaReserva.toString()
                )
            );
        }else {
            JOptionPane.showMessageDialog(dashboard, "Seleciona um elemento na tabela", "Sem reserva selecionada", 0);
        }
    }
    
    private void limparCampo() {
        this.dashboard.getTxtReservaQuantidade().setValue(1);
        this.dashboard.getTxtReservaDesconto().setText("1");
        this.dashboard.getTxtReservaValorPago().setText("");
        this.dashboard.getTxtReservaPesquisarSuite().setText("");
        this.dashboard.getTxtReservaId().setText("0");
        this.dashboard.getTxtReservaHospede().setText("");
        this.reservaDetalhesCesto = new HashMap<>();
        this.suite = null;
    }
    
}
