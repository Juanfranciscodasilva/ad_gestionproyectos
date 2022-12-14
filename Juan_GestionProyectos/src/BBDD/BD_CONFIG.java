package BBDD;

import Clases.Piezas;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import util.HibernateUtil;

public class BD_CONFIG {
    public static void ComprobarBaseDeDatos() throws Exception{
        Session sesion = null;
        try{
            SessionFactory sesionFactory = HibernateUtil.getSessionFactory();
            sesion = sesionFactory.openSession();
            comprobarTablas(sesion);
            sesion.close();
        }catch(Exception ex){
            throw ex;
        }finally{
            if(sesion != null){
                sesion.close();
            }
        }
    }
    
    public static void comprobarTablas(Session sesion) throws Exception{
        try{
            comprobarTablaPiezas(sesion);
            comprobarTablaProveedores(sesion);
            comprobarTablaProyectos(sesion);
            comprobarTablaGestion(sesion);
        }catch(Exception ex){
            System.out.print("ERROR: "+ex.getMessage());
            throw ex;
        }
    }
    
    public static void comprobarTablaPiezas(Session sesion) throws Exception{
        Transaction tx = sesion.beginTransaction();
        StringBuilder sSql = new StringBuilder();
        sSql.append("create table if not exists PIEZAS( ");
        sSql.append("CODIGO	VARCHAR(6) NOT null primary KEY, ");
        sSql.append("NOMBRE	VARCHAR(20) NOT NULL, ");
        sSql.append("PRECIO decimal	NOT NULL, ");
        sSql.append("DESCRIPCION varchar(200) ");
        sSql.append(");");
        NativeQuery sql = sesion.createSQLQuery(sSql.toString());
        sql.executeUpdate();
        tx.commit();
    }
    
    public static void comprobarTablaProveedores(Session sesion) throws Exception{
        Transaction tx = sesion.beginTransaction();
        StringBuilder sSql = new StringBuilder();
        sSql.append("create table if not exists PROVEEDORES( ");
        sSql.append("CODIGO	VARCHAR(6) NOT null primary KEY, ");
        sSql.append("NOMBRE	VARCHAR(20) NOT NULL, ");
        sSql.append("APELLIDOS VARCHAR(30) not null, ");
        sSql.append("DIRECCION VARCHAR(40) not NULL ");
        sSql.append(");");
        NativeQuery sql = sesion.createSQLQuery(sSql.toString());
        sql.executeUpdate();
        tx.commit();
    }
    
    public static void comprobarTablaProyectos(Session sesion) throws Exception{
        Transaction tx = sesion.beginTransaction();
        StringBuilder sSql = new StringBuilder();
        sSql.append("create table if not exists PROYECTOS( ");
        sSql.append("CODIGO	VARCHAR(6) NOT null primary KEY, ");
        sSql.append("NOMBRE	VARCHAR(40) NOT NULL, ");
        sSql.append("CIUDAD VARCHAR(40) ");
        sSql.append(");");
        NativeQuery sql = sesion.createSQLQuery(sSql.toString());
        sql.executeUpdate();
        tx.commit();
    }
    
    public static void comprobarTablaGestion(Session sesion) throws Exception{
        Transaction tx = sesion.beginTransaction();
        StringBuilder sSql = new StringBuilder();
        sSql.append("create table if not exists gestion( ");
        sSql.append("id int primary key auto_increment, ");
        sSql.append("NOMBRE	VARCHAR(20) NOT NULL, ");
        sSql.append("CANTIDAD DECIMAL not NULL, ");
        sSql.append("CODPROVEEDOR VARCHAR(6), ");
        sSql.append("CODPIEZA VARCHAR(6) NOT	 NULL, ");
        sSql.append("CODPROYECTO VARCHAR(6) NOT NULL, ");
        sSql.append("FOREIGN KEY (CODPROVEEDOR) REFERENCES PROVEEDORES(CODIGO), ");
        sSql.append("FOREIGN	KEY  (CODPIEZA) REFERENCES PIEZAS(CODIGO), ");
        sSql.append("FOREIGN	KEY (CODPROYECTO) REFERENCES PROYECTOS(CODIGO) ");
        sSql.append(");");
        NativeQuery sql = sesion.createSQLQuery(sSql.toString());
        sql.executeUpdate();
        tx.commit();
    }
}
