package com.mcglab.dao.impl;

import com.mcglab.dao.DoctorDao;
import com.mcglab.domain.Doctor;
import com.mcglab.service.databaseService.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Admin on 29.07.15.
 */
public class DoctorDaoImpl implements DoctorDao {
    Logger logger = Logger.getLogger(DoctorDaoImpl.class);

    @Override
    public void create(Doctor doctor) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.save(doctor);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            logger.error("Transaction failed!");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public Doctor read(Long id) {
        Session session = HibernateUtil.getSession();
        try {
            return (Doctor) session.get(Doctor.class, id);
        } catch (HibernateException he) {
            logger.error("Transaction failed!");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public Doctor readByLogin(String login) {
        Session session = HibernateUtil.getSession();
        try {
            return (Doctor) session.createCriteria(Doctor.class).add(Restrictions.eq("login", login));
        } catch (HibernateException he) {
            logger.error("Transaction failed!");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }


    @Override
    public void update(Doctor doctor) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.update(doctor);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            logger.error("Transaction failed!");
        } finally {
            session.close();
        }
    }

    @Override
    public void remove(Doctor doctor) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.delete(doctor);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            logger.error("Transaction failed!");
        } finally {
            session.close();
        }
    }

    @Override
    public List<Doctor> findAll() {
        Session session = HibernateUtil.getSession();
        try {
            return session.createCriteria(Doctor.class).list();
        } catch (HibernateException he) {
            logger.error("Transaction failed!");
        } finally {
            session.close();
        }
        return null;
    }
}
