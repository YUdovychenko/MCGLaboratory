package com.mcglab.service.impl;

import com.mcglab.dao.PatientDao;
import com.mcglab.domain.Assistant;
import com.mcglab.domain.Doctor;
import com.mcglab.domain.HeartState;
import com.mcglab.domain.Patient;
import com.mcglab.service.PatientService;

import java.util.Date;
import java.util.List;

/**
 * Created by Admin on 30.07.15.
 */
public class PatientServiceImpl implements PatientService {
    private PatientDao patientDao;

    public PatientServiceImpl(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    @Override
    public void create(Patient patient) {
        patientDao.create(patient);
    }

    @Override
    public Patient read(Long id) {
        return patientDao.read(id);
    }

    @Override
    public Patient readByLogin(String login) {
        return patientDao.readByLogin(login);
    }

    @Override
    public void update(Patient patient) {
        patientDao.update(patient);
    }

    @Override
    public void remove(Patient patient) {
        patientDao.remove(patient);
    }

    @Override
    public List<Patient> findAll() {
        return patientDao.findAll();
    }

    @Override
    public List<Patient> findByDoctor(Doctor doctor) {
        return patientDao.findByDoctor(doctor);
    }

    @Override
    public List<Patient> findByAssistant(Assistant assistant) {
        return patientDao.findByAssistant(assistant);
    }

    @Override
    public List<Patient> findByMCGDate(Date mcgDate) {
        return patientDao.findByMCGDate(mcgDate);
    }

    @Override
    public List<Patient> findByHeartState(HeartState heartState) {
        return patientDao.findByHeartState(heartState);
    }
}
