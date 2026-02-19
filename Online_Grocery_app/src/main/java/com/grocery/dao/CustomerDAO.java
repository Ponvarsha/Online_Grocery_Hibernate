package com.grocery.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.grocery.bean.Customer;
import com.grocery.util.HibernateUtil;



public class CustomerDAO {

    public Customer findCustomer(String customerID) throws Exception {
    	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Customer.class, customerID);
        }
    }

    public List<Customer> viewAllCustomers() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Product", Customer.class).list();
        }
    }

    public boolean insertCustomer(Customer c) throws Exception {
    	Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(c);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteCustomer(String customerID) throws Exception {
    	Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Customer customer = session.get(Customer.class, customerID);
            if (customer != null) {
                session.delete(customer);
                System.out.println("customer deleted: " + customer);
  
            }
            transaction.commit();
            return true;
            
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }
}
