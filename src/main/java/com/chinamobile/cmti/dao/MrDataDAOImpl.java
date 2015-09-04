package com.chinamobile.cmti.dao;

import com.chinamobile.cmti.model.MrDataVO;

import java.util.ArrayList;
import java.util.List;

public class MrDataDAOImpl implements MrDataDAO{
    public List<MrDataVO> getAllMrData() {
        List<MrDataVO> mrs = new ArrayList<MrDataVO>();

        mrs.add(new MrDataVO("四川", "成都", "三环"));
        mrs.add(new MrDataVO("四川", "绵阳", "环城"));

        return mrs;
    }
}
