package com.mcglab.service;

import com.mcglab.domain.HeartState;

import java.util.List;

/**
 * Created by Admin on 29.07.15.
 */
public interface HeartStateService {
    void create(HeartState heartState);
    HeartState read(Long id);
    void update(HeartState heartState);
    void remove(HeartState heartState);
    List<HeartState> findAll();
}
