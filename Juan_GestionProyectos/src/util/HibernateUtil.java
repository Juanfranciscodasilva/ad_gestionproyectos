package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory buildSessionFactory() throws Exception
    {
        try {
            return new Configuration().configure().buildSessionFactory(
                    new StandardServiceRegistryBuilder().configure().build ());
        }
        catch (Exception ex)
        {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new Exception(ex);
        }
    }
    public static SessionFactory getSessionFactory() throws Exception
    {
        return buildSessionFactory();
    }

}
