package com.mcglab.service.impl;

import com.mcglab.dao.AssistantDao;
import com.mcglab.domain.Assistant;
import com.mcglab.service.AssistantService;

import java.util.List;

/**
 * Created by Admin on 29.07.15.
 */
public class AssistantServiceImpl implements AssistantService {
    private AssistantDao assistantDao;

    public AssistantServiceImpl(AssistantDao assistantDao) {
        this.assistantDao = assistantDao;
    }

    @Override
    public void create(Assistant assistant) {
        assistantDao.create(assistant);
    }

    @Override
    public Assistant read(Long id) {
        return assistantDao.read(id);
    }

    @Override
    public Assistant readByLogin(String login) {
        return assistantDao.readByLogin(login);
    }

    @Override
    public void update(Assistant assistant) {
        assistantDao.update(assistant);
    }

    @Override
    public void remove(Assistant assistant) {
        assistantDao.remove(assistant);
    }

    @Override
    public List<Assistant> findAll() {
        return assistantDao.findAll();
    }
}
