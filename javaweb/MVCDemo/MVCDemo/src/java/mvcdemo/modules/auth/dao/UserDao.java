/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvcdemo.modules.auth.dao;

import java.util.ArrayList;
import java.util.List;
import mvcdemo.modules.auth.models.User;
import mvcdemo.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author soderayi
 */
public class UserDao {

    public static User getByUsername(String username) {
        User user = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String queryString = "from User where username = :username";
            Query query = session.createQuery(queryString);
            query.setString("username", username);
            user = (User) query.uniqueResult();
        } catch (RuntimeException e) {
            //e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return user;
    }

    public void addUser(User user) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            //e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    public void deleteUser(int id) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            User user = (User) session.load(User.class, new Integer(id));
            session.delete(user);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            //e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    public void updateUser(User user) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            //e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            users = session.createQuery("from User").list();
        } catch (RuntimeException e) {
            //e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return users;
    }

    public User getUserById(int id) {
        User user = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from User where id = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", id);
            user = (User) query.uniqueResult();
        } catch (RuntimeException e) {
            //e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return user;
    }
}
