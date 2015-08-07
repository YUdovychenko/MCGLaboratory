package com.mcglab.service;


import com.mcglab.domain.Doctor;
import com.mcglab.domain.Patient;

import java.util.List;

/**
 * Created by Admin on 29.07.15.
 */
public interface DoctorService {
    void create(Doctor doctor);
    Doctor read(Long id);
    Doctor readByLogin(String login);
    void update(Doctor doctor);
    void remove (Doctor doctor);
    List<Doctor> findAll();
    List<Patient> getClassifiedPatients();
    List<Patient> getUnclassifiedPatients();
}
