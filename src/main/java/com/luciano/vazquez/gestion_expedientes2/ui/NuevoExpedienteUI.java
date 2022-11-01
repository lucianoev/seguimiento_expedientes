/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luciano.vazquez.gestion_expedientes2.ui;

import com.luciano.vazquez.gestion_expedientes2.bo.ExpedienteBO;
import com.luciano.vazquez.gestion_expedientes2.bo.ExternoBO;
import com.luciano.vazquez.gestion_expedientes2.entity.Expediente;
import com.luciano.vazquez.gestion_expedientes2.entity.Externo;
import com.luciano.vazquez.gestion_expedientes2.entity.Usuario;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javax.swing.JOptionPane;

/**
 *
 * @author Exo
 */
public class NuevoExpedienteUI extends javax.swing.JPanel {

    /**
     * Creates new form NuevoExpediente
     *
     */
    LocalDate dia = LocalDate.now();
    LocalTime hora = LocalTime.now();
    LocalDateTime fecha = LocalDateTime.of(dia, hora);
    ExpedienteBO exp = new ExpedienteBO();
    Expediente nuevoExpediente = new Expediente();
    Externo externo = new Externo();
    ExternoBO externoBO = new ExternoBO();
    Usuario usuario = new Usuario();
    MenuPrincipalUI panelMenu;
    ExpedienteUI panelExpediente;
    javax.swing.JPanel panel;
    javax.swing.JPanel panelSesion;

    int nuevoId;
    String a = "/";

    public NuevoExpedienteUI(javax.swing.JPanel panelContenedor, Usuario sesionUsuario, javax.swing.JPanel panelSesion) {
        initComponents();
        this.usuario = sesionUsuario;
        this.panel = panelContenedor;
        this.panelSesion = panelSesion;
        nuevoId = exp.proximoIdExpediente();
        System.out.println("ID" + String.valueOf(nuevoId));
        jLabelNroExpediente.setText(String.valueOf(nuevoId) + a + String.valueOf(fecha.getYear()));
        jRadioButtonInterno.setSelected(true);
        jTextFieldNombre.setEnabled(false);
        jTextFieldApellido.setEnabled(false);
        jTextFieldDocumento.setEnabled(false);
        jTextFieldDomicilio.setEnabled(false);
        jTextFieldTelefono.setEnabled(false);
        jTextFieldEmail.setEnabled(false);
        jButtonBuscarIniciante.setEnabled(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup4 = new javax.swing.ButtonGroup();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jRadioButtonInterno = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextReferencia = new javax.swing.JTextArea();
        jRadioButtonExterno = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        jButtonGuardar = new javax.swing.JButton();
        jComboBoxTipo = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldApellido = new javax.swing.JTextField();
        jTextFieldDocumento = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldDomicilio = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldTelefono = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jButtonBuscarIniciante = new javax.swing.JButton();
        jLabelNroExpediente = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jComboBoxSituacion = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        jTextFojas = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel4.setText("Registro Nuevo Expediente");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel9.setText("Expediente N° :");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Tipo de iniciante:");

        buttonGroup4.add(jRadioButtonInterno);
        jRadioButtonInterno.setText("Interno");
        jRadioButtonInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonInternoActionPerformed(evt);
            }
        });

        jTextReferencia.setColumns(20);
        jTextReferencia.setRows(5);
        jScrollPane1.setViewportView(jTextReferencia);

        buttonGroup4.add(jRadioButtonExterno);
        jRadioButtonExterno.setText("Externo");
        jRadioButtonExterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonExternoActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Tipo de expediente:");

        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        jComboBoxTipo.setMaximumRowCount(4);
        jComboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Queja", "Reclamo", "Sugerencia", "Petición simple", "Petición con erogación" }));

        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del iniciante", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel10.setText("DNI N°:");

        jLabel13.setText("Nombre:");

        jLabel14.setText("Apellido:");

        jLabel15.setText("Domicilio:");

        jLabel16.setText("Teléfono:");

        jLabel17.setText("Email:");

        jButtonBuscarIniciante.setText("Buscar");
        jButtonBuscarIniciante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarInicianteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonBuscarIniciante)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldEmail)))
                .addGap(30, 30, 30))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel14)
                    .addComponent(jTextFieldApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscarIniciante))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTextFieldDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jTextFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabelNroExpediente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelNroExpediente.setText("845/20 ");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Situación:");

        jComboBoxSituacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Para Autorizar", "Para Conocimiento", "Para Protocolizar", "Para Resolución", "Para Corregir", "Para Adjuntar Documentación", "Para Archivar", "Para Pago", " ", " " }));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setText("Fojas:");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("Referencia:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(29, 29, 29)
                                        .addComponent(jComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel11))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel22)
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jRadioButtonInterno)
                                        .addGap(18, 18, 18)
                                        .addComponent(jRadioButtonExterno))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel23)
                                            .addComponent(jLabel21))
                                        .addGap(27, 27, 27)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextFojas, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jComboBoxSituacion, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jLabel4)
                        .addGap(96, 96, 96)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelNroExpediente)))
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(jButtonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(263, 263, 263))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9)
                    .addComponent(jLabelNroExpediente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel23))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11)
                            .addComponent(jRadioButtonInterno)
                            .addComponent(jRadioButtonExterno))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel21)
                                    .addComponent(jComboBoxSituacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFojas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(12, 12, 12)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButtonGuardar))
                .addGap(21, 21, 21))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonInternoActionPerformed
        jTextFieldNombre.setEnabled(false);
        jTextFieldApellido.setEnabled(false);
        jTextFieldDocumento.setEnabled(false);
        jTextFieldDomicilio.setEnabled(false);
        jTextFieldTelefono.setEnabled(false);
        jTextFieldEmail.setEnabled(false);
        jButtonBuscarIniciante.setEnabled(false);
    }//GEN-LAST:event_jRadioButtonInternoActionPerformed

    private void jRadioButtonExternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonExternoActionPerformed
        jTextFieldDocumento.setEnabled(true);
        jButtonBuscarIniciante.setEnabled(true);

    }//GEN-LAST:event_jRadioButtonExternoActionPerformed

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed

        jComboBoxSituacion.setSelectedIndex(WIDTH);
        String tipo = (String) (jComboBoxTipo.getSelectedItem());
        nuevoExpediente.setTipo(tipo);
        nuevoExpediente.setEstado("Iniciado");
        nuevoExpediente.setFecha(tipo);
        nuevoExpediente.setReferencia(jTextReferencia.getText());
        nuevoExpediente.setIdUsuario(usuario.getIdUsuario());
        nuevoExpediente.setFecha(String.valueOf(fecha));
        nuevoExpediente.setFojas(Integer.parseInt(jTextFojas.getText()));
        
        //CUANDO EL EXPEDIENTE ES INTERNO ID_INICIANTE=0
        if (jRadioButtonExterno.isSelected()) {
            nuevoExpediente.setIdIniciante(Integer.parseInt(jTextFieldDocumento.getText()));
            if (externo.getDni() != (Integer.parseInt(jTextFieldDocumento.getText()))) {
                externo.setNombre(jTextFieldNombre.getText());
                externo.setApellido(jTextFieldApellido.getText());
                externo.setDni(Integer.parseInt(jTextFieldDocumento.getText()));
                externo.setDomicilio(jTextFieldDomicilio.getText());
                externo.setEmail(jTextFieldEmail.getText());
                externo.setTelefono(jTextFieldTelefono.getText());
                externoBO.insert(externo);
            }
        } else {
            nuevoExpediente.setIdIniciante(0);
        }
        
        exp.insert(nuevoExpediente);
        JOptionPane.showMessageDialog(null, "El Expediente se ha cargado correctamente");
        panelExpediente = new ExpedienteUI(panel, usuario, panelSesion, nuevoId);
        panel.add(panelExpediente);
        panelExpediente.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int b;

        b = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea cancelar la carga del nuevo expediente?. Se perderán todos los datos ingresados.",
                "Advertencia", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (b == 0) {
            panelMenu = new MenuPrincipalUI(panel, usuario, panelSesion);
            panel.add(panelMenu);
            panelMenu.setVisible(true);
            this.setVisible(false);
        } else {
            this.setVisible(true);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButtonBuscarInicianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarInicianteActionPerformed

        if (externoBO.buscarInicianteBoolean(Integer.parseInt(jTextFieldDocumento.getText()))) {
            externo = externoBO.buscarIniciante(Integer.parseInt(jTextFieldDocumento.getText()));
            jTextFieldNombre.setText(externo.getNombre());
            jTextFieldApellido.setText(externo.getApellido());
            jTextFieldDomicilio.setText(externo.getDomicilio());
            jTextFieldTelefono.setText(externo.getTelefono());
            jTextFieldEmail.setText(externo.getEmail());

            jTextFieldNombre.setEnabled(false);
            jTextFieldApellido.setEnabled(false);
            jTextFieldDomicilio.setEnabled(false);
            jTextFieldTelefono.setEnabled(false);
            jTextFieldEmail.setEnabled(false);
        } else {
            jTextFieldNombre.setText("");
            jTextFieldApellido.setText("");
            jTextFieldDomicilio.setText("");
            jTextFieldTelefono.setText("");
            jTextFieldEmail.setText("");
            JOptionPane.showMessageDialog(null, "La persona ingresada no posee Expedientes iniciados previamente. Por Favor complete la información personal.");

            jTextFieldNombre.setEnabled(true);
            jTextFieldApellido.setEnabled(true);
            jTextFieldDomicilio.setEnabled(true);
            jTextFieldTelefono.setEnabled(true);
            jTextFieldEmail.setEnabled(true);
        }
    }//GEN-LAST:event_jButtonBuscarInicianteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonBuscarIniciante;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JComboBox<String> jComboBoxSituacion;
    private javax.swing.JComboBox<String> jComboBoxTipo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelNroExpediente;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButtonExterno;
    private javax.swing.JRadioButton jRadioButtonInterno;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldApellido;
    private javax.swing.JTextField jTextFieldDocumento;
    private javax.swing.JTextField jTextFieldDomicilio;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldTelefono;
    private javax.swing.JTextField jTextFojas;
    private javax.swing.JTextArea jTextReferencia;
    // End of variables declaration//GEN-END:variables
}