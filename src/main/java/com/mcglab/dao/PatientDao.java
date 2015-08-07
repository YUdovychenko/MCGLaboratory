package com.mcglab.dao;

import com.mcglab.domain.Assistant;
import com.mcglab.domain.Doctor;
import com.mcglab.domain.HeartState;
import com.mcglab.domain.Patient;

import java.util.Date;
import java.util.List;

/**
 * Created by Admin on 29.07.15.
 */
public interface PatientDao {
    void create(Patient patient);
    Patient read(Long id);
    Patient readByLogin(String login);
    void update(Patient patient);
    void remove(Patient patient);
    List<Patient> findAll();
    List<Patient> findByDoctor(Doctor doctor);
    List<Patient> findByAssistant(Assistant assistant);
    List<Patient> findByMCGDate(Date mcgDate);
    List<Patient> findByHeartState(HeartState heartState);
}
