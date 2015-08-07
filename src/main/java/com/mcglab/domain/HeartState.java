package com.mcglab.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Admin on 28.07.15.
 */

@Entity
@Table(name = "HEARTSTATE")
public class HeartState {

    @Id
    @GeneratedValue
    @Column(name = "HEARTSTATE_ID")
    private Long id;

    @Column(name = "HEARTSTATE_NAME")
    private String state;

    @Column(name = "HEARTSTATE_PATIENTS")
    @OneToMany(mappedBy = "heartState", cascade = CascadeType.ALL)
    private Set<Patient> patients = new HashSet<Patient>();

    public HeartState() {
        super();
    }

    public HeartState(String state) {
        this.state = state;
    }

    public HeartState(String state, Set<Patient> patients) {
        this.state = state;
        this.patients = patients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

        HeartState heartState = (HeartState) o;

        if(id != null ? !id.equals(heartState.getId()) : heartState.getId() != null) return false;

        return true;
    }
}
