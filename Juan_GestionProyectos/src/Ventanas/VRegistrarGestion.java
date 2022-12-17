package Ventanas;

import Clases.*;
import Clases.Response;
import Main.Main;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import javax.swing.JOptionPane;

public class VRegistrarGestion extends javax.swing.JFrame {
    
    Gestion gestion;
    int opcion;
    
    Proyectos proyectoSeleccionado;
    Proveedores proveedorSeleccionado;
    Piezas piezaSeleccionada;
    
    private List<Piezas> listaPiezas;
    private List<Proveedores> listaProveedores;
    private List<Proyectos> listaProyectos;
    
    public VRegistrarGestion() {
        initComponents();
        setLocationRelativeTo(null);
        listaPiezas = new ArrayList<>();
        listaProveedores = new ArrayList<>();
        listaProyectos = new ArrayList<>();
    }
    
    public VRegistrarGestion(int opcion,Gestion gestion,List<Piezas> listaPiezas,List<Proveedores> listaProveedores,List<Proyectos> listaProyectos) {
        initComponents();
        setLocationRelativeTo(null);
        NoCantidad.setVisible(false);
        this.gestion = gestion;
        this.opcion = opcion;
        this.listaPiezas = listaPiezas;
        this.listaProveedores = listaProveedores;
        this.listaProyectos = listaProyectos;
        RellenarCombos();
        AdaptarVentanaOpcion();
        if(this.gestion != null){
            AutocompletarDatos();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tTitulo = new javax.swing.JLabel();
        bRegistrar = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tPrecioPieza = new javax.swing.JTextField();
        tNombrePieza = new javax.swing.JTextField();
        cbCodigoPieza = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tCiudadProyecto = new javax.swing.JTextField();
        tNombreProyecto = new javax.swing.JTextField();
        cbCodigoProyecto = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tDireccionProveedor = new javax.swing.JTextField();
        tApellidosProveedor = new javax.swing.JTextField();
        tNombreProveedor = new javax.swing.JTextField();
        cbCodigoProveedor = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        tCantidad = new javax.swing.JTextField();
        NoCantidad = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tTitulo.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        tTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tTitulo.setText("Registrar gestión");

        bRegistrar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        bRegistrar.setText("Registrar");
        bRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRegistrarActionPerformed(evt);
            }
        });

        bCancelar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        bCancelar.setText("Cancelar");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pieza", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jLabel2.setText("Código");

        jLabel3.setText("Nombre");

        jLabel5.setText("Precio");

        tPrecioPieza.setEditable(false);

        tNombrePieza.setEditable(false);

        cbCodigoPieza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCodigoPiezaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbCodigoPieza, 0, 270, Short.MAX_VALUE)
                    .addComponent(tNombrePieza)
                    .addComponent(tPrecioPieza))
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbCodigoPieza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tNombrePieza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tPrecioPieza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Proyecto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jLabel4.setText("Código");

        jLabel6.setText("Nombre");

        jLabel7.setText("Ciudad");

        tCiudadProyecto.setEditable(false);

        tNombreProyecto.setEditable(false);

        cbCodigoProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCodigoProyectoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tNombreProyecto)
                    .addComponent(tCiudadProyecto)
                    .addComponent(cbCodigoProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbCodigoProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tNombreProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tCiudadProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Proveedor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jLabel8.setText("Código");

        jLabel9.setText("Nombre");

        jLabel10.setText("Apellidos");

        jLabel11.setText("Dirección");

        tDireccionProveedor.setEditable(false);

        tApellidosProveedor.setEditable(false);

        tNombreProveedor.setEditable(false);

        cbCodigoProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCodigoProveedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbCodigoProveedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tApellidosProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tNombreProveedor)
                    .addComponent(tDireccionProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbCodigoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(tNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(tApellidosProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tDireccionProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabel12.setText("Cantidad:");

        NoCantidad.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        NoCantidad.setForeground(new java.awt.Color(255, 0, 0));
        NoCantidad.setText("*Cantidad no válida");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 813, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NoCantidad)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69)
                                .addComponent(bRegistrar)
                                .addGap(43, 43, 43)
                                .addComponent(bCancelar)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(tCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bRegistrar)
                    .addComponent(bCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NoCantidad)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        Main.cerrarRegistrarGestion(this.opcion);
    }//GEN-LAST:event_bCancelarActionPerformed

    private void bRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRegistrarActionPerformed
        if(this.piezaSeleccionada != null && this.proveedorSeleccionado != null && this.proyectoSeleccionado != null){
            if(validarDatos()){
                Response respuesta = null;
                Gestion g = new Gestion();
                g.setPiezasByCodpieza(piezaSeleccionada);
                g.setProveedoresByCodproveedor(proveedorSeleccionado);
                g.setProyectosByCodproyecto(proyectoSeleccionado);
                g.setCantidad(Integer.parseInt(tCantidad.getText()));
                if(this.opcion == 1){
                g.setId(this.gestion.getId());
                respuesta = Main.modificarGestion(g);
                if(respuesta.isCorrecto()){
                    JOptionPane.showMessageDialog(null, "Se ha modificado la gestión correctamente.");
                }
                }else{
                    respuesta = Main.insertarGestion(g);
                    if(respuesta.isCorrecto()){
                        JOptionPane.showMessageDialog(null, "Se ha registrado la gestión correctamente.");
                    }
                }
                if(respuesta != null){
                    if(!respuesta.isCorrecto()){
                        JOptionPane.showMessageDialog(null,respuesta.getMensajeError(),"", JOptionPane.ERROR_MESSAGE);
                    }else{
                        Main.cerrarRegistrarGestion(this.opcion);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado. Vuelve a intentarlo.","", JOptionPane.ERROR_MESSAGE);
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "El proyecto, proveedor y pieza son datos obligatorios.","", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_bRegistrarActionPerformed

    private void cbCodigoPiezaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCodigoPiezaActionPerformed
        int index = cbCodigoPieza.getSelectedIndex()-1;
        Piezas pieza = null;
        if(index > -1){
            pieza = this.listaPiezas.get(index);
        }
        if(pieza == null){
            LimpiarCamposPieza();
        }else{
            this.piezaSeleccionada = pieza;
            AutocompletarDatosPieza();
        }
    }//GEN-LAST:event_cbCodigoPiezaActionPerformed

    private void cbCodigoProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCodigoProyectoActionPerformed
        int index = cbCodigoProyecto.getSelectedIndex()-1;
        Proyectos pro = null;
        if(index > -1){
            pro = this.listaProyectos.get(index);
        }
        if(pro == null){
            LimpiarCamposProyecto();
        }else{
            this.proyectoSeleccionado = pro;
            AutocompletarDatosProyecto();
        }
    }//GEN-LAST:event_cbCodigoProyectoActionPerformed

    private void cbCodigoProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCodigoProveedorActionPerformed
        int index = cbCodigoProveedor.getSelectedIndex()-1;
        Proveedores prov = null;
        if(index > -1){
            prov = this.listaProveedores.get(index);
        }
        if(prov == null){
            LimpiarCamposProveedor();
        }else{
            this.proveedorSeleccionado = prov;
            AutocompletarDatosProveedor();
        }
    }//GEN-LAST:event_cbCodigoProveedorActionPerformed

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
            java.util.logging.Logger.getLogger(VRegistrarGestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VRegistrarGestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VRegistrarGestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VRegistrarGestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new VRegistrarGestion().setVisible(true);
            }
        });
    }
    
    public void LimpiarCamposPieza(){
        tNombrePieza.setText("");
        tPrecioPieza.setText("");
    }
    
    public void LimpiarCamposProyecto(){
        tNombreProyecto.setText("");
        tCiudadProyecto.setText("");
    }
    
    public void LimpiarCamposProveedor(){
        tNombreProveedor.setText("");
        tApellidosProveedor.setText("");
        tDireccionProveedor.setText("");
    }
    
    public void AutocompletarDatosPieza(){
        tNombrePieza.setText(this.piezaSeleccionada.getNombre());
        tPrecioPieza.setText(String.valueOf(this.piezaSeleccionada.getPrecio()));
    }
    
    public void AutocompletarDatosProyecto(){
        tNombreProyecto.setText(this.proyectoSeleccionado.getNombre());
        tCiudadProyecto.setText(this.proyectoSeleccionado.getCiudad());
    }
    
    public void AutocompletarDatosProveedor(){
        tNombreProveedor.setText(this.proveedorSeleccionado.getNombre());
        tApellidosProveedor.setText(this.proveedorSeleccionado.getApellidos());
        tDireccionProveedor.setText(this.proveedorSeleccionado.getDireccion());
    }
    
    public void RellenarCombos(){
        rellenarComboPiezas();
        rellenarComboProyectos();
        rellenarComboProveedores();
    }
    
    public void rellenarComboPiezas(){
        cbCodigoPieza.removeAllItems();
        if(this.listaPiezas != null && !this.listaPiezas.isEmpty()){
             cbCodigoPieza.addItem("-----Elegir piezas-----");
            try{
                for(Piezas pi : this.listaPiezas){
                    cbCodigoPieza.addItem(pi.getCodigo());
                }
            }catch(Exception e){
                System.out.println("ha ocurrido un error "+ e.getMessage());
            } 
        }
    }
    
    public void rellenarComboProyectos(){
        cbCodigoProyecto.removeAllItems();
        if(this.listaProyectos != null && !this.listaProyectos.isEmpty()){
             cbCodigoProyecto.addItem("-----Elegir proyectos-----");
            try{
                for(Proyectos pro : this.listaProyectos){
                    cbCodigoProyecto.addItem(pro.getCodigo());
                }
            }catch(Exception e){
                System.out.println("ha ocurrido un error "+ e.getMessage());
            } 
        }
    }
    
    public void rellenarComboProveedores(){
        cbCodigoProveedor.removeAllItems();
        if(this.listaProveedores != null && !this.listaProveedores.isEmpty()){
             cbCodigoProveedor.addItem("-----Elegir proveedor-----");
            try{
                for(Proveedores prov : this.listaProveedores){
                    cbCodigoProveedor.addItem(prov.getCodigo());
                }
            }catch(Exception e){
                System.out.println("ha ocurrido un error "+ e.getMessage());
            } 
        }
    }
    
    public boolean validarDatos(){
        NoCantidad.setVisible(false);

        boolean valido = true;
        String cantidad = tCantidad.getText().trim();

        if(cantidad == null || cantidad.isBlank()){
            NoCantidad.setText("*La cantidad es obligatoria.");
            NoCantidad.setVisible(true);
            valido = false;
        }else if(!isNumeric(cantidad) || Integer.parseInt(cantidad) <= 0){
            NoCantidad.setText("*La cantidad tiene que ser entera y mayor a 0.");
            NoCantidad.setVisible(true);
            valido = false;
        }
        return valido;
    }
    
    private boolean isNumeric(String numeroString){
         try{
             int numeroConvertido = Integer.parseInt(numeroString);
             return true;
         }catch(Exception ex){
             return false;
         }
     }
    
    public void AdaptarVentanaOpcion(){
        if(this.opcion == 0){
            bRegistrar.setText("Registrar");
            tTitulo.setText("Registrar gestión");
        }else{
            bRegistrar.setText("Modificar");
            tTitulo.setText("Modificar gestión");
        }
    }
    
    public void AutocompletarDatos(){
        //Autocompletar pieza
        if(this.gestion.getPiezasByCodpieza() != null){
            int index = IntStream.range(0, listaPiezas.size())
                        .filter(i -> listaPiezas.get(i).getCodigo().equalsIgnoreCase(this.gestion.getPiezasByCodpieza().getCodigo()))
                        .findFirst().orElse(-1);
            if(index != -1){
                cbCodigoPieza.setSelectedIndex(index+1);
            }
        }
        //Autocompletar proveedor
        if(this.gestion.getProveedoresByCodproveedor() != null){
            int index = IntStream.range(0, listaProveedores.size())
                        .filter(i -> listaProveedores.get(i).getCodigo().equalsIgnoreCase(this.gestion.getProveedoresByCodproveedor().getCodigo()))
                        .findFirst().orElse(-1);
            if(index != -1){
                cbCodigoProveedor.setSelectedIndex(index+1);
            }
        }
        //Autocompletar proyecto
        if(this.gestion.getProyectosByCodproyecto() != null){
            int index = IntStream.range(0, listaProyectos.size())
                        .filter(i -> listaProyectos.get(i).getCodigo().equalsIgnoreCase(this.gestion.getProyectosByCodproyecto().getCodigo()))
                        .findFirst().orElse(-1);
            if(index != -1){
                cbCodigoProyecto.setSelectedIndex(index+1);
            }
        }
        tCantidad.setText(String.valueOf(this.gestion.getCantidad()));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NoCantidad;
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bRegistrar;
    private javax.swing.JComboBox<String> cbCodigoPieza;
    private javax.swing.JComboBox<String> cbCodigoProveedor;
    private javax.swing.JComboBox<String> cbCodigoProyecto;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField tApellidosProveedor;
    private javax.swing.JTextField tCantidad;
    private javax.swing.JTextField tCiudadProyecto;
    private javax.swing.JTextField tDireccionProveedor;
    private javax.swing.JTextField tNombrePieza;
    private javax.swing.JTextField tNombreProveedor;
    private javax.swing.JTextField tNombreProyecto;
    private javax.swing.JTextField tPrecioPieza;
    private javax.swing.JLabel tTitulo;
    // End of variables declaration//GEN-END:variables
}
