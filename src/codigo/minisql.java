/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author lam_m
 */
public class minisql extends javax.swing.JFrame {

    /**
     * Creates new form minisql
     */
    public minisql() {
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

        btnLoadFlex = new javax.swing.JButton();
        btnCargarSQL = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtRespuesta = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnLoadFlex.setText("Cargar Jflex");
        btnLoadFlex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadFlexActionPerformed(evt);
            }
        });

        btnCargarSQL.setText("Cargar SQL");
        btnCargarSQL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarSQLActionPerformed(evt);
            }
        });

        txtRespuesta.setColumns(20);
        txtRespuesta.setRows(5);
        jScrollPane1.setViewportView(txtRespuesta);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLoadFlex)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 305, Short.MAX_VALUE)
                        .addComponent(btnCargarSQL)
                        .addGap(24, 24, 24))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLoadFlex)
                    .addComponent(btnCargarSQL))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoadFlexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadFlexActionPerformed
        // TODO add your handling code here:
        JFileChooser dialogo = new JFileChooser();
        FileNameExtensionFilter filtro=new FileNameExtensionFilter("Archivo Flex","flex");
        dialogo.setFileFilter(filtro);
        int valor = dialogo.showOpenDialog(this);
        if (valor == JFileChooser.APPROVE_OPTION) {
            File archivo = dialogo.getSelectedFile();
            JFlex.Main.generate(archivo);
            txtRespuesta.setText(archivo.toString());
        }
    }//GEN-LAST:event_btnLoadFlexActionPerformed

    private void btnCargarSQLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarSQLActionPerformed
        // TODO add your handling code here:
        try
        {
            
        }catch(Exception e){}
        
    }//GEN-LAST:event_btnCargarSQLActionPerformed

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
            java.util.logging.Logger.getLogger(minisql.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(minisql.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(minisql.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(minisql.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new minisql().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargarSQL;
    private javax.swing.JButton btnLoadFlex;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtRespuesta;
    // End of variables declaration//GEN-END:variables
}
