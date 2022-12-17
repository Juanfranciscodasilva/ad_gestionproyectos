package BBDD;

import Clases.Gestion;
import Clases.Proyectos;
import Clases.Response;
import java.util.List;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class BD_GESTION {
    
    public static Response insertarGestion(Gestion ges){
        Response response = new Response();
        Session sesion = null;
        try{
            SessionFactory sesionFactory = HibernateUtil.getSessionFactory();
            sesion = sesionFactory.openSession();
            Transaction tx = sesion.beginTransaction();
            sesion.save(ges);
            tx.commit();
        }catch(Exception ex){
           ex.printStackTrace();
            response.setCorrecto(false);
            response.setMensajeError("Ha ocurrido un error al registrar la gestión");
        }finally{
            if(sesion != null && sesion.isOpen()){
                sesion.close();
            }
        }
        return response;
    }
    
    public static Response modificarGestion(Gestion ges){
        Response response = new Response();
        Session sesion = null;
        try{
            SessionFactory sesionFactory = HibernateUtil.getSessionFactory();
            sesion = sesionFactory.openSession();
            Transaction tx = sesion.beginTransaction();
            sesion.update(ges);
            tx.commit();
        }catch(ObjectNotFoundException ex){
            response.setCorrecto(false);
            response.setMensajeError("No se ha encontrado la gestión a modificar");
        }catch(Exception ex){
            response.setCorrecto(false);
            response.setMensajeError("Ha ocurrido un error al modificar la gestión");
        }finally{
            if(sesion != null && sesion.isOpen()){
                sesion.close();
            }
        }
        return response;
    }
    
    public static Response eliminarGestion(Gestion ges){
        Response response = new Response();
        Session sesion = null;
        try{
            SessionFactory sesionFactory = HibernateUtil.getSessionFactory();
            sesion = sesionFactory.openSession();
            Transaction tx = sesion.beginTransaction();
            sesion.delete(ges);
            tx.commit();
        }catch(ObjectNotFoundException ex){
            response.setCorrecto(false);
            response.setMensajeError("No se ha encontrado la gestión a eliminar");
        }catch(Exception ex){
            response.setCorrecto(false);
            response.setMensajeError("Ha ocurrido un error al eliminar la gestión");
        }finally{
            if(sesion != null && sesion.isOpen()){
                sesion.close();
            }
        }
        return response;
    }
    
    public static List<Gestion> getAllGestiones(){
        Session sesion = null;
        try{
            SessionFactory sesionFactory = HibernateUtil.getSessionFactory();
            sesion = sesionFactory.openSession();
            StringBuilder query = new StringBuilder();
            query.append("FROM Gestion");
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
    
    public static List<Gestion> buscarGestiones(String codPieza, String codProveedor, String codProyecto, int cantidad){
        Session sesion = null;
        try{
            SessionFactory sesionFactory = HibernateUtil.getSessionFactory();
            sesion = sesionFactory.openSession();
            StringBuilder query = new StringBuilder();
            query.append("FROM Gestion g ");
            query.append("left join fetch g.piezasByCodpieza Piezas ");
            query.append("left join fetch g.proveedoresByCodproveedor Proveedores ");
            query.append("left join fetch g.proyectosByCodproyecto Proyectos ");
            query.append("WHERE 1=1 ");
            if(!codPieza.isBlank()){
                query.append(" AND CODPIEZA = :codpieza ");
            }
            if(!codProveedor.isBlank()){
                query.append(" AND CODPROVEEDOR = :codproveedor ");
            }
            if(!codProyecto.isBlank()){
                query.append(" AND CODPROYECTO = :codproyecto ");
            }
            if(cantidad != -1){
                query.append(" AND CANTIDAD = :cantidad ");
            }
            Query q = sesion.createQuery(query.toString());
            if(!codPieza.isBlank()){
                q.setParameter("codpieza", codPieza);
            }
            if(!codProveedor.isBlank()){
                q.setParameter("codproveedor", codProveedor);
            }
            if(!codProyecto.isBlank()){
                q.setParameter("codproyecto", codProyecto);
            }
            if(cantidad != -1){
                q.setParameter("cantidad", cantidad);
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
