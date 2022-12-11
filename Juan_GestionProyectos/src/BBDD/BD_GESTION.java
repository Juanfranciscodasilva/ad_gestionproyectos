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
    
//    public static List<Proyectos> buscarGestiones(String codigo, String nombre, String ciudad){
//        Session sesion = null;
//        try{
//            SessionFactory sesionFactory = HibernateUtil.getSessionFactory();
//            sesion = sesionFactory.openSession();
//            StringBuilder query = new StringBuilder();
//            query.append("FROM Proyectos WHERE 1=1 ");
//            if(!codigo.isBlank()){
//                query.append(" AND CODIGO = :codigo ");
//            }
//            if(!nombre.isBlank()){
//                query.append(" AND NOMBRE = :nombre ");
//            }
//            if(!ciudad.isBlank()){
//                query.append(" AND CIUDAD = :ciudad ");
//            }
//            Query q = sesion.createQuery(query.toString());
//            if(!codigo.isBlank()){
//                q.setParameter("codigo", codigo);
//            }
//            if(!nombre.isBlank()){
//                q.setParameter("nombre", nombre);
//            }
//            if(!ciudad.isBlank()){
//                q.setParameter("ciudad", ciudad);
//            }
//            return q.list();
//        }catch(Exception ex){
//            return null;
//        }finally{
//            if(sesion != null && sesion.isOpen()){
//                sesion.close();
//            }
//        }
//    }
    
}
