package com.mcglab.domain;

import sun.net.www.content.text.plain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Admin on 28.07.15.
 */

@Entity
@Table(name = "DOCTOR")
public class Doctor {
    @Id
    @GeneratedValue
    @Column(name = "DOCTOR_ID")
    private Long id;

    @Column(name = "DOCTOR_FIRST_NAME")
    private String firstName;

    @Column(name = "DOCTOR_SECOND_NAME")
    private String secondName;

    @Column(name = "DOCTOR_LOGIN")
    private String login;

    @Column(name = "DOCTOR_PASSWORD")
    private String password;

    @Column(name = "DOCTOR_PATIENTS")
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private Set<Patient> patients = new HashSet<Patient>();

    public Doctor() {
        super();
    }

    public Doctor(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public Doctor(String firstName, String secondName, String login, String password) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.login = login;
        this.password = password;
    }

    public Doctor(String firstName, String secondName, String login, String password, Set<Patient> patients) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.login = login;
        this.password = password;
        this.patients = patients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }

    @Override
    public int hashCode(){
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        Doctor doctor = (Doctor) o;

        if(id != null ? !id.equals(doctor.id) : doctor.id != null) return false;

        return true;
    }
}
