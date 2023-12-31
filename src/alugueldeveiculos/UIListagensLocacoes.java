/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package alugueldeveiculos;

import control.Controlador;
import java.time.LocalDate;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author sabri
 */
public class UIListagensLocacoes extends javax.swing.JDialog {

    /**
     * Creates new form UIListagemLocacao
     */
    public UIListagensLocacoes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaListagens = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        buttonListar = new javax.swing.JButton();
        radioTodasLocacoes = new javax.swing.JRadioButton();
        radioLucroMes = new javax.swing.JRadioButton();
        radioFinalizadas = new javax.swing.JRadioButton();
        radioNaoFinalizadas = new javax.swing.JRadioButton();
        radioLocacoesEmAtraso = new javax.swing.JRadioButton();
        comboMes = new javax.swing.JComboBox<>();
        comboLocacoes = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        textAreaListagens.setEditable(false);
        textAreaListagens.setColumns(20);
        textAreaListagens.setRows(5);
        jScrollPane1.setViewportView(textAreaListagens);

        jLabel1.setFont(new java.awt.Font("Source Sans Pro Light", 1, 24)); // NOI18N
        jLabel1.setText("Listagens Locações");

        jLabel2.setFont(new java.awt.Font("Source Sans Pro", 0, 14)); // NOI18N
        jLabel2.setText("Selecione qual relatório você deseja listar:");

        buttonListar.setText("LISTAR");
        buttonListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonListarActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioTodasLocacoes);
        radioTodasLocacoes.setText("Todas as Locações Realizadas");
        radioTodasLocacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioTodasLocacoesActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioLucroMes);
        radioLucroMes.setText("Locações e Lucro do mês");
        radioLucroMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioLucroMesActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioFinalizadas);
        radioFinalizadas.setText("Locações Finalizadas");
        radioFinalizadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioFinalizadasActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioNaoFinalizadas);
        radioNaoFinalizadas.setText("Locações não Finalizadas");
        radioNaoFinalizadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioNaoFinalizadasActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioLocacoesEmAtraso);
        radioLocacoesEmAtraso.setText("Locações em Atraso");
        radioLocacoesEmAtraso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioLocacoesEmAtrasoActionPerformed(evt);
            }
        });

        comboMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));
        comboMes.setEnabled(false);

        comboLocacoes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Geral", "Nacional", "Importado" }));
        comboLocacoes.setEnabled(false);
        comboLocacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboLocacoesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(radioTodasLocacoes)
                                    .addComponent(jLabel2)
                                    .addComponent(buttonListar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(radioLucroMes)
                                            .addComponent(radioFinalizadas))
                                        .addGap(18, 18, 18)
                                        .addComponent(comboMes, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(radioLocacoesEmAtraso, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(radioNaoFinalizadas, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(comboLocacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(21, 21, 21))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(radioTodasLocacoes)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(radioLucroMes)
                            .addComponent(comboMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(radioFinalizadas)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(radioNaoFinalizadas)
                            .addComponent(comboLocacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(radioLocacoesEmAtraso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                        .addComponent(buttonListar)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonListarActionPerformed
        // TODO add your handling code here:
        
        JFrame jFrame = new JFrame();
        Controlador control = new Controlador();
        
        if(radioTodasLocacoes.isSelected()){
            textAreaListagens.setText(control.ListarTodasLocacoes());
        } else
            if(radioLucroMes.isSelected()){
                String relatorio ="";
                int mes = comboMes.getSelectedIndex()+1;
                relatorio = control.ListarTodasLocacoesMesEspecifico(mes);
                relatorio += "\nLucro total do mês: " + String.valueOf(control.LucroTotalMesEspecifico(mes));
                textAreaListagens.setText(relatorio);
            } else
                if(radioFinalizadas.isSelected()){
                    textAreaListagens.setText(control.ListarTodasLocacoesFinalizadas());
                } else
                    if(radioNaoFinalizadas.isSelected()){
                        int tipo = comboLocacoes.getSelectedIndex();
                        switch(tipo){
                            case 0:
                                textAreaListagens.setText(control.ListarTodasLocacoesNaoFinalizadas());
                                break;
                                
                            case 1:
                                textAreaListagens.setText(control.ListarTodasLocacoesNaoFinalizadasVeiculosNacionais());
                                break;
                            
                            case 2:
                                textAreaListagens.setText(control.ListarTodasLocacoesNaoFinalizadasVeiculosImportados());
                                break;
                        }
                    } else 
                        if(radioLocacoesEmAtraso.isSelected()){
                            textAreaListagens.setText(control.ListarTodasLocacoesEmAtaso());
                        } else {
                            JOptionPane.showMessageDialog(jFrame, "Selecione algum opção de listagem!");
                        }
    }//GEN-LAST:event_buttonListarActionPerformed

    private void radioTodasLocacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioTodasLocacoesActionPerformed
        // TODO add your handling code here:
        textAreaListagens.setText("");
    }//GEN-LAST:event_radioTodasLocacoesActionPerformed

    private void radioLucroMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioLucroMesActionPerformed
        // TODO add your handling code here:
        comboMes.setEnabled(true);
        textAreaListagens.setText("");
    }//GEN-LAST:event_radioLucroMesActionPerformed

    private void radioLocacoesEmAtrasoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioLocacoesEmAtrasoActionPerformed
        // TODO add your handling code here:
        textAreaListagens.setText("");
    }//GEN-LAST:event_radioLocacoesEmAtrasoActionPerformed

    private void comboLocacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboLocacoesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboLocacoesActionPerformed

    private void radioNaoFinalizadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioNaoFinalizadasActionPerformed
        // TODO add your handling code here:
        comboLocacoes.setEnabled(true);
        textAreaListagens.setText("");
    }//GEN-LAST:event_radioNaoFinalizadasActionPerformed

    private void radioFinalizadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioFinalizadasActionPerformed
        // TODO add your handling code here:
        textAreaListagens.setText("");
    }//GEN-LAST:event_radioFinalizadasActionPerformed

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
            java.util.logging.Logger.getLogger(UIListagensLocacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UIListagensLocacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UIListagensLocacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UIListagensLocacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UIListagensLocacoes dialog = new UIListagensLocacoes(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                   
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton buttonListar;
    private javax.swing.JComboBox<String> comboLocacoes;
    private javax.swing.JComboBox<String> comboMes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JRadioButton radioFinalizadas;
    private javax.swing.JRadioButton radioLocacoesEmAtraso;
    private javax.swing.JRadioButton radioLucroMes;
    private javax.swing.JRadioButton radioNaoFinalizadas;
    private javax.swing.JRadioButton radioTodasLocacoes;
    private javax.swing.JTextArea textAreaListagens;
    // End of variables declaration//GEN-END:variables
}
