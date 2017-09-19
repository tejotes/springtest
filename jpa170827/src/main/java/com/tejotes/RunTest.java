package com.tejotes;

import com.tejotes.com.tejotes.jpa.Person;
import org.postgresql.ds.PGSimpleDataSource;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.*;
import java.sql.Connection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Hashtable;

public class RunTest {

    static EntityManagerFactory emf;


    public static void main(String[] args) throws Exception {
        System.out.println("Hi there!");

        org.postgresql.ds.PGSimpleDataSource ds = new PGSimpleDataSource();
        ds.setUrl("jdbc:postgresql://g3920.fritz.box:5432/tejotes");
        ds.setDatabaseName("tejotes");
        ds.setUser("tejotesjpa");
        ds.setPassword("hallo");
        Connection connection = ds.getConnection();
        connection.setAutoCommit(false);

        Hashtable<String, Object> contextMap = new Hashtable<String, Object>();
        contextMap.put(Context.INITIAL_CONTEXT_FACTORY,"org.eclipse.jetty.jndi.InitialContextFactory");
        contextMap.put(Context.PROVIDER_URL,"org.eclipse.jetty.jndi");
        javax.naming.InitialContext context = new InitialContext(contextMap);
        context.bind("DefaultDS", ds);

        System.out.println("context="+context);

        emf = Persistence.createEntityManagerFactory( "testappPU" );
        try {

            GregorianCalendar cal = new GregorianCalendar(2003, 7-1, 7);
            Person person = new Person("Reiss", "Alin", cal.getTime());

            EntityManager em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();
                em.persist( person );
                em.flush();
                tx.commit();
            } catch( RuntimeException ex ) {
                System.err.println("Exception: "+ ex);
                if( tx != null && tx.isActive() ) tx.rollback();
                throw ex;
            } finally {
                em.close();
            }

        } finally {
            emf.close();
        }

        connection.commit();
    }

}
