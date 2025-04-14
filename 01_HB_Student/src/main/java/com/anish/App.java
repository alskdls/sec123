package com.anish;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.anish.pojo.Vykladach;

public class App 
{
	private static SessionFactory factory;
	
    public static void main( String[] args )
    {
    	
    Configuration config = new Configuration();
    System.out.println(config.getProperty("hibernate.connection.driver_class"));
    
    config.configure("com\\anish\\config\\hibernate.cfg.xml");
    System.out.println(config.getProperty("hibernate.connection.driver_class"));
    
    SessionFactory factory = config.buildSessionFactory();
    
    Session ses=factory.openSession();
    
    Transaction trans = ses.beginTransaction();
    
    Vykladach vykladach = new Vykladach();
    vykladach.setId(1);
    vykladach.setLocation("Fizyka");
    vykladach.setName("Matematyka");
    
    ses.persist(vykladach);
    trans.commit();
    ses.close();
    
    }
    
    public boolean removeVykladach(Vykladach vykladach) {
        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(vykladach);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}