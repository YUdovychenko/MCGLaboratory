package com.mcglab.dao.impl;

import com.mcglab.dao.PatientDao;
import com.mcglab.domain.Assistant;
import com.mcglab.domain.Doctor;
import com.mcglab.domain.HeartState;
import com.mcglab.domain.Patient;
import com.mcglab.service.databaseService.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.Date;
import java.util.List;

/**
 * Created by Admin on 29.07.15.
 */
public class PatientDaoImpl implements PatientDao {
    Logger logger = Logger.getLogger(PatientDaoImpl.class);

    @Override
    public void create(Patient patient) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.save(patient);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            logger.error("Transaction failed!");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public Patient read(Long id) {
        Session session = HibernateUtil.getSession();
        try {
            return (Patient) session.get(Patient.class, id);
        } catch (HibernateException he) {
            logger.error("Transaction failed!");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public Patient readByLogin(String login) {
        Session session = HibernateUtil.getSession();
        try {
            return (Patient) session.createCriteria(Patient.class).add(Restrictions.eq("login", login));
        } catch (HibernateException he) {
            logger.error("Transaction failed!");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }


    @Override
    public void update(Patient patient) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.update(patient);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            logger.error("Transaction failed!");
        } finally {
            session.close();
        }
    }

    @Override
    public void remove(Patient patient) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.delete(patient);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            logger.error("Transaction failed!");
        } finally {
            session.close();
        }
    }

    @Override
    public List<Patient> findAll() {
        Session session = HibernateUtil.getSession();
        try {
            return session.createCriteria(Patient.class).list();
        } catch (HibernateException he) {
            logger.error("Transaction failed!");
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<Patient> findByDoctor(Doctor doctor) {
        Session session = HibernateUtil.getSession();
        try {
            return session.createCriteria(Patient.class).add(Restrictions.eq("doctor", doctor)).list();
        } catch (HibernateException he) {
            logger.error("Transaction failed!");
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<Patient> findByAssistant(Assistant assistant) {
        Session session = HibernateUtil.getSession();
        try {
            return session.createCriteria(Patient.class).add(Restrictions.eq("assistant", assistant)).list();
        } catch (HibernateException he) {
            logger.error("Transaction failed!");
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<Patient> findByMCGDate(Date mcgDate) {
        Session session = HibernateUtil.getSession();
        try {
            return session.createCriteria(Patient.class).add(Restrictions.eq("mcgDate", mcgDate)).list();
        } catch (HibernateException he) {
            logger.error("Transaction failed!");
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<Patient> findByHeartState(HeartState heartState) {
        Session session = HibernateUtil.getSession();
        try {
            return session.createCriteria(Patient.class).add(Restrictions.eq("heartState", heartState)).list();
        } catch (HibernateException he) {
            logger.error("Transaction failed!");
        } finally {
            session.close();
        }
        return null;
    }
}
