package net.apispark.webapi;

import org.hibernate.Session;
import org.restlet.Component;
import org.restlet.data.Protocol;

import dao.HibernateUtil;
import express.Express;
import ml_models.ML_Model;
import net.apispark.webapi.representation.Usemodel;


public class WebApiHost {

    public static void main(String[] args) throws Exception {
    	Express app = new Express();
        app.bind(new WebApiApplication()); // See class below
        app.listen(9002);

        // Attach application to http://localhost:9001/v1
       Component c = new Component();
       c.getServers().add(Protocol.HTTP, 9001);
       c.getDefaultHost().attach("/v1", new WebApiApplication());
       c.start();
       
       Session session = HibernateUtil.getSessionFactory().openSession();
       
       session.beginTransaction();
       MLUser model = new MLUser();
       // Check database version
       String sql = "select version()";
       session.save(model);
       //String result = (String) session.createNativeQuery(sql).getSingleResult();
       //System.out.println(result);
       session.getTransaction().commit();
       session.close();     
       HibernateUtil.shutdown();
       
       
    }
}