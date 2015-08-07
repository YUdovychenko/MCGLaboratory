package com.mcglab.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Admin on 28.07.15.
 */

@Entity
@Table(name = "PATIENT")
public class Patient {

    @Id
    @GeneratedValue
    @Column(name = "PATIENT_ID")
    private Long id;

    @Column(name = "PATIENT_FIRST_NAME")
    private String firstName;

    @Column(name = "PATIENT_SECOND_NAME")
    private String secondName;

    @Column(name = "PATIENT_LOGIN")
    private String login;

    @Column(name = "PATIENT_PASSWORD")
    private String password;

    @Temporal(TemporalType.DATE)
    @Column(name = "PATIENT_BIRTH_DATE")
    private Date birthDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "PATIENT_MCG_DATE")
    private Date mcgDate;

    @Column(name = "PATIENT_DOCTOR")
    @ManyToOne
    private Doctor doctor;

    @Column(name = "PATIENT_ASSISTANT")
    @ManyToOne
    private Assistant assistant;

    @Column(name = "PATIENT_HEARTSTATE")
    @ManyToOne
    private HeartState heartState;

    @ElementCollection
    @Column(name = "PATIENT_MAP")
    private List<Long> map;

    public Patient() {
        super();
    }

    public Patient(String firstName, String secondName, Date birthDate, Assistant assistant) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.birthDate = birthDate;
        this.assistant = assistant;
    }

    public Patient(String firstName, String secondName, Date birthDate, Date mcgDate, Assistant assistant, List<Long> map) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.birthDate = birthDate;
        this.mcgDate = mcgDate;
        this.assistant = assistant;
        this.map = map;
    }

    public Patient(String firstName, String secondName, Date birthDate, Assistant assistant, Doctor doctor) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.birthDate = birthDate;
        this.assistant = assistant;
        this.doctor = doctor;
    }

    public Patient(String firstName, String secondName, Date birthDate, Date mcgDate, Doctor doctor, Assistant assistant, List<Long> map) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.birthDate = birthDate;
        this.mcgDate = mcgDate;
        this.doctor = doctor;
        this.assistant = assistant;
        this.map = map;
    }

    public Patient(String firstName, String secondName, String login, String password, Assistant assistant, Date birthDate) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.login = login;
        this.password = password;
        this.assistant = assistant;
        this.birthDate = birthDate;
    }

    public Patient(String firstName, String secondName, String login, Assistant assistant, String password, Date birthDate, Date mcgDate, List<Long> map) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.login = login;
        this.assistant = assistant;
        this.password = password;
        this.birthDate = birthDate;
        this.mcgDate = mcgDate;
        this.map = map;
    }

    public Patient(String firstName, String secondName, String login, String password, Date birthDate, Assistant assistant, Doctor doctor) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.login = login;
        this.password = password;
        this.birthDate = birthDate;
        this.assistant = assistant;
        this.doctor = doctor;
    }

    public Patient(String firstName, String secondName, String login, String password, Date birthDate, Date mcgDate, Doctor doctor, Assistant assistant, List<Long> map) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.login = login;
        this.password = password;
        this.birthDate = birthDate;
        this.mcgDate = mcgDate;
        this.doctor = doctor;
        this.assistant = assistant;
        this.map = map;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getMcgDate() {
        return mcgDate;
    }

    public void setMcgDate(Date mcgDate) {
        this.mcgDate = mcgDate;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Assistant getAssistant() {
        return assistant;
    }

    public void setAssistant(Assistant assistant) {
        this.assistant = assistant;
    }

    public HeartState getHeartState() {
        return heartState;
    }

    public void setHeartState(HeartState heartState) {
        this.heartState = heartState;
    }

    public List<Long> getMap() {
        return map;
    }

    public void setMap(List<Long> map) {
        this.map = map;
    }

    @Override
    public int hashCode(){
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        Patient patient = (Patient) o;

        if(id != null ? !id.equals(patient.getId()) : patient.getId() != null) return false;

        return true;
    }
}
