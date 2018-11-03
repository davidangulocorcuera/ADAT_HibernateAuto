/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernateauto;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author biolizard
 */
public class HibernateUtil {

    private SessionFactory sessionFactory;
    
    public HibernateUtil(){

        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) config file.
        	sessionFactory = new Configuration().configure().buildSessionFactory();
                     
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    	
    }
    
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
}
