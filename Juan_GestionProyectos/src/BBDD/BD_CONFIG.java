package BBDD;

import org.hibernate.SessionFactory;
import util.HibernateUtil;

public class BD_CONFIG {
    public static void ComprobarBaseDeDatos() throws Exception{
        try{
            SessionFactory sesion = HibernateUtil.getSessionFactory();
            sesion.close();
        }catch(Exception ex){
            throw ex;
        }
    }
}
