/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

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
        this.setLocationRelativeTo(null);
        
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
        jScrollPane2 = new javax.swing.JScrollPane();
        tblFinal = new javax.swing.JTable();

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

        tblFinal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblFinal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLoadFlex)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCargarSQL)
                        .addGap(24, 24, 24))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 878, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLoadFlex)
                    .addComponent(btnCargarSQL))
                .addGap(48, 48, 48)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
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
        }
    }//GEN-LAST:event_btnLoadFlexActionPerformed

    private void btnCargarSQLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarSQLActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Lineas y Columnas");
        model.addColumn("Palabra");
        model.addColumn("Token");
        tblFinal.setModel(model);
        
        File archivo;
        JFileChooser dialogo = new JFileChooser();
        String rutaArchivo = "";
        FileNameExtensionFilter filtro=new FileNameExtensionFilter("Archivo SQL","sql");
        dialogo.setFileFilter(filtro);
        int valor = dialogo.showOpenDialog(this);
        if (valor == JFileChooser.APPROVE_OPTION) {
            //Obtener la direccion del documento
            archivo = dialogo.getSelectedFile();
            rutaArchivo = archivo.getPath();
            String result = "";
            
            try {
                //Comenzar con la lectura del documento
                Reader lector = new BufferedReader(new FileReader(archivo));
                Lexer lexer = new Lexer(lector);
                while (true) {
                    Tokens tokens = lexer.yylex();
                    if (tokens == null) {
                        break;
                    }
                    
                    switch (tokens) {
                        case ERROR:
                            result += "Linea " + lexer.lin + " Columnas:"+lexer.col +"-"+(lexer.col+lexer.lexeme.length()) + ".\t" +"ERROR\t"+ lexer.lexeme + " caracter no valido" +"\n";
                            break;
                        case ErrorMultilinea:
                            result += "Linea " + lexer.lin + "\tERROR\tNo se encuentra apertura/cerradura de comentario multilinea\n";
                            break;
                        case IdentificadorOver:
                            result += "Linea " + lexer.lin + " Columnas:"+lexer.col +"-"+(lexer.col+lexer.lexeme.length()) + ".\t" + lexer.lexeme.substring(0, 31) + ".\t"+ "ERROR. MAX LONGITUD. Nuevo token: " + "\n";
                            break;
                        case ErrorCadena:
                            result += "Linea " + lexer.lin + " Columnas:"+lexer.col +"-"+(lexer.col+lexer.lexeme.length()) + ".\t" + "ERROR \t" + "La siguiente cadena contiene un caracter no valido" + lexer.lexeme + "\n";
                            break;
//                        case ErrorApertura:
//                            result += "Linea " + lexer.lin + ".\t" + "ERROR\t" + "Falta terminar la cadena en esta línea" + lexer.lexeme + "\n";
//                            break;
                        default:
                            result += "Linea " + lexer.lin + " Columnas:"+lexer.col +"-"+(lexer.col+lexer.lexeme.length()) + ".\t" + lexer.lexeme + "\t" + "Es " + tokens.toString().toUpperCase() + "\n";
                            break;
                    }
                }
                //File archivoOut = new File
            } catch (FileNotFoundException ex) {
                Logger.getLogger(minisql.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(minisql.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String rutaSalida = rutaArchivo;
            rutaSalida = rutaSalida.substring(0, (rutaSalida.length() - 4));
            rutaSalida += ".out";

            File n = new File(rutaSalida);
            try {
                if(!n.exists()){
                    BufferedWriter bw = new BufferedWriter(new FileWriter(n));
                    bw.close();
                }
                
                //Creacion del archivo .OUT
                FileWriter TextOut = new FileWriter(n, false);
                TextOut.write(result + "\r\n");
                TextOut.close();
                
                //Añadir la data al table
                String[] lineas = result.split("\\n");
                String[] data;
                
                for (int i = 0; i < lineas.length; i++) {
                    data = lineas[i].split("\\t");
                    model.addRow(data);
                }
            } catch (IOException ex) {
                Logger.getLogger(minisql.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblFinal;
    // End of variables declaration//GEN-END:variables
}
