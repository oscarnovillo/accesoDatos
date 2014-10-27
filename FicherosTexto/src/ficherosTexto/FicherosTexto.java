/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ficherosTexto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import bd.Archivo;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import negocio.Navegador;
import javax.swing.JComponent;
import javax.swing.JFileChooser;

/**
 *
 * @author profesor
 */
public class FicherosTexto extends javax.swing.JFrame {

    /**
     * Creates new form FicherosTexto
     */
    public FicherosTexto() {
        initComponents();
        jFileChooser.setVisible(false);
        setLocationRelativeTo(null);

        // restea datos
        jListDirectorios.setModel(new DefaultListModel());

        DefaultListModel model = (DefaultListModel) jListDirectorios.getModel();
        jListDirectorios.setSelectedIndex(0);
        Navegador n = new Navegador();
        Archivo archivo = n.crearArchivo(new File(".").getAbsolutePath());

// si no tengo crear archivo haria falta esto.
//        File f = new File ("/home/profesor/NetBeansProjects/JavaApplication1");
//        Archivo archivoTemp = new Archivo(f.getName(),true,"","");
        model.addElement(archivo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelElementos = new javax.swing.JPanel();
        jLabelNombreFichero = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListDirectorios = new javax.swing.JList();
        jButtonNavegar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaFichero = new javax.swing.JTextArea();
        jButtonEditar = new javax.swing.JButton();
        jButtonGuardar = new javax.swing.JButton();
        jButtonNuevo = new javax.swing.JButton();
        jFileChooser = new javax.swing.JFileChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelElementos.setPreferredSize(new java.awt.Dimension(571, 400));

        jListDirectorios.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListDirectorios.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListDirectorios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListDirectoriosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jListDirectorios);

        jButtonNavegar.setText("IR");
        jButtonNavegar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNavegarActionPerformed(evt);
            }
        });

        jTextAreaFichero.setColumns(20);
        jTextAreaFichero.setRows(5);
        jScrollPane2.setViewportView(jTextAreaFichero);

        jButtonEditar.setText("Cargar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        jButtonNuevo.setText("Nuevo");
        jButtonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelElementosLayout = new javax.swing.GroupLayout(jPanelElementos);
        jPanelElementos.setLayout(jPanelElementosLayout);
        jPanelElementosLayout.setHorizontalGroup(
            jPanelElementosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelElementosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelElementosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelElementosLayout.createSequentialGroup()
                        .addGroup(jPanelElementosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelElementosLayout.createSequentialGroup()
                                .addComponent(jButtonNavegar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonGuardar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanelElementosLayout.createSequentialGroup()
                        .addComponent(jButtonNuevo)
                        .addGroup(jPanelElementosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelElementosLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(400, Short.MAX_VALUE))
                            .addGroup(jPanelElementosLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabelNombreFichero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())))))
        );
        jPanelElementosLayout.setVerticalGroup(
            jPanelElementosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelElementosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelNombreFichero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelElementosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelElementosLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelElementosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonNavegar)
                            .addComponent(jButtonGuardar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelElementosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonEditar)
                            .addComponent(jButtonNuevo)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(714, 714, 714))
        );

        jFileChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelElementos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jFileChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelElementos, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(137, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(219, 219, 219)
                    .addComponent(jFileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void navegar() {
        Navegador n = new Navegador();

        Archivo raiz = ((Archivo) jListDirectorios.getSelectedValue());
        if (raiz != null) {
            ArrayList<Archivo> archivos = n.directorios(raiz.getPath());
            if (raiz.isIsDirectorio()) {
                //    labelActualDir.setText(raiz.getPath());
                DefaultListModel model = (DefaultListModel) jListDirectorios.getModel();
                model.clear();

                Archivo padre = n.crearArchivo(raiz.getParentPath());
                padre.setNombre("..");
                model.addElement(padre);

                if (!archivos.isEmpty()) {
                    for (Archivo a : archivos) {
                        model.addElement(a);
                    }
                } else {
                }

            } else {

                JOptionPane.showMessageDialog(this, "Selecciona un directorio");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona un directorio");
        }
    }

    private void jFileChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooserActionPerformed
        // TODO add your handling code here:
        if (evt.getActionCommand().equals(JFileChooser.APPROVE_SELECTION)) {
            jLabelNombreFichero.setText(jFileChooser.getSelectedFile().getPath());
        }
        panelVisible(jPanelElementos);
    }//GEN-LAST:event_jFileChooserActionPerformed

    private void jButtonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNuevoActionPerformed
        // TODO add your handling code here:
        //        String path=null;
        //        path = JOptionPane.showInputDialog("Introduce el nombre del fichero nuevo");
        //        jLabelNombreFichero.setText(path);
        panelVisible(jFileChooser);

    }//GEN-LAST:event_jButtonNuevoActionPerformed

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        // TODO add your handling code here:
        String path = jLabelNombreFichero.getText();
Navegador n = new  Navegador();
        if (path != null) {
            try {
                n.escribirFicheroTexto(path, jTextAreaFichero.getText());
                JOptionPane.showMessageDialog(this, "Fichero Guardado");
            } catch (IOException ex) {
                Logger.getLogger(FicherosTexto.class.getName()).log(Level.SEVERE, null, ex);
            } 
        } else {
            JOptionPane.showMessageDialog(this, "Nombre de fichero no encontrado");
        }
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        // TODO add your handling code here:
        Navegador n = new Navegador();
        Archivo fichero = ((Archivo) jListDirectorios.getSelectedValue());
        if (!fichero.isIsDirectorio()) {
            FileReader reader = null;
            try {
                jLabelNombreFichero.setText(fichero.getPath());
                jTextAreaFichero.setText("");
                jTextAreaFichero.append(n.leerFicheroTexto(fichero.getPath()));

            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Fichero no encontrado");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Se ha producido un error al leer el fichero");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona un fichero");
        }

    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonNavegarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNavegarActionPerformed
        // TODO add your handling code here:
        navegar();
    }//GEN-LAST:event_jButtonNavegarActionPerformed

    private void jListDirectoriosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListDirectoriosMouseClicked
        // TODO add your handling code here:

        if (evt.getClickCount() == 2) {
            navegar();
        }
    }//GEN-LAST:event_jListDirectoriosMouseClicked

    private void panelVisible(JComponent panel) {
        jFileChooser.setVisible(false);
        jPanelElementos.setVisible(false);

        panel.setVisible(true);

    }

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
            java.util.logging.Logger.getLogger(FicherosTexto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FicherosTexto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FicherosTexto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FicherosTexto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FicherosTexto().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonNavegar;
    private javax.swing.JButton jButtonNuevo;
    private javax.swing.JFileChooser jFileChooser;
    private javax.swing.JLabel jLabelNombreFichero;
    private javax.swing.JList jListDirectorios;
    private javax.swing.JPanel jPanelElementos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextAreaFichero;
    // End of variables declaration//GEN-END:variables
}
