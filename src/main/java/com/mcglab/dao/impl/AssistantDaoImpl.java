package com.mcglab.dao.impl;

import com.mcglab.dao.AssistantDao;
import com.mcglab.domain.Assistant;
import com.mcglab.service.databaseService.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Admin on 29.07.15.
 */
public class AssistantDaoImpl implements AssistantDao {
    private static Logger logger = Logger.getLogger(AssistantDaoImpl.class);

    @Override
    public void create(Assistant assistant) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.save(assistant);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            logger.error("Transaction failed!");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public Assistant read(Long id) {
        Session session = HibernateUtil.getSession();
        try {
            return (Assistant) session.get(Assistant.class, id);
        } catch (HibernateException he) {
            logger.error("Transaction failed!");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public Assistant readByLogin(String login) {
        Session session = HibernateUtil.getSession();
        try {
            return (Assistant) session.createCriteria(Assistant.class).add(Restrictions.eq("login", login));
        } catch (HibernateException he) {
            logger.error("Transaction failed!");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public void update(Assistant assistant) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.update(assistant);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            logger.error("Transaction failed!");
        } finally {
            session.close();
        }
    }

    @Override
    public void remove(Assistant assistant) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.delete(assistant);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            logger.error("Transaction failed!");
        } finally {
            session.close();
        }
    }

    @Override
    public List<Assistant> findAll() {
        Session session = HibernateUtil.getSession();
        try {
            return session.createCriteria(Assistant.class).list();
        } catch (HibernateException he) {
            logger.error("Transaction failed!");
        } finally {
            session.close();
        }
        return null;
    }
}
