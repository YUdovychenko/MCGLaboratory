package com.mcglab.service.impl;

import com.mcglab.dao.DoctorDao;
import com.mcglab.domain.Doctor;
import com.mcglab.domain.Patient;
import com.mcglab.service.DoctorService;

import java.util.*;

/**
 * Created by Admin on 29.07.15.
 */
public class DoctorServiceImpl implements DoctorService {
    private DoctorDao doctorDao;

    public DoctorServiceImpl(DoctorDao doctorDao) {
        this.doctorDao = doctorDao;
    }

    @Override
    public void create(Doctor doctor) {
        doctorDao.create(doctor);
    }

    @Override
    public Doctor read(Long id) {
        return doctorDao.read(id);
    }

    @Override
    public Doctor readByLogin(String login) {
        return doctorDao.readByLogin(login);
    }

    @Override
    public void update(Doctor doctor) {
        doctorDao.update(doctor);
    }

    @Override
    public void remove(Doctor doctor) {
        doctorDao.remove(doctor);
    }

    @Override
    public List<Doctor> findAll() {
        return doctorDao.findAll();
    }


    @Override
    public List<Patient> getClassifiedPatients() {
        List<Patient> classifiedPatients = new LinkedList<Patient>();
        for(Patient patient : classifiedPatients) {
            if (patient.getHeartState() != null) {
                classifiedPatients.add(patient);
            }
        }
        return classifiedPatients;
    }

    @Override
    public List<Patient> getUnclassifiedPatients() {
        List<Patient> unclassifiedPatients = new LinkedList<Patient>();
        for(Patient patient : unclassifiedPatients) {
            if (patient.getHeartState() == null) {
                unclassifiedPatients.add(patient);
            }
        }
        return unclassifiedPatients;
    }
}
