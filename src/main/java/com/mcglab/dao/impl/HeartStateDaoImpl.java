package com.mcglab.dao.impl;

import com.mcglab.dao.HeartStateDao;
import com.mcglab.domain.HeartState;
import com.mcglab.service.databaseService.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Admin on 29.07.15.
 */
public class HeartStateDaoImpl implements HeartStateDao {
    Logger logger = Logger.getLogger(HeartStateDaoImpl.class);

    @Override
    public void create(HeartState heartState) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.save(heartState);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            logger.error("Transaction failed!");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public HeartState read(Long id) {
        Session session = HibernateUtil.getSession();
        try {
            return (HeartState) session.get(HeartState.class, id);
        } catch (HibernateException he) {
            logger.error("Transaction failed!");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public void update(HeartState heartState) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.update(heartState);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            logger.error("Transaction failed!");
        } finally {
            session.close();
        }
    }

    @Override
    public void remove(HeartState heartState) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.delete(heartState);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            logger.error("Transaction failed!");
        } finally {
            session.close();
        }
    }

    @Override
    public List<HeartState> findAll() {
        Session session = HibernateUtil.getSession();
        try {
            return session.createCriteria(HeartState.class).list();
        } catch (HibernateException he) {
            logger.error("Transaction failed!");
        } finally {
            session.close();
        }
        return null;
    }
}
