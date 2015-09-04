package com.chinamobile.cmti.service;

import com.chinamobile.cmti.dao.MrDataDAO;
import com.chinamobile.cmti.model.MrDataVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MrDataManagerImpl implements MrDataManager {

    @Autowired
    MrDataDAO mrDataDAO;

    public List<MrDataVO> getAllMrData() {
        return mrDataDAO.getAllMrData();
    }
}
