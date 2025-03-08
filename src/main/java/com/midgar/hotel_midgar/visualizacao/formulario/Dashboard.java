
package com.midgar.hotel_midgar.visualizacao.formulario;


import com.midgar.hotel_midgar.controller.CategoriaController;
import com.midgar.hotel_midgar.controller.DashboardController;
import com.midgar.hotel_midgar.controller.HospedeController;
import com.midgar.hotel_midgar.controller.ReservaController;
import com.midgar.hotel_midgar.controller.SuiteController;
import com.midgar.hotel_midgar.controller.UsuarioController;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Dashboard extends javax.swing.JFrame {

    private DashboardController dashboardController;
    private CategoriaController categoriaController;
    private SuiteController suiteController;
    private UsuarioController usuarioController;
    private ReservaController reservaController;
    private HospedeController hospedeController;
    
    public Dashboard() {
        initComponents();
        setLocationRelativeTo(null);
        this.dashboardController = new DashboardController(this);
        this.categoriaController = new CategoriaController(this);
        this.usuarioController = new UsuarioController(this);
        this.suiteController = new SuiteController(this);
        this.reservaController = new ReservaController(this);
        this.hospedeController = new HospedeController(this);
        eventosDashboard();
        eventoUsuario();
        eventoSuite();
        eventoCategoria();
        eventoReserva();
        eventoHospede();
    }
    
    
    private void eventosDashboard() {
        botaoDashboardSuites.addActionListener(dashboardController);
        botaoDashboardHospedes.addActionListener(dashboardController);
        botaoDashboardHome.addActionListener(dashboardController);
        botaoDashboardReservas.addActionListener(dashboardController);
        botaoDashboardUsuario.addActionListener(dashboardController);
        botaoDashboardSair.addActionListener(dashboardController);
    }
    
    private void eventoUsuario() {
        botaoUsuarioAdicionar.addActionListener(usuarioController);
        botaoUsuarioEditar.addActionListener(usuarioController);
        botaoUsuarioApagar.addActionListener(usuarioController);
        botaoUsuarioSalvar.addActionListener(usuarioController);
        botaoUsuarioCancelar.addActionListener(usuarioController);
        tabelaUsuario.addMouseListener(usuarioController);
        txtUsuarioPesquisar.addKeyListener(usuarioController);
    }
    
    private void eventoSuite() {
        botaoSuiteAdicionar.addActionListener(suiteController);
        botaoSuiteAdicionarCategoria.addActionListener(suiteController);
        botaoSuiteSalvar.addActionListener(suiteController);
        botaoSuiteCancelar.addActionListener(suiteController);
        botaoSuiteEditar.addActionListener(suiteController);
        botaoSuiteApagar.addActionListener(suiteController);
        tabelaSuite.addMouseListener(suiteController);
        txtSuitePesquisar.addKeyListener(suiteController);
    }
    
    private void eventoReserva() {
        botaoReservaAdicionar.addActionListener(reservaController);
        botaoReservaCancelar.addActionListener(reservaController);
        botaoReservaLimpar.addActionListener(reservaController);
        botaoReservaRegistroRemover.addActionListener(reservaController);
        botaoReservaResgistroAdicionar.addActionListener(reservaController);
        botaoReservaReservar.addActionListener(reservaController);
        botaoReservaDetalhes.addActionListener(reservaController);
        
        comboBoxReservaSuite.addActionListener(reservaController);
        comboBoxReservaPesquisarSuitePelaCategoria.addActionListener(reservaController);
        txtReservaPesquisarSuite.addKeyListener(reservaController);
        tabelaReservaRegistro.addMouseListener(reservaController);
        tabelaReserva.addMouseListener(reservaController);
        checkboxReservaDesconto.addActionListener(reservaController);
    }
    
    private void eventoCategoria() {
       botaoCategoriaApagar.addActionListener(categoriaController);
       botaoCategoriaLimpar.addActionListener(categoriaController);
       botaoCategoriaSalvar.addActionListener(categoriaController);
       botaoCategoriaCancelar.addActionListener(categoriaController);
       tabelaCategoria.addMouseListener(categoriaController);
    }
    
    private void eventoHospede() {
        botaoHospedeAdicionar.addActionListener(hospedeController);        
        botaoHospedeCancelar.addActionListener(hospedeController);
        botaoHospedeApagar.addActionListener(hospedeController);
        botaoHospedeEditar.addActionListener(hospedeController);
        botaoHospedeSalvar.addActionListener(hospedeController);
    }
    

    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogUsuario = new javax.swing.JDialog();
        jPanel13 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        botaoUsuarioCancelar = new javax.swing.JButton();
        botaoUsuarioSalvar = new javax.swing.JButton();
        txtUsuarioId = new javax.swing.JTextField();
        txtUsuarioNome = new javax.swing.JTextField();
        txtUsuarioUsername = new javax.swing.JTextField();
        comboBoxUsuarioPerfil = new javax.swing.JComboBox<>();
        radioBotaoUsuarioAtivo = new javax.swing.JRadioButton();
        radioBotaoUsuarioInativo = new javax.swing.JRadioButton();
        txtUsuarioSenha = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        labelUsuarioMensagem = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        labelUsuarioLogadoId = new javax.swing.JLabel();
        dialogSuite = new javax.swing.JDialog();
        jPanel21 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        botaoSuiteCancelar = new javax.swing.JButton();
        botaoSuiteSalvar = new javax.swing.JButton();
        txtSuiteId = new javax.swing.JTextField();
        txtSuiteNome = new javax.swing.JTextField();
        txtSuitePreco = new javax.swing.JTextField();
        comboBoxSuiteCategoria = new javax.swing.JComboBox<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtSuiteDescricao = new javax.swing.JTextArea();
        botaoSuiteAdicionarCategoria = new javax.swing.JButton();
        txtSuiteQuantidade = new javax.swing.JSpinner();
        jLabel30 = new javax.swing.JLabel();
        labelSuiteMensagem = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        dialogCategoria = new javax.swing.JDialog();
        jPanel22 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        botaoCategoriaCancelar = new javax.swing.JButton();
        botaoCategoriaSalvar = new javax.swing.JButton();
        txtCategoriaId = new javax.swing.JTextField();
        txtCategoriaNome = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtCategoriaDescricao = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaCategoria = new javax.swing.JTable();
        botaoCategoriaApagar = new javax.swing.JButton();
        botaoCategoriaLimpar = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        labelCategoriaMensagem = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        dialogReserva = new javax.swing.JDialog();
        jPanel23 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        botaoReservaCancelar = new javax.swing.JButton();
        botaoReservaReservar = new javax.swing.JButton();
        txtReservaId = new javax.swing.JTextField();
        txtReservaPesquisarSuite = new javax.swing.JTextField();
        txtReservaValorPago = new javax.swing.JTextField();
        comboBoxReservaPesquisarSuitePelaCategoria = new javax.swing.JComboBox<>();
        botaoReservaResgistroAdicionar = new javax.swing.JButton();
        txtReservaQuantidade = new javax.swing.JSpinner();
        jLabel22 = new javax.swing.JLabel();
        comboBoxReservaSuite = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        botaoReservaRegistroRemover = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        txtReservaDesconto = new javax.swing.JTextField();
        checkboxReservaDesconto = new javax.swing.JCheckBox();
        jSeparator6 = new javax.swing.JSeparator();
        labelReservaTotalDaReserva = new javax.swing.JLabel();
        labelReservaValorPago = new javax.swing.JLabel();
        labelReservaDesconto = new javax.swing.JLabel();
        labelReservaTroco = new javax.swing.JLabel();
        labelReservaPrecoDaSuite = new javax.swing.JLabel();
        labelReservaQuantidadeDeSuite = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        labelReservaNomeDaSuite = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        txtReservaHospede = new javax.swing.JTextField();
        botaoReservaResgistroLimpar = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        labelReservaMensagem = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tabelaReservaRegistro = new javax.swing.JTable();
        botaoReservaLimpar = new javax.swing.JButton();
        dialogHospede = new javax.swing.JDialog();
        jPanel14 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        botaoHospedeCancelar = new javax.swing.JButton();
        botaoHospedeSalvar = new javax.swing.JButton();
        txtHospedeId = new javax.swing.JTextField();
        txtHospedeNome = new javax.swing.JTextField();
        txtHospedeEmail = new javax.swing.JTextField();
        txtHospedeTelefone = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        labelHospedeMensagem = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel0 = new javax.swing.JPanel();
        botaoDashboardHome = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        botaoDashboardSuites = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        botaoDashboardHospedes = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        botaoDashboardReservas = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        botaoDashboardSair = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        botaoDashboardUsuario = new javax.swing.JButton();
        panelBody = new javax.swing.JPanel();
        panelHome = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        labelHomeSuite = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        labelHomeHospede = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        labelHomeReserva = new javax.swing.JLabel();
        labelDashboardBemvindoUsuario = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panelSuite = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        botaoSuiteAdicionar = new javax.swing.JButton();
        botaoSuiteEditar = new javax.swing.JButton();
        botaoSuiteApagar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaSuite = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        txtSuitePesquisar = new javax.swing.JTextField();
        labelP = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        panelHospede = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        botaoHospedeAdicionar = new javax.swing.JButton();
        botaoHospedeEditar = new javax.swing.JButton();
        botaoHospedeApagar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaHospede = new javax.swing.JTable();
        jPanel16 = new javax.swing.JPanel();
        txtHospedePesquisar = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        panelReservas = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        botaoReservaAdicionar = new javax.swing.JButton();
        botaoReservaEditar = new javax.swing.JButton();
        botaoReservaApagar = new javax.swing.JButton();
        botaoReservaDetalhes = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabelaReserva = new javax.swing.JTable();
        jPanel20 = new javax.swing.JPanel();
        txtReservaPesquisar = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        panelUsuarios = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        botaoUsuarioAdicionar = new javax.swing.JButton();
        botaoUsuarioEditar = new javax.swing.JButton();
        botaoUsuarioApagar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelaUsuario = new javax.swing.JTable();
        jPanel18 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtUsuarioPesquisar = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        dialogUsuario.setTitle("Adicionar Usuários");
        dialogUsuario.setMinimumSize(new java.awt.Dimension(742, 450));

        jPanel13.setBackground(java.awt.Color.white);
        jPanel13.setMinimumSize(new java.awt.Dimension(742, 450));
        jPanel13.setLayout(null);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Id:");
        jPanel13.add(jLabel10);
        jLabel10.setBounds(112, 97, 15, 20);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Nome:");
        jPanel13.add(jLabel11);
        jLabel11.setBounds(90, 130, 45, 20);

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Username:");
        jPanel13.add(jLabel18);
        jLabel18.setBounds(70, 170, 70, 20);

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Senha:");
        jPanel13.add(jLabel19);
        jLabel19.setBounds(80, 212, 40, 20);

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Perfil:");
        jPanel13.add(jLabel20);
        jLabel20.setBounds(87, 252, 33, 20);

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Status:");
        jPanel13.add(jLabel21);
        jLabel21.setBounds(80, 300, 41, 20);
        jPanel13.add(jSeparator1);
        jSeparator1.setBounds(57, 332, 587, 3);

        botaoUsuarioCancelar.setText("Cancelar");
        jPanel13.add(botaoUsuarioCancelar);
        botaoUsuarioCancelar.setBounds(410, 340, 129, 23);

        botaoUsuarioSalvar.setText("Salvar");
        jPanel13.add(botaoUsuarioSalvar);
        botaoUsuarioSalvar.setBounds(190, 340, 131, 23);

        txtUsuarioId.setEditable(false);
        txtUsuarioId.setText("0");
        jPanel13.add(txtUsuarioId);
        txtUsuarioId.setBounds(147, 97, 70, 22);
        jPanel13.add(txtUsuarioNome);
        txtUsuarioNome.setBounds(147, 130, 320, 22);
        jPanel13.add(txtUsuarioUsername);
        txtUsuarioUsername.setBounds(147, 168, 270, 22);

        comboBoxUsuarioPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel13.add(comboBoxUsuarioPerfil);
        comboBoxUsuarioPerfil.setBounds(147, 252, 200, 22);

        buttonGroup1.add(radioBotaoUsuarioAtivo);
        radioBotaoUsuarioAtivo.setText("Ativo");
        radioBotaoUsuarioAtivo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel13.add(radioBotaoUsuarioAtivo);
        radioBotaoUsuarioAtivo.setBounds(147, 299, 51, 21);

        buttonGroup1.add(radioBotaoUsuarioInativo);
        radioBotaoUsuarioInativo.setText("Inativo");
        radioBotaoUsuarioInativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBotaoUsuarioInativoActionPerformed(evt);
            }
        });
        jPanel13.add(radioBotaoUsuarioInativo);
        radioBotaoUsuarioInativo.setBounds(232, 299, 59, 21);
        jPanel13.add(txtUsuarioSenha);
        txtUsuarioSenha.setBounds(147, 212, 200, 22);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Usuário");
        jPanel13.add(jLabel9);
        jLabel9.setBounds(300, 10, 70, 25);

        labelUsuarioMensagem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelUsuarioMensagem.setForeground(new java.awt.Color(255, 255, 255));
        jPanel13.add(labelUsuarioMensagem);
        labelUsuarioMensagem.setBounds(220, 40, 240, 30);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setIcon(new javax.swing.ImageIcon("C:\\Users\\bruna\\OneDrive\\Documentos\\NetBeansProjects\\Hotel_Midgar\\src\\main\\java\\com\\midgar\\hotel_midgar\\visualizacao\\imagens\\Logo.jpg")); // NOI18N
        jPanel13.add(jLabel12);
        jLabel12.setBounds(-7, -14, 820, 450);

        javax.swing.GroupLayout dialogUsuarioLayout = new javax.swing.GroupLayout(dialogUsuario.getContentPane());
        dialogUsuario.getContentPane().setLayout(dialogUsuarioLayout);
        dialogUsuarioLayout.setHorizontalGroup(
            dialogUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogUsuarioLayout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 728, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        dialogUsuarioLayout.setVerticalGroup(
            dialogUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogUsuarioLayout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        labelUsuarioLogadoId.setText("0");

        dialogSuite.setTitle("Adicionar Suites");

        jPanel21.setBackground(java.awt.Color.white);
        jPanel21.setLayout(null);

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Id:");
        jPanel21.add(jLabel31);
        jLabel31.setBounds(126, 97, 16, 21);

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Nome:");
        jPanel21.add(jLabel32);
        jLabel32.setBounds(98, 130, 44, 21);

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Preço:");
        jPanel21.add(jLabel33);
        jLabel33.setBounds(97, 168, 40, 21);

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Quantidade:");
        jPanel21.add(jLabel34);
        jLabel34.setBounds(57, 208, 81, 21);

        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Categoria:");
        jPanel21.add(jLabel35);
        jLabel35.setBounds(70, 248, 68, 21);

        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Descrição:");
        jPanel21.add(jLabel36);
        jLabel36.setBounds(68, 288, 68, 21);
        jPanel21.add(jSeparator3);
        jSeparator3.setBounds(57, 386, 587, 3);

        botaoSuiteCancelar.setText("Cancelar");
        jPanel21.add(botaoSuiteCancelar);
        botaoSuiteCancelar.setBounds(430, 390, 129, 23);

        botaoSuiteSalvar.setText("Salvar");
        jPanel21.add(botaoSuiteSalvar);
        botaoSuiteSalvar.setBounds(210, 390, 131, 23);

        txtSuiteId.setEditable(false);
        txtSuiteId.setText("0");
        jPanel21.add(txtSuiteId);
        txtSuiteId.setBounds(161, 97, 150, 22);
        jPanel21.add(txtSuiteNome);
        txtSuiteNome.setBounds(161, 130, 290, 22);

        txtSuitePreco.setText("1");
        jPanel21.add(txtSuitePreco);
        txtSuitePreco.setBounds(161, 168, 70, 22);

        comboBoxSuiteCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxSuiteCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxSuiteCategoriaActionPerformed(evt);
            }
        });
        jPanel21.add(comboBoxSuiteCategoria);
        comboBoxSuiteCategoria.setBounds(161, 248, 190, 22);

        txtSuiteDescricao.setColumns(20);
        txtSuiteDescricao.setRows(5);
        jScrollPane6.setViewportView(txtSuiteDescricao);

        jPanel21.add(jScrollPane6);
        jScrollPane6.setBounds(161, 288, 483, 86);

        botaoSuiteAdicionarCategoria.setText("Cadastrar Categoria");
        botaoSuiteAdicionarCategoria.setActionCommand("adicionarcategoria");
        jPanel21.add(botaoSuiteAdicionarCategoria);
        botaoSuiteAdicionarCategoria.setBounds(380, 250, 160, 20);
        jPanel21.add(txtSuiteQuantidade);
        txtSuiteQuantidade.setBounds(161, 208, 110, 22);

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Suite");
        jPanel21.add(jLabel30);
        jLabel30.setBounds(330, 0, 60, 40);

        labelSuiteMensagem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelSuiteMensagem.setForeground(new java.awt.Color(255, 255, 255));
        jPanel21.add(labelSuiteMensagem);
        labelSuiteMensagem.setBounds(240, 40, 250, 30);

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setIcon(new javax.swing.ImageIcon("C:\\Users\\bruna\\OneDrive\\Documentos\\NetBeansProjects\\Hotel_Midgar\\src\\main\\java\\com\\midgar\\hotel_midgar\\visualizacao\\imagens\\Logo.jpg")); // NOI18N
        jPanel21.add(jLabel16);
        jLabel16.setBounds(-7, -14, 780, 490);

        javax.swing.GroupLayout dialogSuiteLayout = new javax.swing.GroupLayout(dialogSuite.getContentPane());
        dialogSuite.getContentPane().setLayout(dialogSuiteLayout);
        dialogSuiteLayout.setHorizontalGroup(
            dialogSuiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, 723, Short.MAX_VALUE)
        );
        dialogSuiteLayout.setVerticalGroup(
            dialogSuiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        dialogCategoria.setTitle("Adicionar Categorias");

        jPanel22.setBackground(java.awt.Color.white);
        jPanel22.setLayout(null);

        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Id:");
        jPanel22.add(jLabel38);
        jLabel38.setBounds(129, 97, 15, 20);

        jLabel39.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Nome:");
        jPanel22.add(jLabel39);
        jLabel39.setBounds(101, 130, 40, 20);

        jLabel43.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Descrição:");
        jPanel22.add(jLabel43);
        jLabel43.setBounds(71, 170, 61, 20);
        jPanel22.add(jSeparator4);
        jSeparator4.setBounds(57, 268, 587, 3);

        botaoCategoriaCancelar.setText("Cancelar");
        jPanel22.add(botaoCategoriaCancelar);
        botaoCategoriaCancelar.setBounds(515, 273, 129, 23);

        botaoCategoriaSalvar.setText("Salvar");
        jPanel22.add(botaoCategoriaSalvar);
        botaoCategoriaSalvar.setBounds(372, 273, 131, 23);

        txtCategoriaId.setEditable(false);
        txtCategoriaId.setText("0");
        jPanel22.add(txtCategoriaId);
        txtCategoriaId.setBounds(164, 97, 130, 22);
        jPanel22.add(txtCategoriaNome);
        txtCategoriaNome.setBounds(164, 130, 290, 22);

        txtCategoriaDescricao.setColumns(20);
        txtCategoriaDescricao.setRows(5);
        jScrollPane7.setViewportView(txtCategoriaDescricao);

        jPanel22.add(jScrollPane7);
        jScrollPane7.setBounds(164, 170, 480, 86);

        tabelaCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tabelaCategoria);

        jPanel22.add(jScrollPane2);
        jScrollPane2.setBounds(70, 320, 587, 169);

        botaoCategoriaApagar.setText("Apagar");
        jPanel22.add(botaoCategoriaApagar);
        botaoCategoriaApagar.setBounds(241, 273, 113, 23);

        botaoCategoriaLimpar.setText("Limpar");
        jPanel22.add(botaoCategoriaLimpar);
        botaoCategoriaLimpar.setBounds(123, 273, 100, 23);

        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Categoria");
        jPanel22.add(jLabel37);
        jLabel37.setBounds(300, 10, 90, 25);

        labelCategoriaMensagem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelCategoriaMensagem.setForeground(new java.awt.Color(255, 255, 255));
        jPanel22.add(labelCategoriaMensagem);
        labelCategoriaMensagem.setBounds(250, 40, 260, 30);

        jLabel54.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel54.setIcon(new javax.swing.ImageIcon("C:\\Users\\bruna\\OneDrive\\Documentos\\NetBeansProjects\\Hotel_Midgar\\src\\main\\java\\com\\midgar\\hotel_midgar\\visualizacao\\imagens\\Logo.jpg")); // NOI18N
        jPanel22.add(jLabel54);
        jLabel54.setBounds(-7, -14, 750, 560);

        javax.swing.GroupLayout dialogCategoriaLayout = new javax.swing.GroupLayout(dialogCategoria.getContentPane());
        dialogCategoria.getContentPane().setLayout(dialogCategoriaLayout);
        dialogCategoriaLayout.setHorizontalGroup(
            dialogCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogCategoriaLayout.createSequentialGroup()
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        dialogCategoriaLayout.setVerticalGroup(
            dialogCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogCategoriaLayout.createSequentialGroup()
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        dialogReserva.setTitle("Fazer Reservas");

        jPanel23.setBackground(java.awt.Color.white);
        jPanel23.setLayout(null);

        jLabel41.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Id:");
        jPanel23.add(jLabel41);
        jLabel41.setBounds(124, 93, 20, 19);

        jLabel42.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Pesquisar suite:");
        jPanel23.add(jLabel42);
        jLabel42.setBounds(50, 130, 120, 19);

        jLabel44.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Valor pago:");
        jPanel23.add(jLabel44);
        jLabel44.setBounds(62, 340, 73, 19);

        jLabel45.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Diaria:");
        jPanel23.add(jLabel45);
        jLabel45.setBounds(83, 253, 50, 19);

        jLabel46.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("Categoria:");
        jPanel23.add(jLabel46);
        jLabel46.setBounds(70, 160, 66, 19);
        jPanel23.add(jSeparator5);
        jSeparator5.setBounds(0, 520, 766, 3);

        botaoReservaCancelar.setText("Cancelar");
        jPanel23.add(botaoReservaCancelar);
        botaoReservaCancelar.setBounds(590, 530, 129, 23);

        botaoReservaReservar.setText("Reservar");
        botaoReservaReservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoReservaReservarActionPerformed(evt);
            }
        });
        jPanel23.add(botaoReservaReservar);
        botaoReservaReservar.setBounds(450, 530, 131, 23);

        txtReservaId.setEditable(false);
        txtReservaId.setText("0");
        jPanel23.add(txtReservaId);
        txtReservaId.setBounds(160, 90, 60, 22);
        jPanel23.add(txtReservaPesquisarSuite);
        txtReservaPesquisarSuite.setBounds(160, 130, 370, 22);
        jPanel23.add(txtReservaValorPago);
        txtReservaValorPago.setBounds(159, 340, 220, 22);

        comboBoxReservaPesquisarSuitePelaCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxReservaPesquisarSuitePelaCategoria.setActionCommand("comboboxVendaCategoria");
        comboBoxReservaPesquisarSuitePelaCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxReservaPesquisarSuitePelaCategoriaActionPerformed(evt);
            }
        });
        jPanel23.add(comboBoxReservaPesquisarSuitePelaCategoria);
        comboBoxReservaPesquisarSuitePelaCategoria.setBounds(160, 160, 151, 22);

        botaoReservaResgistroAdicionar.setText("Adicionar");
        botaoReservaResgistroAdicionar.setActionCommand("adicionarnocesto");
        jPanel23.add(botaoReservaResgistroAdicionar);
        botaoReservaResgistroAdicionar.setBounds(160, 530, 150, 23);

        txtReservaQuantidade.setValue(Integer.valueOf("1")
        );
        jPanel23.add(txtReservaQuantidade);
        txtReservaQuantidade.setBounds(159, 253, 170, 22);

        jLabel22.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Suite");
        jPanel23.add(jLabel22);
        jLabel22.setBounds(410, 160, 32, 19);

        comboBoxReservaSuite.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxReservaSuite.setActionCommand("comboboxvendaproduto");
        jPanel23.add(comboBoxReservaSuite);
        comboBoxReservaSuite.setBounds(510, 160, 140, 22);

        jLabel23.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Preço:");
        jPanel23.add(jLabel23);
        jLabel23.setBounds(159, 194, 41, 19);

        jLabel24.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Diária:");
        jPanel23.add(jLabel24);
        jLabel24.setBounds(410, 190, 70, 19);
        jPanel23.add(jSeparator2);
        jSeparator2.setBounds(159, 244, 607, 3);

        jLabel25.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Total da Reserva:");
        jPanel23.add(jLabel25);
        jLabel25.setBounds(150, 402, 120, 19);

        jLabel26.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Valor pago:");
        jPanel23.add(jLabel26);
        jLabel26.setBounds(159, 434, 73, 19);

        jLabel27.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Desconto:");
        jPanel23.add(jLabel27);
        jLabel27.setBounds(159, 464, 64, 19);

        jLabel28.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Troco:");
        jPanel23.add(jLabel28);
        jLabel28.setBounds(159, 497, 41, 19);

        botaoReservaRegistroRemover.setText("Remover");
        jPanel23.add(botaoReservaRegistroRemover);
        botaoReservaRegistroRemover.setBounds(320, 530, 121, 23);

        jLabel29.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Desconto:");
        jPanel23.add(jLabel29);
        jLabel29.setBounds(69, 293, 64, 19);

        txtReservaDesconto.setText("0");
        txtReservaDesconto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtReservaDescontoActionPerformed(evt);
            }
        });
        jPanel23.add(txtReservaDesconto);
        txtReservaDesconto.setBounds(159, 293, 190, 22);

        checkboxReservaDesconto.setActionCommand("checkboxvendadesconto");
        jPanel23.add(checkboxReservaDesconto);
        checkboxReservaDesconto.setBounds(360, 290, 20, 30);

        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel23.add(jSeparator6);
        jSeparator6.setBounds(788, 2, 3, 575);

        labelReservaTotalDaReserva.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        labelReservaTotalDaReserva.setForeground(new java.awt.Color(255, 255, 255));
        labelReservaTotalDaReserva.setText("0.00");
        jPanel23.add(labelReservaTotalDaReserva);
        labelReservaTotalDaReserva.setBounds(274, 402, 492, 20);

        labelReservaValorPago.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        labelReservaValorPago.setForeground(new java.awt.Color(255, 255, 255));
        labelReservaValorPago.setText("0.00");
        jPanel23.add(labelReservaValorPago);
        labelReservaValorPago.setBounds(274, 434, 492, 24);

        labelReservaDesconto.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        labelReservaDesconto.setForeground(new java.awt.Color(255, 255, 255));
        labelReservaDesconto.setText("0.00");
        jPanel23.add(labelReservaDesconto);
        labelReservaDesconto.setBounds(274, 464, 492, 27);

        labelReservaTroco.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        labelReservaTroco.setForeground(new java.awt.Color(255, 255, 255));
        labelReservaTroco.setText("0.00");
        jPanel23.add(labelReservaTroco);
        labelReservaTroco.setBounds(274, 500, 492, 19);

        labelReservaPrecoDaSuite.setForeground(new java.awt.Color(255, 255, 255));
        labelReservaPrecoDaSuite.setText("0,00");
        jPanel23.add(labelReservaPrecoDaSuite);
        labelReservaPrecoDaSuite.setBounds(211, 194, 174, 20);

        labelReservaQuantidadeDeSuite.setForeground(new java.awt.Color(255, 255, 255));
        labelReservaQuantidadeDeSuite.setText("0");
        jPanel23.add(labelReservaQuantidadeDeSuite);
        labelReservaQuantidadeDeSuite.setBounds(460, 190, 190, 20);

        jLabel47.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Nome da suite:");
        jPanel23.add(jLabel47);
        jLabel47.setBounds(159, 220, 94, 19);

        labelReservaNomeDaSuite.setForeground(new java.awt.Color(255, 255, 255));
        jPanel23.add(labelReservaNomeDaSuite);
        labelReservaNomeDaSuite.setBounds(280, 220, 380, 22);

        jLabel53.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("Buscar hospede:");
        jPanel23.add(jLabel53);
        jLabel53.setBounds(35, 374, 110, 19);
        jPanel23.add(txtReservaHospede);
        txtReservaHospede.setBounds(159, 374, 350, 22);

        botaoReservaResgistroLimpar.setText("Limpar");
        jPanel23.add(botaoReservaResgistroLimpar);
        botaoReservaResgistroLimpar.setBounds(10, 530, 140, 23);

        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Reserva");
        jPanel23.add(jLabel40);
        jLabel40.setBounds(320, 30, 70, 20);

        labelReservaMensagem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelReservaMensagem.setForeground(new java.awt.Color(255, 255, 255));
        jPanel23.add(labelReservaMensagem);
        labelReservaMensagem.setBounds(240, 60, 230, 30);

        jLabel56.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel56.setIcon(new javax.swing.ImageIcon("C:\\Users\\bruna\\OneDrive\\Documentos\\NetBeansProjects\\Hotel_Midgar\\src\\main\\java\\com\\midgar\\hotel_midgar\\visualizacao\\imagens\\Logo.jpg")); // NOI18N
        jPanel23.add(jLabel56);
        jLabel56.setBounds(0, 0, 750, 580);

        jPanel24.setBackground(java.awt.Color.white);

        tabelaReservaRegistro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane8.setViewportView(tabelaReservaRegistro);

        botaoReservaLimpar.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        botaoReservaLimpar.setText("Limpar");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botaoReservaLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8)
                .addGap(18, 18, 18)
                .addComponent(botaoReservaLimpar)
                .addContainerGap())
        );

        javax.swing.GroupLayout dialogReservaLayout = new javax.swing.GroupLayout(dialogReserva.getContentPane());
        dialogReserva.getContentPane().setLayout(dialogReservaLayout);
        dialogReservaLayout.setHorizontalGroup(
            dialogReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogReservaLayout.createSequentialGroup()
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, 735, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        dialogReservaLayout.setVerticalGroup(
            dialogReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        dialogHospede.setTitle("Adicionar Hospedes");

        jPanel14.setBackground(java.awt.Color.white);
        jPanel14.setLayout(null);

        jLabel49.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("Id:");
        jPanel14.add(jLabel49);
        jLabel49.setBounds(108, 97, 15, 20);

        jLabel50.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("Nome:");
        jPanel14.add(jLabel50);
        jLabel50.setBounds(80, 130, 40, 20);

        jLabel51.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("Telefone:");
        jPanel14.add(jLabel51);
        jLabel51.setBounds(57, 168, 54, 20);

        jLabel52.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("E-mail:");
        jPanel14.add(jLabel52);
        jLabel52.setBounds(78, 205, 41, 20);
        jPanel14.add(jSeparator7);
        jSeparator7.setBounds(57, 231, 587, 3);

        botaoHospedeCancelar.setText("Cancelar");
        jPanel14.add(botaoHospedeCancelar);
        botaoHospedeCancelar.setBounds(470, 250, 129, 23);

        botaoHospedeSalvar.setText("Salvar");
        jPanel14.add(botaoHospedeSalvar);
        botaoHospedeSalvar.setBounds(150, 250, 131, 23);

        txtHospedeId.setEditable(false);
        txtHospedeId.setText("0");
        jPanel14.add(txtHospedeId);
        txtHospedeId.setBounds(143, 97, 501, 22);
        jPanel14.add(txtHospedeNome);
        txtHospedeNome.setBounds(143, 130, 501, 22);
        jPanel14.add(txtHospedeEmail);
        txtHospedeEmail.setBounds(143, 203, 501, 22);
        jPanel14.add(txtHospedeTelefone);
        txtHospedeTelefone.setBounds(143, 168, 501, 22);

        jLabel48.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("Hospede");
        jPanel14.add(jLabel48);
        jLabel48.setBounds(310, 10, 100, 25);

        labelHospedeMensagem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelHospedeMensagem.setForeground(new java.awt.Color(255, 255, 255));
        jPanel14.add(labelHospedeMensagem);
        labelHospedeMensagem.setBounds(250, 40, 210, 30);

        jLabel57.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel57.setIcon(new javax.swing.ImageIcon("C:\\Users\\bruna\\OneDrive\\Documentos\\NetBeansProjects\\Hotel_Midgar\\src\\main\\java\\com\\midgar\\hotel_midgar\\visualizacao\\imagens\\Logo.jpg")); // NOI18N
        jPanel14.add(jLabel57);
        jLabel57.setBounds(0, -10, 750, 420);

        javax.swing.GroupLayout dialogHospedeLayout = new javax.swing.GroupLayout(dialogHospede.getContentPane());
        dialogHospede.getContentPane().setLayout(dialogHospedeLayout);
        dialogHospedeLayout.setHorizontalGroup(
            dialogHospedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
        );
        dialogHospedeLayout.setVerticalGroup(
            dialogHospedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sitema Hotel Midgar");
        setBackground(java.awt.Color.white);

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel0.setBackground(java.awt.Color.white);

        botaoDashboardHome.setText("Home");
        botaoDashboardHome.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                botaoDashboardHomeMouseDragged(evt);
            }
        });
        botaoDashboardHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoDashboardHomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel0Layout = new javax.swing.GroupLayout(jPanel0);
        jPanel0.setLayout(jPanel0Layout);
        jPanel0Layout.setHorizontalGroup(
            jPanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botaoDashboardHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel0Layout.setVerticalGroup(
            jPanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botaoDashboardHome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
        );

        jPanel4.setBackground(java.awt.Color.white);

        botaoDashboardSuites.setText("Suites");
        botaoDashboardSuites.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoDashboardSuitesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botaoDashboardSuites, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botaoDashboardSuites, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
        );

        jPanel8.setBackground(java.awt.Color.white);

        botaoDashboardHospedes.setText("Hospedes");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botaoDashboardHospedes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botaoDashboardHospedes, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
        );

        jPanel9.setBackground(java.awt.Color.white);

        botaoDashboardReservas.setText("Reservas");
        botaoDashboardReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoDashboardReservasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botaoDashboardReservas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botaoDashboardReservas, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
        );

        jPanel7.setBackground(java.awt.Color.white);

        botaoDashboardSair.setText("Sair");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botaoDashboardSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(botaoDashboardSair, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel6.setBackground(java.awt.Color.white);

        botaoDashboardUsuario.setText("Usuarios");
        botaoDashboardUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoDashboardUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botaoDashboardUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(botaoDashboardUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jPanel0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelBody.setBackground(java.awt.Color.white);
        panelBody.setPreferredSize(new java.awt.Dimension(537, 338));
        panelBody.setLayout(new java.awt.CardLayout());

        panelHome.setBackground(java.awt.Color.white);
        panelHome.setMinimumSize(new java.awt.Dimension(535, 357));
        panelHome.setName(""); // NOI18N
        panelHome.setPreferredSize(new java.awt.Dimension(535, 357));
        panelHome.setLayout(null);

        jPanel5.setBackground(java.awt.Color.white);
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("SUITES");

        labelHomeSuite.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelHomeSuite.setText("0");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(labelHomeSuite)
                .addGap(24, 24, 24))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelHomeSuite)
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        panelHome.add(jPanel5);
        jPanel5.setBounds(30, 70, 120, 60);

        jPanel10.setBackground(java.awt.Color.white);
        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel10.setPreferredSize(new java.awt.Dimension(204, 88));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("HOSPEDES");

        labelHomeHospede.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelHomeHospede.setText("0");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(labelHomeHospede)
                .addGap(17, 17, 17))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel4)
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelHomeHospede)
                .addContainerGap())
        );

        panelHome.add(jPanel10);
        jPanel10.setBounds(30, 160, 120, 60);

        jPanel11.setBackground(java.awt.Color.white);
        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel11.setPreferredSize(new java.awt.Dimension(204, 88));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("RESERVAS");

        labelHomeReserva.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelHomeReserva.setText("0");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(labelHomeReserva)
                .addGap(25, 25, 25))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelHomeReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelHome.add(jPanel11);
        jPanel11.setBounds(30, 250, 120, 60);

        labelDashboardBemvindoUsuario.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        labelDashboardBemvindoUsuario.setForeground(new java.awt.Color(255, 255, 255));
        panelHome.add(labelDashboardBemvindoUsuario);
        labelDashboardBemvindoUsuario.setBounds(10, 10, 500, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\bruna\\OneDrive\\Documentos\\NetBeansProjects\\Hotel_Midgar\\src\\main\\java\\com\\midgar\\hotel_midgar\\visualizacao\\imagens\\home.jpg")); // NOI18N
        panelHome.add(jLabel3);
        jLabel3.setBounds(0, -40, 600, 440);

        panelBody.add(panelHome, "card6");

        panelSuite.setBackground(java.awt.Color.white);
        panelSuite.setMinimumSize(new java.awt.Dimension(535, 357));
        panelSuite.setPreferredSize(new java.awt.Dimension(535, 357));
        panelSuite.setLayout(null);

        jPanel2.setBackground(java.awt.Color.white);
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        botaoSuiteAdicionar.setText("Adicionar");
        jPanel2.add(botaoSuiteAdicionar);

        botaoSuiteEditar.setText("Editar");
        jPanel2.add(botaoSuiteEditar);

        botaoSuiteApagar.setText("Apagar");
        jPanel2.add(botaoSuiteApagar);

        panelSuite.add(jPanel2);
        jPanel2.setBounds(6, 53, 510, 23);

        tabelaSuite.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ));
        jScrollPane1.setViewportView(tabelaSuite);

        panelSuite.add(jScrollPane1);
        jScrollPane1.setBounds(20, 130, 490, 200);

        jPanel12.setBackground(java.awt.Color.white);
        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtSuitePesquisar.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtSuitePesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(txtSuitePesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelSuite.add(jPanel12);
        jPanel12.setBounds(220, 100, 290, 20);

        labelP.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelP.setForeground(new java.awt.Color(255, 255, 255));
        labelP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelP.setText("SUITES");
        panelSuite.add(labelP);
        labelP.setBounds(180, 10, 150, 29);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\bruna\\OneDrive\\Documentos\\NetBeansProjects\\Hotel_Midgar\\src\\main\\java\\com\\midgar\\hotel_midgar\\visualizacao\\imagens\\home.jpg")); // NOI18N
        panelSuite.add(jLabel1);
        jLabel1.setBounds(0, -20, 590, 390);

        panelBody.add(panelSuite, "card2");

        panelHospede.setBackground(java.awt.Color.white);
        panelHospede.setMinimumSize(new java.awt.Dimension(535, 357));
        panelHospede.setPreferredSize(new java.awt.Dimension(535, 357));
        panelHospede.setLayout(null);

        jPanel15.setBackground(java.awt.Color.white);
        jPanel15.setLayout(new java.awt.GridLayout(1, 0));

        botaoHospedeAdicionar.setText("Adicionar");
        jPanel15.add(botaoHospedeAdicionar);

        botaoHospedeEditar.setText("Editar");
        jPanel15.add(botaoHospedeEditar);

        botaoHospedeApagar.setText("Apagar");
        jPanel15.add(botaoHospedeApagar);

        panelHospede.add(jPanel15);
        jPanel15.setBounds(6, 53, 500, 23);

        tabelaHospede.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ));
        jScrollPane3.setViewportView(tabelaHospede);

        panelHospede.add(jScrollPane3);
        jScrollPane3.setBounds(20, 130, 490, 202);

        jPanel16.setBackground(java.awt.Color.white);
        jPanel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtHospedePesquisar.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(txtHospedePesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(txtHospedePesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelHospede.add(jPanel16);
        jPanel16.setBounds(200, 100, 300, 20);

        jLabel13.setBackground(java.awt.Color.white);
        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("HOSPEDES");
        panelHospede.add(jLabel13);
        jLabel13.setBounds(6, 6, 525, 29);

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\bruna\\OneDrive\\Documentos\\NetBeansProjects\\Hotel_Midgar\\src\\main\\java\\com\\midgar\\hotel_midgar\\visualizacao\\imagens\\home.jpg")); // NOI18N
        panelHospede.add(jLabel5);
        jLabel5.setBounds(0, -30, 750, 410);

        panelBody.add(panelHospede, "card3");

        panelReservas.setMinimumSize(new java.awt.Dimension(535, 357));
        panelReservas.setPreferredSize(new java.awt.Dimension(535, 357));
        panelReservas.setLayout(null);

        jPanel19.setBackground(java.awt.Color.white);
        jPanel19.setLayout(new java.awt.GridLayout(1, 0));

        botaoReservaAdicionar.setText("Adicionar");
        jPanel19.add(botaoReservaAdicionar);

        botaoReservaEditar.setText("Editar");
        jPanel19.add(botaoReservaEditar);

        botaoReservaApagar.setText("Apagar");
        jPanel19.add(botaoReservaApagar);

        botaoReservaDetalhes.setText("Detalhes");
        jPanel19.add(botaoReservaDetalhes);

        panelReservas.add(jPanel19);
        jPanel19.setBounds(6, 53, 510, 23);

        tabelaReserva.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ));
        jScrollPane5.setViewportView(tabelaReserva);

        panelReservas.add(jScrollPane5);
        jScrollPane5.setBounds(20, 130, 490, 202);

        jPanel20.setBackground(java.awt.Color.white);
        jPanel20.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtReservaPesquisar.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addComponent(txtReservaPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addComponent(txtReservaPesquisar)
                .addContainerGap())
        );

        panelReservas.add(jPanel20);
        jPanel20.setBounds(210, 100, 300, 20);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("RESERVAS");
        panelReservas.add(jLabel17);
        jLabel17.setBounds(6, 6, 525, 29);

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\bruna\\OneDrive\\Documentos\\NetBeansProjects\\Hotel_Midgar\\src\\main\\java\\com\\midgar\\hotel_midgar\\visualizacao\\imagens\\home.jpg")); // NOI18N
        panelReservas.add(jLabel7);
        jLabel7.setBounds(0, -40, 780, 440);

        panelBody.add(panelReservas, "card4");

        panelUsuarios.setBackground(java.awt.Color.white);
        panelUsuarios.setMinimumSize(new java.awt.Dimension(535, 357));
        panelUsuarios.setPreferredSize(new java.awt.Dimension(535, 357));
        panelUsuarios.setLayout(null);

        jPanel17.setBackground(java.awt.Color.white);
        jPanel17.setLayout(new java.awt.GridLayout(1, 0));

        botaoUsuarioAdicionar.setText("Adicionar");
        jPanel17.add(botaoUsuarioAdicionar);

        botaoUsuarioEditar.setText("Editar");
        jPanel17.add(botaoUsuarioEditar);

        botaoUsuarioApagar.setText("Apagar");
        jPanel17.add(botaoUsuarioApagar);

        panelUsuarios.add(jPanel17);
        jPanel17.setBounds(6, 53, 500, 23);

        jScrollPane4.setBackground(java.awt.Color.white);

        tabelaUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ));
        jScrollPane4.setViewportView(tabelaUsuario);

        panelUsuarios.add(jScrollPane4);
        jScrollPane4.setBounds(10, 120, 500, 212);

        jPanel18.setBackground(java.awt.Color.white);
        jPanel18.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtUsuarioPesquisar.setToolTipText("Pesquisar pelo Nome");
        txtUsuarioPesquisar.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtUsuarioPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(txtUsuarioPesquisar)
        );

        panelUsuarios.add(jPanel18);
        jPanel18.setBounds(220, 90, 290, 20);

        jLabel15.setBackground(java.awt.Color.white);
        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("USUARIOS");
        panelUsuarios.add(jLabel15);
        jLabel15.setBounds(6, 6, 525, 29);

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\bruna\\OneDrive\\Documentos\\NetBeansProjects\\Hotel_Midgar\\src\\main\\java\\com\\midgar\\hotel_midgar\\visualizacao\\imagens\\home.jpg")); // NOI18N
        panelUsuarios.add(jLabel8);
        jLabel8.setBounds(0, -20, 710, 390);

        panelBody.add(panelUsuarios, "card5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBody, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoDashboardHomeMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoDashboardHomeMouseDragged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_botaoDashboardHomeMouseDragged

    private void botaoDashboardUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDashboardUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoDashboardUsuarioActionPerformed

    private void botaoDashboardSuitesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDashboardSuitesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoDashboardSuitesActionPerformed

    private void botaoDashboardHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDashboardHomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoDashboardHomeActionPerformed

    private void botaoDashboardReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDashboardReservasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoDashboardReservasActionPerformed

    private void comboBoxSuiteCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxSuiteCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxSuiteCategoriaActionPerformed

    private void comboBoxReservaPesquisarSuitePelaCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxReservaPesquisarSuitePelaCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxReservaPesquisarSuitePelaCategoriaActionPerformed

    private void txtReservaDescontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtReservaDescontoActionPerformed
         // TODO add your handling code here:
    }//GEN-LAST:event_txtReservaDescontoActionPerformed

    private void radioBotaoUsuarioInativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBotaoUsuarioInativoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioBotaoUsuarioInativoActionPerformed

    private void botaoReservaReservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoReservaReservarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoReservaReservarActionPerformed

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCategoriaApagar;
    private javax.swing.JButton botaoCategoriaCancelar;
    private javax.swing.JButton botaoCategoriaLimpar;
    private javax.swing.JButton botaoCategoriaSalvar;
    private javax.swing.JButton botaoDashboardHome;
    private javax.swing.JButton botaoDashboardHospedes;
    private javax.swing.JButton botaoDashboardReservas;
    private javax.swing.JButton botaoDashboardSair;
    private javax.swing.JButton botaoDashboardSuites;
    private javax.swing.JButton botaoDashboardUsuario;
    private javax.swing.JButton botaoHospedeAdicionar;
    private javax.swing.JButton botaoHospedeApagar;
    private javax.swing.JButton botaoHospedeCancelar;
    private javax.swing.JButton botaoHospedeEditar;
    private javax.swing.JButton botaoHospedeSalvar;
    private javax.swing.JButton botaoReservaAdicionar;
    private javax.swing.JButton botaoReservaApagar;
    private javax.swing.JButton botaoReservaCancelar;
    private javax.swing.JButton botaoReservaDetalhes;
    private javax.swing.JButton botaoReservaEditar;
    private javax.swing.JButton botaoReservaLimpar;
    private javax.swing.JButton botaoReservaRegistroRemover;
    private javax.swing.JButton botaoReservaReservar;
    private javax.swing.JButton botaoReservaResgistroAdicionar;
    private javax.swing.JButton botaoReservaResgistroLimpar;
    private javax.swing.JButton botaoSuiteAdicionar;
    private javax.swing.JButton botaoSuiteAdicionarCategoria;
    private javax.swing.JButton botaoSuiteApagar;
    private javax.swing.JButton botaoSuiteCancelar;
    private javax.swing.JButton botaoSuiteEditar;
    private javax.swing.JButton botaoSuiteSalvar;
    private javax.swing.JButton botaoUsuarioAdicionar;
    private javax.swing.JButton botaoUsuarioApagar;
    private javax.swing.JButton botaoUsuarioCancelar;
    private javax.swing.JButton botaoUsuarioEditar;
    private javax.swing.JButton botaoUsuarioSalvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox checkboxReservaDesconto;
    private javax.swing.JComboBox<String> comboBoxReservaPesquisarSuitePelaCategoria;
    private javax.swing.JComboBox<String> comboBoxReservaSuite;
    private javax.swing.JComboBox<String> comboBoxSuiteCategoria;
    private javax.swing.JComboBox<String> comboBoxUsuarioPerfil;
    private javax.swing.JDialog dialogCategoria;
    private javax.swing.JDialog dialogHospede;
    private javax.swing.JDialog dialogReserva;
    private javax.swing.JDialog dialogSuite;
    private javax.swing.JDialog dialogUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel0;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JLabel labelCategoriaMensagem;
    private javax.swing.JLabel labelDashboardBemvindoUsuario;
    private javax.swing.JLabel labelHomeHospede;
    private javax.swing.JLabel labelHomeReserva;
    private javax.swing.JLabel labelHomeSuite;
    private javax.swing.JLabel labelHospedeMensagem;
    private javax.swing.JLabel labelP;
    private javax.swing.JLabel labelReservaDesconto;
    private javax.swing.JLabel labelReservaMensagem;
    private javax.swing.JLabel labelReservaNomeDaSuite;
    private javax.swing.JLabel labelReservaPrecoDaSuite;
    private javax.swing.JLabel labelReservaQuantidadeDeSuite;
    private javax.swing.JLabel labelReservaTotalDaReserva;
    private javax.swing.JLabel labelReservaTroco;
    private javax.swing.JLabel labelReservaValorPago;
    private javax.swing.JLabel labelSuiteMensagem;
    private javax.swing.JLabel labelUsuarioLogadoId;
    private javax.swing.JLabel labelUsuarioMensagem;
    private javax.swing.JPanel panelBody;
    private javax.swing.JPanel panelHome;
    private javax.swing.JPanel panelHospede;
    private javax.swing.JPanel panelReservas;
    private javax.swing.JPanel panelSuite;
    private javax.swing.JPanel panelUsuarios;
    private javax.swing.JRadioButton radioBotaoUsuarioAtivo;
    private javax.swing.JRadioButton radioBotaoUsuarioInativo;
    private javax.swing.JTable tabelaCategoria;
    private javax.swing.JTable tabelaHospede;
    private javax.swing.JTable tabelaReserva;
    private javax.swing.JTable tabelaReservaRegistro;
    private javax.swing.JTable tabelaSuite;
    private javax.swing.JTable tabelaUsuario;
    private javax.swing.JTextArea txtCategoriaDescricao;
    private javax.swing.JTextField txtCategoriaId;
    private javax.swing.JTextField txtCategoriaNome;
    private javax.swing.JTextField txtHospedeEmail;
    private javax.swing.JTextField txtHospedeId;
    private javax.swing.JTextField txtHospedeNome;
    private javax.swing.JTextField txtHospedePesquisar;
    private javax.swing.JTextField txtHospedeTelefone;
    private javax.swing.JTextField txtReservaDesconto;
    private javax.swing.JTextField txtReservaHospede;
    private javax.swing.JTextField txtReservaId;
    private javax.swing.JTextField txtReservaPesquisar;
    private javax.swing.JTextField txtReservaPesquisarSuite;
    private javax.swing.JSpinner txtReservaQuantidade;
    private javax.swing.JTextField txtReservaValorPago;
    private javax.swing.JTextArea txtSuiteDescricao;
    private javax.swing.JTextField txtSuiteId;
    private javax.swing.JTextField txtSuiteNome;
    private javax.swing.JTextField txtSuitePesquisar;
    private javax.swing.JTextField txtSuitePreco;
    private javax.swing.JSpinner txtSuiteQuantidade;
    private javax.swing.JTextField txtUsuarioId;
    private javax.swing.JTextField txtUsuarioNome;
    private javax.swing.JTextField txtUsuarioPesquisar;
    private javax.swing.JPasswordField txtUsuarioSenha;
    private javax.swing.JTextField txtUsuarioUsername;
    // End of variables declaration//GEN-END:variables

    public JButton getBotaoDashboardHome() {
        return botaoDashboardHome;
    }

    public JButton getBotaoDashboardSuites() {
        return botaoDashboardSuites;
    }
    
    public JButton getBotaoDashboardHospedes() {
        return botaoDashboardHospedes;
    }
    
    public JButton getBotaoDashboardReservas() {
        return botaoDashboardReservas;
    }
    
    public JButton getBotaoDashboardUsuarios() {
        return botaoDashboardUsuario;
    }
    
    public JButton getBotaoDashboardSair() {
        return botaoDashboardSair;
    }
    
    public JPanel getPanelHome() {
        return panelHome;
    }
    
    public JPanel getPanelBody() {
        return panelBody;
    }
    
    public JPanel getPanelSuite() {
        return panelSuite;
    }
    
    public JPanel getPanelHospede() {
        return panelHospede;
    }
    
    public JPanel getPanelReserva() {
        return panelReservas;
    }
    
    public JPanel getPanelUsuario() {
        return panelUsuarios;
    }
    
    public JTable getTabelaUsuarios(){
        return tabelaUsuario;
    }    
    
    public JLabel getLabelBemvindoUsuario() {
        return labelDashboardBemvindoUsuario;
    }

    public JLabel getLabelUsuarioLogadoId() {
        return labelUsuarioLogadoId;
    }
    
    public JButton getBotaoUsuarioAdicionar() {
        return botaoUsuarioAdicionar;
    }
    
    public JButton getBotaoUsuarioEditar() {
        return botaoUsuarioEditar;
    }
    
    public JButton getBotaoUsuarioApagar() {
        return botaoUsuarioApagar;
    }
    
    public JDialog getDialogUsuario() {
        return this.dialogUsuario;
    }
    
    public JComboBox getComboBoxUsuarioPerfil() {
        return comboBoxUsuarioPerfil;
    }
    
    public JTextField getTxtUsuarioId() {
        return txtUsuarioId;
    }
    
    public JTextField getTxtUsuarioNome() {
        return txtUsuarioNome;
    }
    
    public JTextField getTxtUsuarioSenha() {
        return txtUsuarioSenha;
    }
    
    public JTextField getTxtUsuarioUsername() {
        return txtUsuarioUsername;
    }
    
    public JRadioButton getRadioBotaoAtivo() {
        return radioBotaoUsuarioAtivo;
    }
    
    public JRadioButton getRadioBotaoInativo() {
        return radioBotaoUsuarioInativo;
    }
    
    public JLabel getLabelUsuarioMensagem() {
        return labelUsuarioMensagem;
    }
    
    public JTextField getTxtUsuarioPesquisar() {
        return txtUsuarioPesquisar;
    }
    
    public JButton getBotaoCategoriaSalvar() {
        return botaoCategoriaSalvar;
    }
    
    public JButton getBotaoCategoriaCancelar() {
        return botaoCategoriaCancelar;
    }
    
    public JButton getBotaoCategoriaApagar() {
        return botaoCategoriaApagar;
    }
    
    public JButton getBotaoCategoriaLimpar() {
        return botaoCategoriaLimpar;
    }
    
    public JTextField getTxtCategoriaId() {
        return txtCategoriaId;
    }
    
    public JTextField getTxtCategoriaNome() {
        return txtCategoriaNome;
    }
    
    public JTextArea getTxtCategoriaDescricao() {
        return txtCategoriaDescricao;
    }
    
    public JTable getTabelaCategoria() {
        return tabelaCategoria;
    }
    
    public JDialog getDialogSuite() {
        return dialogSuite;
    }
    
    public JButton getBotaoSuiteAdicionarCategoria() {
        return botaoSuiteAdicionarCategoria;
    }
    
    public JDialog getDialogCategoria() {
        return dialogCategoria;
    }
    
    public JButton getBotaoSuiteAdicionar() {
        return botaoSuiteAdicionar;
    }
    
    public JButton getBotaoSuiteEditar() {
        return botaoSuiteEditar;
    }
    
    public JButton getBotaoSuiteApagar() {
        return botaoSuiteApagar;
    }
    
    public JLabel getLabelCategoriaMensagem() {
        return labelCategoriaMensagem;
    }
    
    public JComboBox getComboBoxSuiteCategoria() {
        return comboBoxSuiteCategoria;
    }
    
    public JTextField getTxtSuiteId() {
        return txtSuiteId;
    }
    
    public JTextField getTxtSuiteNome() {
        return txtSuiteNome;
    }
    
    public JTextField getTxtSuitePreco() {
        return txtSuitePreco;
    }
    
    public JSpinner getTxtSuiteQuantidade() {
        return txtSuiteQuantidade;
    }
    
    public JTextArea getTxtSuiteDescricao() {
        return txtSuiteDescricao;
    }
 
    public JLabel getLabelSuiteMensagem() {
        return jLabel30;
    }
    
    public JTable getTabelaSuite() {
        return tabelaSuite;
    }
    
    public JTextField getTxtSuitePesquisar() {
        return txtSuitePesquisar;
    }
    
    public JDialog getDialogReserva() {
        return dialogReserva;
    }
    
    public JLabel getLabelReservaPrecoDaSuite() {
        return labelReservaPrecoDaSuite;
    }
    
    public JLabel getLabelReservaQuantidadeDaSuite() {
        return labelReservaQuantidadeDeSuite;
    }
    
    public JLabel getLabelReservaNomeDaSuite() {
        return labelReservaNomeDaSuite;
    }
    
    public JTextField getTxtReservaPesquisarSuite() {
        return txtReservaPesquisarSuite;
    }
    
    public JComboBox getComboBoxReservaPesquisarSuitePelaCategoria() {
        return comboBoxReservaPesquisarSuitePelaCategoria;
    }
    
    public JComboBox getComboBoxReservaSuite() {
        return comboBoxReservaSuite;
    }
    
    public JLabel getLabelReservaMensagem() {
        return labelReservaMensagem;
    }
    
    public JTable getTabelaReservaRegistro() {
        return tabelaReservaRegistro;
    }
    
    public JTextField getTxtReservaId() {
        return txtReservaId;
    }
    
    public JSpinner getTxtReservaQuantidade() {
        return txtReservaQuantidade;
    }
    
    public JTextField getTxtReservaValorPago() {
        return txtReservaValorPago;
    }
    
    public JTextField getTxtReservaDesconto() {
        return txtReservaDesconto;
    }
    
    public JLabel getLabelReservaTotalDaReserva() {
        return labelReservaTotalDaReserva;
    }
    
    public JLabel getLabelReservaValorPago() {
        return labelReservaValorPago;
    }
    
    public JLabel getLabelReservaTotalDoDesconto() {
        return labelReservaDesconto;
    }
    
    public JLabel getLabelReservaTroco() {
        return labelReservaTroco;
    }
    
    public JCheckBox getCheckBoxReservaDesconto() {
        return checkboxReservaDesconto;
    }
    
    public JLabel getLabelHospedeMensagem() {
        return labelHospedeMensagem;
    }
    
    public JTextField getTxtHospedeId() {
        return txtHospedeId;
    }
    
    public JTextField getTxtHospedeNome() {
        return txtHospedeNome;
    }
    
    public JTextField getTxtHospedeTelefone() {
        return txtHospedeTelefone;
    }
    
    public JTextField getTxtHospedeEmail() {
        return txtHospedeEmail;
    }
    
    public JDialog getDialogHospede() {
        return dialogHospede;
    }
    
    public JTextField getTxtReservaHospede() {
        return txtReservaHospede;
    }
    
    public JTable getTabelaReserva() {
        return tabelaReserva;
    }
    
    public JButton getBotaoReservaDetalhes() {
        return botaoReservaDetalhes;
    }
    
    public JLabel getLabelHomeSuite() {
        return labelHomeSuite;
    }
    
    public JLabel getLabelHomeHospede() {
        return labelHomeHospede;
    }
    
    public JLabel getLabelHomeReserva() {
        return labelHomeReserva;
    }
    
    public JTable getTabelaHospede() {
        return tabelaHospede;
    }
    
    
}
