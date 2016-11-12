/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TaskManager;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Hibernate implements Serializable {
SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public Hibernate() {
    }

public void updatetask(Task task) {
        
        //create a session and open a seesion in the session factory
        Session session = sessionFactory.openSession();
        //create a new transaction
        session.beginTransaction();
        //save the account object to the database
        session.save(task);
        //commit the transaction to the database
        session.getTransaction().commit();
        //close the session
        session.close();
        
    }
        
    public Task getTaskById(int id) {
        
        //create a session and open a seesion in the session factory
        Session session = sessionFactory.openSession();
        //create a new transaction
        session.beginTransaction();
        Task task = (Task) session.get(Task.class, id);
        session.getTransaction().commit();
        //close the session
        session.close();
        
        return task;
        }
    
    public List<Task> getAllTasks() {

        //create a session and open a seesion in the session factory
        Session session = sessionFactory.openSession();
        //create a new transaction
        session.beginTransaction();
        List<Task> tasks = (List<Task>) session.createCriteria(Task.class).list();
        session.getTransaction().commit();
        //close the session
        session.close();
        
        System.out.println();
        
        return tasks;
        }
    
    public List<String> getAccountNames() {
        Session session2 = sessionFactory.openSession();
        //create a new transaction
        session2.beginTransaction();
        Query query = session2.createQuery("select accountName from BudgetAccount");
        List<String> accountNames = (List<String>) query.list();
        session2.getTransaction().commit();
        //close the session
        session2.close();
        
        return accountNames;
    }
}