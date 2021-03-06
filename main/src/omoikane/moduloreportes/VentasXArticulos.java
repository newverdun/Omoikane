/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ventasXlineas.java
 *
 * Created on 12/07/2010, 04:53:23 PM
 */

package omoikane.moduloreportes;


import javax.swing.*;
import java.text.*;
/**
 *
 * @author Phesus-Lab
 */
public class VentasXArticulos extends javax.swing.JPanel {

        
    /** Creates new form ventasXlineas */
    public VentasXArticulos(){
        initComponents();
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dateDesde = new org.jdesktop.swingx.JXDatePicker();
        dateHasta = new org.jdesktop.swingx.JXDatePicker();
        panel = new javax.swing.JPanel();
        barra = new javax.swing.JProgressBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaArticulos = new javax.swing.JList();
        btnGenerar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        codigoTxt = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(50, 50));
        setPreferredSize(new java.awt.Dimension(600, 400));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ventas por artículos");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setText("Desde :");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setText("Hasta :");

        dateDesde.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        dateHasta.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        dateHasta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateHastaActionPerformed(evt);
            }
        });

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panel.setMinimumSize(new java.awt.Dimension(580, 218));
        panel.setLayout(new java.awt.BorderLayout());

        barra.setBackground(new java.awt.Color(0, 0, 0));
        barra.setForeground(new java.awt.Color(255, 255, 255));

        listaArticulos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        listaArticulos.setVisibleRowCount(4);
        jScrollPane1.setViewportView(listaArticulos);

        btnGenerar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnGenerar.setText("Generar Reporte");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel4.setText("Producto en el reporte");

        codigoTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoTxtActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar");

        jLabel5.setText("Código:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1)
                                .addGap(10, 10, 10))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(codigoTxt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAgregar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGenerar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(barra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dateDesde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dateHasta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                        .addGap(132, 132, 132))
                    .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(codigoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dateHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGenerar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(barra, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnGenerarActionPerformed

    private void dateHastaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateHastaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateHastaActionPerformed

    private void codigoTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoTxtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barra;
    public javax.swing.JButton btnAgregar;
    public javax.swing.JButton btnGenerar;
    public javax.swing.JTextField codigoTxt;
    public org.jdesktop.swingx.JXDatePicker dateDesde;
    public org.jdesktop.swingx.JXDatePicker dateHasta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JList listaArticulos;
    public javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables

    public Object[] getLineas(){
        return this.listaArticulos.getSelectedValues();
    }

    public String getFechaDesde(){
        String fechaDesde     = "";
        SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd");
        if(this.dateDesde.getDate() != null)
        {
            try {
                fechaDesde = sdf.format(this.dateDesde.getDate());
            } catch(Exception e) { JOptionPane.showMessageDialog(null, "Error en el registro: Fecha invÃ¡lida"); }
        }
        fechaDesde=fechaDesde+" 00:00:00";
        return fechaDesde ;
    }

    public String getFechaHasta(){
        String fechaHasta     = "";
        SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd");
        if(this.dateDesde.getDate() != null)
        {
            try {
                fechaHasta = sdf.format(this.dateHasta.getDate());
            } catch(Exception e) { JOptionPane.showMessageDialog(null, "Error en el registro: Fecha invÃ¡lida"); }
        }
        fechaHasta=fechaHasta+" 23:59:59";
        return fechaHasta ;
    }

}

