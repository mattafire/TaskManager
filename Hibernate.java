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

/**
 *
 * @author Mattafire
 */
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
    /*
    public int getOneAccount(String accountName) {
        
        Session session3 = sessionFactory.openSession();
        //create a new transaction
        session3.beginTransaction();
        // get a single account name
        Query query1 = session3.getNamedQuery("BudgetAccount.byName");
        query1.setString(0, accountName);
        // store the account name in a variable
        List<BudgetAccount> acco = (List<BudgetAccount>) query1.list();
        //commit the transaction to the database
        session3.getTransaction().commit();
        // close the session
        session3.close();
        
        int result = 0;
        for (BudgetAccount acc1 : acco) {
            result = acc1.getAccountId();
            System.out.println(result);
        }
        
        return result;
    }
      
    public static void main(String[] args) {
        HibernateInterface hib = new HibernateInterface();
        
        BudgetAccount account = new BudgetAccount();
        account.setAccountName("Travel");
        account.setAccountDesc("This account is used to budget travel for our family");
        account.setBalance(1265.32);
        
        BudgetAccount account1 = new BudgetAccount();
        account1.setAccountName("Vacation");
        account1.setAccountDesc("This account is used to budget vacations for our family");
        account1.setBalance(985.78);
        
        BudgetAccount account2 = new BudgetAccount();
        account2.setAccountName("Groceries");
        account2.setAccountDesc("This account is used to budget groceries for our family");
        account2.setBalance(450.00);
        
        Deposits deposit1 = new Deposits();
        deposit1.setAccount(account);
        deposit1.setDeposit(100.00);
        
        Deposits deposit2 = new Deposits();
        deposit2.setAccount(account);
        deposit2.setDeposit(859.32);
        
        Expenses expense1 = new Expenses();
        expense1.setAccount(account);
        expense1.setExpense(200.00);
        
        Expenses expense2 = new Expenses();
        expense2.setAccount(account);
        expense2.setExpense(158.38);
        
        account.getAccountDeposits().add(deposit1);
        account.getAccountDeposits().add(deposit2);
        account.getAccountExpenses().add(expense1);
        account.getAccountExpenses().add(expense2);
        
        
       SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        //create a session and open a seesion in the session factory
        Session session = sessionFactory.openSession();
        //create a new transaction
        session.beginTransaction();
        //save the account object to the database
        session.save(account);
        session.save(account1);
        session.save(account2);
        session.save(deposit1);
        session.save(deposit2);
        session.save(expense1);
        session.save(expense2);
        //commit the transaction to the database
        session.getTransaction().commit();
        //close the session
        session.close();
        
       
        Session session1 = sessionFactory.openSession();
        int id = 2;
        //create a new transaction
        session1.beginTransaction();
        BudgetAccount accoount2 = (BudgetAccount) session1.get(BudgetAccount.class, id);
        System.out.println("Get Account: " + accoount2.getAccountName());
        session1.getTransaction().commit();
        //close the session
        session1.close();
    */
}
