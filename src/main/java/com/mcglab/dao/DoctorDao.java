package com.mcglab.dao;

import com.mcglab.domain.Doctor;

import java.util.List;

/**
 * Created by Admin on 29.07.15.
 */
public interface DoctorDao {
    void create(Doctor doctor);
    Doctor read(Long id);
    Doctor readByLogin(String login);
    void update(Doctor doctor);
    void remove (Doctor doctor);
    List<Doctor> findAll();

}
