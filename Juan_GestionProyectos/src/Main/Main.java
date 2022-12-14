package Main;

import Clases.*;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.*;
import BBDD.*;
import Ventanas.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public static VEstadisticasProveedores vEstadisticasProveedores;
    public static VEstadisticasProyectos vEstadisticasProyectos;
    public static VEstadisticasPiezas vEstadisticasPiezas;
    
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
    
    public static void abrirEstadisticasProveedor(){
        try{
            vCargando.setVisible(true);
            EstadisticasProveedor masPiezasSuministradas = ProveedorConMasPiezasSuministradas();
            EstadisticasProveedor masProyectos = ProveedorConMasProyectos();
            EstadisticasProveedor masGestiones = ProveedorConMasGestiones();
            vEstadisticasProveedores = new VEstadisticasProveedores(masPiezasSuministradas,masProyectos,masGestiones);
            vEstadisticasProveedores.setVisible(true);
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
    
    public static void cerrarEstadisticasProveedor(){
        vPrincipal = new VPrincipal();
        vPrincipal.setVisible(true);
        vEstadisticasProveedores.setVisible(false);
        vEstadisticasProveedores.dispose();
    }
    
    public static void abrirEstadisticasProyectos(){
        try{
            vCargando.setVisible(true);
            EstadisticasProyectos masPiezasSuministradas = ProyectoConMasPiezasSuministradas();
            EstadisticasProyectos masProveedores = ProyectoConMasProveedores();
            EstadisticasProyectos masGestiones = ProyectoConMasGestiones();
            vEstadisticasProyectos = new VEstadisticasProyectos(masPiezasSuministradas,masProveedores,masGestiones);
            vEstadisticasProyectos.setVisible(true);
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
    
    public static void cerrarEstadisticasProyectos(){
        vPrincipal = new VPrincipal();
        vPrincipal.setVisible(true);
        vEstadisticasProyectos.setVisible(false);
        vEstadisticasProyectos.dispose();
    }
    
    public static void abrirEstadisticasPiezas(){
        try{
            vCargando.setVisible(true);
            EstadisticasPiezas piezaMasSuministrada = piezaMasSuministrada();
            EstadisticasPiezas masProveedores = piezaConMasProveedores();
            EstadisticasPiezas masProyectos = piezaConMasProyectos();
            EstadisticasPiezas masGestiones = piezaConMasGestiones();
            vEstadisticasPiezas = new VEstadisticasPiezas(piezaMasSuministrada,masProveedores,masProyectos,masGestiones);
            vEstadisticasPiezas.setVisible(true);
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
    
    public static void cerrarEstadisticasPiezas(){
        vPrincipal = new VPrincipal();
        vPrincipal.setVisible(true);
        vEstadisticasPiezas.setVisible(false);
        vEstadisticasPiezas.dispose();
    }
    
    public static EstadisticasProveedor ProveedorConMasPiezasSuministradas() throws Exception{
        EstadisticasProveedor prov = null;
        try{
            List<Gestion> gestiones = buscarGestiones("", "", "", -1);
            Map<String, Integer> map = new HashMap<String, Integer>();
            for(Gestion g : gestiones){
                int valor = 0;
                String clave = g.getProveedoresByCodproveedor().getCodigo();
                if(map.containsKey(clave)){
                    valor = map.get(clave);
                }
                valor += g.getCantidad();
                map.put(clave, valor);
            }
            String codigo = "";
            int cantidadPiezas = 0;
            for(Map.Entry<String,Integer> entry : map.entrySet()){
                if(entry.getValue() > cantidadPiezas){
                    codigo = entry.getKey();
                    cantidadPiezas = entry.getValue();
                }
            }
            if(!codigo.isBlank() && cantidadPiezas != 0){
                prov = new EstadisticasProveedor();
                prov.setCodigo(codigo);
                prov.setNumeroPiezas(cantidadPiezas);
            }
            return prov;
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public static EstadisticasProveedor ProveedorConMasProyectos() throws Exception{
        EstadisticasProveedor prov = null;
        try{
            List<Proveedores> proveedores = buscarProveedoresConGestiones("", "", "", "");
            Map<String, Integer> map = new HashMap<String, Integer>();
            for(Proveedores p : proveedores){
                String clave = p.getCodigo();
                List<String> proyectos = new ArrayList<>();
                for(Gestion g : p.getGestionsByCodigo()){
                    if(!proyectos.contains(g.getProyectosByCodproyecto().getCodigo())){
                        proyectos.add(g.getProyectosByCodproyecto().getCodigo());
                    }
                }
                map.put(clave, proyectos.size());
            }
            String codigo = "";
            int cantidadProyectos = 0;
            for(Map.Entry<String,Integer> entry : map.entrySet()){
                if(entry.getValue() > cantidadProyectos){
                    codigo = entry.getKey();
                    cantidadProyectos = entry.getValue();
                }
            }
            if(!codigo.isBlank() && cantidadProyectos != 0){
                prov = new EstadisticasProveedor();
                prov.setCodigo(codigo);
                prov.setNumeroProyectos(cantidadProyectos);
            }
            return prov;
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public static EstadisticasProveedor ProveedorConMasGestiones() throws Exception{
        EstadisticasProveedor prov = null;
        try{
            List<Proveedores> proveedores = buscarProveedoresConGestiones("", "", "", "");
            Proveedores provConMasGestiones = null;
            for(Proveedores p : proveedores){
                
                if(provConMasGestiones == null || p.getGestionsByCodigo().size() > provConMasGestiones.getGestionsByCodigo().size()){
                    provConMasGestiones = p;
                }
            }
            if(provConMasGestiones != null){
                prov = new EstadisticasProveedor();
                prov.setCodigo(provConMasGestiones.getCodigo());
                prov.setNumeroGestiones(provConMasGestiones.getGestionsByCodigo().size());
            }
            return prov;
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public static List<EstadisticasProveedor> buscarEstadisticasProveedores(String codigo, String nombre, String apellidos, String direccion){
        try{
            List<Proveedores> proveedores = BD_PROVEEDORES.buscarProveedoresConGestiones(codigo, nombre, apellidos, direccion);
            List<EstadisticasProveedor> estadisticas = new ArrayList<>();
            for(Proveedores p : proveedores){
                EstadisticasProveedor estat = new EstadisticasProveedor();
                estat.setCodigo(p.getCodigo());
                estat.setNombre(p.getNombre());
                estat.setApellidos(p.getApellidos());
                estat.setDireccion(p.getDireccion());
                estat.setNumeroGestiones(p.getGestionsByCodigo().size());
                List<String> proyectos = new ArrayList<>();
                int numeroPiezas = 0;
                for(Gestion g : p.getGestionsByCodigo()){
                    if(!proyectos.contains(g.getProyectosByCodproyecto().getCodigo())){
                        proyectos.add(g.getProyectosByCodproyecto().getCodigo());
                    }
                    numeroPiezas += g.getCantidad();
                }
                estat.setNumeroProyectos(proyectos.size());
                estat.setNumeroPiezas(numeroPiezas);
                estadisticas.add(estat);
            }
            return estadisticas;
        }catch(Exception ex){
            return null;
        }
    }
    
    public static EstadisticasProyectos ProyectoConMasPiezasSuministradas() throws Exception{
        EstadisticasProyectos pro = null;
        try{
            List<Gestion> gestiones = buscarGestiones("", "", "", -1);
            Map<String, Integer> map = new HashMap<String, Integer>();
            for(Gestion g : gestiones){
                int valor = 0;
                String clave = g.getProyectosByCodproyecto().getCodigo();
                if(map.containsKey(clave)){
                    valor = map.get(clave);
                }
                valor += g.getCantidad();
                map.put(clave, valor);
            }
            String codigo = "";
            int cantidadPiezas = 0;
            for(Map.Entry<String,Integer> entry : map.entrySet()){
                if(entry.getValue() > cantidadPiezas){
                    codigo = entry.getKey();
                    cantidadPiezas = entry.getValue();
                }
            }
            if(!codigo.isBlank() && cantidadPiezas != 0){
                pro = new EstadisticasProyectos();
                pro.setCodigo(codigo);
                pro.setNumeroPiezas(cantidadPiezas);
            }
            return pro;
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public static EstadisticasProyectos ProyectoConMasProveedores() throws Exception{
        EstadisticasProyectos pro = null;
        try{
            List<Proyectos> proyectos = buscarProyectosConGestiones("", "", "");
            Map<String, Integer> map = new HashMap<String, Integer>();
            for(Proyectos p : proyectos){
                String clave = p.getCodigo();
                List<String> proveedores = new ArrayList<>();
                for(Gestion g : p.getGestionsByCodigo()){
                    if(!proveedores.contains(g.getProveedoresByCodproveedor().getCodigo())){
                        proveedores.add(g.getProveedoresByCodproveedor().getCodigo());
                    }
                }
                map.put(clave, proyectos.size());
            }
            String codigo = "";
            int cantidadProveedores = 0;
            for(Map.Entry<String,Integer> entry : map.entrySet()){
                if(entry.getValue() > cantidadProveedores){
                    codigo = entry.getKey();
                    cantidadProveedores = entry.getValue();
                }
            }
            if(!codigo.isBlank() && cantidadProveedores != 0){
                pro = new EstadisticasProyectos();
                pro.setCodigo(codigo);
                pro.setNumeroProveedores(cantidadProveedores);
            }
            return pro;
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public static EstadisticasProyectos ProyectoConMasGestiones() throws Exception{
        EstadisticasProyectos pro = null;
        try{
            List<Proyectos> proyectos = buscarProyectosConGestiones("", "", "");
            Proyectos proConMasGestiones = null;
            for(Proyectos p : proyectos){
                if(proConMasGestiones == null || p.getGestionsByCodigo().size() > proConMasGestiones.getGestionsByCodigo().size()){
                    proConMasGestiones = p;
                }
            }
            if(proConMasGestiones != null){
                pro = new EstadisticasProyectos();
                pro.setCodigo(proConMasGestiones.getCodigo());
                pro.setNumeroGestiones(proConMasGestiones.getGestionsByCodigo().size());
            }
            return pro;
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public static List<EstadisticasProyectos> buscarEstadisticasProyectos(String codigo, String nombre, String ciudad){
        try{
            List<Proyectos> proyectos = BD_PROYECTOS.buscarProyectosConGestiones(codigo, nombre, ciudad);
            List<EstadisticasProyectos> estadisticas = new ArrayList<>();
            for(Proyectos p : proyectos){
                EstadisticasProyectos estat = new EstadisticasProyectos();
                estat.setCodigo(p.getCodigo());
                estat.setNombre(p.getNombre());
                estat.setCiudad(p.getCiudad());
                estat.setNumeroGestiones(p.getGestionsByCodigo().size());
                List<String> proveedores = new ArrayList<>();
                int numeroPiezas = 0;
                for(Gestion g : p.getGestionsByCodigo()){
                    if(!proveedores.contains(g.getProveedoresByCodproveedor().getCodigo())){
                        proveedores.add(g.getProveedoresByCodproveedor().getCodigo());
                    }
                    numeroPiezas += g.getCantidad();
                }
                estat.setNumeroProveedores(proveedores.size());
                estat.setNumeroPiezas(numeroPiezas);
                estadisticas.add(estat);
            }
            return estadisticas;
        }catch(Exception ex){
            return null;
        }
    }
    
    public static List<EstadisticasPiezas> buscarEstadisticasPiezas(String codigo, String nombre, int precio){
        try{
            List<Piezas> piezas = BD_PIEZAS.buscarPiezasConGestiones(codigo, nombre, precio);
            List<EstadisticasPiezas> estadisticas = new ArrayList<>();
            for(Piezas p : piezas){
                EstadisticasPiezas estat = new EstadisticasPiezas();
                estat.setCodigo(p.getCodigo());
                estat.setNombre(p.getNombre());
                estat.setPrecio(p.getPrecio());
                estat.setNumeroGestiones(p.getGestionsByCodigo().size());
                List<String> proveedores = new ArrayList<>();
                List<String> proyectos = new ArrayList<>();
                int numeroPiezas = 0;
                for(Gestion g : p.getGestionsByCodigo()){
                    if(!proveedores.contains(g.getProveedoresByCodproveedor().getCodigo())){
                        proveedores.add(g.getProveedoresByCodproveedor().getCodigo());
                    }
                    if(!proyectos.contains(g.getProyectosByCodproyecto().getCodigo())){
                        proyectos.add(g.getProyectosByCodproyecto().getCodigo());
                    }
                    numeroPiezas += g.getCantidad();
                }
                estat.setNumeroProveedores(proveedores.size());
                estat.setNumeroProyectos(proyectos.size());
                estat.setNumeroPiezas(numeroPiezas);
                estadisticas.add(estat);
            }
            return estadisticas;
        }catch(Exception ex){
            return null;
        }
    }
    
    public static EstadisticasPiezas piezaMasSuministrada() throws Exception{
        EstadisticasPiezas pieza = null;
        try{
            List<Gestion> gestiones = buscarGestiones("", "", "", -1);
            Map<String, Integer> map = new HashMap<String, Integer>();
            for(Gestion g : gestiones){
                int valor = 0;
                String clave = g.getPiezasByCodpieza().getCodigo();
                if(map.containsKey(clave)){
                    valor = map.get(clave);
                }
                valor += g.getCantidad();
                map.put(clave, valor);
            }
            String codigo = "";
            int cantidadPiezas = 0;
            for(Map.Entry<String,Integer> entry : map.entrySet()){
                if(entry.getValue() > cantidadPiezas){
                    codigo = entry.getKey();
                    cantidadPiezas = entry.getValue();
                }
            }
            if(!codigo.isBlank() && cantidadPiezas != 0){
                pieza = new EstadisticasPiezas();
                pieza.setCodigo(codigo);
                pieza.setNumeroPiezas(cantidadPiezas);
            }
            return pieza;
        }catch(Exception ex){
            throw ex;
        }
    }
   
    public static EstadisticasPiezas piezaConMasProveedores() throws Exception{
        EstadisticasPiezas pieza = null;
        try{
            List<Piezas> piezas = buscarPiezasConGestiones("", "", -1);
            Map<String, Integer> map = new HashMap<String, Integer>();
            for(Piezas p : piezas){
                String clave = p.getCodigo();
                List<String> proveedores = new ArrayList<>();
                for(Gestion g : p.getGestionsByCodigo()){
                    if(!proveedores.contains(g.getProveedoresByCodproveedor().getCodigo())){
                        proveedores.add(g.getProveedoresByCodproveedor().getCodigo());
                    }
                }
                map.put(clave, proveedores.size());
            }
            String codigo = "";
            int cantidadProveedores = 0;
            for(Map.Entry<String,Integer> entry : map.entrySet()){
                if(entry.getValue() > cantidadProveedores){
                    codigo = entry.getKey();
                    cantidadProveedores = entry.getValue();
                }
            }
            if(!codigo.isBlank() && cantidadProveedores != 0){
                pieza = new EstadisticasPiezas();
                pieza.setCodigo(codigo);
                pieza.setNumeroProveedores(cantidadProveedores);
            }
            return pieza;
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public static EstadisticasPiezas piezaConMasProyectos() throws Exception{
        EstadisticasPiezas pieza = null;
        try{
            List<Piezas> piezas = buscarPiezasConGestiones("", "", -1);
            Map<String, Integer> map = new HashMap<String, Integer>();
            for(Piezas p : piezas){
                String clave = p.getCodigo();
                List<String> proyectos = new ArrayList<>();
                for(Gestion g : p.getGestionsByCodigo()){
                    if(!proyectos.contains(g.getProyectosByCodproyecto().getCodigo())){
                        proyectos.add(g.getProyectosByCodproyecto().getCodigo());
                    }
                }
                map.put(clave, proyectos.size());
            }
            String codigo = "";
            int cantidadProyectos = 0;
            for(Map.Entry<String,Integer> entry : map.entrySet()){
                if(entry.getValue() > cantidadProyectos){
                    codigo = entry.getKey();
                    cantidadProyectos = entry.getValue();
                }
            }
            if(!codigo.isBlank() && cantidadProyectos != 0){
                pieza = new EstadisticasPiezas();
                pieza.setCodigo(codigo);
                pieza.setNumeroProyectos(cantidadProyectos);
            }
            return pieza;
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public static EstadisticasPiezas piezaConMasGestiones() throws Exception{
        EstadisticasPiezas pieza = null;
        try{
            List<Piezas> piezas = buscarPiezasConGestiones("", "", -1);
            Piezas piezaConMasGestiones = null;
            for(Piezas p : piezas){
                
                if(piezaConMasGestiones == null || p.getGestionsByCodigo().size() > piezaConMasGestiones.getGestionsByCodigo().size()){
                    piezaConMasGestiones = p;
                }
            }
            if(piezaConMasGestiones != null){
                pieza = new EstadisticasPiezas();
                pieza.setCodigo(piezaConMasGestiones.getCodigo());
                pieza.setNumeroGestiones(piezaConMasGestiones.getGestionsByCodigo().size());
            }
            return pieza;
        }catch(Exception ex){
            throw ex;
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
    
    public static Response eliminarProveedor(Proveedores prov){
        try{
            return BD_PROVEEDORES.eliminarProveedor(prov);
        }catch(Exception ex){
            return new Response(false,"Ha ocurrido un error al eliminar el proveedor");
        }
    }
    
    public static List<Proveedores> buscarProveedores(String codigo, String nombre, String apellidos, String direccion){
        try{
            return BD_PROVEEDORES.buscarProveedores(codigo, nombre, apellidos, direccion);
        }catch(Exception ex){
            return null;
        }
    }
    
    public static List<Proveedores> buscarProveedoresConGestiones(String codigo, String nombre, String apellidos, String direccion){
        try{
            return BD_PROVEEDORES.buscarProveedoresConGestiones(codigo, nombre, apellidos, direccion);
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
    
    public static Response eliminarPieza(Piezas pieza){
        try{
            return BD_PIEZAS.eliminarPieza(pieza);
        }catch(Exception ex){
            return new Response(false,"Ha ocurrido un error al eliminar la pieza");
        }
    }
    
    public static List<Piezas> buscarPiezas(String codigo, String nombre, int precio){
        try{
            return BD_PIEZAS.buscarPiezas(codigo, nombre, precio);
        }catch(Exception ex){
            return null;
        }
    }
    
    public static List<Piezas> buscarPiezasConGestiones(String codigo, String nombre, int precio){
        try{
            return BD_PIEZAS.buscarPiezasConGestiones(codigo, nombre, precio);
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
    
    public static Response eliminarProyecto(Proyectos pro){
        try{
            return BD_PROYECTOS.eliminarProyecto(pro);
        }catch(Exception ex){
            return new Response(false,"Ha ocurrido un error al eliminar el proyecto");
        }
    }
    
    public static List<Proyectos> buscarProyectos(String codigo, String nombre, String ciudad){
        try{
            return BD_PROYECTOS.buscarProyectos(codigo, nombre, ciudad);
        }catch(Exception ex){
            return null;
        }
    }
    
    public static List<Proyectos> buscarProyectosConGestiones(String codigo, String nombre, String ciudad){
        try{
            return BD_PROYECTOS.buscarProyectosConGestiones(codigo, nombre, ciudad);
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
