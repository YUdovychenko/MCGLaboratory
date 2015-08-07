package com.mcglab.service;

import com.mcglab.domain.Assistant;

import java.util.List;

/**
 * Created by Admin on 29.07.15.
 */
public interface AssistantService {
    void create(Assistant assistant);
    Assistant read(Long id);
    Assistant readByLogin(String login);
    void update(Assistant assistant);
    void remove(Assistant assistant);
    List<Assistant> findAll();
}
