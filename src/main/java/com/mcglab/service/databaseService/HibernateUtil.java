package com.mcglab.service.databaseService;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

/**
 * Created by Admin on 29.07.15.
 */
public class HibernateUtil {
    private static ApplicationContext context = new ClassPathXmlApplicationContext("/spring/database/context-db.xml");
    private static SessionFactory sessionFactory = buildSessionFactory();

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }

    private static SessionFactory buildSessionFactory(){
        try{
            Locale.setDefault(Locale.ENGLISH);
            return context.getBean("sessionFactory", SessionFactory.class);
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed!" + ex);
            throw new ExceptionInInitializerError(ex);
        }


    }
}
