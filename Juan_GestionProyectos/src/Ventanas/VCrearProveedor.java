package Ventanas;

import Clases.*;
import Main.Main;
import java.util.Date;
import javax.swing.JOptionPane;

public class VCrearProveedor extends javax.swing.JFrame {
    
    private int opcion;
    private Proveedores p;
    
    public VCrearProveedor() {
        initComponents();
        setLocationRelativeTo(null);
        NoCodigo.setVisible(false);
        NoNombre.setVisible(false);
        NoApellidos.setVisible(false);
        NoDireccion.setVisible(false);
    }
    
    public VCrearProveedor(int opcion, Proveedores prov) {
        initComponents();
        setLocationRelativeTo(null);
        NoCodigo.setVisible(false);
        NoNombre.setVisible(false);
        NoApellidos.setVisible(false);
        NoDireccion.setVisible(false);
        this.opcion = opcion;
        this.p = prov;
        AdaptarVentanaOpcion();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCalendar1 = new com.toedter.calendar.JCalendar();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        tTitulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        eNombre = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tCodigo = new javax.swing.JTextField();
        tNombre = new javax.swing.JTextField();
        bAceptar = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();
        NoApellidos = new javax.swing.JLabel();
        NoCodigo = new javax.swing.JLabel();
        NoNombre = new javax.swing.JLabel();
        tApellidos = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tDireccion = new javax.swing.JTextField();
        NoDireccion = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tTitulo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        tTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tTitulo.setText("Crear Proveedor");

        jLabel2.setText("Código:");

        eNombre.setText("Nombre:");

        jLabel6.setText("Apellidos:");

        bAceptar.setText("Aceptar y crear");
        bAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAceptarActionPerformed(evt);
            }
        });

        bCancelar.setText("Cancelar");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });

        NoApellidos.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        NoApellidos.setForeground(new java.awt.Color(255, 0, 0));
        NoApellidos.setText("*Apellido no válido");

        NoCodigo.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        NoCodigo.setForeground(new java.awt.Color(255, 0, 0));
        NoCodigo.setText("*Código no válido");

        NoNombre.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        NoNombre.setForeground(new java.awt.Color(255, 0, 0));
        NoNombre.setText("*Nombre no válido");

        jLabel10.setText("Dirección:");

        NoDireccion.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        NoDireccion.setForeground(new java.awt.Color(255, 0, 0));
        NoDireccion.setText("*Dirección no válida");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NoDireccion)
                                    .addComponent(tDireccion)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(eNombre)
                                            .addComponent(jLabel6)))
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tCodigo)
                                    .addComponent(tNombre)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(NoApellidos)
                                            .addComponent(NoCodigo)
                                            .addComponent(NoNombre))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(tApellidos)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(bAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addComponent(bCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)))
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NoCodigo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NoNombre)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NoApellidos)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(tDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NoDireccion)
                .addGap(18, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        Main.cerrarCrearProveedor(opcion);
    }//GEN-LAST:event_bCancelarActionPerformed

    private void bAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAceptarActionPerformed
        if(validarDatos()){
            String codigo = tCodigo.getText().trim().replaceAll(" ", "");
            String nombre = tNombre.getText().trim();
            String apellidos = tApellidos.getText().trim();
            String direccion = tDireccion.getText().trim();
            
            Proveedores prov = new Proveedores();
            prov.setCodigo(codigo);
            prov.setNombre(nombre);
            prov.setApellidos(apellidos);
            prov.setDireccion(direccion);
            Response respuesta = null;
            
            if(this.opcion == 1){
                respuesta = Main.modificarProveedor(prov);
                if(respuesta.isCorrecto()){
                    JOptionPane.showMessageDialog(null, "Se ha modificado el proveedor correctamente.");
                }
            }else{
                respuesta = Main.insertarProveedor(prov);
                if(respuesta.isCorrecto()){
                    JOptionPane.showMessageDialog(null, "Se ha insertado el proveedor correctamente.");
                }
            }
            if(respuesta != null){
                if(!respuesta.isCorrecto()){
                    JOptionPane.showMessageDialog(null,respuesta.getMensajeError(),"", JOptionPane.ERROR_MESSAGE);
                }else{
                    Main.cerrarCrearProveedor(this.opcion);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado. Vuelve a intentarlo.","", JOptionPane.ERROR_MESSAGE);
            }
            
        }
    }//GEN-LAST:event_bAceptarActionPerformed

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
            java.util.logging.Logger.getLogger(VCrearProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VCrearProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VCrearProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VCrearProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new VCrearProveedor().setVisible(true);
            }
        });
    }
    
    public boolean validarDatos(){
        NoCodigo.setVisible(false);
        NoNombre.setVisible(false);
        NoApellidos.setVisible(false);
        NoDireccion.setVisible(false);

        boolean valido = true;
        String codigo = tCodigo.getText().trim().replaceAll(" ","");
        String nombre = tNombre.getText().trim();
        String apellidos = tApellidos.getText().trim();
        String direccion = tDireccion.getText().trim();

        if(codigo == null || codigo.isBlank()){
            NoCodigo.setText("*El código es obligatorio.");
            NoCodigo.setVisible(true);
            valido = false;
        }else if(codigo.length() > 6){
            NoCodigo.setText("*El código debe tener máximo 6 caracteres.");
            NoCodigo.setVisible(true);
            valido = false;
        }
        if(nombre == null || nombre.isBlank()){
            NoNombre.setText("*El nombre es obligatorio.");
            NoNombre.setVisible(true);
            valido = false;
        }else if(nombre.length() > 20){
            NoNombre.setText("*El nombre debe tener máximo 20 caracteres.");
            NoNombre.setVisible(true);
            valido = false;
        }
        if(apellidos == null || apellidos.isBlank()){
            NoApellidos.setText("*Los apellidos son obligatorios.");
            NoApellidos.setVisible(true);
            valido = false;
        }else if(apellidos.length() > 30){
            NoApellidos.setText("*Los apellidos deben tener máximo 30 caracteres.");
            NoApellidos.setVisible(true);
            valido = false;
        }
        if(direccion == null || direccion.isBlank()){
            NoDireccion.setText("*La dirección es obligatoria.");
            NoDireccion.setVisible(true);
            valido = false;
        }else if(direccion.length() > 40){
            NoDireccion.setText("*La dirección debe tener máximo 40 caracteres.");
            NoDireccion.setVisible(true);
            valido = false;
        }
        return valido;
    }
     
     private void AdaptarVentanaOpcion(){
         if(opcion == 1){
            tTitulo.setText("Modificar Proveedor");
            tCodigo.setEditable(false);
            bAceptar.setText("Aceptar y modificar");
            RellenarDatosDelProveedor();
        }else{
            tTitulo.setText("Crear Proveedor");
            bAceptar.setText("Aceptar y crear");
            tCodigo.setEditable(true);
        }
     }
     
     private void RellenarDatosDelProveedor(){
         if(p != null){
            tCodigo.setText(p.getCodigo());
            tNombre.setText(p.getNombre());
            tApellidos.setText(p.getApellidos());
            tDireccion.setText(p.getDireccion());
        }
     }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NoApellidos;
    private javax.swing.JLabel NoCodigo;
    private javax.swing.JLabel NoDireccion;
    private javax.swing.JLabel NoNombre;
    private javax.swing.JButton bAceptar;
    private javax.swing.JButton bCancelar;
    private javax.swing.JLabel eNombre;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextField tApellidos;
    private javax.swing.JTextField tCodigo;
    private javax.swing.JTextField tDireccion;
    private javax.swing.JTextField tNombre;
    private javax.swing.JLabel tTitulo;
    // End of variables declaration//GEN-END:variables
}
