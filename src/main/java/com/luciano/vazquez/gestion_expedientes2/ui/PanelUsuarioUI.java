/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luciano.vazquez.gestion_expedientes2.ui;

import com.luciano.vazquez.gestion_expedientes2.bo.ExpedienteBO;
import com.luciano.vazquez.gestion_expedientes2.bo.TransicionBO;
import com.luciano.vazquez.gestion_expedientes2.entity.Expediente;
import com.luciano.vazquez.gestion_expedientes2.entity.Usuario;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Exo
 */
public class PanelUsuarioUI extends javax.swing.JPanel {

    int idExpediente;
    ExpedienteBO expedienteBO = new ExpedienteBO();
    Expediente expediente = new Expediente();
    TransicionBO paseBO = new TransicionBO();
    MenuPrincipalUI panelMenu;
    javax.swing.JPanel panelContenedor;
    Usuario usuario;
    javax.swing.JPanel panelContenedorSesion;
    ExpedienteUI panelExpediente;

    /**
     * Creates new form Usuario
     */
    public PanelUsuarioUI(javax.swing.JPanel panelContenedor, Usuario sesionUsuario, javax.swing.JPanel panelContenedorSesion) {
        initComponents();
        this.usuario = sesionUsuario;
        this.panelContenedor = panelContenedor;
        this.panelContenedorSesion = panelContenedorSesion;
        jLabelUsuario.setText(usuario.getNombre());
        
        expedienteBO.listarExpedientePorUsuario(jTable1, usuario.getIdUsuario());
        paseBO.listarExpedientesQuePoseeUsuario(jTable2, usuario.getIdUsuario());
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Expedientes Usuario:");

        jLabelUsuario.setText("Luciano Vazquez");

        jButton3.setText("Menú Principal");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setText("Consultar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "N° Expediente", "Fecha ", "Estado", "Situación", "Área de Destino", "Recibido por usuario"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTabbedPane1.addTab("Iniciados", jScrollPane1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "N° Expediente", "Fecha ", "Estado", "Situación", "Área de Origen", "Enviado por usuario"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jTabbedPane1.addTab("Actuales", jScrollPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelUsuario))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
            .addGroup(layout.createSequentialGroup()
                .addGap(232, 232, 232)
                .addComponent(jButton3)
                .addGap(140, 140, 140)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelUsuario))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton5))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Actuales");
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        panelMenu = new MenuPrincipalUI(panelContenedor,usuario,panelContenedorSesion);
        panelContenedor.add(panelMenu);
        panelMenu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
        
        int IdSeleccion;
        
      if(jScrollPane1.isVisible()){
        if (jTable1.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar el expediente que desea consultar.");
        } else {
            IdSeleccion = Integer.parseInt(String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 0)));
            System.out.println("INFO" + IdSeleccion);
            panelExpediente= new ExpedienteUI(panelContenedor, usuario,panelContenedorSesion,IdSeleccion);
            panelContenedor.add(panelExpediente);
            panelExpediente.setVisible(true);
            this.setVisible(false);          
        }}
        
      else{
       
        if (jTable2.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar el expediente que desea consultar.");
        } else {
            IdSeleccion = Integer.parseInt(String.valueOf(jTable2.getValueAt(jTable2.getSelectedRow(), 0)));
            System.out.println("INFO" + IdSeleccion);
            panelExpediente= new ExpedienteUI(panelContenedor, usuario, panelContenedorSesion,IdSeleccion);
            panelContenedor.add(panelExpediente);
            panelExpediente.setVisible(true);
            this.setVisible(false);          
        }}
        
        
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}