package Main;

import Clases.*;
import Clases.Proveedores;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.*;

public class Main {

    public static void main(String[] args) {
        Gestion g = new Gestion();
        SessionFactory sesion =
                HibernateUtil.getSessionFactory();
        Session session = sesion.openSession();
        Proveedores prov = new Proveedores();
        prov = (Proveedores)
                session.load(Proveedores.class, "1234");
        System.out.println(prov == null ? "no se ha encontrado ni pingas":prov.toString());
    }
    
}
