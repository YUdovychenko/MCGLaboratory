package com.mcglab.service.impl;

import com.mcglab.dao.HeartStateDao;
import com.mcglab.domain.HeartState;
import com.mcglab.service.HeartStateService;

import java.util.List;

/**
 * Created by Admin on 29.07.15.
 */
public class HeartStateServiceImpl implements HeartStateService {
    private HeartStateDao heartStateDao;

    public HeartStateServiceImpl(HeartStateDao heartStateDao) {
        this.heartStateDao = heartStateDao;
    }

    @Override
    public void create(HeartState heartState) {
        heartStateDao.create(heartState);
    }

    @Override
    public HeartState read(Long id) {
        return heartStateDao.read(id);
    }

    @Override
    public void update(HeartState heartState) {
        heartStateDao.update(heartState);
    }

    @Override
    public void remove(HeartState heartState) {
        heartStateDao.remove(heartState);
    }

    @Override
    public List<HeartState> findAll() {
        return heartStateDao.findAll();
    }
}
