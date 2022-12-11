
package Ventanas;

import Main.Main;
import javax.swing.JOptionPane;


public class VPrincipal extends javax.swing.JFrame {
    
    public VPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        eTitulo1 = new javax.swing.JLabel();
        Salir = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        NuevoEspectaculo = new javax.swing.JMenuItem();
        ModificarEspectaculo = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        AltaEmpleado = new javax.swing.JMenuItem();
        ModificarEmpleado = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        AltaCliente = new javax.swing.JMenuItem();
        ModificarCliente = new javax.swing.JMenuItem();
        DatosAgencia = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        eTitulo1.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        eTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eTitulo1.setText("Gestión Proyectos");
        eTitulo1.setMaximumSize(new java.awt.Dimension(45, 62));

        Salir.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });

        jMenu1.setText("Gestiones");

        NuevoEspectaculo.setText("Registrar gestión");
        NuevoEspectaculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoEspectaculoActionPerformed(evt);
            }
        });
        jMenu1.add(NuevoEspectaculo);

        ModificarEspectaculo.setText("Mantenimiento de gestiones");
        ModificarEspectaculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarEspectaculoActionPerformed(evt);
            }
        });
        jMenu1.add(ModificarEspectaculo);

        jMenuBar1.add(jMenu1);

        jMenu5.setText("Proyectos");

        AltaEmpleado.setText("Alta de proyecto");
        AltaEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AltaEmpleadoActionPerformed(evt);
            }
        });
        jMenu5.add(AltaEmpleado);

        ModificarEmpleado.setText("Mantenimiento de proyectos");
        ModificarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarEmpleadoActionPerformed(evt);
            }
        });
        jMenu5.add(ModificarEmpleado);

        jMenuBar1.add(jMenu5);

        jMenu2.setText("Piezas");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        AltaCliente.setText("Alta de pieza");
        AltaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AltaClienteActionPerformed(evt);
            }
        });
        jMenu2.add(AltaCliente);

        ModificarCliente.setText("Mantenimiento de piezas");
        ModificarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarClienteActionPerformed(evt);
            }
        });
        jMenu2.add(ModificarCliente);

        jMenuBar1.add(jMenu2);

        DatosAgencia.setText("Proveedores");

        jMenuItem3.setText("Alta de proveedor");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        DatosAgencia.add(jMenuItem3);

        jMenuItem8.setText("Mantenimiento de proveedores");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        DatosAgencia.add(jMenuItem8);

        jMenuBar1.add(DatosAgencia);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(eTitulo1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(eTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(Salir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        Main.cerrarPrograma();
    }//GEN-LAST:event_SalirActionPerformed

    private void NuevoEspectaculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoEspectaculoActionPerformed
        Main.abrirRegistrarGestion(0);
    }//GEN-LAST:event_NuevoEspectaculoActionPerformed

    private void ModificarEspectaculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarEspectaculoActionPerformed
//        Main.abrirVMEEspectaculo(1);
    }//GEN-LAST:event_ModificarEspectaculoActionPerformed

    private void ModificarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarClienteActionPerformed
        Main.abrirMantenimientoPiezas();
    }//GEN-LAST:event_ModificarClienteActionPerformed

    private void AltaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AltaClienteActionPerformed
        Main.abrirCrearPieza(0);
    }//GEN-LAST:event_AltaClienteActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        Main.abrirCrearProveedor(0);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void AltaEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AltaEmpleadoActionPerformed
        Main.abrirCrearProyecto(0);
    }//GEN-LAST:event_AltaEmpleadoActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
//        Main.abrirVMECliente(0);
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void ModificarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarEmpleadoActionPerformed
        Main.abrirMantenimientoProyectos();
    }//GEN-LAST:event_ModificarEmpleadoActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        Main.abrirMantenimientoProveedor();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

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
            java.util.logging.Logger.getLogger(VPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AltaCliente;
    private javax.swing.JMenuItem AltaEmpleado;
    private javax.swing.JMenu DatosAgencia;
    private javax.swing.JMenuItem ModificarCliente;
    private javax.swing.JMenuItem ModificarEmpleado;
    private javax.swing.JMenuItem ModificarEspectaculo;
    private javax.swing.JMenuItem NuevoEspectaculo;
    private javax.swing.JButton Salir;
    private javax.swing.JLabel eTitulo1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem8;
    // End of variables declaration//GEN-END:variables

    public void NoCampamentos() {
        JOptionPane.showMessageDialog(this,"No hay campamentos","", JOptionPane.WARNING_MESSAGE);
    }
    
    public void NoPersonas() {
        JOptionPane.showMessageDialog(this,"No hay personas registradas","", JOptionPane.WARNING_MESSAGE);
    }
}
