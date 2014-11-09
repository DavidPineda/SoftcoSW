/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.softco.model.dao;

import co.com.softco.model.pojos.ModeloTracker;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author david
 */
public class ModeloTrackerDAO {
    
    private SessionFactory sf = null;
    private Session session = null;
    private Transaction tx = null;
    
    public void insertarModeloTracker(ModeloTracker m){
        try{
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            session.save(m);
            tx.commit();
            session.close();
        }catch(HibernateException ex){
            tx.rollback();
            throw new RuntimeException("No se pudo guardar el modelo de tracker", ex);
        }
    }

    public List<ModeloTracker> consultarModeloTracker(){
        try{
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            Query query = session.createQuery("from ModeloTracker");
            List<ModeloTracker> lista = query.list();
            session.close();
            return lista;
        }catch(HibernateException ex){
            throw new RuntimeException("No se pudo consultar los datos del modelo de tracker", ex);
        }
        
    }
}
