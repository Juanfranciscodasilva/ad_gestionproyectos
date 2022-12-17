package Main;

import Clases.*;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.*;
import BBDD.*;
import Ventanas.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    
    public static VCargando vCargando;
    public static VPrincipal vPrincipal;
    public static VCrearProveedor vCrearProveedor;
    public static VMantenimientoProveedores vMantProveedores;
    public static VCrearPieza vCrearPieza;
    public static VMantenimientoPiezas vMantPiezas;
    public static VCrearProyecto vCrearProyecto;
    public static VMantenimientoProyectos vMantProyectos;
    public static VRegistrarGestion vRegistrarGestion;
    public static VMantenimientoGestiones vMantGestiones;
    
    public static void main(String[] args) {
        try{
            vCargando = new VCargando();
            vCargando.setVisible(true);
            BD_CONFIG.ComprobarBaseDeDatos();
        }catch(Exception ex){
            System.out.println("Ha ocurrido un error al comprobar la conexión con la base de datos");
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al comprobar la base de datos. Intentalo de nuevo.","",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }finally{
            if(vCargando != null){
                vCargando.setVisible(false);
            }
        }
        vPrincipal = new VPrincipal();
        vPrincipal.setVisible(true);
    }
    
    public static void cerrarPrograma(){
        System.exit(0);
    }
    
    public static void abrirCrearProveedor(int opcion){
        vCrearProveedor = new VCrearProveedor(opcion,null);
        vCrearProveedor.setVisible(true);
        vPrincipal.setVisible(false);
        vPrincipal.dispose();
    }
    
    public static void cerrarCrearProveedor(int opcion){
        vCrearProveedor.setVisible(false);
        vCrearProveedor.dispose();
        if(opcion==1){
            abrirMantenimientoProveedor();
        }else{
            vPrincipal = new VPrincipal();
            vPrincipal.setVisible(true);
        }
    }
    
    public static void abrirMantenimientoProveedor(){
        vMantProveedores = new VMantenimientoProveedores();
        vMantProveedores.setVisible(true);
        vPrincipal.setVisible(false);
        vPrincipal.dispose();
    }
    
    public static void cerrarMantenimientoProveedor(){
        vPrincipal = new VPrincipal();
        vPrincipal.setVisible(true);
        vMantProveedores.setVisible(false);
        vMantProveedores.dispose();
    }
    
    public static void abrirModificarProveedor(Proveedores pro){
        vMantProveedores.setVisible(false);
        vMantProveedores.dispose();
        vCrearProveedor = new VCrearProveedor(1, pro);
        vCrearProveedor.setVisible(true);
    }
    
    public static void abrirCrearPieza(int opcion){
        vCrearPieza = new VCrearPieza(opcion,null);
        vCrearPieza.setVisible(true);
        vPrincipal.setVisible(false);
        vPrincipal.dispose();
    }
    
    public static void cerrarCrearPieza(int opcion){
        vCrearPieza.setVisible(false);
        vCrearPieza.dispose();
        if(opcion==1){
            abrirMantenimientoPiezas();
        }else{
            vPrincipal = new VPrincipal();
            vPrincipal.setVisible(true);
        }
    }
    
    public static void abrirMantenimientoPiezas(){
        vMantPiezas = new VMantenimientoPiezas();
        vMantPiezas.setVisible(true);
        vPrincipal.setVisible(false);
        vPrincipal.dispose();
    }
    
    public static void cerrarMantenimientoPiezas(){
        vPrincipal = new VPrincipal();
        vPrincipal.setVisible(true);
        vMantPiezas.setVisible(false);
        vMantPiezas.dispose();
    }
    
    public static void abrirModificarPieza(Piezas pieza){
        vMantPiezas.setVisible(false);
        vMantPiezas.dispose();
        vCrearPieza = new VCrearPieza(1, pieza);
        vCrearPieza.setVisible(true);
    }
    
    public static void abrirCrearProyecto(int opcion){
        vCrearProyecto = new VCrearProyecto(opcion,null);
        vCrearProyecto.setVisible(true);
        vPrincipal.setVisible(false);
        vPrincipal.dispose();
    }
    
    public static void cerrarCrearProyecto(int opcion){
        vCrearProyecto.setVisible(false);
        vCrearProyecto.dispose();
        if(opcion==1){
            abrirMantenimientoProyectos();
        }else{
            vPrincipal = new VPrincipal();
            vPrincipal.setVisible(true);
        }
    }
    
    public static void abrirMantenimientoProyectos(){
        vMantProyectos = new VMantenimientoProyectos();
        vMantProyectos.setVisible(true);
        vPrincipal.setVisible(false);
        vPrincipal.dispose();
    }
    
    public static void cerrarMantenimientoProyectos(){
        vMantProyectos.setVisible(false);
        vMantProyectos.dispose();
        vPrincipal = new VPrincipal();
        vPrincipal.setVisible(true);
    }
    
    public static void abrirModificarProyecto(Proyectos pro){
        vMantProyectos.setVisible(false);
        vMantProyectos.dispose();
        vCrearProyecto = new VCrearProyecto(1, pro);
        vCrearProyecto.setVisible(true);
    }
    
    public static void abrirRegistrarGestion(int opcion){
        try{
            vCargando.setVisible(true);
            List<Proveedores> proveedores = BD_PROVEEDORES.getAllProveedores();
            List<Proyectos> proyectos = BD_PROYECTOS.getAllProyectos();
            List<Piezas> piezas = BD_PIEZAS.getAllPiezas();
            if(proveedores == null || proyectos == null || piezas == null){
                throw new Exception();
            }
            vRegistrarGestion = new VRegistrarGestion(opcion,null,piezas,proveedores,proyectos);
            vRegistrarGestion.setVisible(true);
            vPrincipal.setVisible(false);
            vPrincipal.dispose();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al abrir la ventana. Intentalo de nuevo.","",JOptionPane.ERROR_MESSAGE);
        }finally{
            if(vCargando != null){
                vCargando.setVisible(false);
            }
        }
    }
    
    public static void cerrarRegistrarGestion(int opcion){
        vRegistrarGestion.setVisible(false);
        vRegistrarGestion.dispose();
        if(opcion==1){
            abrirMantenimientoGestiones();
        }else{
            vPrincipal = new VPrincipal();
            vPrincipal.setVisible(true);
        }
    }
    
    public static void abrirMantenimientoGestiones(){
        vMantGestiones = new VMantenimientoGestiones();
        vMantGestiones.setVisible(true);
        vPrincipal.setVisible(false);
        vPrincipal.dispose();
    }
    
    public static void cerrarMantenimientoGestiones(){
        vPrincipal = new VPrincipal();
        vPrincipal.setVisible(true);
        vMantGestiones.setVisible(false);
        vMantGestiones.dispose();
    }
    
    public static void abrirModificarGestion(Gestion ges){
        try{
            vCargando.setVisible(true);
            List<Proveedores> proveedores = BD_PROVEEDORES.getAllProveedores();
            List<Proyectos> proyectos = BD_PROYECTOS.getAllProyectos();
            List<Piezas> piezas = BD_PIEZAS.getAllPiezas();
            if(proveedores == null || proyectos == null || piezas == null){
                throw new Exception();
            }
            vRegistrarGestion = new VRegistrarGestion(1,ges,piezas,proveedores,proyectos);
            vRegistrarGestion.setVisible(true);
            vMantGestiones.setVisible(false);
            vMantGestiones.dispose();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al abrir la ventana. Intentalo de nuevo.","",JOptionPane.ERROR_MESSAGE);
        }finally{
            if(vCargando != null){
                vCargando.setVisible(false);
            }
        }
    }
    
    public static Response insertarProveedor(Proveedores prov){
        try{
           return BD_PROVEEDORES.insertarProveedor(prov); 
        }catch(Exception ex){
            return new Response(false,"Ha ocurrido un error al insertar el proveedor");
        }
    }
    
    public static Response modificarProveedor(Proveedores prov){
        try{
            return BD_PROVEEDORES.modificarProveedor(prov);
        }catch(Exception ex){
            return new Response(false,"Ha ocurrido un error al modificar el proveedor");
        }
    }
    
    public static List<Proveedores> buscarProveedores(String codigo, String nombre, String apellidos, String direccion){
        try{
            return BD_PROVEEDORES.buscarProveedores(codigo, nombre, apellidos, direccion);
        }catch(Exception ex){
            return null;
        }
    }
    
    public static Response insertarPieza(Piezas pieza){
        try{
           return BD_PIEZAS.insertarPieza(pieza); 
        }catch(Exception ex){
            return new Response(false,"Ha ocurrido un error al insertar la pieza");
        }
    }
    
    public static Response modificarPieza(Piezas pieza){
        try{
            return BD_PIEZAS.modificarPieza(pieza);
        }catch(Exception ex){
            return new Response(false,"Ha ocurrido un error al modificar la pieza");
        }
    }
    
    public static List<Piezas> buscarPiezas(String codigo, String nombre, int precio){
        try{
            return BD_PIEZAS.buscarPiezas(codigo, nombre, precio);
        }catch(Exception ex){
            return null;
        }
    }
    
    public static Response insertarProyecto(Proyectos pro){
        try{
           return BD_PROYECTOS.insertarProyecto(pro); 
        }catch(Exception ex){
            return new Response(false,"Ha ocurrido un error al insertar el proyecto");
        }
    }
    
    public static Response modificarProyecto(Proyectos pro){
        try{
            return BD_PROYECTOS.modificarProyecto(pro);
        }catch(Exception ex){
            return new Response(false,"Ha ocurrido un error al modificar el proyecto");
        }
    }
    
    public static List<Proyectos> buscarProyectos(String codigo, String nombre, String ciudad){
        try{
            return BD_PROYECTOS.buscarProyectos(codigo, nombre, ciudad);
        }catch(Exception ex){
            return null;
        }
    }
    
    public static Response insertarGestion(Gestion gestion){
        try{
           return BD_GESTION.insertarGestion(gestion);
        }catch(Exception ex){
            return new Response(false,"Ha ocurrido un error al insertar la gestión");
        }
    }
    
    public static Response modificarGestion(Gestion gestion){
        try{
            return BD_GESTION.modificarGestion(gestion);
        }catch(Exception ex){
            return new Response(false,"Ha ocurrido un error al modificar la gestión");
        }
    }
    
    public static Response eliminarGestion(Gestion g){
        try{
            return BD_GESTION.eliminarGestion(g);
        }catch(Exception ex){
            return new Response(false,"Ha ocurrido un error al eliminar la gestión");
        }
    }
    
    public static List<Gestion> buscarGestiones(String codPieza, String codProveedor, String codProyecto, int cantidad){
        try{
            return BD_GESTION.buscarGestiones(codPieza, codProveedor, codProyecto, cantidad);
        }catch(Exception ex){
            return null;
        }
    }
    
}
