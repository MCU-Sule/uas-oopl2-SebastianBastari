package com.example.uaspbo2.Util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Sebastian Giovanni Bastari 1972006
 */
public class HibernateUtil {

    public static Session getSession(){
        SessionFactory sf ;
        sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session s ;
        s = sf.openSession();
        return s ;
    }
}
