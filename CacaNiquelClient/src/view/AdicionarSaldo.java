package view;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import model.Cliente;
import service.CacaNiquelService;
import static service.CacaNiquelService.HOST;
import static service.CacaNiquelService.NOME;
import static service.CacaNiquelService.PORTA;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.text.DecimalFormat;


public class AdicionarSaldo extends javax.swing.JFrame {

    private Cliente usuario;
    private double saldoAtual;
    private final DecimalFormat formatarSaldoAtual = new DecimalFormat("#,##0.00");
    
    public AdicionarSaldo() {
        initComponents();
        this.setResizable(false);
        this.setTitle("Inserir saldo");
        this.setVisible(true);
        this.setLocationRelativeTo(null); 
        
        
    }
    
    public AdicionarSaldo(Cliente c) {
        this();
        
        usuario = c;
        saldoAtual = usuario.getSaldo();
        lblSaldo.setText(formatarSaldoAtual.format(saldoAtual));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblSaldoAtual = new javax.swing.JLabel();
        lblInserirValorSaldo = new javax.swing.JLabel();
        btnInserir10 = new javax.swing.JButton();
        btnInserir50 = new javax.swing.JButton();
        btnInserir100 = new javax.swing.JButton();
        txtInserirSaldo = new javax.swing.JTextField();
        bntSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblSaldo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));

        lblSaldoAtual.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSaldoAtual.setForeground(new java.awt.Color(255, 255, 255));
        lblSaldoAtual.setText("Saldo atual: R$");

        lblInserirValorSaldo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblInserirValorSaldo.setForeground(new java.awt.Color(255, 255, 255));
        lblInserirValorSaldo.setText("Inserir valor de saldo (valor mínimo: 10)");

        btnInserir10.setText("10");
        btnInserir10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserir10ActionPerformed(evt);
            }
        });

        btnInserir50.setText("50");
        btnInserir50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserir50ActionPerformed(evt);
            }
        });

        btnInserir100.setText("100");
        btnInserir100.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserir100ActionPerformed(evt);
            }
        });

        txtInserirSaldo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtInserirSaldoKeyPressed(evt);
            }
        });

        bntSalvar.setText("Salvar");
        bntSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblSaldo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSaldo.setForeground(new java.awt.Color(255, 255, 255));
        lblSaldo.setText("Saldo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 57, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtInserirSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnInserir50, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(btnInserir100, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblInserirValorSaldo)
                        .addGap(25, 25, 25)))
                .addGap(41, 41, 41))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(btnInserir10, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bntSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(lblSaldoAtual)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSaldo)))
                .addContainerGap(139, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSaldoAtual)
                    .addComponent(lblSaldo))
                .addGap(78, 78, 78)
                .addComponent(lblInserirValorSaldo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInserir10)
                    .addComponent(btnInserir50)
                    .addComponent(btnInserir100))
                .addGap(18, 18, 18)
                .addComponent(txtInserirSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(bntSalvar)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInserir10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserir10ActionPerformed
        saldoAtual += 10;
        lblSaldo.setText(formatarSaldoAtual.format(saldoAtual));
    }//GEN-LAST:event_btnInserir10ActionPerformed

    private void btnInserir50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserir50ActionPerformed
        saldoAtual += 50;
        lblSaldo.setText(formatarSaldoAtual.format(saldoAtual));
    }//GEN-LAST:event_btnInserir50ActionPerformed

    private void btnInserir100ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserir100ActionPerformed
        saldoAtual += 100;
        lblSaldo.setText(formatarSaldoAtual.format(saldoAtual));
    }//GEN-LAST:event_btnInserir100ActionPerformed

    private void txtInserirSaldoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtInserirSaldoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if(txtInserirSaldo.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "O campo de "
                        + "inserir saldo está vazio!", "Adicionar saldo", 
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                if(Double.parseDouble(txtInserirSaldo.getText()) < 10) {
                    JOptionPane.showMessageDialog(null,
                            "O valor inserido é menor que 10", "Adicionar saldo",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                } else {
                    saldoAtual += Double.parseDouble(txtInserirSaldo.getText());
                    txtInserirSaldo.setText("");
                    lblSaldo.setText(formatarSaldoAtual.format(saldoAtual));
                }
            }
        }
    }//GEN-LAST:event_txtInserirSaldoKeyPressed

    private void bntSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntSalvarActionPerformed
        try {
            Registry srv = LocateRegistry.getRegistry(HOST, PORTA);
            CacaNiquelService op = (CacaNiquelService)srv.lookup(NOME);

            usuario.setSaldo(saldoAtual);
            
            op.atualizarInformacoesUsuario(usuario);

            MenuCliente menu = new MenuCliente(usuario);
            menu.setVisible(true);
            this.dispose();
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_bntSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        MenuCliente menu  = new MenuCliente(usuario);
        this.dispose();
        
        menu.setVisible(true);
        
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdicionarSaldo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdicionarSaldo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdicionarSaldo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdicionarSaldo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdicionarSaldo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntSalvar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnInserir10;
    private javax.swing.JButton btnInserir100;
    private javax.swing.JButton btnInserir50;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblInserirValorSaldo;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JLabel lblSaldoAtual;
    private javax.swing.JTextField txtInserirSaldo;
    // End of variables declaration//GEN-END:variables
}