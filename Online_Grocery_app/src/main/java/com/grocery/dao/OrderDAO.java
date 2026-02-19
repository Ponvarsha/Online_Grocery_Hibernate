package com.grocery.dao;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.grocery.bean.GroceryOrder;
import com.grocery.util.HibernateUtil;


public class OrderDAO {


    public boolean recordOrder(GroceryOrder o) throws Exception {
    	Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(o);
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

    public boolean updateOrderStatus(int orderID, String status) throws Exception {
    	 Transaction transaction = null;
         try (Session session = HibernateUtil.getSessionFactory().openSession()) {
             transaction = session.beginTransaction();
             GroceryOrder groceryOrder=session.get(GroceryOrder.class, orderID);
             if(groceryOrder!=null) {
            	 groceryOrder.setStatus(status);
            	 session.update(groceryOrder);
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

    public boolean updateOrderDelivery(int orderID, java.util.Date d, String slot) throws Exception {
    	 Transaction transaction = null;
         try (Session session = HibernateUtil.getSessionFactory().openSession()) {
             transaction = session.beginTransaction();
             GroceryOrder groceryOrder=session.get(GroceryOrder.class,orderID);
             if(groceryOrder!=null) {
            	 groceryOrder.setDeliveryDate(d);
            	 groceryOrder.setDeliverySlot(slot);
            	 session.update(groceryOrder);
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

    public List<GroceryOrder> findOrdersByCustomer(String customerID) throws Exception {
    	 try (Session session = HibernateUtil.getSessionFactory().openSession()) {
             return session.createQuery("from GroceryOrder", GroceryOrder.class).list();
         }
    }

    public List<GroceryOrder> findOrdersByDeliverySlot(java.util.Date dd, String slot) throws Exception {
    	 try (Session session = HibernateUtil.getSessionFactory().openSession()) {
             return session.createQuery("from GroceryOrder", GroceryOrder.class).list();
         }
}
}
