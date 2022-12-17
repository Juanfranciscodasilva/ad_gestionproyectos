package BBDD;

import Clases.Proveedores;
import Clases.Response;
import java.util.List;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import util.HibernateUtil;

public class BD_PROVEEDORES {
    
    public static Response insertarProveedor(Proveedores prov){
        Response response = new Response();
        Session sesion = null;
        try{
            SessionFactory sesionFactory = HibernateUtil.getSessionFactory();
            sesion = sesionFactory.openSession();
            Transaction tx = sesion.beginTransaction();
            sesion.save(prov);
            tx.commit();
        }catch(ConstraintViolationException ex){
            response.setCorrecto(false);
            response.setMensajeError("Ya hay un proveedor registrado con el código: \""+prov.getCodigo()+"\"");
        }catch(Exception ex){
            response.setCorrecto(false);
            response.setMensajeError("Ha ocurrido un error al registrar el proveedor");
        }finally{
            if(sesion != null && sesion.isOpen()){
                sesion.close();
            }
        }
        return response;
    }
    
    public static Response modificarProveedor(Proveedores prov){
        Response response = new Response();
        Session sesion = null;
        try{
            SessionFactory sesionFactory = HibernateUtil.getSessionFactory();
            sesion = sesionFactory.openSession();
            Transaction tx = sesion.beginTransaction();
            sesion.update(prov);
            tx.commit();
        }catch(ObjectNotFoundException ex){
            response.setCorrecto(false);
            response.setMensajeError("No se ha encontrado el proveedor a modificar");
        }catch(Exception ex){
            response.setCorrecto(false);
            response.setMensajeError("Ha ocurrido un error al modificar el proveedor");
        }finally{
            if(sesion != null && sesion.isOpen()){
                sesion.close();
            }
        }
        return response;
    }
    
    public static Response eliminarProveedor(Proveedores prov){
        Response response = new Response();
        Session sesion = null;
        try{
            SessionFactory sesionFactory = HibernateUtil.getSessionFactory();
            sesion = sesionFactory.openSession();
            Transaction tx = sesion.beginTransaction();
            sesion.delete(prov);
            tx.commit();
        }catch(ObjectNotFoundException ex){
            response.setCorrecto(false);
            response.setMensajeError("No se ha encontrado el proveedor a eliminar");
        }catch(ConstraintViolationException ex){
            response.setCorrecto(false);
            response.setMensajeError("No se ha podido eliminar el proveedor porque está registrado en 1 o más gestiones");
        }
        catch(Exception ex){
            response.setCorrecto(false);
            response.setMensajeError("Ha ocurrido un error al eliminar el proveedor");
        }finally{
            if(sesion != null && sesion.isOpen()){
                sesion.close();
            }
        }
        return response;
    }
    
    public static List<Proveedores> getAllProveedores(){
        Session sesion = null;
        try{
            SessionFactory sesionFactory = HibernateUtil.getSessionFactory();
            sesion = sesionFactory.openSession();
            StringBuilder query = new StringBuilder();
            query.append("FROM Proveedores");
            Query q = sesion.createQuery(query.toString());
            return q.list();
        }catch(Exception ex){
            return null;
        }finally{
            if(sesion != null && sesion.isOpen()){
                sesion.close();
            }
        }
    }
    
    public static List<Proveedores> buscarProveedores(String codigo, String nombre, String apellidos, String direccion){
        Session sesion = null;
        try{
            SessionFactory sesionFactory = HibernateUtil.getSessionFactory();
            sesion = sesionFactory.openSession();
            StringBuilder query = new StringBuilder();
            query.append("FROM Proveedores WHERE 1=1 ");
            if(!codigo.isBlank()){
                query.append(" AND CODIGO = :codigo ");
            }
            if(!nombre.isBlank()){
                query.append(" AND NOMBRE = :nombre ");
            }
            if(!apellidos.isBlank()){
                query.append(" AND APELLIDOS = :apellidos ");
            }
            if(!direccion.isBlank()){
                query.append(" AND DIRECCION = :direccion ");
            }
            Query q = sesion.createQuery(query.toString());
            if(!codigo.isBlank()){
                q.setParameter("codigo", codigo);
            }
            if(!nombre.isBlank()){
                q.setParameter("nombre", nombre);
            }
            if(!apellidos.isBlank()){
                q.setParameter("apellidos", apellidos);
            }
            if(!direccion.isBlank()){
                q.setParameter("direccion", direccion);
            }
            return q.list();
        }catch(Exception ex){
            return null;
        }finally{
            if(sesion != null && sesion.isOpen()){
                sesion.close();
            }
        }
    }
    
    public static List<Proveedores> buscarProveedoresConGestiones(String codigo, String nombre, String apellidos, String direccion){
        Session sesion = null;
        try{
            SessionFactory sesionFactory = HibernateUtil.getSessionFactory();
            sesion = sesionFactory.openSession();
            StringBuilder query = new StringBuilder();
            query.append("SELECT DISTINCT p FROM Proveedores p ");
            query.append("left join fetch p.gestionsByCodigo Gestion ");
            query.append("left join fetch Gestion.proyectosByCodproyecto Proyecto ");
            query.append("WHERE 1=1 ");
            if(!codigo.isBlank()){
                query.append(" AND p.codigo = :codigo ");
            }
            if(!nombre.isBlank()){
                query.append(" AND p.nombre = :nombre ");
            }
            if(!apellidos.isBlank()){
                query.append(" AND p.apellidos = :apellidos ");
            }
            if(!direccion.isBlank()){
                query.append(" AND p.direccion = :direccion ");
            }
            Query q = sesion.createQuery(query.toString());
            if(!codigo.isBlank()){
                q.setParameter("codigo", codigo);
            }
            if(!nombre.isBlank()){
                q.setParameter("nombre", nombre);
            }
            if(!apellidos.isBlank()){
                q.setParameter("apellidos", apellidos);
            }
            if(!direccion.isBlank()){
                q.setParameter("direccion", direccion);
            }
            return q.list();
        }catch(Exception ex){
            return null;
        }finally{
            if(sesion != null && sesion.isOpen()){
                sesion.close();
            }
        }
    }
    
}
