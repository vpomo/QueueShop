/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vpomo.queueshop.Util;

import com.vpomo.queueshop.Model.Entity.Purchaser;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Pomogalov
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory = null;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            AnnotationConfiguration ac = new AnnotationConfiguration();
          ac.addAnnotatedClass(Purchaser.class);

//          ac.addAnnotatedClass(Users.class).addAnnotatedClass(Report.class).addAnnotatedClass(DraftReport.class).                  addAnnotatedClass(LogUsers.class);

          
            sessionFactory = ac.configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    
}
