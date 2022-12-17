package BBDD;

import Clases.Piezas;
import Clases.Proveedores;
import Clases.Proyectos;
import Clases.Response;
import java.util.List;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import util.HibernateUtil;

public class BD_PROYECTOS {
    
    public static Response insertarProyecto(Proyectos pro){
        Response response = new Response();
        Session sesion = null;
        try{
            SessionFactory sesionFactory = HibernateUtil.getSessionFactory();
            sesion = sesionFactory.openSession();
            Transaction tx = sesion.beginTransaction();
            sesion.save(pro);
            tx.commit();
        }catch(ConstraintViolationException ex){
            response.setCorrecto(false);
            response.setMensajeError("Ya hay un proyecto registrado con el código: \""+pro.getCodigo()+"\"");
        }catch(Exception ex){
            response.setCorrecto(false);
            response.setMensajeError("Ha ocurrido un error al registrar el proyecto");
        }finally{
            if(sesion != null && sesion.isOpen()){
                sesion.close();
            }
        }
        return response;
    }
    
    public static Response modificarProyecto(Proyectos pro){
        Response response = new Response();
        Session sesion = null;
        try{
            SessionFactory sesionFactory = HibernateUtil.getSessionFactory();
            sesion = sesionFactory.openSession();
            Transaction tx = sesion.beginTransaction();
            sesion.update(pro);
            tx.commit();
        }catch(ObjectNotFoundException ex){
            response.setCorrecto(false);
            response.setMensajeError("No se ha encontrado el proyecto a modificar");
        }catch(Exception ex){
            response.setCorrecto(false);
            response.setMensajeError("Ha ocurrido un error al modificar el proyecto");
        }finally{
            if(sesion != null && sesion.isOpen()){
                sesion.close();
            }
        }
        return response;
    }
    
    public static Response eliminarProyecto(Proyectos pro){
        Response response = new Response();
        Session sesion = null;
        try{
            SessionFactory sesionFactory = HibernateUtil.getSessionFactory();
            sesion = sesionFactory.openSession();
            Transaction tx = sesion.beginTransaction();
            sesion.delete(pro);
            tx.commit();
        }catch(ObjectNotFoundException ex){
            response.setCorrecto(false);
            response.setMensajeError("No se ha encontrado el proyecto a eliminar");
        }catch(ConstraintViolationException ex){
            response.setCorrecto(false);
            response.setMensajeError("No se ha podido eliminar el proyecto porque está registrado en 1 o más gestiones");
        }
        catch(Exception ex){
            response.setCorrecto(false);
            response.setMensajeError("Ha ocurrido un error al eliminar el proyecto");
        }finally{
            if(sesion != null && sesion.isOpen()){
                sesion.close();
            }
        }
        return response;
    }
    
    public static List<Proyectos> getAllProyectos(){
        Session sesion = null;
        try{
            SessionFactory sesionFactory = HibernateUtil.getSessionFactory();
            sesion = sesionFactory.openSession();
            StringBuilder query = new StringBuilder();
            query.append("FROM Proyectos");
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
    
    public static List<Proyectos> buscarProyectos(String codigo, String nombre, String ciudad){
        Session sesion = null;
        try{
            SessionFactory sesionFactory = HibernateUtil.getSessionFactory();
            sesion = sesionFactory.openSession();
            StringBuilder query = new StringBuilder();
            query.append("FROM Proyectos WHERE 1=1 ");
            if(!codigo.isBlank()){
                query.append(" AND CODIGO = :codigo ");
            }
            if(!nombre.isBlank()){
                query.append(" AND NOMBRE = :nombre ");
            }
            if(!ciudad.isBlank()){
                query.append(" AND CIUDAD = :ciudad ");
            }
            Query q = sesion.createQuery(query.toString());
            if(!codigo.isBlank()){
                q.setParameter("codigo", codigo);
            }
            if(!nombre.isBlank()){
                q.setParameter("nombre", nombre);
            }
            if(!ciudad.isBlank()){
                q.setParameter("ciudad", ciudad);
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
    
    public static List<Proyectos> buscarProyectosConGestiones(String codigo, String nombre, String ciudad){
        Session sesion = null;
        try{
            SessionFactory sesionFactory = HibernateUtil.getSessionFactory();
            sesion = sesionFactory.openSession();
            StringBuilder query = new StringBuilder();
            query.append("SELECT DISTINCT p FROM Proyectos p ");
            query.append("left join fetch p.gestionsByCodigo Gestion ");
            query.append("left join fetch Gestion.proveedoresByCodproveedor Proveedor ");
            query.append("WHERE 1=1 ");
            if(!codigo.isBlank()){
                query.append(" AND p.codigo = :codigo ");
            }
            if(!nombre.isBlank()){
                query.append(" AND p.nombre = :nombre ");
            }
            if(!ciudad.isBlank()){
                query.append(" AND p.ciudad = :ciudad ");
            }
            Query q = sesion.createQuery(query.toString());
            if(!codigo.isBlank()){
                q.setParameter("codigo", codigo);
            }
            if(!nombre.isBlank()){
                q.setParameter("nombre", nombre);
            }
            if(!ciudad.isBlank()){
                q.setParameter("ciudad", ciudad);
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
