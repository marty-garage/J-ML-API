package dao;



import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import net.apispark.webapi.MLUser;
import net.apispark.webapi.representation.Usemodel;

/**
 * @author imssbora
 */
public class HibernateUtil {
   private static StandardServiceRegistry registry;
   private static SessionFactory sessionFactory;

   public static SessionFactory getSessionFactory() {
      if (sessionFactory == null) {
         try {

            // Create registry builder
            StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
            
            Configuration config = new Configuration();
            
            
            // Hibernate settings equivalent to hibernate.cfg.xml's properties
            Properties settings = new Properties();
            settings.put(Environment.DRIVER, "org.postgresql.Driver");
            settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/ml");
            settings.put(Environment.USER, "postgres");
            settings.put(Environment.PASS, "");
            settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL95Dialect");
            settings.put(Environment.HBM2DDL_AUTO,"create-drop");
           // config.getProperties().entrySet().forEach(entry -> settings.put((entry, value)); 
        
            
            settings.put(Environment.SHOW_SQL, "true");
            settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        
            config.setProperties(settings);
            config.addAnnotatedClass(MLUser.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(config.getProperties()).build();
            sessionFactory = config.buildSessionFactory(serviceRegistry); 

         } catch (Exception e) {
            e.printStackTrace();
            if (registry != null) {
               StandardServiceRegistryBuilder.destroy(registry);
            }
         }
      }
      return sessionFactory;
   }

   public static void shutdown() {
      if (registry != null) {
         StandardServiceRegistryBuilder.destroy(registry);
      }
   }
}