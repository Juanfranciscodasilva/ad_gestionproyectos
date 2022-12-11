package BBDD;

import Clases.Piezas;
import Clases.Response;
import java.util.List;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import util.HibernateUtil;

public class BD_PIEZAS {
    
    public static Response insertarPieza(Piezas pieza){
        Response response = new Response();
        Session sesion = null;
        try{
            SessionFactory sesionFactory = HibernateUtil.getSessionFactory();
            sesion = sesionFactory.openSession();
            Transaction tx = sesion.beginTransaction();
            sesion.save(pieza);
            tx.commit();
        }catch(ConstraintViolationException ex){
            response.setCorrecto(false);
            response.setMensajeError("Ya hay una pieza registrada con el código: \""+pieza.getCodigo()+"\"");
        }catch(Exception ex){
            response.setCorrecto(false);
            response.setMensajeError("Ha ocurrido un error al registrar la pieza");
        }finally{
            if(sesion != null && sesion.isOpen()){
                sesion.close();
            }
        }
        return response;
    }
    
    public static Response modificarPieza(Piezas pieza){
        Response response = new Response();
        Session sesion = null;
        try{
            SessionFactory sesionFactory = HibernateUtil.getSessionFactory();
            sesion = sesionFactory.openSession();
            Transaction tx = sesion.beginTransaction();
            sesion.update(pieza);
            tx.commit();
        }catch(ObjectNotFoundException ex){
            response.setCorrecto(false);
            response.setMensajeError("No se ha encontrado la pieza a modificar");
        }catch(Exception ex){
            response.setCorrecto(false);
            response.setMensajeError("Ha ocurrido un error al modificar la pieza");
        }finally{
            if(sesion != null && sesion.isOpen()){
                sesion.close();
            }
        }
        return response;
    }
    
    public static List<Piezas> getAllPiezas(){
        Session sesion = null;
        try{
            SessionFactory sesionFactory = HibernateUtil.getSessionFactory();
            sesion = sesionFactory.openSession();
            StringBuilder query = new StringBuilder();
            query.append("FROM Piezas");
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
    
    public static List<Piezas> buscarPiezas(String codigo, String nombre, int precio){
        Session sesion = null;
        try{
            SessionFactory sesionFactory = HibernateUtil.getSessionFactory();
            sesion = sesionFactory.openSession();
            StringBuilder query = new StringBuilder();
            query.append("FROM Piezas WHERE 1=1 ");
            if(!codigo.isBlank()){
                query.append(" AND CODIGO = :codigo ");
            }
            if(!nombre.isBlank()){
                query.append(" AND NOMBRE = :nombre ");
            }
            if(precio != -1){
                query.append(" AND precio = :precio ");
            }
            Query q = sesion.createQuery(query.toString());
            if(!codigo.isBlank()){
                q.setParameter("codigo", codigo);
            }
            if(!nombre.isBlank()){
                q.setParameter("nombre", nombre);
            }
            if(precio != -1){
                q.setParameter("precio", precio);
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
