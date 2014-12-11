/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package basedatos;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.filter.Filters;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;
import storage.SaveXML;
import util.Constantes;

/**
 *
 * @author profesor
 */
public class FramePersonas extends javax.swing.JFrame {

    /**
     * Creates new form FramePersonas
     */
    private String rutaBD = null;
    
    Document document = null;
    Element compras = null;

    boolean hayCosasQueGuardar = false;

    //<editor-fold defaultstate="collapsed" desc="modelo de la tabla persona">
    public DefaultTableModel crearModeloPersonas() {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int col) {
                return col == Constantes.COLUMN_PERSONA_NOMBRE;
            }
        };
        model.addColumn("ID");
        model.addColumn("NOMBRE");
        model.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {
                    Integer id = Integer.parseInt(jTablePersonas.getValueAt(e.getFirstRow(), Constantes.COLUMN_PERSONA_ID).toString());
                    changePersonaJDom(id, 
                            jTablePersonas.getValueAt(e.getFirstRow(), Constantes.COLUMN_PERSONA_NOMBRE).toString());
                }
            }
        });

        return model;
    }

    
    private void deJDomATablaPersonas(Document document) {
        List<Element> lista = document.getRootElement().getChildren("persona");
        for (Element element : lista) {
            ((DefaultTableModel) jTablePersonas.getModel()).addRow(new Object[]{element.getAttributeValue("id"), element.getChildText("nombre")});
        }
    }

    private void deJDomATablaCompras(Element compras) {
        List<Element> lista = compras.getChildren("compra");
        for (Element element : lista) {
            ((DefaultTableModel) jTablePersonas.getModel()).addRow(new Object[]{element.getAttributeValue("id"), element.getChildText("nombre")});
        }
    }

    public Element encuentraPersonaConId(Integer id) {
        Element encontrado = null;

        XPathFactory xFactory = XPathFactory.instance();
        XPathExpression<Element> expr = xFactory.compile("/personas/persona[@id = " + id + "]", Filters.element());
        encontrado = expr.evaluateFirst(document);

        return encontrado;
    }

    public Element encuentraCompraConIndice(int indice) {
        Element encontrado = null;
        encontrado = compras.getChildren().get(indice);
        return encontrado;
    }

    public void addPersonaJDom(Integer id, String nombre) {
        Element persona = new Element("persona");
        persona.setAttribute(new Attribute("id", id + ""));
        persona.addContent(new Element("nombre").setText(nombre));
        persona.addContent(new Element("compras"));
        document.getRootElement().addContent(persona);
    }

    public void changePersonaJDom(Integer id, String nombre) {
        Element persona = encuentraPersonaConId(id);
        persona.getChild("nombre").setText(nombre);
    }

    public void borrarPersonajDom(Integer id) {
        XPathFactory xFactory = XPathFactory.instance();
        XPathExpression<Element> expr = xFactory.compile("/personas/persona[@id = " + id + "]", Filters.element());
        Element resultado = expr.evaluateFirst(document);
        resultado.detach();
    }

    public void borrarComprasjDom(int indice) {
        Element compra = encuentraCompraConIndice(indice);
        compra.detach();
    }

    public void changeComprajDom(int indice, String cantidad, String nombre) {
        Element compra = encuentraCompraConIndice(indice);
        compra.getChild("cantidad").setText(cantidad + "");
        compra.getChild("concepto").setText(nombre);
        compras.addContent(compra);
    }

    public void addComprajDom(int cantidad, String nombre) {
        Element compra = new Element("compra");
        compra.addContent(new Element("cantidad").setText(cantidad + ""));
        compra.addContent(new Element("concepto").setText(nombre));
        compras.addContent(compra);
    }

    public void addCompraaTabla(int cantidad, String nombre) {
        ((DefaultTableModel) jTableCompras.getModel()).addRow(new Object[]{cantidad, nombre});
    }

    public void addPersonaaTabla(int id, String nombre) {
        DefaultTableModel model = ((DefaultTableModel) jTablePersonas.getModel());
        model.addRow(new Object[]{id, nombre});
    }

    //</editor-fold>
    public DefaultTableModel crearModeloCompras() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("CANTIDAD");
        model.addColumn("CONCEPTO");
        model.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {
                    changeComprajDom(e.getFirstRow(),
                            jTableCompras.getValueAt(e.getFirstRow(), Constantes.COLUMN_COMPRA_CANTIDAD).toString(),
                            jTableCompras.getValueAt(e.getFirstRow(), Constantes.COLUMN_COMPRA_CONCEPTO).toString());
                }

            }
        });

        return model;
    }

    public void vaciarTabla(JTable tabla) {
        for (int i = 0; i < tabla.getRowCount(); i++) {
            ((DefaultTableModel) tabla.getModel()).removeRow(i);
        }
    }

    public FramePersonas() {
        initComponents();
        leerProperties();
        crearModeloVacio();
        this.setLocationRelativeTo(null);
        jTablePersonas.setModel(crearModeloPersonas());
        jTableCompras.setModel(crearModeloCompras());
    }

    //<editor-fold defaultstate="collapsed" desc="inicializacion">
   private void crearModeloVacio()
   {
       document =  new Document(new Element("personas"));
   }
    
    private void leerProperties() {
        FileReader file = null;
        Properties p = null;
        try {
            p = new Properties();
            file = new FileReader(Constantes.FICHERO_PROPERTIES);
            p.load(file);
            rutaBD = p.getProperty(Constantes.RUTABD_PROPERTY);
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFound");
        } catch (IOException e) {
            System.out.println("IOEXCeption");
        } finally {
            if (file != null) {
                try {
                    file.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
            }
        }
    }

    //</editor-fold>
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogCompras = new javax.swing.JDialog();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCompras = new javax.swing.JTable();
        jButtonCrearCompras = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButtonBorrarCompras = new javax.swing.JButton();
        jButonVolverCompras = new javax.swing.JButton();
        jTextCantidad = new javax.swing.JTextField();
        jTextConcepto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePersonas = new javax.swing.JTable();
        jTextId = new javax.swing.JTextField();
        jTextNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonCrearPersona = new javax.swing.JButton();
        jButtonComprasDePersona = new javax.swing.JButton();
        jButtonBorrarPersona = new javax.swing.JButton();
        jButtonCargarPersona = new javax.swing.JButton();
        jButtonGuardarPersona = new javax.swing.JButton();

        jDialogCompras.setMinimumSize(new java.awt.Dimension(400, 400));
        jDialogCompras.setModal(true);

        jTableCompras.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTableCompras);

        jButtonCrearCompras.setText("Crear");
        jButtonCrearCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrearComprasActionPerformed(evt);
            }
        });

        jLabel3.setText("Cliente");

        jButtonBorrarCompras.setText("Borrar");
        jButtonBorrarCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarComprasActionPerformed(evt);
            }
        });

        jButonVolverCompras.setText("Volver");
        jButonVolverCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarComprasActionPerformed(evt);
            }
        });

        jLabel4.setText("Cantidad: ");

        jLabel5.setText("Concepto:");

        javax.swing.GroupLayout jDialogComprasLayout = new javax.swing.GroupLayout(jDialogCompras.getContentPane());
        jDialogCompras.getContentPane().setLayout(jDialogComprasLayout);
        jDialogComprasLayout.setHorizontalGroup(
            jDialogComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogComprasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialogComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogComprasLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextCantidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextConcepto, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogComprasLayout.createSequentialGroup()
                        .addComponent(jButtonBorrarCompras, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCrearCompras, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButonVolverCompras, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                        .addGap(javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialogComprasLayout.setVerticalGroup(
            jDialogComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogComprasLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialogComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialogComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonBorrarCompras)
                        .addComponent(jButtonCrearCompras))
                    .addComponent(jButonVolverCompras))
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTablePersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTablePersonas);

        jLabel1.setText("Id");

        jLabel2.setText("Nombre");

        jButtonCrearPersona.setText("Crear");
        jButtonCrearPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrearPersonaActionPerformed(evt);
            }
        });

        jButtonComprasDePersona.setLabel("Compras");
        jButtonComprasDePersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonComprasActionPerformed(evt);
            }
        });

        jButtonBorrarPersona.setText("Borrar");
        jButtonBorrarPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarPersonaActionPerformed(evt);
            }
        });

        jButtonCargarPersona.setText("Cargar");
        jButtonCargarPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCargarPersonaActionPerformed(evt);
            }
        });

        jButtonGuardarPersona.setText("Guardar");
        jButtonGuardarPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarPersonaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextId, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonCrearPersona, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonComprasDePersona, javax.swing.GroupLayout.PREFERRED_SIZE, 91, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonBorrarPersona, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonGuardarPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 81, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCargarPersona, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                        .addGap(6, 6, 6)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCrearPersona)
                    .addComponent(jButtonComprasDePersona)
                    .addComponent(jButtonBorrarPersona)
                    .addComponent(jButtonGuardarPersona)
                    .addComponent(jButtonCargarPersona))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

//<editor-fold defaultstate="collapsed" desc="eventos botones persona">
    private void jButtonCrearPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrearPersonaActionPerformed
        if (jTextId.getText().equals("") || jTextNombre.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "No has introducido datos para crear la persona");
        } else {

            try {
                int enteroTextId = Integer.parseInt(jTextId.getText());
                if (encuentraPersonaConId(enteroTextId) == null) {
                    addPersonaJDom(Integer.parseInt(jTextId.getText()), jTextNombre.getText());
                    addPersonaaTabla(Integer.parseInt(jTextId.getText()), jTextNombre.getText());
                    JOptionPane.showMessageDialog(this, "Creado");
                } else {
                    JOptionPane.showMessageDialog(this, "Ese ID ya existe");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "ID no valido");
            }
        }

    }//GEN-LAST:event_jButtonCrearPersonaActionPerformed

    private void jButtonGuardarPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarPersonaActionPerformed

        SaveXML save = new SaveXML();
        save.saveToXML(document, Constantes.NOMBREFICHERO_PROPERTY);
        JOptionPane.showMessageDialog(this, "Guardado");
    }//GEN-LAST:event_jButtonGuardarPersonaActionPerformed
    private void jButtonCargarPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCargarPersonaActionPerformed

        try {
            SaveXML save = new SaveXML();
            document = save.personasFromXML(Constantes.NOMBREFICHERO_PROPERTY);
            if (document != null){
                deJDomATablaPersonas(document);
                JOptionPane.showMessageDialog(this, "Cargado");
            }
            else
            {
                JOptionPane.showMessageDialog(this, "No se ha podido cargar el fichero");
            }
        } catch (Exception e) {
        }

    }//GEN-LAST:event_jButtonCargarPersonaActionPerformed

    private void jButtonComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonComprasActionPerformed
        try {
            int fila = jTablePersonas.getSelectedRow();
            if (fila >= 0) {
                Element persona = encuentraPersonaConId(idPersonaSeleccionada());
                jDialogCompras.setTitle(persona.getChild("nombre").getText());
                hayCosasQueGuardar = false;

                jLabel3.setText("Compras de: " + persona.getChild("nombre").getText());

                compras = persona.getChild("compras");
                deJDomATablaCompras(compras);
                jDialogCompras.setLocationRelativeTo(null);
                jDialogCompras.setVisible(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Selecciona una persona");
        }
    }//GEN-LAST:event_jButtonComprasActionPerformed
    private void jButtonBorrarPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarPersonaActionPerformed
        DefaultTableModel model = ((DefaultTableModel) jTablePersonas.getModel());
        try {
            if (jTablePersonas.getSelectedRow() >= 0) {
                borrarPersonajDom(idPersonaSeleccionada());
                model.removeRow(jTablePersonas.getSelectedRow());
                JOptionPane.showMessageDialog(this, "Borrado");
            } else {
                JOptionPane.showMessageDialog(this, "Selecciona una persona");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al borrar persona");
        }
    }//GEN-LAST:event_jButtonBorrarPersonaActionPerformed
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="eventos botones compras">  
    private void jButtonCancelarComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarComprasActionPerformed
         jDialogCompras.setVisible(false);
    }//GEN-LAST:event_jButtonCancelarComprasActionPerformed

    private void jButtonBorrarComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarComprasActionPerformed
        DefaultTableModel model = ((DefaultTableModel) jTableCompras.getModel());
        if (jTableCompras.getSelectedRow() >= 0) {
            borrarComprasjDom(jTableCompras.getSelectedRow());
            model.removeRow(jTableCompras.getSelectedRow());
            JOptionPane.showMessageDialog(jDialogCompras, "Borrado");
            hayCosasQueGuardar = true;
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona una compra");
        }
    }//GEN-LAST:event_jButtonBorrarComprasActionPerformed

    private void jButtonCrearComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrearComprasActionPerformed
        if (jTextCantidad.getText().equals("") || jTextConcepto.getText().equals("")) {
            JOptionPane.showMessageDialog(jDialogCompras, "No has introducido datos para crear la compra");
        } else {

            try {
                int enteroTextCantidad = Integer.parseInt(jTextCantidad.getText());
                addComprajDom(enteroTextCantidad, jTextConcepto.getText());
                addCompraaTabla(enteroTextCantidad, jTextConcepto.getText());
                JOptionPane.showMessageDialog(jDialogCompras, "Creado");
            } catch (NumberFormatException numberFormatException) {
                JOptionPane.showMessageDialog(jDialogCompras, "Cantidad no valida");
            }

        }
    }//GEN-LAST:event_jButtonCrearComprasActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    public Integer idPersonaSeleccionada() {
        int fila = jTablePersonas.getSelectedRow();
        Integer id = null;
        if (fila >= 0) {
            id = Integer.parseInt(jTablePersonas.getModel().getValueAt(fila, Constantes.COLUMN_PERSONA_ID).toString());
        }
        return id;
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
            java.util.logging.Logger.getLogger(FramePersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FramePersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FramePersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramePersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FramePersonas().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButonVolverCompras;
    private javax.swing.JButton jButtonBorrarCompras;
    private javax.swing.JButton jButtonBorrarPersona;
    private javax.swing.JButton jButtonCargarPersona;
    private javax.swing.JButton jButtonComprasDePersona;
    private javax.swing.JButton jButtonCrearCompras;
    private javax.swing.JButton jButtonCrearPersona;
    private javax.swing.JButton jButtonGuardarPersona;
    private javax.swing.JDialog jDialogCompras;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableCompras;
    private javax.swing.JTable jTablePersonas;
    private javax.swing.JTextField jTextCantidad;
    private javax.swing.JTextField jTextConcepto;
    private javax.swing.JTextField jTextId;
    private javax.swing.JTextField jTextNombre;
    // End of variables declaration//GEN-END:variables
}
